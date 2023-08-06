package com.bank.sederhana.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.sederhana.model.Nasabah;
public interface NasabahRepository extends JpaRepository<Nasabah, Integer>{
    List<Nasabah> findByAccountId(int accountId);
}
