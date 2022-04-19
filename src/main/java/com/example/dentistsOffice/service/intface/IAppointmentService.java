package com.example.dentistsOffice.service.intface;

import com.example.dentistsOffice.model.DTO.AppointmentDTO;

import java.util.Set;

public interface IAppointmentService {
    void createAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO readAppointment(Long id);
    void editAppointment(AppointmentDTO appointmentDTO);
    void cancelAppointment(Long id);
    Set<AppointmentDTO> getAppointments();
}
