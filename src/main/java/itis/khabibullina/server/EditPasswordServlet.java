package itis.khabibullina.server;

import itis.khabibullina.model.User;
import itis.khabibullina.service.UserService;
import itis.khabibullina.service.impl.UserServiceImpl;
import itis.khabibullina.util.CurrentUserUtil;
import itis.khabibullina.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editPasswordServlet", urlPatterns = "/editPassword")
public class EditPasswordServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        User user = CurrentUserUtil.getUser(req);

        req.setAttribute("user", user);
        req.setAttribute("dateOfBirth", String.valueOf(user.getDateOfBirth()));

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("imageUrl")) {
                    String url = c.getValue();
                    req.setAttribute("imageUrl", url);
                }
            }
        }

        if (PasswordUtil.encrypt(oldPassword).equals(user.getPassword())) {
            user.setPassword(newPassword);
            userService.update(user);
            req.setAttribute("changedPassword", true);
            req.getRequestDispatcher("profile.ftl").forward(req, resp);
        } else {
            req.setAttribute("wrongPassword", true);
            req.getRequestDispatcher("profile.ftl").forward(req, resp);
        }
    }
}
