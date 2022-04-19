package com.example.dentistsOffice.service;

import com.example.dentistsOffice.model.Appointment;
import com.example.dentistsOffice.model.DTO.AppointmentDTO;
import com.example.dentistsOffice.repository.IAppointmentRepository;
import com.example.dentistsOffice.service.intface.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO,Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void createAppointment(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    @Override
    public AppointmentDTO readAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent()){
            appointmentDTO = mapper.convertValue(appointmentDTO, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void editAppointment(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    @Override
    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Set<AppointmentDTO> getAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentsDTO = new HashSet<>();
        for(Appointment appointment : appointments){
            appointmentsDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentsDTO;
    }
}
