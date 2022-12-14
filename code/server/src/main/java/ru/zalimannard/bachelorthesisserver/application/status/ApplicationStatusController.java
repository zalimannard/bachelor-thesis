package ru.zalimannard.bachelorthesisserver.application.status;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${application.endpoint.root}" + "${application.endpoint.applicationStatus}")
@Tag(name = "Статусы обращений")
public class ApplicationStatusController {
    private final ApplicationStatusService applicationStatusService;

    public ApplicationStatusController(ApplicationStatusService applicationStatusService) {
        this.applicationStatusService = applicationStatusService;
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение статуса обращений")
    public ApplicationStatusDto get(@PathVariable int id) {
        return applicationStatusService.get(id);
    }

    @GetMapping
    @Operation(summary = "Получение списка статусов обращений")
    public List<ApplicationStatusDto> getAll() {
        return applicationStatusService.getAll();
    }

    @PostMapping
    @Operation(summary = "Создание нового статуса обращений")
    public ApplicationStatusDto post(@RequestBody ApplicationStatusDto applicationStatusDto) {
        return applicationStatusService.post(applicationStatusDto);
    }

    @PutMapping
    @Operation(summary = "Обновление существующего статуса обращений")
    public ApplicationStatusDto put(@RequestBody ApplicationStatusDto applicationStatusDto) {
        return applicationStatusService.put(applicationStatusDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление статуса обращений")
    public ApplicationStatusDto delete(@PathVariable int id) {
        return applicationStatusService.delete(id);
    }
}
