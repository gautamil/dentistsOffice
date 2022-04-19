package com.example.dentistsOffice.repository;

import com.example.dentistsOffice.model.Domicile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicileRepository extends JpaRepository<Domicile, Long> {

}
