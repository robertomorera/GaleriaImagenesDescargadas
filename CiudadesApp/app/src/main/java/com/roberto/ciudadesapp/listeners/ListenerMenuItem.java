package com.roberto.ciudadesapp.listeners;

/**
 * Created by Usr on 26/03/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.MenuItem;
import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.activities.GaleriaActivity;
import com.roberto.ciudadesapp.activities.MainActivity;
import com.roberto.ciudadesapp.data.Constantes;

/**
 * Created by PCCasa on 13/03/2017.
 * Listener para los distintos menus de la app.
 */

public class ListenerMenuItem implements MenuItem.OnMenuItemClickListener {

    private Context context;

    public ListenerMenuItem(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Activity activity=null;
        Intent intent=null;
        switch(item.getItemId()){
            case R.id.reiniciarValoracion:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el menu de reiniciar las valoraciones");
                //Reiniciamos las valoraciones del usuario.
                reiniciarValoraciones();
                //Lanzamos un Intent para el GaleriaActivity y reiniciar el paso de las fotografías.
                intent= new Intent(context,GaleriaActivity.class);
                activity=(Activity)context;
                //Ejecutamos el intent a la actividad principal.
                activity.startActivity(intent);
                break;
            case R.id.reiniciarApp:
                Log.d(getClass().getCanonicalName(),"El usuario ha pulsado el menu de reiniciar la aplicación");
                //Lanzamos un Intent para el MainActivity y volver al menú principal de la app.
                intent= new Intent(context,MainActivity.class);
                activity=(Activity)context;
                //Ejecutamos el intent a la actividad principal.
                activity.startActivity(intent);
                break;
        }
        return true;
    }

    /**
     * Método que reiniciar las valoraciones proporcionadas por el
     * usuario.
     */
    public void reiniciarValoraciones(){
        //Recuperamos el SharedPreferences con las valoraciones del usuario.
        Activity activity=(Activity) context;
        SharedPreferences sp=activity.getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        //Recorremos todas las claves para reiniciar las valoraciones.
        for(int i = 0; i< Constantes.NUM_FOTOGRAFIAS; i++){
            editor.putString("valoracion"+i,"");
        }
        //Guardamos las valoraciones.
        editor.commit();
    }

}


