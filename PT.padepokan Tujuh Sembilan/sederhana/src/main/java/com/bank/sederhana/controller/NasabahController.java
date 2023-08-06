package com.bank.sederhana.controller;

import com.bank.sederhana.model.Nasabah;
import com.bank.sederhana.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class NasabahController {
    @Autowired
    NasabahRepository nasabahRepository;

    @GetMapping("/nasabah")
    public ResponseEntity<List<Nasabah>> getAllNasabah(){
        List<Nasabah> data = nasabahRepository.findAll();

        if(!data.isEmpty()){
            return new ResponseEntity<>(data,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/nasabah")
    public ResponseEntity<Nasabah> createNasabah(@RequestBody Nasabah nasabah) {
        try {
            Nasabah _nasabah = nasabahRepository.save(new Nasabah(nasabah.getName()));
            return new ResponseEntity<>(_nasabah, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
