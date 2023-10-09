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

@WebFilter(filterName = "httpSessionFilter", urlPatterns = "/*")
public class HttpSessionFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("login")) {
                    HttpSession httpSession = httpServletRequest.getSession();
                    httpSession.setAttribute("login", c.getValue());
                    httpSession.setMaxInactiveInterval(60 * 60);
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
