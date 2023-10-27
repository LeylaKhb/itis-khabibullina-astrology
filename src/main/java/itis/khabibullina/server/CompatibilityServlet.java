package itis.khabibullina.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import itis.khabibullina.client.HttpClient;
import itis.khabibullina.client.HttpClientImpl;
import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.dto.FriendDto;
import itis.khabibullina.dto.UserDto;
import itis.khabibullina.model.User;
import itis.khabibullina.service.FriendService;
import itis.khabibullina.service.UserService;
import itis.khabibullina.service.impl.FriendServiceImpl;
import itis.khabibullina.service.impl.UserServiceImpl;
import itis.khabibullina.util.CurrentUserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "compatibilityServlet", urlPatterns = "/compatibility")
public class CompatibilityServlet extends HttpServlet {
    private final FriendService friendService = new FriendServiceImpl();

    private final UserDao<User> userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = CurrentUserUtil.getUser(req);

        req.setAttribute("friends", friendService.getAllByUserId(user.getId()));
        req.getRequestDispatcher("compatibility.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String friendName = req.getParameter("friend");
        User user = CurrentUserUtil.getUser(req);

        List<FriendDto> friendDtoList = friendService.getAllByUserId(user.getId());
        for (FriendDto friendDto : friendDtoList) {
            if (friendDto.getName().equals(friendName)) {
                HttpClient httpClient = new HttpClientImpl();
                Map<String, String> params = new HashMap<>();
                params.put("sign1", user.getZodiacSign());
                params.put("sign2", friendDto.getZodiacSign());
                String compatibility = httpClient.get("https://horoscope-astrology.p.rapidapi.com/affinity",
                        params);

                JsonArray compatibilityJSON = new JsonParser().parse(compatibility).getAsJsonArray();
                JsonObject compatibilityJSONParsed = compatibilityJSON.get(0).getAsJsonObject();

                req.setAttribute("header", compatibilityJSONParsed.get("header")
                        .getAsString().replaceAll("/n", ""));
                req.setAttribute("text", compatibilityJSONParsed.get("text")
                        .getAsString().replaceAll("/n", ""));


                req.getRequestDispatcher("compatibility.ftl").forward(req, resp);

            }
        }
    }
}
