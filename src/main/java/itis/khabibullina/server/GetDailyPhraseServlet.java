package itis.khabibullina.server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import itis.khabibullina.client.HttpClient;
import itis.khabibullina.client.HttpClientImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "getDailyPhraseServlet", urlPatterns = "/daily/get")
public class GetDailyPhraseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpClient httpClient = new HttpClientImpl();
        String dailyPhrase = httpClient.get("https://horoscope-astrology.p.rapidapi.com/dailyphrase",
                new HashMap<>());
        JsonObject dailyPhraseJSON = new JsonParser().parse(dailyPhrase).getAsJsonObject();
        String message = String.valueOf(dailyPhraseJSON.get("daily"));
        resp.setContentType("text/plain");
        resp.getWriter().write(message);
    }
}