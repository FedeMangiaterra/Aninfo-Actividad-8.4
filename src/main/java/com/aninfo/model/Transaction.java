package com.aninfo.model;

import javax.persistence.*;

import static java.lang.Math.min;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long cbu;

    private Double sum;

    public Transaction(){
    }

    public Transaction(Long cbu, Double sum) {
        this.cbu = cbu;
        Double final_sum = sum;
        if (sum > 2000) {
            final_sum += min(sum * 0.1, 500);
        }
        this.sum = final_sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void print_data() {
        System.out.println(this.cbu);
        System.out.println(this.sum);
    }
}
