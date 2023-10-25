package itis.khabibullina.server.posts;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.dto.PostDto;
import itis.khabibullina.model.Comment;
import itis.khabibullina.model.User;
import itis.khabibullina.service.CommentService;
import itis.khabibullina.service.PostService;
import itis.khabibullina.service.impl.CommentServiceImpl;
import itis.khabibullina.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletePostServlet", urlPatterns = "/deletePost")

public class DeletePostServlet extends HttpServlet {
    private final PostService postService = new PostServiceImpl();

    private final CommentService commentService = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        postService.delete(id);
        for (CommentDto comment : commentService.getAllByPostId(id)) {
            commentService.delete(comment.getId());
        }


        resp.sendRedirect("/forum");
    }
}
