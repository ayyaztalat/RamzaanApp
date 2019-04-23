package com.tecjaunt.ramzanapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecjaunt.ramzanapp.R;

public class MuhammadNamesAdapter extends BaseAdapter {
    Context context;
    int[] imagesSmall;
    String[] meaning;
    String[] names;
    LayoutInflater inflater;

    public MuhammadNamesAdapter(Context context, int[] imagesSmall, String[] meaning, String[] names) {
        this.context=context;
        this.imagesSmall=imagesSmall;
        this.meaning=meaning;
        this.names=names;
    }

    @Override
    public int getCount() {
        return Integer.valueOf(99).intValue();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = this.inflater.inflate(R.layout.allah_names_item, parent, false);

        TextView Meaning = (TextView) itemView.findViewById(R.id.description);
        ImageView nameImage = (ImageView) itemView.findViewById(R.id.arabic_word);
        TextView name = (TextView)itemView.findViewById(R.id.name);

        name.setText(names[position]);
        Meaning.setText(meaning[position]);
        nameImage.setImageResource(imagesSmall[position]);
        //((TextView) itemView.findViewById(R.id.LVname)).setText(new StringBuilder(String.valueOf(Integer.toString(position + 1))).append(" - ").append(this.Names[position]).toString());
        //Meaning.setText(this.Meanings[position]);
        //nameImage.setImageResource(this.nameId[position]);
        //this.f47i++;
        return itemView;
    }
}
