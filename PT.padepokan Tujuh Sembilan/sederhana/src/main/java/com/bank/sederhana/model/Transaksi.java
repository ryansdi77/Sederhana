package com.bank.sederhana.model;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "account_id")
    private int accountId;
    @Column(name = "transaction_date")
    private String transactionDate;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "amount")
    private BigDecimal amount;
    public Transaksi(){};
    public Transaksi(int accountId,String transactionDate,String description,String status,BigDecimal amount){
        this.accountId=accountId;
        this.transactionDate=transactionDate;
        this.description=description;
        this.status=status;
        this.amount=amount;
    }
    public int getId(){
        return id;
    }
    public int getAccountId(){
        return accountId;
    }
    public void setAccountId(int accountId){
        this.accountId=accountId;
    }
    public String getTransactionDate(){
        return transactionDate;
    }
    public void setTransactionDate(String transactionDate){
        this.transactionDate=transactionDate;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }
}
