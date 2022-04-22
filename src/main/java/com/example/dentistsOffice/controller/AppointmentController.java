package com.example.dentistsOffice.controller;

import com.example.dentistsOffice.exceptions.ExceptionMessage;
import com.example.dentistsOffice.model.DTO.AppointmentDTO;
import com.example.dentistsOffice.service.intface.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    LocalDateTime currDateTime = LocalDateTime.now();

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) throws ExceptionMessage{
        if(appointmentDTO.getDateTime().isBefore(currDateTime)){
            throw new ExceptionMessage("Cannot create appointment for a date and time previous to the current one.");
        } else {
            appointmentService.createAppointment(appointmentDTO);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Appointment booked successfully");
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id){
        return appointmentService.readAppointment(id);
    }

    @PutMapping
    public ResponseEntity<?> editAppointment(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.editAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Appointment edited successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long id){
        appointmentService.cancelAppointment(id);
        return ResponseEntity.status(HttpStatus.OK).body("Appointment cancelled");
    }

    @GetMapping
    public Collection<AppointmentDTO> getAllAppointments(){
        return appointmentService.getAppointments();
    }
}

