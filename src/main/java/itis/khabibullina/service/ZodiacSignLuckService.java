package itis.khabibullina.service;

import itis.khabibullina.dto.ZodiacSignLuckDto;
import itis.khabibullina.model.ZodiacSignLuck;

import java.sql.Date;
import java.util.List;

public interface ZodiacSignLuckService {
    List<ZodiacSignLuckDto> getAll();

    ZodiacSignLuckDto get(int id);

    ZodiacSignLuckDto get(Date date);

    List<ZodiacSignLuckDto> getAllByName(String sign);

    void save(ZodiacSignLuck zodiacSignLuck);
}
