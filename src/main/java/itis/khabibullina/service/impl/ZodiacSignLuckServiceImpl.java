package itis.khabibullina.service.impl;

import itis.khabibullina.dao.Dao;
import itis.khabibullina.dao.ZodiacSignLuckDao;
import itis.khabibullina.dao.impl.ZodiacSignLuckDaoImpl;
import itis.khabibullina.dto.ZodiacSignLuckDto;
import itis.khabibullina.model.ZodiacSignLuck;
import itis.khabibullina.service.ZodiacSignLuckService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ZodiacSignLuckServiceImpl implements ZodiacSignLuckService {
    private final ZodiacSignLuckDao<ZodiacSignLuck> dao = new ZodiacSignLuckDaoImpl();

    @Override
    public List<ZodiacSignLuckDto> getAll() {
        return dao.getAll().stream().map(
                z -> new ZodiacSignLuckDto(z.getDateOfLuck(), z.getLuckyZodiacSign(), z.getUnluckyZodiacSign())
        ).collect(Collectors.toList());
    }

    @Override
    public ZodiacSignLuckDto get(int id) {
        ZodiacSignLuck z = dao.get(id);
        return new ZodiacSignLuckDto(z.getDateOfLuck(), z.getLuckyZodiacSign(), z.getUnluckyZodiacSign());
    }

    @Override
    public ZodiacSignLuckDto get(Date date) {
        ZodiacSignLuck z = dao.get(date);
        if (z == null) return null;
        return new ZodiacSignLuckDto(z.getDateOfLuck(), z.getLuckyZodiacSign(), z.getUnluckyZodiacSign());    }

    @Override
    public void save(ZodiacSignLuck zodiacSignLuck) {
        dao.save(zodiacSignLuck);
    }

}
