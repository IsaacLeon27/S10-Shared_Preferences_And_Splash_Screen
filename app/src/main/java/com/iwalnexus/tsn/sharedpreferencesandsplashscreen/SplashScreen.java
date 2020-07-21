package com.iwalnexus.tsn.sharedpreferencesandsplashscreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pref = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LogingActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);

        String isLogged = pref.getString("isLogged", "NO");

        if(isLogged.equals("yes")){
            startActivity(intentMain);
        } else {
            startActivity(intentLogin);
        }


    }
}
