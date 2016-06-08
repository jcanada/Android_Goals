package com.example.rikacanada.goalsvolley;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Rika Canada on 6/2/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private List<Person> persons;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name, country, age, gender, eyeColor, regDate;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            country = (TextView) view.findViewById(R.id.country);
            age = (TextView) view.findViewById(R.id.age);
            gender = (TextView) view.findViewById(R.id.gender);
            eyeColor = (TextView) view.findViewById(R.id.eye_color);
            regDate = (TextView) view.findViewById(R.id.registered_date);
        }
    }

    public RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        holder.name.setText(persons.get(position).getName());
        holder.country.setText(persons.get(position).getCountry());
        holder.age.setText("Age: " + String.valueOf(persons.get(position).getAge()));
        holder.gender.setText("Gender: " + String.valueOf(persons.get(position).getGender()));
        holder.eyeColor.setText("Eye Color: " + persons.get(position).getEyeColor());
        holder.regDate.setText("Registered: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(persons.get(position).getRegistrationDate()));
    }

    @Override
    public int getItemCount(){
        return persons.size();
    }
}
