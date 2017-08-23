package br.com.adrianob.helloworld;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        TextView tv = (TextView) findViewById(R.id.tvDestino);
        String nome = this.getIntent().getStringExtra("nome");
        tv.setText(nome);

        Button botao = (Button) findViewById(R.id.btnMensagem);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tela2.this, Tela2.this.getIntent().getStringExtra("nome")
                        , Toast.LENGTH_SHORT).show();
            }
        });

        Button btnAbreLista = (Button) findViewById(R.id.btnAbreLista);

        btnAbreLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela2.this,TelaLista.class);
                startActivity(intent);
            }
        });

    }
}
