package itis.khabibullina.server.friends;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.model.User;
import itis.khabibullina.service.FriendService;
import itis.khabibullina.service.impl.FriendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteFriendServlet", urlPatterns = "/deleteFriend")

public class DeleteFriendServlet extends HttpServlet {
    private final FriendService friendService = new FriendServiceImpl();
    private static final UserDao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        friendService.delete(id);
        resp.sendRedirect("/friends");
    }
}
