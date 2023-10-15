package itis.khabibullina.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/profile", "/horoscope"})
public class AuthenticationFilter implements Filter {

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

        String uri = httpServletRequest.getRequestURI();
        HttpSession httpSession = httpServletRequest.getSession(false);

        if (cookieFound) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (httpSession == null && !uri.contains("login")) {
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
