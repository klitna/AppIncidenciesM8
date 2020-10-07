package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddIncidence extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ArrayList<Incidence> incidencesList =  (ArrayList<Incidence>)getIntent().getSerializableExtra("incidencesList");

        setContentView(R.layout.activity_add_incidence);
        Spinner spinner = findViewById(R.id.addIncidenceSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.incidencesUrgence, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Button saveIncidenceButton = findViewById(R.id.saveIncidenceButton);
        final TextView personName = findViewById(R.id.editTextTextPersonName);
        final Context c = getApplicationContext();
        final Spinner incidenceSpinner = findViewById(R.id.addIncidenceSpinner);
        saveIncidenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (personName.equals("") || personName.equals(null)) {
                    Toast.makeText(c, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(c, "Incidence saved succesfully!", Toast.LENGTH_SHORT).show();
                    Incidence incidence = new Incidence(personName.getText().toString(), incidenceSpinner.getSelectedItem().toString());
                    /*incidence.name=personName.getText().toString();
                    incidence.urgence=incidenceSpinner.getSelectedItem().toString();*/
                    incidencesList.add(incidence);
                    Log.i("add_incidence_success", "person name: "+personName );
                    for(int i=0; i<incidencesList.size(); i++)
                        Log.i("show_incidence", "incidence "+i+": "+ incidencesList.get(i).getName());
                }
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goBack(){

    }
}