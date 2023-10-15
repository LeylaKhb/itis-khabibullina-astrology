package itis.khabibullina.server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import itis.khabibullina.client.HttpClient;
import itis.khabibullina.client.HttpClientImpl;
import itis.khabibullina.dao.UserDao;
import itis.khabibullina.dao.impl.UserDaoImpl;
import itis.khabibullina.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "horoscopeServlet", urlPatterns = "/horoscope")
public class HoroscopeServlet extends HttpServlet {
    private final UserDao<User> userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            resp.sendRedirect("/login");
        } else {
            String login = String.valueOf(httpSession.getAttribute("login"));
            User user = userDao.get(login);
            String zodiacSign = user.getZodiacSign();

            HttpClient httpClient = new HttpClientImpl();
            Map<String, String> params = new HashMap<>();
            params.put("day", "today");
            params.put("sunsign", zodiacSign.toLowerCase());
            String horoscope = httpClient.get("https://horoscope-astrology.p.rapidapi.com/horoscope",
                    params);

            JsonObject horoscopeJSON = new JsonParser().parse(horoscope).getAsJsonObject();
            String message = String.valueOf(horoscopeJSON.get("horoscope"));

            req.setAttribute("horoscope", message);
            req.setAttribute("zodiacSign", zodiacSign);
            req.getRequestDispatcher("horoscope.ftl").forward(req, resp);
        }
    }
}
