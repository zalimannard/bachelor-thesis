package ru.zalimannard.bachelorthesisserver.scheduleelments.status;

import java.util.List;

public interface ScheduleElementStatusService {
    ScheduleElementStatusDto read(int id);

    List<ScheduleElementStatusDto> list();

    ScheduleElementStatusDto create(ScheduleElementStatusDto scheduleElementStatusDto);

    ScheduleElementStatusDto update(ScheduleElementStatusDto scheduleElementStatusDto);

    ScheduleElementStatusDto delete(int id);
}
