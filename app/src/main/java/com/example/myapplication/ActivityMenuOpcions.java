package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ActivityMenuOpcions extends AppCompatActivity {

    ArrayList<Incidence> incidences = new ArrayList<Incidence>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcions);

        final ImageButton buttonAddIncidence= findViewById(R.id.addIncidenceButton);
        buttonAddIncidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn_click", "El botó d'afegir incidència s'ha clicat");
                goToAddIncidence();
            }
        });
    }

    public void goToAddIncidence(){
        Intent intentAddIncidence = new Intent(this, AddIncidence.class);
        intentAddIncidence.putExtra("incidencesList", incidences);
        startActivity(intentAddIncidence);

    }
}