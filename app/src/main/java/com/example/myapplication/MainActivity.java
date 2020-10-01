package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.loginButton);
        final EditText username = findViewById(R.id.loginEmail);
        final EditText password = findViewById(R.id.loginPassword);
        final TextView title = findViewById(R.id.loginTitle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn_click", "EL botó de login s'ha clicat");
                String textUsername = username.getText().toString();
                String textPassword = password.getText().toString();
                if (textUsername.equals("admin") && textPassword == "admin") {
                    Log.i("login_success", "Admin s'ha loguejat");
                    title.setText("LOGGED IN SUCCESSFULY!");
                } else
                    Log.i("login_success", "Error al loguearse");


            }
        });
    }

    public void goToMenu() {
        Intent intentMenu = new Intent(this, ActivityMenuOpcions.class);
        startActivity(intentMenu);
    }

    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

*/
}