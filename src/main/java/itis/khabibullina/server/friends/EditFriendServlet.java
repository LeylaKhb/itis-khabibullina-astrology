package itis.khabibullina.server.friends;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.model.Friend;
import itis.khabibullina.model.User;
import itis.khabibullina.service.FriendService;
import itis.khabibullina.service.impl.FriendServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "editFriendServlet", urlPatterns = "/editFriend")

public class EditFriendServlet extends HttpServlet {
    private final FriendService friendService = new FriendServiceImpl();
    private static final UserDao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        FriendDto friend = friendService.get(id);
        req.setAttribute("friend", friend);
        req.setAttribute("dateOfBirth", String.valueOf(friend.getDateOfBirth()));
        req.getRequestDispatcher("friends/edit_friend.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date dateOfBirth = Date.valueOf(req.getParameter("dateOfBirth"));
        String zodiacSign = req.getParameter("zodiacSign");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        int id = Integer.parseInt(req.getParameter("id"));

        HttpSession httpSession = req.getSession();
        String login = String.valueOf(httpSession.getAttribute("login"));

        User user = userDao.get(login);

        Friend friend = new Friend(id, user.getId(), dateOfBirth, zodiacSign, name, city);
        friendService.update(friend);

        resp.sendRedirect("/friends");

    }
}
