package ru.zalimannard.bachelorthesisserver.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class PatientDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("birthdate")
    private Date birthdate;

    @JsonProperty("address")
    private String address;

    @JsonProperty("occupation")
    private String occupation;
}