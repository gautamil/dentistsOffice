package com.example.dentistsOffice.controller;

import com.example.dentistsOffice.model.DTO.AppointmentDTO;
import com.example.dentistsOffice.service.intface.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id){
        return appointmentService.readAppointment(id);
    }

    @PutMapping
    public ResponseEntity<?> editAppointment(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.editAppointment(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Long id){
        appointmentService.cancelAppointment(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<AppointmentDTO> getAllAppointments(){
        return appointmentService.getAppointments();
    }
}

