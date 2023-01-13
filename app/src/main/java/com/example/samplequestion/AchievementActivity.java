package com.example.samplequestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AchievementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        //Toolbar back button
        Toolbar toolbar = findViewById(R.id.achievementAct_TB);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AchievementActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

        ListView history = findViewById(R.id.achievementAct_LV);

        SharedPreferences sharedPreferences = getSharedPreferences("courseEnrolled", Context.MODE_PRIVATE);
        String course1 = sharedPreferences.getString("course", "");

        String[] courseName = {course1};
        String[] grades = {"A"};



        MyListAdapter adapter=new MyListAdapter(this, courseName, grades);
        history.setAdapter(adapter);


        TextView total = findViewById(R.id.achievementAct_TV_total);
        total.setText(String.valueOf(courseName.length));






    }
}