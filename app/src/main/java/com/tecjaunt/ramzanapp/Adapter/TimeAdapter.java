package com.tecjaunt.ramzanapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecjaunt.ramzanapp.Activities.SaharIftarActivity;
import com.tecjaunt.ramzanapp.R;
import com.tecjaunt.ramzanapp.networkArea.network.IslamModel;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.Holder> {
    Context context;
    ArrayList<IslamModel> models;

    public TimeAdapter(Context context, ArrayList<IslamModel> models) {
        this.context=context;
        this.models=models;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.sahri_aftari_time_item_view,viewGroup,false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        IslamModel model=models.get(i);

        holder.number.setText(String.valueOf(i));
        holder.Date.setText(model.date);
        holder.iftar_time.setText(model.aftari_time);
        holder.sehr_time.setText(model.sahri_time);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView number,Date,sehr_time,iftar_time;


        public Holder(@NonNull View itemView) {
            super(itemView);

            number=itemView.findViewById(R.id.number);
            Date=itemView.findViewById(R.id.Date);
            sehr_time=itemView.findViewById(R.id.sehr_time);
            iftar_time=itemView.findViewById(R.id.iftar_time);
        }
    }
}
