package com.example.samplequestion;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    ArrayList<Course> list;


    public MyAdapter(ArrayList<Course> list,
                     RecyclerViewInterface recyclerViewInterface) {

        this.list = list;
        this.recyclerViewInterface = recyclerViewInterface;
    }



    public void filterList(ArrayList<Course> filterList){
        list = filterList;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_schedule,parent,false);
        return new MyViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Course aClass= list.get(position);
        holder.day.setText(aClass.getDay());
        holder.time.setText(aClass.getTime());
        holder.course.setText(aClass.getCourse());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView day, time,course;


        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            day = itemView.findViewById(R.id.recyclerView_textView_day);
            time = itemView.findViewById(R.id.recyclerView_textView_time);
            course = itemView.findViewById(R.id.recyclerView_textView_course);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface !=null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                            recyclerViewInterface.onItemClick(position);



                    }
                }
            });
        }
    }
}