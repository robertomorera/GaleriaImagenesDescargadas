package com.roberto.ciudadesapp.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.activities.GaleriaActivity;
import com.roberto.ciudadesapp.data.Constantes;

/**
 * Created by Usr on 26/03/2017.
 * Clase que escucha los eventos asociados
 * a los botones de la MainActivity.
 */

public class ListenerButtons implements View.OnClickListener
{
    /**
     * Atributo que representa el contexto de la app.
     */
    private Context context;

    /**
     * Constructor de la clase ListenerButtons
     * @param context
     */
    public ListenerButtons(Context context){
        this.context=context;
    }

    @Override
    public void onClick(View v) {

        Activity activity=null;
        Intent intent=null;
        SharedPreferences sp=context.getSharedPreferences("ciudadSeleccionada", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        switch(v.getId()){
            case R.id.boton_londres:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el botón LONDRES");
                //Guardamos el Shared Preferences la cuidad elegida por el usuario para escoger las imagenes.
                editor.putString("ciudad", Constantes.LONDRES);
                editor.commit();
                activity=(Activity)context;
                intent=new Intent(context, GaleriaActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.boton_roma:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el botón ROMA");
                //Guardamos el Shared Preferences la cuidad elegida por el usuario para escoger las imagenes.
                editor.putString("ciudad", Constantes.ROMA);
                editor.commit();
                activity=(Activity)context;
                intent=new Intent(context, GaleriaActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.boton_ny:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el botón NEW YORK");
                //Guardamos el Shared Preferences la cuidad elegida por el usuario para escoger las imagenes.
                editor.putString("ciudad", Constantes.NY);
                editor.commit();
                activity=(Activity)context;
                intent=new Intent(context, GaleriaActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.boton_paris:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el botón PARIS");
                //Guardamos el Shared Preferences la cuidad elegida por el usuario para escoger las imagenes.
                editor.putString("ciudad", Constantes.PARIS);
                editor.commit();
                activity=(Activity)context;
                intent=new Intent(context, GaleriaActivity.class);
                activity.startActivity(intent);
                break;

        }

    }
}
