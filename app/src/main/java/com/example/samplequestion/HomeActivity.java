package com.example.samplequestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button classBTN = findViewById(R.id.ClassButton);
        Button achievementBTN = findViewById(R.id.AchievementButton);
        Button submitBTN = findViewById(R.id.submitButton);
        EditText usernameInput = findViewById(R.id.editTextTextPersonName);
        EditText passwordInput = findViewById(R.id.editTextNumberPassword);




        classBTN.setOnClickListener(view -> {
            Intent intent = new Intent(this, ClassActivity.class);
            startActivity(intent);
            finish();
        });

        achievementBTN.setOnClickListener(view -> {
            Intent intent = new Intent(this, AchievementActivity.class);
            startActivity(intent);
            finish();
        });

        submitBTN.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("login",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();


            editor.putBoolean("isUserLogin", true);
            editor.commit();
            checkLogin(sharedPreferences);
        });









    }

    private void checkLogin(SharedPreferences sharedPreferences){
        if (sharedPreferences.contains("isUserLogin")) {
            Toast.makeText(getApplicationContext(), "Successfully logged in", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Not logged in", Toast.LENGTH_SHORT).show();
        }

    }




}