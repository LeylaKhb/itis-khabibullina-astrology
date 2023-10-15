package itis.khabibullina.server;

import com.cloudinary.Cloudinary;
import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.model.User;
import itis.khabibullina.service.UserService;
import itis.khabibullina.service.impl.UserServiceImpl;
import itis.khabibullina.util.CloudinaryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.HashMap;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class PersonalAccountServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    private static final UserDao<User> userDao = new UserDaoImpl();
    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();


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
                    LOGGER.info(url);
                    req.setAttribute("imageUrl", url);
                }
            }
        }
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addAndUpdateUser(req, resp, "update");
        resp.sendRedirect("/");
    }

    static void addAndUpdateUser(HttpServletRequest req, HttpServletResponse resp, String method) throws IOException {
        String login;
        if (method.equals("add")){
            login = req.getParameter("login");
        }
        else {
            HttpSession httpSession = req.getSession(false);
            login = String.valueOf(httpSession.getAttribute("login"));
        }
        String password = req.getParameter("password");
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        String zodiacSign = req.getParameter("zodiacSign");
        String name = req.getParameter("name");
        String city = req.getParameter("city");

        if (method.equals("update")) {
            userDao.update(
                    login, password, dateOfBirth, zodiacSign, name, city
            );
        } else {
            userDao.save(new User(
                    login, password, dateOfBirth, zodiacSign, name, city
            ));
        }
    }
}
