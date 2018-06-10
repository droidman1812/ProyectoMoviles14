package com.example.usuario.proyectomoviles14;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreEvento, ubicacion, fechaInicio, horaInicio, fechaFin, horaFin;
    private EditText descripcion;

    private Button guardar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombreEvento=(EditText)findViewById(R.id.txtnombreEventos);
        ubicacion=(EditText)findViewById(R.id.txtUbicacion);
        fechaInicio=(EditText)findViewById(R.id.txtFechaInicio);
        fechaFin=(EditText)findViewById(R.id.txtFechaFin);
        horaInicio=(EditText)findViewById(R.id.txtHoraInicio);
        horaFin=(EditText)findViewById(R.id.txtHoraFin);
        descripcion=(EditText)findViewById(R.id.txtDescripcion);


        Bundle bundle = getIntent().getExtras();
        int dia=0, mes=0, anio=0;

        dia=bundle.getInt("dia");
        mes=bundle.getInt("mes");
        anio=bundle.getInt("anio");

        fechaInicio.setText(dia+" - " + mes +" - " + anio);
        fechaFin.setText(dia+" - " + mes +" - " + anio);


        guardar=(Button) findViewById(R.id.btnGuardar);
        cancelar=(Button) findViewById(R.id.btnCancelar);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==guardar.getId()){

            BDSQLite bd = new BDSQLite(getApplication(),"Agenda",null,1);
            SQLiteDatabase db = bd.getWritableDatabase();
            String sql ="insert into enventos" +
                    "(nombreEvento, ubicacion, fechainicio, horainicio, fechafin, horafin," +
                    " descripcion) values('" +
                    nombreEvento.getText()+
                    "','"+ ubicacion.getText()+
                    "','"+ fechaInicio.getText()+
                    "','"+ horaInicio.getText()+
                    "','"+ fechaFin.getText()+
                    "','"+ horaFin.getText()+
                    "','"+ descripcion.getText()+ "')";

            try{
                db.execSQL(sql);
                nombreEvento.setText("");
                ubicacion.setText("");
                fechaInicio.setText("");
                fechaFin.setText("");
                horaInicio.setText("");
                horaFin.setText("");
                descripcion.setText("");

            }catch (Exception e){
                Toast.makeText(getApplication(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            }
            this.finish();
        } else{
            this.finish();
            return;
        }

    }

}
