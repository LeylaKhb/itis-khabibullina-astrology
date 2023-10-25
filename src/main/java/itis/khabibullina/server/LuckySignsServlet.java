package itis.khabibullina.server;

import itis.khabibullina.model.ZodiacSignLuck;
import itis.khabibullina.service.ZodiacSignLuckService;
import itis.khabibullina.service.impl.ZodiacSignLuckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "luckySignsServlet", urlPatterns = "/luckySigns")

public class LuckySignsServlet extends HttpServlet {

    private final ZodiacSignLuckService zodiacSignLuckService = new ZodiacSignLuckServiceImpl();

    private final String[] zodiacSigns = new String[] {"Capricorn", "Aquarius", "Pisces", "Aries", "Taurus",
            "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius"};
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Date date = new Date(System.currentTimeMillis());
        if (zodiacSignLuckService.get(date) == null) {
            int firstRandomIndex = (int) ( Math.random() * 12 );
            int secondRandomIndex = firstRandomIndex;
            while (firstRandomIndex == secondRandomIndex) {
                secondRandomIndex = (int) ( Math.random() * 12 );
            }
            zodiacSignLuckService.save(new ZodiacSignLuck(
                    date,
                    zodiacSigns[firstRandomIndex],
                    zodiacSigns[secondRandomIndex]));
        }
        req.setAttribute("zodiacSigns", zodiacSignLuckService.getAll());
        req.getRequestDispatcher("lucky_signs.ftl").forward(req, resp);
    }
}
