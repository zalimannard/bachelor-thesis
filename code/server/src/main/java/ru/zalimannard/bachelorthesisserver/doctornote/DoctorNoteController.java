package ru.zalimannard.bachelorthesisserver.doctornote;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${application.endpoint.root}" + "${application.endpoint.doctorNote}")
@Tag(name = "Направления")
public class DoctorNoteController {
    private final DoctorNoteRepository doctorNoteRepository;

    public DoctorNoteController(DoctorNoteRepository doctorNoteRepository) {
        this.doctorNoteRepository = doctorNoteRepository;
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение направления")
    public DoctorNote get(@PathVariable int id) {
        return doctorNoteRepository.retrieve(id);
    }

    @GetMapping
    @Operation(summary = "Получение списка направлений")
    public List<DoctorNote> getAll() {
        return doctorNoteRepository.retrieveAll();
    }

    @PostMapping
    @Operation(summary = "Создание нового направления")
    public void post(@RequestBody DoctorNote doctorNote) {
        doctorNoteRepository.create(doctorNote);
    }

    @PutMapping
    @Operation(summary = "Обновление существующего направления")
    public void put(@RequestBody DoctorNote doctorNote) {
        doctorNoteRepository.update(doctorNote);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление направления")
    public void delete(@PathVariable int id) {
        doctorNoteRepository.delete(id);
    }
}