package com.iwalnexus.tsn.sharedpreferencesandsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogingActivity extends AppCompatActivity {


    private EditText user;
    private EditText pass;

    public Button log;
    private Button reg;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);


        user= findViewById(R.id.User);
        pass = findViewById(R.id.Pass);

        log = findViewById(R.id.Ingresar);
        reg = findViewById(R.id.GoReg);

        pref = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogingActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String us = pref.getString("user", "");
                String ps = pref.getString("pass", "");

                String usuario = user.getText().toString();
                String contra = pass.getText().toString();

                if(!usuario.isEmpty() && !contra.isEmpty()){

                    if(usuario.equals(us)&& contra.equals(ps)){

                        Intent intent = new Intent(LogingActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("isLogged", "yes");
                                editor.apply();
                    } else {
                        Toast t = Toast.makeText(LogingActivity.this, "No existe el usuario", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }


            }
        });

    }
}
