package br.com.adrianob.helloworld;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drink on 22/08/2017.
 */

public class MeuAdapter extends BaseAdapter {

    private List<Produto> lst = null;
    private Activity act = null;

    public MeuAdapter(List<Produto> prods, Activity a) {
        this.lst = prods;
        this.act = a;
    }


    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lst.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View v =  act.getLayoutInflater().inflate(
                    R.layout.lista_personalizada,
                    parent,
                    false
                );
        TextView tvcodigo = (TextView) v.findViewById(R.id.tvListaCodigo);
        TextView tvdescricao = (TextView) v.findViewById(R.id.tvListaDescricao);
        TextView tvValor = (TextView) v.findViewById(R.id.tvListaValor);

        Produto produto = lst.get(position);

        tvcodigo.setText(Integer.toString(produto.getId()));
        tvdescricao.setText(produto.getNome());
        tvValor.setText(Float.toString(produto.getValor()));

        return v;
    }
}
