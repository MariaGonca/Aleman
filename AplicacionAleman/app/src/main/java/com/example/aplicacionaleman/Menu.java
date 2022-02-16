package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private TextView bienvenido;
    private Button btntest, bnttraductor, btnsalir;
    private static String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bienvenido = (TextView)findViewById(R.id.nombreUsuario);
        nom = getIntent().getStringExtra( "nombre_usuario");

        bienvenido.setText( "Willkommen " + nom);

        btntest = (Button)findViewById(R.id.ir_test);
        bnttraductor = (Button)findViewById(R.id.ir_animales);
        btnsalir = (Button)findViewById(R.id.salir_aplicacion);

         }

    public void CerrarAplic(View view){

        finish();
    }

    public void IrTest(View view){
        Intent intent = new Intent(getApplicationContext(), Test.class);
        startActivity(intent);
    }

    public void IrAnimal(View view){
        Intent intent = new Intent(getApplicationContext(), Animales.class);
        startActivity(intent);
    }

    public void IrPronun(View view){
        Intent intent = new Intent(getApplicationContext(), Pronunciacion.class);
        startActivity(intent);
    }

}