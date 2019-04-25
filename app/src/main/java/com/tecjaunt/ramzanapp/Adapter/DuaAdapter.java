package com.tecjaunt.ramzanapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tecjaunt.ramzanapp.Activities.DuaDetails;
import com.tecjaunt.ramzanapp.Activities.DuaLayout;
import com.tecjaunt.ramzanapp.R;

public class DuaAdapter extends BaseAdapter {
    Context context;
    String[] duas_arabic;
    String[] meaning;
    String[] translatitions;
    LayoutInflater inflater;

    public DuaAdapter(Context context, String[] duas_arabic, String[] meaning, String[] translatitions) {
        this.context=context;
        this.duas_arabic=duas_arabic;
        this.meaning= meaning;
        this.translatitions=translatitions;
    }

    @Override
    public int getCount() {
        return Integer.valueOf(7).intValue();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = this.inflater.inflate(R.layout.item_recycler_dua, parent, false);
        LinearLayout data_dua=(LinearLayout) itemView.findViewById(R.id.dua_items);
        TextView name = (TextView) itemView.findViewById(R.id.arabic_dua);

        TextView meanings = (TextView)itemView.findViewById(R.id.title_dua);

        name.setText(duas_arabic[position]);
        meanings.setText(meaning[position]);

        data_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DuaDetails.class);
                intent.putExtra("dua_arabic",duas_arabic[position]);
                intent.putExtra("name",meaning[position]);
                intent.putExtra("translatation",translatitions[position]);
                context.startActivity(intent);
            }
        });

        //((TextView) itemView.findViewById(R.id.LVname)).setText(new StringBuilder(String.valueOf(Integer.toString(position + 1))).append(" - ").append(this.Names[position]).toString());
        //Meaning.setText(this.Meanings[position]);
        //nameImage.setImageResource(this.nameId[position]);
        //this.f47i++;
        return itemView;
    }
}
