package com.tecjaunt.ramzanapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecjaunt.ramzanapp.R;
import com.tecjaunt.ramzanapp.networkArea.network.IslamModel;

import java.util.ArrayList;

import retrofit2.Callback;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.Holder> {
    Context context;
    ArrayList<IslamModel> arrayList;

    public CalenderAdapter(Context context, ArrayList<IslamModel> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calender_item_view,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

        IslamModel model=arrayList.get(i);


        holder.ramzan_date.setText(model.ramzan_date);
        holder.Date.setText(model.date);
        holder.day.setText(model.day);
        holder.iftar_time.setText(model.aftari_time);
        holder.sehr_time.setText(model.sahri_time);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView ramzan_date,Date,day,sehr_time,iftar_time;

        public Holder(@NonNull View itemView) {
            super(itemView);

            ramzan_date=itemView.findViewById(R.id.ramzan_date);
            Date=itemView.findViewById(R.id.Date);
            day=itemView.findViewById(R.id.day);
            sehr_time=itemView.findViewById(R.id.sehr_time);
            iftar_time=itemView.findViewById(R.id.iftar_time);
        }
    }
}
