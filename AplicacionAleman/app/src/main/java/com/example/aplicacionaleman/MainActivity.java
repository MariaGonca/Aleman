package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button registro, iniciarSesion;

    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.txt_nombre);
        password=findViewById(R.id.txt_contra);
        repassword=findViewById(R.id.txt_contra2);
        registro=findViewById(R.id.registro);
        iniciarSesion=findViewById(R.id.entrar);
        DB = new DBHelper(this);

        registro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(MainActivity.this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.ComprobarNombre(user);
                        if(checkuser==false){
                            Boolean insert = DB.Registrar(user, pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registro concluido", Toast.LENGTH_SHORT).show();
                                     Intent intent;
                                     intent = new Intent(getApplicationContext(), Menu.class);
                                     intent.putExtra( "nombre_usuario", username.getText().toString());
                                     startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "No se ha podido registrar", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Ese nombre de usuario ya está escogido", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "La contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        iniciarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}