package itis.khabibullina.server;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserDao<User> userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = userDao.get(login);
        if (user != null) {
            req.setAttribute("userExist", true);
            req.getRequestDispatcher("registration.ftl").forward(req, resp);
        } else {
            PersonalAccountServlet.addAndUpdateUser(req, resp, "add");
            String remember = req.getParameter("remember");

            LoginServlet.setSessionAndCookie(req, resp, login, remember);
            resp.sendRedirect("/");
        }


    }
}
