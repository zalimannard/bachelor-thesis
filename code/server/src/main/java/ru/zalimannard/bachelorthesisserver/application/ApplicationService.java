package ru.zalimannard.bachelorthesisserver.application;

import java.util.List;

public interface ApplicationService {
    ApplicationDto read(int id);

    List<ApplicationDto> list();

    ApplicationDto create(ApplicationDto applicationDto);

    ApplicationDto update(ApplicationDto applicationDto);

    ApplicationDto delete(int id);
}
