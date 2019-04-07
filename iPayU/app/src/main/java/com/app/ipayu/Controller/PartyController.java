package com.app.ipayu.Controller;

import com.app.ipayu.Model.Party;
import com.app.ipayu.Model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartyController {

    private Party party;
    private List<PartyObserver> observerList;

    private void notifyDebtCalculated(){
        for (PartyObserver obs : observerList)
            obs.partyDebtCalculated();
    }

    public PartyController(){
        party = new Party(new Date());
        observerList = new ArrayList<>();
    }

    public void observ(PartyObserver obs){
        observerList.add(obs);
    }

    public void addPerson(String name, double payedValue){
        party.addPerson(new Person(name, payedValue));
    }

    public void removePerson(String name){
        party.removePerson(party.getPersonByName(name));
    }

    public boolean changePayedValue(String name, double payedValue){
        Person p  = party.getPersonByName(name);

        if (p != null)
            p.setPayedValue(payedValue);

        return p != null;
    }

    public void calculateDebts(){
        party.calculateDebts();
        notifyDebtCalculated();
    }

}
