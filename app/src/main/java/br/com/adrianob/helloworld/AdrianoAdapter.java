package br.com.adrianob.helloworld;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drink on 21/08/2017.
 */

public class AdrianoAdapter extends BaseAdapter {

    private final List<ProdutoModelo> lst;
    private final Activity act;

    AdrianoAdapter(List<ProdutoModelo> ls, Activity ac) {
        this.act = ac;
        this.lst = ls;
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
        View v = act.getLayoutInflater().inflate(R.layout.lista_adriano,parent,false);
        ProdutoModelo p = lst.get(position);
        TextView ds = (TextView) v.findViewById(R.id.tvDsProd);
        TextView vl = (TextView) v.findViewById(R.id.tvValProd);
        ds.setText(p.getNome());
        vl.setText(Float.toString(p.getValor()));
        return v;
    }
}
