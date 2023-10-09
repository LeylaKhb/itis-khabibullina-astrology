package itis.khabibullina.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "mainPageServlet", urlPatterns = "/")

public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        boolean cookieFound = false;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("login")) {
                    req.setAttribute("sessionIsNull", false);
                    cookieFound = true;
                }
            }
        }
        if (!cookieFound) {
            HttpSession httpSession = req.getSession(false);
            req.setAttribute("sessionIsNull", httpSession == null);
        }

        req.getRequestDispatcher("main.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
