package br.com.adrianob.helloworld;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarProdutos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        lista = (ListView) findViewById(R.id.listaPersonalizadaView);
        lista.setOnItemClickListener(this);
        listar();
    }

    private void listar() {
        DbHelper db = new DbHelper(getBaseContext());
        Cursor cur = db.getReadableDatabase().query("PRODUTO",
                new String[]{"NOME","VALOR","_id"},null,null,null,null,null);
        cur.moveToFirst();
        ArrayList<Produto> lst = new ArrayList<Produto>();
        while (cur.moveToNext()) {
            Produto p = new Produto();
            p.setId(cur.getInt(2));
            p.setNome(cur.getString(0));
            p.setValor(cur.getFloat(1));
            lst.add(p);
        }
        MeuAdapter adapter = new MeuAdapter(lst,this);
        cur.close();
        db.close();
        lista.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        DbHelper db = new DbHelper(getBaseContext());
        db.getWritableDatabase().delete("PRODUTO","_id = "+id,null);
        db.close();

        listar();
    }
}
