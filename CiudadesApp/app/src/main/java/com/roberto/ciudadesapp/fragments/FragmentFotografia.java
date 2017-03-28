package com.roberto.ciudadesapp.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.activities.GaleriaActivity;
import com.roberto.ciudadesapp.listeners.ListenerFloatingButton;

/**
 * Created by Usr on 26/03/2017.
 * Fragment que representa el carrusel de imagenes.
 */

public class FragmentFotografia extends Fragment {


    /**
     * Bitmap con la fotografia descargada.
     */
     private Bitmap fotografia;
    /**
     * Regferencia a la actividad principal de la app
     */
    private GaleriaActivity galeriaActivity;
    /**
     * Nombre de la fotografía.
     */
    private String nombreFoto;

    public FragmentFotografia(){}

    /**
     * Constructor de la clase FragmentFotografia
     * @param fotografia
     * @param galeriaActivity
     * @param nombreFoto
     */
    public FragmentFotografia(Bitmap fotografia,GaleriaActivity galeriaActivity,String nombreFoto){
        super();
        this.fotografia=fotografia;
        this.galeriaActivity=galeriaActivity;
        this.nombreFoto=nombreFoto;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fotografia,container,false);
        //Obtenemos la referencia del ImageView del fragment.
        ImageView imagenFotografia=(ImageView)view.findViewById(R.id.fotografia);
        //Obtenemos la referencia de los Floating Buttons.
        FloatingActionButton fabLike=(FloatingActionButton)view.findViewById(R.id.fabLike);
        fabLike.setBackgroundTintList(getResources().getColorStateList(R.color.colorFabLike));
        FloatingActionButton fabDislike=(FloatingActionButton)view.findViewById(R.id.fabDislike);
        fabDislike.setBackgroundTintList(getResources().getColorStateList(R.color.colorFabDislike));
        //Seteamos la fotografia.
        imagenFotografia.setImageBitmap(fotografia);
        //Obtenemos la referencias del TextView.
        TextView txtNombreFoto=(TextView)view.findViewById(R.id.txtNombreFoto);
        txtNombreFoto.setText(nombreFoto);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Recuperamos los floating button para permitir al usuario dar su opinion
        FloatingActionButton fabLike=(FloatingActionButton)getView().findViewById(R.id.fabLike);
        FloatingActionButton fabDislike=(FloatingActionButton)getView().findViewById(R.id.fabDislike);
        //Asociamos el listener a los botones.
        fabLike.setOnClickListener(new ListenerFloatingButton(galeriaActivity));
        fabDislike.setOnClickListener(new ListenerFloatingButton(galeriaActivity));

    }
}
