package com.bank.sederhana.controller;

import com.bank.sederhana.model.Nasabah;
import com.bank.sederhana.model.Transaksi;
import com.bank.sederhana.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TransaksiController {
    @Autowired
    TransaksiRepository transaksiRepository;

    @GetMapping("/transaksi")
    public ResponseEntity<List<Transaksi>> getAllTransaksi(){
        List<Transaksi> data = transaksiRepository.findAll();

        if(!data.isEmpty()){
            return new ResponseEntity<>(data,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reportCetakBuku")
    public ResponseEntity<List<Transaksi>> getTransaksiByDate(@RequestBody Map<Object,String> transaksi) throws ParseException {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date startFormat = inputDateFormat.parse(transaksi.get("startDate"));
        Date endFormat = inputDateFormat.parse(transaksi.get("endDate"));
        String startDate = outputDateFormat.format(startFormat);
        String endDate = outputDateFormat.format(endFormat);

        int accountId = Integer.valueOf(transaksi.get("accountId"));
        List<Transaksi> data = transaksiRepository.findByTransactionDate(startDate,endDate,accountId);

        if(!data.isEmpty()){
            return new ResponseEntity<>(data,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/transaksi")
    public ResponseEntity<Transaksi> createTransaksi(@RequestBody Transaksi transaksi) {
        try {
            Transaksi _transaksi = transaksiRepository.save(new Transaksi(transaksi.getAccountId(),transaksi.getTransactionDate(), transaksi.getDescription(), transaksi.getStatus(),transaksi.getAmount()));
            return new ResponseEntity<>(_transaksi, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
