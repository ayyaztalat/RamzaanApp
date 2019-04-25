package com.tecjaunt.ramzanapp.Adapter;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tecjaunt.ramzanapp.Activities.AllahNameActivity;
import com.tecjaunt.ramzanapp.R;

import java.io.IOException;
import java.util.ArrayList;

public class AllahNamesAdapter extends BaseAdapter {

    Context context;
    int[] imagesSmall;
    String[] meaning;
    String[] names;
    ArrayList<Integer> arrayList;
    LayoutInflater inflater;
    MediaPlayer player;
    public AllahNamesAdapter(Context context, int[] imagesSmall, String[] meaning, String[] names, ArrayList<Integer> arrayList) {
        this.context=context;
        this.imagesSmall=imagesSmall;
        this.meaning=meaning;
        this.names=names;
        this.arrayList=arrayList;

        player=new MediaPlayer();

    }

    public int getCount() {
        return Integer.valueOf(100).intValue();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = this.inflater.inflate(R.layout.allah_names_item, parent, false);

        TextView Meaning = (TextView) itemView.findViewById(R.id.description);
        ImageView nameImage = (ImageView) itemView.findViewById(R.id.arabic_word);
        ImageView image_word = (ImageView) itemView.findViewById(R.id.image_word);
        TextView name = (TextView)itemView.findViewById(R.id.name);

        name.setText(names[position]);
        Meaning.setText(meaning[position]);
        nameImage.setImageResource(imagesSmall[position]);
        //((TextView) itemView.findViewById(R.id.LVname)).setText(new StringBuilder(String.valueOf(Integer.toString(position + 1))).append(" - ").append(this.Names[position]).toString());
        //Meaning.setText(this.Meanings[position]);
        //nameImage.setImageResource(this.nameId[position]);
        //this.f47i++;

        image_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.e("eror", "onClick: "+arrayList.get(position) );
                    AssetFileDescriptor descriptor=context.getResources().openRawResourceFd(arrayList.get(position));
                    if (player.isPlaying()){
                        player.stop();
                        player.reset();
                        player.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
                    }else if (!player.isPlaying()){
                        player.reset();
                        player.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
                    }else{
                        player.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
                    }
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        return itemView;
    }
}
