package itis.khabibullina.server;

import itis.khabibullina.dao.*;
import itis.khabibullina.dao.impl.*;
import itis.khabibullina.dto.PostDto;
import itis.khabibullina.model.Post;
import itis.khabibullina.model.User;
import itis.khabibullina.service.*;
import itis.khabibullina.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "forumServlet", urlPatterns = "/forum")

public class ForumServlet extends HttpServlet {
    private static final Dao<Post> postDao = new PostDaoImpl();
    private final PostService postService = new PostServiceImpl();
    private final CommentService commentService = new CommentServiceImpl();
    private static final UserDao<User> userDao = new UserDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("login") != null) {
            req.setAttribute("sessionLogin", httpSession.getAttribute("login"));
        }

        List<PostDto> posts = postService.getAll();
        Collections.reverse(posts);
        req.setAttribute("posts", posts);
        req.setAttribute("comments", commentService.getAll());
        req.getRequestDispatcher("forum.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        HttpSession httpSession = req.getSession(false);
        String login = String.valueOf(httpSession.getAttribute("login"));

        Date date = new Date(System.currentTimeMillis());
        User user = userDao.get(login);

        postService.save(new Post(user.getId(), login, content, date));
        resp.sendRedirect("/forum");

    }
}
