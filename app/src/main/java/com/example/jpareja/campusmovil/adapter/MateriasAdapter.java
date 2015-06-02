package com.example.jpareja.campusmovil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.jpareja.campusmovil.R;
import com.example.jpareja.campusmovil.dto.RespuestaMateria;

import java.util.List;

/**
 * Created by cvrodriguez on 6/1/15.
 */
public abstract class MateriasAdapter extends BaseAdapter {
    private LayoutInflater inflador;

    public MateriasAdapter(Context context) {
        inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return getLista().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    public abstract List<RespuestaMateria> getLista();

    @Override
    public long getItemId(int position) {
        return getLista().get(position).getIdmateria();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RespuestaMateria r = getLista().get(position);

        if(convertView == null){
            convertView = inflador.inflate(R.layout.materia_item_lista, null);
        }

        TextView nombreMateria = (TextView) convertView.findViewById(R.id.txtMateria);
        TextView definitivaMateria = (TextView) convertView.findViewById(R.id.txtNota);

        nombreMateria.setText(r.getNombre());
        definitivaMateria.setText("Nota definitiva: " + r.getNota());

        return convertView;
    }


}
