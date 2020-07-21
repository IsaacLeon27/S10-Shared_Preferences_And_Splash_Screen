package com.iwalnexus.tsn.sharedpreferencesandsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;

    public Button Reg;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        user= findViewById(R.id.userRegist);
        pass = findViewById(R.id.PassRegist);

        Reg = findViewById(R.id.registrar);

        pref = getSharedPreferences("Preferences", Context.MODE_PRIVATE);



        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(!user.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()){
              SharedPreferences.Editor editor = pref.edit();
              editor.putString("user", user.getText().toString());
              editor.putString("pass", pass.getText().toString());
              editor.apply();


                  Toast t = Toast.makeText(RegistActivity.this, "Registrado", Toast.LENGTH_LONG);
                  t.show();

                  finish();

              } else {
                  Toast t = Toast.makeText(RegistActivity.this, "Se requieren los campos", Toast.LENGTH_LONG);
                  t.show();

              }


            }
        });
    }
}
