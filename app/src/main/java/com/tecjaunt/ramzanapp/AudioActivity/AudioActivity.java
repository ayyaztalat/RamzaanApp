package com.tecjaunt.ramzanapp.AudioActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {

    Button Stop_Azaan;
    MediaPlayer player;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        preferences=new Preferences(this);

        Stop_Azaan=findViewById(R.id.Stop_Azaan);



        player=new MediaPlayer();
        try {
            AssetFileDescriptor descriptor = getResources().openRawResourceFd(R.raw.ramzanazan1);

            if (!player.isPlaying()) {

                player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            } else {
                player.isPlaying();
                player.reset();
                player.stop();
                player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            }


            player.prepare();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.stop();
                    player.reset();
                    player.release();
                    finish();
                }
            });
            player.start();




        }catch (IOException e){
            e.printStackTrace();
        }

        Stop_Azaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player.reset();
                player.release();
                finish();

            }
        });

    }
}
