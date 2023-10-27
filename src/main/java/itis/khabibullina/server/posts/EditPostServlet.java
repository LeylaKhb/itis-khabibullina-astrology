package itis.khabibullina.server.posts;

import itis.khabibullina.dto.PostDto;
import itis.khabibullina.model.Post;
import itis.khabibullina.model.User;
import itis.khabibullina.service.PostService;
import itis.khabibullina.service.impl.PostServiceImpl;
import itis.khabibullina.util.CurrentUserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "editPostServlet", urlPatterns = "/editPost")

public class EditPostServlet extends HttpServlet {
    private final PostService postService = new PostServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        PostDto post = postService.get(id);
        req.setAttribute("post", post);
        req.getRequestDispatcher("posts/edit_post.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        int id = Integer.parseInt(req.getParameter("id"));
        Date date = new Date(System.currentTimeMillis());

        User user = CurrentUserUtil.getUser(req);
        Post post = new Post(id, user.getId(), user.getLogin(), content, date);
        postService.update(post);

        resp.sendRedirect("/forum");

    }
}

