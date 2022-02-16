package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Perfecto extends AppCompatActivity {

    ImageButton play;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfecto);

        play = (ImageButton) findViewById(R.id.sonido);
        mp = MediaPlayer.create(this, R.raw.victoria);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               mp.start();
            }
        });
    }


    public void saliraprobado(View view){
        Intent intent;
        intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }
}