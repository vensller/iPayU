package com.app.ipayu.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.ipayu.Controller.PartyController;
import com.app.ipayu.R;

public class PartyPeople extends Fragment {

    private PartyController controller;

    public PartyPeople(){
    }

    public void setController(PartyController controller) {
        this.controller = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_party_people, container, false);
    }

}
