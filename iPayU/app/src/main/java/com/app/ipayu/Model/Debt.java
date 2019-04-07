package com.app.ipayu.Model;

public class Debt {

    private Person person;
    private double value;

    public Debt(Person person, double value) {
        this.person = person;
        this.value = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
