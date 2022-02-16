package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Animales extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombres [] = {"Perro", "Gato", "Caballo", "Gallina", "Serpiente", "Cangrejo",
            "Mariposa", "Mapache", "Elefante", "Gorila"};
    private String aleman [] = {"Hund", "Katze", "Pferd", "Huhn", "Schlange", "Krabbe", "Schmetterling", "Waschbär", "Elefant", "Gorilla"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);

        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.items, nombres);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv1.setText(lv1.getItemAtPosition(i) + " es " + aleman[i]);
            }
        });

    }

    public  void sal(View v){
        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }
}
