package com.example.webbmortgageplanner.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "prospect")
public class Prospect {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;


    @Getter
    @Setter
    private double totalLoan;

    @Getter
    @Setter
    private double interest;

    @Getter
    @Setter
    private double years;

    @Getter
    @Setter
    private double monthlyPayment;


    public Prospect() {}

    public Prospect(String name, double totalLoan, double interest, double years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
        monthlyPayment = 0;
    }

    @Override
    public String toString() {
        return "Prospect: id "+id+", name: "+ name+", total loan: "+ totalLoan+", interest: "+interest
                +", years: "+ years+", monthly payment: "+monthlyPayment;
    }

}