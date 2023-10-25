package itis.khabibullina.server.comments;

import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.dto.CommentDto;
import itis.khabibullina.model.Comment;
import itis.khabibullina.model.User;
import itis.khabibullina.service.CommentService;
import itis.khabibullina.service.CommentService;
import itis.khabibullina.service.impl.CommentServiceImpl;
import itis.khabibullina.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCommentServlet", urlPatterns = "/deleteComment")

public class DeleteCommentServlet extends HttpServlet {
    private final CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        commentService.delete(id);

        resp.sendRedirect("/forum");
    }
}
