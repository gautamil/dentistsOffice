package com.example.dentistsOffice.repository;

import com.example.dentistsOffice.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Long> {
}
