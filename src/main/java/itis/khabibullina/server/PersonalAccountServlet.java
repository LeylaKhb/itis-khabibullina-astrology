package itis.khabibullina.server;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.model.User;
import itis.khabibullina.service.UserService;
import itis.khabibullina.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class PersonalAccountServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    private static final UserDao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession(false);
        String login = String.valueOf(httpSession.getAttribute("login"));
        req.setAttribute("user", userService.get(login));
        req.setAttribute("dateOfBirth", String.valueOf(userService.get(login).getDateOfBirth()));
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addAndUpdateUser(req, resp, "update");
    }

    static void addAndUpdateUser(HttpServletRequest req, HttpServletResponse resp, String method) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        if (method.equals("update")) {
            userDao.update(
                    login, password, dateOfBirth, name, city
            );
        } else {
            userDao.save(new User(
                    login, password, dateOfBirth, name, city
            ));
        }
        resp.sendRedirect("/");
    }
}
