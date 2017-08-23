package br.com.adrianob.helloworld;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaProduto extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);
        this.lista = (ListView) findViewById(R.id.lvProduto);
        this.lista.setOnItemClickListener(this);
        listar();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //fazer algo
        // abrir tela de edição
        DbHelper db = new DbHelper(getBaseContext());
        db.getWritableDatabase().delete("PRODUTO","_id = "+Long.toString(id),null);
        listar();
    }

    private void listar() {
        DbHelper db = new DbHelper(getBaseContext());
        Cursor cur = db.getReadableDatabase().query("PRODUTO",
                new String[]{"_id","NOME","VALOR"},null,null,null,null,null);
        cur.moveToFirst();
        List<ProdutoModelo> lp = new ArrayList<ProdutoModelo>();
        while (cur.moveToNext()) {
            ProdutoModelo pm = new ProdutoModelo();
            try {
                pm.setId(cur.getInt(0));
                pm.setNome(cur.getString(1));
                pm.setValor(cur.getFloat(2));
            } catch (Exception e) {
                Toast.makeText(this,"Erro"+e.getMessage(),Toast.LENGTH_LONG);
            }
            lp.add(pm);
        }
        AdrianoAdapter adapter = new AdrianoAdapter(lp,this);
        cur.close();
        db.close();
        lista.setAdapter(adapter);
    }


}
