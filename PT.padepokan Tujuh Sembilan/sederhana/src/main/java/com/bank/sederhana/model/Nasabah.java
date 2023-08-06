package com.bank.sederhana.model;
import javax.persistence.*;

@Entity
@Table(name = "Nasabah")
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "name")
    private String name;
    public Nasabah(){};
    public Nasabah(String name){
        this.name=name;
    }
    public int getAccountId(){
        return accountId;
    }
    public void setAccountId(int accountId){
        this.accountId=accountId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
