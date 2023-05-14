package com.aninfo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cbu;

    private Double balance;

    /*private List<Transaction> myObjects;

    @ElementCollection(targetClass = Transaction.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "books", joinColumns = @JoinColumn(name = "library_id"))
    @Column(name = "book", nullable = false)
    private List<Transaction> transactions = new ArrayList<Transaction>();*/

    public Account(){
    }

    public Account(Double balance) {
        this.balance = balance;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /*public void addTransaction(Transaction transaction) {}

    public Double[] getTransactions() { return transactions; }

    public Double[] getTransaction(Long id) { }

    public deleteTransaction(Long id) {}*/

}
