package com.roberto.ciudadesapp.listeners;

import android.util.Log;
import android.view.View;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.activities.GaleriaActivity;

/**
 * Created by Usr on 26/03/2017.
 */

public class ListenerFloatingButton implements View.OnClickListener {

    private GaleriaActivity galeriaActivity;

    public ListenerFloatingButton(GaleriaActivity galeriaActivity) {

        this.galeriaActivity = galeriaActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabLike:
                Log.d(getClass().getCanonicalName(), "El usuario ha pulsado el botón de me gusta");
                galeriaActivity.apuntarMeGusta();
                break;
            case R.id.fabDislike:
                Log.d(getClass().getCanonicalName(), "El usuario ha pulsado el botón de no me gusta");
                galeriaActivity.apuntarNoMeGusta();
                break;
        }
    }

}