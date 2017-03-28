package com.roberto.ciudadesapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.roberto.ciudadesapp.listeners.ListenerButtons;
import com.roberto.ciudadesapp.R;

/**
 * Created by Usr on 26/03/2017.
 *Representa el fragment para iniciar la galeria de monumentos de
 * de la ciudad de Paris.
 */

public class FragmentParis extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_paris,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Recuperamos el botón.
        Button boton_paris=(Button) getView().findViewById(R.id.boton_paris);
        //Asignamos el listener al botón.
        ListenerButtons listenerButtons=new ListenerButtons(getView().getContext());
        boton_paris.setOnClickListener(listenerButtons);
    }
}
