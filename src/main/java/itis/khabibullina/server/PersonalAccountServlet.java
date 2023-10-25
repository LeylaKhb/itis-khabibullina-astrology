package itis.khabibullina.server;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.UserDto;
import itis.khabibullina.model.User;
import itis.khabibullina.service.UserService;
import itis.khabibullina.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class PersonalAccountServlet extends HttpServlet {
    private static final UserService userService = new UserServiceImpl();

    private static final UserDao<User> userDao = new UserDaoImpl();

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession(false);
        String login = String.valueOf(httpSession.getAttribute("login"));
        req.setAttribute("user", userService.get(login));
        req.setAttribute("dateOfBirth", String.valueOf(userService.get(login).getDateOfBirth()));

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("imageUrl")) {
                    String url = c.getValue();
                    req.setAttribute("imageUrl", url);
                }
            }
        }
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addAndUpdateUser(req, resp, "update");
    }

    static void addAndUpdateUser(HttpServletRequest req, HttpServletResponse resp, String method) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        String zodiacSign = req.getParameter("zodiacSign");
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        if (method.equals("update")) {
            HttpSession httpSession = req.getSession(false);
            String oldLogin = String.valueOf(httpSession.getAttribute("login"));
            User user = userDao.get(oldLogin);
            boolean userExist = false;
            if (!oldLogin.equals(user.getLogin())) {
                User newUser = userDao.get(login);
                if (newUser != null) {
                    req.setAttribute("userExist", true);
                    req.getRequestDispatcher("profile.ftl").forward(req, resp);
                    userExist = true;
                }
            }
            if (!userExist) {
                userService.update(new User(
                        user.getId(), login, password, dateOfBirth, zodiacSign, name, city
                ));
                resp.sendRedirect("/");
            }
        } else {
            userService.save(new User(
                    login, password, dateOfBirth, zodiacSign, name, city
            ));
        }
    }
}
