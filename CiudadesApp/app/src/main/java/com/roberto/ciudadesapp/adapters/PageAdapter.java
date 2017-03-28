package com.roberto.ciudadesapp.adapters;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.roberto.ciudadesapp.activities.GaleriaActivity;
import com.roberto.ciudadesapp.data.Constantes;
import com.roberto.ciudadesapp.fragments.FragmentFotografia;

/**
 * Created by Usr on 26/03/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    /**
     * Atributo que representa la galeria de fotos descargadas.
     */
    private Bitmap[] galeriaFotos;

    /**
     * Referencia a la actividad de la galeria de fotosa.
     */
    private GaleriaActivity galeriaActivity;

    /**
     * Titulos de las fotos descargadas.
     */
    private String[] titulosFotos;

    /**
     * Constructor de la clase PageAdapter
     * @param fm
     * @param galeriaFotos
     * @param galeriaActivity
     */
    public PageAdapter(FragmentManager fm, Bitmap[] galeriaFotos,String [] titulosFotos,GaleriaActivity galeriaActivity) {
        super(fm);
        this.galeriaFotos = galeriaFotos;
        this.titulosFotos=titulosFotos;
        this.galeriaActivity = galeriaActivity;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch(position){
            case 0: fragment=new FragmentFotografia(galeriaFotos[0],galeriaActivity,titulosFotos[0]);
                break;
            case 1: fragment=new FragmentFotografia(galeriaFotos[1],galeriaActivity,titulosFotos[1]);
                break;
            case 2: fragment=new FragmentFotografia(galeriaFotos[2],galeriaActivity,titulosFotos[2]);
                break;
            case 3: fragment=new FragmentFotografia(galeriaFotos[3],galeriaActivity,titulosFotos[3]);
                break;
            case 4: fragment=new FragmentFotografia(galeriaFotos[4],galeriaActivity,titulosFotos[4]);
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return Constantes.NUM_FOTOGRAFIAS;
    }
}
