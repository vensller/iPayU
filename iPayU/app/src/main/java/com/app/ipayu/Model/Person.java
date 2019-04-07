package com.app.ipayu.Model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double payedValue;
    private List<Debt> debtList;

    public Person(String name, double payedValue) {
        this.name = name;
        this.payedValue = payedValue;
        this.debtList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayedValue() {
        return payedValue;
    }

    public void setPayedValue(double payedValue) {
        this.payedValue = payedValue;
    }

    public void addDebt(Person person, double value){
        debtList.add(new Debt(person, value));
    }

    public List<Debt> getDebtList() {
        return debtList;
    }
}
