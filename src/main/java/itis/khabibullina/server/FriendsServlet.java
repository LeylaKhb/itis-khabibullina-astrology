package itis.khabibullina.server;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.model.Friend;
import itis.khabibullina.model.User;
import itis.khabibullina.service.FriendService;
import itis.khabibullina.service.impl.FriendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet(name = "friendsServlet", urlPatterns = "/friends")
public class FriendsServlet extends HttpServlet {

    private final FriendService friendService = new FriendServiceImpl();
    private static final UserDao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        String login = String.valueOf(httpSession.getAttribute("login"));


        User user = userDao.get(login);
        List<FriendDto> friends = friendService.getAllByUserId(user.getId());
        req.setAttribute("friends", friends);
        req.getRequestDispatcher("friends.ftl").forward(req, resp);

    }
}
