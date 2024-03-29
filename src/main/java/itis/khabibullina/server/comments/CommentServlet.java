package itis.khabibullina.server.comments;

import com.google.gson.Gson;
import itis.khabibullina.dao.*;
import itis.khabibullina.dao.impl.*;
import itis.khabibullina.dto.*;
import itis.khabibullina.model.Comment;
import itis.khabibullina.model.Post;
import itis.khabibullina.model.User;
import itis.khabibullina.server.LoginServlet;
import itis.khabibullina.service.*;
import itis.khabibullina.service.impl.*;
import itis.khabibullina.util.CurrentUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "commentServlet", urlPatterns = "/comment")

public class CommentServlet extends HttpServlet {
    private final CommentService commentService = new CommentServiceImpl();
    private static final UserDao<User> userDao = new UserDaoImpl();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("commentContent");
        String postId = req.getParameter("postId");

        User user = CurrentUserUtil.getUser(req);

        commentService.save(new Comment(user.getId(), user.getLogin(), Integer.parseInt(postId), content));
        resp.sendRedirect("/forum");
    }
}
