package com.example.dentistsOffice.controller;

import com.example.dentistsOffice.model.DTO.DomicileDTO;
import com.example.dentistsOffice.service.intface.IDomicileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/addresses")
public class DomicileController {

    @Autowired
    IDomicileService domicileService;

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody DomicileDTO domicileDTO){
        domicileService.createAddress(domicileDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicileDTO getAddress(@PathVariable Long id){
        return domicileService.readAddress(id);
    }

    @PutMapping
    public ResponseEntity<?> editAddress(@RequestBody DomicileDTO domicileDTO){
        domicileService.editAddress(domicileDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAddress(@PathVariable Long id){
        domicileService.removeAddress(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<DomicileDTO> getAllAddresses(){
        return domicileService.getAddresses();
    }
}
