package com.bank.sederhana.repository;

import com.bank.sederhana.model.Nasabah;
import com.bank.sederhana.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer>{
    List<Transaksi> findById(int accountId);
    @Query("SELECT t FROM Transaksi t WHERE t.accountId=:accountId AND t.transactionDate BETWEEN :startDate AND :endDate")
    List<Transaksi> findByTransactionDate(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("accountId") int accountId);
}
