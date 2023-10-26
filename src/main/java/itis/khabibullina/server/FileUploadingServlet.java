package itis.khabibullina.server;

import com.cloudinary.Cloudinary;
import itis.khabibullina.util.CloudinaryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = "/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class FileUploadingServlet extends HttpServlet {

    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("upload.ftl");

    }

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");

        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String filePath = FILE_PATH_PREFIX + File.separator
                + filename.hashCode() % DIRECTORIES_COUNT + File.separator + filename;
        File file = new File(filePath);
        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];

        content.read(buffer);

        outputStream.write(buffer);
        outputStream.close();

        Map uploadResult = cloudinary.uploader().upload(file, new HashMap<>());
        String url = String.valueOf(uploadResult.get("url"));


        Cookie cookie = new Cookie("imageUrl", url);
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);

        resp.sendRedirect("/profile");
    }
}
