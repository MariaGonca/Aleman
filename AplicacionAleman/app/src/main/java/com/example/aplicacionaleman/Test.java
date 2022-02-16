package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends AppCompatActivity {

    RadioButton rd1, rd2, rd3;
    TextView txtNPregunta, txtPregunta;
    Button btnSiguiente, btnSalir;
    int nota = 0;
    int NPregunta = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        rd1 = (RadioButton) findViewById(R.id.radioButton);
        rd2 = (RadioButton) findViewById(R.id.radioButton2);
        rd3 = (RadioButton) findViewById(R.id.radioButton3);

        txtNPregunta = (TextView) findViewById(R.id.txtNumpregunta);
        txtPregunta = (TextView) findViewById(R.id.txtpregunta);
        btnSalir = (Button) findViewById(R.id.btnSalirTest);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
    }

    public void Suiguiente(View v) {
        if (rd1.isChecked() == false && rd2.isChecked() == false && rd3.isChecked() == false) {
            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();
        } else if (NPregunta == 1) {
            //Se verifica que la respuesta sea correcta y se suma la nota
            if (rd2.isChecked()) {
                nota = nota + 2;
            }
            NPregunta = NPregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNPregunta.setText("Pregunta 2");
            txtPregunta.setText("¿De dónde vienes?");
            rd1.setText("Woher kommst Du?");
            rd2.setText("Wie geht es dir?");
            rd3.setText("Wie alt sind Sie?");
            //Se limpian los radio buttons para la siquiente pregunta
            rd1.setChecked(false);
            rd2.setChecked(false);
            rd3.setChecked(false);
        } else if (NPregunta == 2) {
            //Se verifica que la respuesta sea correcta, si lo es se suman 2 puntos
            if (rd1.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            NPregunta = NPregunta + 1;
            //Se cambian los textos para la siguiente pregunta
            txtNPregunta.setText("Pregunta 3");
            txtPregunta.setText("¿Cuántos años tienes?");
            rd1.setText("Wie heißt Du?");
            rd2.setText("Wie geht es dir?");
            rd3.setText("Wie alt sind Sie?");
            //Se limpian los radio buttons para la siquiente pregunta
            rd1.setChecked(false);
            rd2.setChecked(false);
            rd3.setChecked(false);
        } else if (NPregunta == 3) {
            //Se verifica que la respuesta sea correcta, si lo es se suman 2 puntos
            if (rd3.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            NPregunta = NPregunta + 1;
            //Se cambian los textos para la siguiente pregunta
            txtNPregunta.setText("Pregunta 4");
            txtPregunta.setText("Ich verstehe das nicht");
            rd1.setText("No lo entiendo");
            rd2.setText("Hablo un poco de aleman");
            rd3.setText("Muy bien gracias");
            //Se limpian los radio buttons para la siquiente pregunta
            rd1.setChecked(false);
            rd2.setChecked(false);
            rd3.setChecked(false);
        } else if (NPregunta == 4) {
            //Se verifica que la respuesta sea correcta, si lo es se suman 2 puntos
            if (rd1.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            NPregunta = NPregunta + 1;
            //Se cambian los textos para la siguiente pregunta
            txtNPregunta.setText("Pregunta 5");
            txtPregunta.setText("¿Cuándo sale el autobus?");
            rd1.setText("Wo sind die Toiletten?");
            rd2.setText("Wann färht der Bus?");
            rd3.setText("Können Sie das bitte buchstabieren?");
            //Se limpian los radio buttons para la siquiente pregunta
            rd1.setChecked(false);
            rd2.setChecked(false);
            rd3.setChecked(false);
        } else if (NPregunta == 5) {
            //Se verifica que la respuesta sea correcta, si lo es se suman 2 puntos
            if (rd2.isChecked()) {
                nota = nota + 2;
            }
            //Se cambian los textos para el resultado
            //txtNPregunta.setText("Nota obtenida: "+nota);
            if (nota == 10) {
                Intent intent;
                intent = new Intent(getApplicationContext(), Perfecto.class);
                startActivity(intent);
            }else if(nota <10 && nota >5){
                Intent intent;
                intent = new Intent(getApplicationContext(), Aprobado.class);
                String notaf = String.valueOf(nota);
                intent.putExtra( "nota", notaf);
                startActivity(intent);
            }else{
                Intent intent;
                intent = new Intent(getApplicationContext(), Suspenso.class);
                String notaf = String.valueOf(nota);
                intent.putExtra( "nota", notaf);
                startActivity(intent);
            }


        }
    }
}