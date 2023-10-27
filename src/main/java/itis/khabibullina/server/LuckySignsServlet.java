package itis.khabibullina.server;

import itis.khabibullina.dto.ZodiacSignLuckDto;
import itis.khabibullina.model.ZodiacSignLuck;
import itis.khabibullina.service.ZodiacSignLuckService;
import itis.khabibullina.service.impl.ZodiacSignLuckServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "luckySignsServlet", urlPatterns = "/luckySigns")

public class LuckySignsServlet extends HttpServlet {

    private final ZodiacSignLuckService zodiacSignLuckService = new ZodiacSignLuckServiceImpl();

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);


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

        List<ZodiacSignLuckDto> luckyZodiacSigns;

        String sign = req.getParameter("sign");
        if (sign == null || sign.equals("")) {
            luckyZodiacSigns = zodiacSignLuckService.getAll();
        } else {
            luckyZodiacSigns = zodiacSignLuckService.getAllByName(sign);
        }

        Collections.reverse(luckyZodiacSigns);

        req.setAttribute("zodiacSigns", zodiacSigns);
        req.setAttribute("luckyZodiacSigns", luckyZodiacSigns);
        req.getRequestDispatcher("lucky_signs.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String search = req.getParameter("search");
        List<ZodiacSignLuckDto> luckyZodiacSigns = new ArrayList<>();

        if ("Date: ".contains(search)
                || "Lucky zodiac sign: ".contains(search)
                || "Unlucky zodiac sign: ".contains(search)){
            luckyZodiacSigns = zodiacSignLuckService.getAll();
        } else {
            List<ZodiacSignLuckDto> luckyZodiacSignsAll = zodiacSignLuckService.getAll();

            for (ZodiacSignLuckDto zodiacSignLuckDto : luckyZodiacSignsAll) {
                if (zodiacSignLuckDto.getLuckyZodiacSign().contains(search)
                || zodiacSignLuckDto.getUnluckyZodiacSign().contains(search)
                || String.valueOf(zodiacSignLuckDto.getDateOfLuck()).contains(search)) {
                    luckyZodiacSigns.add(zodiacSignLuckDto);
                }
            }
        }

        req.setAttribute("zodiacSigns", zodiacSigns);
        req.setAttribute("luckyZodiacSigns", luckyZodiacSigns);
        req.getRequestDispatcher("lucky_signs.ftl").forward(req, resp);

    }
}
