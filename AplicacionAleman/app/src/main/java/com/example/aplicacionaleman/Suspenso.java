package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Suspenso extends AppCompatActivity {

    private TextView not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspenso);

        not = (TextView)findViewById(R.id.nota);
        String dato = getIntent().getStringExtra( "nota");
        not.setText(dato+"/10");
    }

    public void saliraprobado(View view){
        Intent intent;
        intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }

}