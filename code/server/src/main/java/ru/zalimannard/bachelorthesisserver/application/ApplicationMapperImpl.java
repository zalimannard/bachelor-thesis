package ru.zalimannard.bachelorthesisserver.application;

import org.springframework.stereotype.Component;
import ru.zalimannard.bachelorthesisserver.application.status.ApplicationStatus;
import ru.zalimannard.bachelorthesisserver.application.status.ApplicationStatusRepository;
import ru.zalimannard.bachelorthesisserver.doctornote.DoctorNote;
import ru.zalimannard.bachelorthesisserver.doctornote.DoctorNoteRepository;
import ru.zalimannard.bachelorthesisserver.exceptions.NotFoundException;
import ru.zalimannard.bachelorthesisserver.patient.Patient;
import ru.zalimannard.bachelorthesisserver.patient.PatientRepository;

import java.util.Optional;

@Component
public class ApplicationMapperImpl implements ApplicationMapper {
    private final ApplicationRepository applicationRepository;
    private final PatientRepository patientRepository;
    private final DoctorNoteRepository doctorNoteRepository;
    private final ApplicationStatusRepository applicationStatusRepository;

    public ApplicationMapperImpl(ApplicationRepository applicationRepository, PatientRepository patientRepository, DoctorNoteRepository doctorNoteRepository, ApplicationStatusRepository applicationStatusRepository) {
        this.applicationRepository = applicationRepository;
        this.patientRepository = patientRepository;
        this.doctorNoteRepository = doctorNoteRepository;
        this.applicationStatusRepository = applicationStatusRepository;
    }

    @Override
    public Application toEntity(ApplicationDto dto) {
        Application entity = Application.builder()
                .id(dto.getId())
                .parentApplication(obtainParentApplication(dto.getParentApplicationId()))
                .patient(obtainPatient(dto.getPatientId()))
                .doctorNote(obtainDoctorNote(dto.getDoctorNoteId()))
                .status(obtainStatus(dto.getStatusId()))
                .finalDiagnosis(dto.getFinalDiagnosis())
                .build();
        if (entity.getParentApplication() == null) {
            entity.setParentApplication(entity);
        }
        return entity;
    }

    @Override
    public ApplicationDto toDto(Application entity) {
        return ApplicationDto.builder()
                .id(entity.getId())
                .parentApplicationId(obtainParentApplicationId(entity.getParentApplication()))
                .patientId(obtainPatientId(entity.getPatient()))
                .doctorNoteId(obtainDoctorNoteId(entity.getDoctorNote()))
                .statusId(obtainStatusId(entity.getStatus()))
                .finalDiagnosis(entity.getFinalDiagnosis())
                .build();
    }

    private Integer obtainParentApplicationId(Application application) {
        if (application == null) {
            return null;
        } else {
            return application.getId();
        }
    }

    private Application obtainParentApplication(Integer applicationId) {
        if (applicationId == null) {
            return null;
        } else {
            Optional<Application> applicationOptional = applicationRepository.findById(applicationId);
            return applicationOptional.orElse(null);
        }
    }

    private int obtainPatientId(Patient patient) {
        return patient.getId();
    }

    private Patient obtainPatient(int patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else {
            throw new NotFoundException("???????????????????? ?? ?????????????????? ???????????????? ???? ????????????????????");
        }
    }

    private int obtainDoctorNoteId(DoctorNote doctorNote) {
        return doctorNote.getId();
    }

    private DoctorNote obtainDoctorNote(int doctorNoteId) {
        Optional<DoctorNote> doctorNoteOptional = doctorNoteRepository.findById(doctorNoteId);
        if (doctorNoteOptional.isPresent()) {
            return doctorNoteOptional.get();
        } else {
            throw new NotFoundException("???????????????????? ?? ?????????????????? ?????????????????????? ???? ????????????????????");
        }
    }

    private int obtainStatusId(ApplicationStatus applicationStatus) {
        return applicationStatus.getId();
    }

    private ApplicationStatus obtainStatus(int applicationStatusId) {
        Optional<ApplicationStatus> applicationStatusOptional = applicationStatusRepository.findById(applicationStatusId);
        if (applicationStatusOptional.isPresent()) {
            return applicationStatusOptional.get();
        } else {
            throw new NotFoundException("???????????????????? ?? ?????????????????? ?????????????? ???? ????????????????????");
        }
    }
}
