package br.com.adrianob.helloworld;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class TelaLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista);

        //força a abertura em um tipo de orientação
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ListView lista = (ListView) findViewById(R.id.listDados);

        //Criação do arraylist
        ArrayList<String> lst = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            lst.add("Item adicionado "+i);
        }

        //definição de um adapter de array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getLayoutInflater().getContext(),
                android.R.layout.simple_list_item_1,lst);

        lista.setAdapter(adapter);

        Button btcad = (Button) findViewById(R.id.btnTeste);
        btcad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaLista.this,TelaDeCadastro.class);
                startActivity(i);
            }
        });
    }
}
