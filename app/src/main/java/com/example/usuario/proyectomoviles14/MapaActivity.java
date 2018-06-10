package com.example.usuario.proyectomoviles14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapaActivity extends AppCompatActivity {

    private Button ubicarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        ubicarme=(Button)findViewById(R.id.ubicarme);

        ubicarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vermapa = new Intent(MapaActivity.this,MapsActivity.class);
                startActivity(vermapa);
            }
        });
}
}
