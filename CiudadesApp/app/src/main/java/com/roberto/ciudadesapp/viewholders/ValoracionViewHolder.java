package com.roberto.ciudadesapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.entidades.Valoracion;

/**
 * Created by Usr on 26/03/2017.
 */

public class ValoracionViewHolder extends RecyclerView.ViewHolder {

    private ImageView imagen_monumento;

    private TextView  texto_foto;

    private ImageView imagen_valoracion;

    public ValoracionViewHolder(View itemView){
        super(itemView);
        imagen_monumento=(ImageView)itemView.findViewById(R.id.imagenMonumento);
        texto_foto=(TextView)itemView.findViewById(R.id.txtFoto);
        imagen_valoracion=(ImageView)itemView.findViewById(R.id.imagenValoracion);

    }

    public void cargarValoracionEnHolder(Valoracion valoracion){

        this.imagen_monumento.setImageBitmap(valoracion.getImagenMonumento());
        this.texto_foto.setText(valoracion.getNombreMonumento());
        this.imagen_valoracion.setImageResource(valoracion.getImagenValoracion());
    }






}
