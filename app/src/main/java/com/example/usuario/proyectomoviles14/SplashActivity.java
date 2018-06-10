package com.example.usuario.proyectomoviles14;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {


    RelativeLayout rellay1 ,rellay2;


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        rellay1 = (RelativeLayout)findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout)findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 3000 );

        Button boton =(Button)findViewById(R.id.ingresar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=((EditText)findViewById(R.id.txtusuario)).getText().toString();
                String password=((EditText)findViewById(R.id.txtpassword)).getText().toString();

                if (usuario.equals("joshua") && password.equals("joshua"))
                {
                    Intent ingresar = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(ingresar);
                }
                if (usuario.length() ==0){
                    Toast.makeText(getApplicationContext(), "Ingresar Usuario",Toast.LENGTH_LONG).show();
                }
                if (password.length() ==0){
                    Toast.makeText(getApplicationContext(), "Ingresar Password", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario o Password Incorrecto",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}