package com.example.samplequestion;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;


    public MyListAdapter(Activity context, String[] maintitle,String[] subtitle) {
        super(context, R.layout.item_history, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;


    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_history, null,true);

        TextView courseText = (TextView) rowView.findViewById(R.id.item_courseName);
        TextView gradeText = (TextView) rowView.findViewById(R.id.item_courseGrade);

        courseText.setText(maintitle[position]);
        gradeText.setText(subtitle[position]);

        return rowView;

    };


}
