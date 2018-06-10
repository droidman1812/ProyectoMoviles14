package com.example.usuario.proyectomoviles14;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDSQLite extends SQLiteOpenHelper {

    private String sql = "create table eventos(" +
            "idEventos int identity," +
            "nombreEvento varchar(40)," +
            "ubicacion varchar(60)," +
            "fechaInicio date," +
            "horaInicio time," +
            "fechaFin date," +
            "horaFin time," +
            "descripcion varchar(60))";

    public BDSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
