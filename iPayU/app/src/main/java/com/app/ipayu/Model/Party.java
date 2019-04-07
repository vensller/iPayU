package com.app.ipayu.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Party {

    private Date partyDate;
    private List<Person> people;

    public Party(Date partyDate) {
        this.partyDate = partyDate;
        this.people = new ArrayList<>();
    }

    private List<Person> getDebtPerson(double value, double valuePerPerson){
        List<Person> debtList = new ArrayList<>();

        for (Person p : people)
            if (p.getPayedValue() < value && p.getPayedValue() < valuePerPerson)
                debtList.add(p);

        return debtList;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(Date partyDate) {
        this.partyDate = partyDate;
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public void removePerson(Person person){
        if (person != null)
            people.remove(person);
    }

    public Person getPersonByName(String name){
        for (Person p : people)
            if (p.getName().equalsIgnoreCase(name))
                return p;

        return null;
    }

    public double getAccountValue(){
        double total = 0;

        for (Person p : people)
            total += p.getPayedValue();

        return total;
    }

    public void calculateDebts(){
        double valuePerPerson = 0;

        if (people.size() > 0)
           valuePerPerson = getAccountValue() / people.size();

        for (Person p : people){
            if (p.getPayedValue() > valuePerPerson) {
                List<Person> debtListPeople = getDebtPerson(p.getPayedValue(), valuePerPerson);
                double valueToPay = p.getPayedValue() - valuePerPerson;

                for (Person debt : debtListPeople){
                    double valueDebtPayed = 0;

                    if (valueToPay > (valuePerPerson - debt.getPayedValue()))
                        valueDebtPayed = valuePerPerson - debt.getPayedValue();
                    else valueDebtPayed = valueToPay;

                    debt.setPayedValue(debt.getPayedValue() + valueDebtPayed);
                    valueToPay -= valueDebtPayed;

                    p.addDebt(debt, valueDebtPayed);

                    if (valueToPay == 0)
                        break;
                }
            }
        }
    }


}
