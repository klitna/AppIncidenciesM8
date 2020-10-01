package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityMenuOpcions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcions);

        final ImageButton buttonAddIncidence= findViewById(R.id.addIncidenceButton);
        buttonAddIncidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn_click", "El botó d'afegir incidència s'ha clicat");
            }
        });
    }

    public void goToAddIncidence(){
        Intent intentAddIncidence = new Intent(this, AddIncidence.class);
        startActivity(intentAddIncidence);
    }
}