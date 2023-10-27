package itis.khabibullina.filter;

import itis.khabibullina.server.LoginServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/profile", "/horoscope", "/friends", "/addFriend",
        "/editFriend", "/deleteFriend", "/compatibility", "/editComment", "/deleteComment", "/deletePost",
        "/editPost"})
public class AuthenticationFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        Cookie[] cookies = httpServletRequest.getCookies();
        boolean cookieFound = false;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("login")) {
                    cookieFound = true;
                }
            }
        }

        HttpSession httpSession = httpServletRequest.getSession(false);

        if (cookieFound) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (httpSession == null || httpSession.getAttribute("login") == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
