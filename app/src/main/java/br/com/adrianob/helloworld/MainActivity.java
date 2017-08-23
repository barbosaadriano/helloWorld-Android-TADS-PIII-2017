package br.com.adrianob.helloworld;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btnHello);
        Button btn2 = (Button) findViewById(R.id.abreTela);

        tv1 = (TextView) findViewById(R.id.tv1);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHello) {
            tv1.setText("Adriano!!!");
            Intent listaProduto = new Intent(this,ListarProdutos.class);
            startActivity(listaProduto);
        }
        if (v.getId() == R.id.abreTela) {
            Intent tela2 = new Intent(this,Tela2.class);
            EditText edP = (EditText) findViewById(R.id.edParametro);
            //Bundle bundle = new Bundle();
            //bundle.putString("nome",edP.getText().toString());
            tela2.putExtra("nome", edP.getText().toString());
            //tela2.putExtras(bundle);
            startActivity(tela2);
        }
    }
}
