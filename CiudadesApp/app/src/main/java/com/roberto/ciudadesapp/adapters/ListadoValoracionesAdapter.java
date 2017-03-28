package com.roberto.ciudadesapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.entidades.Valoracion;
import com.roberto.ciudadesapp.data.Constantes;
import com.roberto.ciudadesapp.viewholders.ValoracionViewHolder;

import java.util.ArrayList;


/**
 * Created by Usr on 26/03/2017.
 */

public class ListadoValoracionesAdapter extends RecyclerView.Adapter<ValoracionViewHolder> {

    private ArrayList<Valoracion> valoraciones;

    public ListadoValoracionesAdapter(ArrayList<Valoracion> valoraciones){
        this.valoraciones=valoraciones;
    }

    @Override
    public ValoracionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ValoracionViewHolder valoracionViewHolder=null;
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View fila_inflada=inflater.inflate(R.layout.fila,parent,false);
        valoracionViewHolder=new ValoracionViewHolder(fila_inflada);
        return valoracionViewHolder;
    }

    @Override
    public void onBindViewHolder(ValoracionViewHolder holder, int position) {

        Valoracion valoracion=(Valoracion)valoraciones.get(position);
        holder.cargarValoracionEnHolder(valoracion);
    }

    @Override
    public int getItemCount() {
        return Constantes.NUM_FOTOGRAFIAS;
    }
}


