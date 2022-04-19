package com.example.dentistsOffice.repository;

import com.example.dentistsOffice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
}
