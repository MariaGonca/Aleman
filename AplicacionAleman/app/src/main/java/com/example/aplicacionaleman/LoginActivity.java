package com.example.aplicacionaleman;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button iniciarSesion;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.txt_nombre1);
        password=findViewById(R.id.txt_contra1);
        iniciarSesion=findViewById(R.id.entrar);
        DB = new DBHelper(this);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this, "No has completado todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.ComprobarContra(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Login completado", Toast.LENGTH_SHORT).show();
                        Intent intent;
                        intent = new Intent(getApplicationContext(), Menu.class);
                        intent.putExtra( "nombre_usuario", username.getText().toString());
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Login ha fallado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}