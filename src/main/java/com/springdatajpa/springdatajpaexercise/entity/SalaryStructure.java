package com.springdatajpa.springdatajpaexercise.entity;

import javax.persistence.Embeddable;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="empId")
@Embeddable
public class SalaryStructure {
    private int basicsalary, bonussalary, taxamount, specialallowancesalary;

    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getBonussalary() {
        return bonussalary;
    }

    public void setBonussalary(int bonussalary) {
        this.bonussalary = bonussalary;
    }

    public int getTaxamount() {
        return taxamount;
    }

    public void setTaxamount(int taxamount) {
        this.taxamount = taxamount;
    }

    public int getSpecialallowancesalary() {
        return specialallowancesalary;
    }

    public void setSpecialallowancesalary(int specialallowancesalary) {
        this.specialallowancesalary = specialallowancesalary;
    }
}
