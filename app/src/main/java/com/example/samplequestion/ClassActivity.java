package com.example.samplequestion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ClassActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ArrayList<Course> list;
    private ArrayList<String> enrolledList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        //Toolbar back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

        //recyclerview
        list = new ArrayList<>();
        list.add(new Course("Monday", "3:00 PM", "English", null));
        list.add(new Course("Monday", "4:00 PM", "Maths",null));
        list.add(new Course("Tuesday", "12:00 PM", "English",null));
        RecyclerView recyclerView = findViewById(R.id.classAct_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);

        enrolledList = new ArrayList<>();



    }

    @Override
    public void onItemClick(int position) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Enroll?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        SharedPreferences sharedPreferences = getSharedPreferences("courseEnrolled", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        enrolledList.add(new Course(list.get(position).getDay(),list.get(position).getTime(),list.get(position).getCourse(),"").toString());
//                        editor.putString("day", list.get(position).getDay());
//                        editor.putString("time", list.get(position).getTime());
//                        editor.putString("course", list.get(position).getCourse());
//                        editor.commit();

                        //Put list of data in set for shared preferences
                        Set<String> set = new HashSet<String>();
                        set.addAll(enrolledList);
                        editor.putStringSet("courseKey", set);
                        editor.commit();

                        Toast.makeText(getApplicationContext(), "Enrolled", Toast.LENGTH_SHORT).show();










                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }




}