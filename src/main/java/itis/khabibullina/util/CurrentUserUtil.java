package itis.khabibullina.util;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CurrentUserUtil {
    private static final UserDao<User> userDao = new UserDaoImpl();
    public static User getUser(HttpServletRequest req) {
        HttpSession httpSession = req.getSession(false);
        String login = String.valueOf(httpSession.getAttribute("login"));
        return userDao.get(login);
    }
}
