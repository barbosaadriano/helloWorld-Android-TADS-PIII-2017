package br.com.adrianob.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by drink on 11/08/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "dbteste";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUTO (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOME TEXT, VALOR REAL, REMOTE_ID INTEGER ); ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
