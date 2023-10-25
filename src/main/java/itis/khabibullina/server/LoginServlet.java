package itis.khabibullina.server;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.model.User;
import itis.khabibullina.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDao<User> userDao = new UserDaoImpl();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        User user = userDao.get(login);

        if (user != null) {
            if (user.getPassword().equals(PasswordUtil.encrypt(password))) {
                setSessionAndCookie(req, resp, login, remember);
                resp.sendRedirect("/");
            } else {
                req.setAttribute("wrongPassword", true);
                req.getRequestDispatcher("login.ftl").forward(req, resp);
            }
        } else {
            req.setAttribute("userIsNull", true);
            req.getRequestDispatcher("login.ftl").forward(req, resp);
        }
    }

    static void setSessionAndCookie(HttpServletRequest req, HttpServletResponse resp, String login, String remember) {
        HttpSession httpSession = req.getSession(false);
        httpSession.setAttribute("login", login);
        httpSession.setMaxInactiveInterval(60 * 60);

        if (remember == null) return;

        Cookie cookie = new Cookie("login", login);
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);
    }
}
