package com.example.dentistsOffice.model.DTO;

import com.example.dentistsOffice.model.Dentist;
import com.example.dentistsOffice.model.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDTO {

    private Long id;
    private LocalDateTime dateTime;
    private Dentist dentist;
    private Patient patient;

}
