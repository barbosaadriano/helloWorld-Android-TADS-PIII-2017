package br.com.adrianob.helloworld;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TelaDeCadastro extends AppCompatActivity implements View.OnClickListener {

    private ListView lista = null;
    private EditText nome = null;
    private EditText valor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_cadastro);
        Button btnAdd = (Button) findViewById(R.id.btnAddProduto);
        btnAdd.setOnClickListener(this);
        lista = (ListView) findViewById(R.id.lstProdutos);
        nome = (EditText) findViewById(R.id.edNomeProduto);
        valor = (EditText) findViewById(R.id.edValorProduto);
        listaProdutos();
    }

    private void listaProdutos() {

        DbHelper db = new DbHelper(getBaseContext());
        Cursor cur = db.getReadableDatabase().query("PRODUTO",
                new String[]{"NOME"},null,null,null,null,null);
        cur.moveToFirst();
        ArrayList<String> lst = new ArrayList<String>();
        while (cur.moveToNext()) {
            lst.add(cur.getString(0));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getLayoutInflater().getContext(),
                android.R.layout.simple_list_item_1,
                lst
        );
        cur.close();
        db.close();
        lista.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddProduto) {
            addProduto();
        }
    }

    private void addProduto() {
        String nm = nome.getText().toString();
//        try {
            Float vl = Float.parseFloat(valor.getText().toString());
//        } catch (Exception e) {
//            Toast.makeText(this,"Erro de conversão",Toast.LENGTH_LONG).show();
//        }
        DbHelper db = new DbHelper(getBaseContext());
        ContentValues produto = new ContentValues();
        produto.put("NOME",nm);
        produto.put("VALOR",vl);
        db.getWritableDatabase().insert("PRODUTO",null,produto);
        db.close();
        listaProdutos();
    }
}
