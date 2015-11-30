package com.example.jpareja.campusmovil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jpareja.campusmovil.R;
import com.example.jpareja.campusmovil.dto.RespuestaMatricula;

import java.util.List;

/**
 * Created by cvrodriguez on 29/11/15.
 */
public class MatriculaAdapter extends ArrayAdapter<RespuestaMatricula> {

    private final Context context;
    private final List<RespuestaMatricula> materiasMatricula;

    public MatriculaAdapter(Context context, List<RespuestaMatricula> materiasMatricula){
        super(context, -1, materiasMatricula);

        this.context = context;
        this.materiasMatricula = materiasMatricula;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflador = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RespuestaMatricula r = materiasMatricula.get(position);

        if(convertView == null){
            convertView = inflador.inflate(R.layout.materia_item_lista, null);
        }

        TextView nombreMateria = (TextView) convertView.findViewById(R.id.txtMateria);
        TextView definitivaMateria = (TextView) convertView.findViewById(R.id.txtNota);

        nombreMateria.setText(r.getNombre());
        definitivaMateria.setText("");

        return convertView;
    }
}
