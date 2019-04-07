package com.app.ipayu.View;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.app.ipayu.Controller.PartyController;
import com.app.ipayu.R;
import com.app.ipayu.View.Fragments.DebtCalc;
import com.app.ipayu.View.Fragments.PartyPeople;

public class Main extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private PartyPeople partyPeople;
    private DebtCalc debtCalc;
    private PartyController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents(){
        controller = new PartyController();
        bottomNav = findViewById(R.id.main_bottomNav);
        partyPeople = new PartyPeople();
        debtCalc = new DebtCalc();
        partyPeople.setController(controller);
        debtCalc.setController(controller);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_people :
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, partyPeople).commit();
                        return true;
                    case R.id.action_calculate :
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, debtCalc).commit();
                        return true;
                }
                return false;
            }
        });

        bottomNav.setSelectedItemId(R.id.action_people);
    }
}
