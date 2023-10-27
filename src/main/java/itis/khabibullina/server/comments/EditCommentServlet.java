package itis.khabibullina.server.comments;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.model.Friend;
import itis.khabibullina.model.Comment;
import itis.khabibullina.model.User;
import itis.khabibullina.service.FriendService;
import itis.khabibullina.service.CommentService;
import itis.khabibullina.service.impl.FriendServiceImpl;
import itis.khabibullina.service.impl.CommentServiceImpl;
import itis.khabibullina.util.CurrentUserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "editCommentServlet", urlPatterns = "/editComment")

public class EditCommentServlet extends HttpServlet {
    private final CommentService commentService = new CommentServiceImpl();
    private static final UserDao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        CommentDto comment = commentService.get(id);
        req.setAttribute("comment", comment);
        req.getRequestDispatcher("comments/edit_comment.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = CurrentUserUtil.getUser(req);

        Comment comment = new Comment(id, content);
        commentService.update(comment);

        resp.sendRedirect("/forum");

    }
}


