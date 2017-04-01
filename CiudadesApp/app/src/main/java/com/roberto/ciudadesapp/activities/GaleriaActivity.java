package com.roberto.ciudadesapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.adapters.PageAdapter;
import com.roberto.ciudadesapp.animations.DepthPageTransformer;
import com.roberto.ciudadesapp.asynctask.AsyncTaskDescargaImagen;
import com.roberto.ciudadesapp.data.Constantes;
import com.roberto.ciudadesapp.data.GaleriasFotograficas;

public class GaleriaActivity extends AppCompatActivity {

    /**
     * Referencia al elemento que permitirá la animacion de la galeria de fotos.
     **/
    private ViewPager viewPager;

    /**
     * Sumunistra las fotos al viewPager
     **/
    private PageAdapter pageAdapter;

    /**
     * Galeria de imagenes descargadas
     **/
    private Bitmap[] imagenesDescargadas;
    /**
     * Titulos de las fotos.
     */
    private String[] tituloFotos;

    private String[] urlsFotos;

    public static Bitmap[] imagenes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        //Obtenemos la referencia del ViewPager.
        viewPager = (ViewPager) findViewById(R.id.pagerFotografias);
        //Ponemos la animación
        viewPager.setPageTransformer(true,new DepthPageTransformer());
        //Obtenemos la ciudad seleccionada por el usuario.
        SharedPreferences sp = getSharedPreferences("ciudadSeleccionada", Context.MODE_PRIVATE);
        String ciudad = sp.getString("ciudad", "");
        Log.d(getClass().getCanonicalName(), "Se ha recuperado la ciudad: " + ciudad);
        //En función de la ciudad seleccionada mapeamos los datos.
        if (ciudad.equals(Constantes.LONDRES)) {
            urlsFotos = GaleriasFotograficas.URLS_IMAGENES_LONDRES;
            tituloFotos = GaleriasFotograficas.TITULOS_MONUMENTOS_LONDRES;
        } else if (ciudad.equals(Constantes.NY)) {
            urlsFotos = GaleriasFotograficas.URLS_IMAGENES_NY;
            tituloFotos = GaleriasFotograficas.TITULOS_MONUMENTOS_NY;
        } else if (ciudad.equals(Constantes.ROMA)) {
            urlsFotos = GaleriasFotograficas.URLS_IMAGENES_ROMA;
            tituloFotos = GaleriasFotograficas.TITULOS_MONUMENTOS_ROMA;
        } else if (ciudad.equals(Constantes.PARIS)) {
            urlsFotos = GaleriasFotograficas.URLS_IMAGENES_PARIS;
            tituloFotos = GaleriasFotograficas.TITULOS_MONUMENTOS_PARIS;
        }
        //Descargamos las imagenes de la ciudad seleccionada.
        AsyncTaskDescargaImagen asyncTaskDescargaImagen = new AsyncTaskDescargaImagen(this);
        asyncTaskDescargaImagen.execute(urlsFotos);
    }


    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else {
            super.onBackPressed();
        }
    }

    public void getImagenesDescargadas(Bitmap[] bitmaps) {
        //Como las imagenes están descargadas quitamos la barra de progreso.
        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar);
        //La hacemos invisible.
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        imagenesDescargadas = bitmaps;
        imagenes=imagenesDescargadas;
        //Creamos el adaptador para proporcionar al ViewPager los fragments del carrusel de fotos.
        FragmentManager fm = getSupportFragmentManager();
        //Con las imagenes descargadas creamos el viewPager.
        pageAdapter = new PageAdapter(fm, imagenesDescargadas, tituloFotos, this);
        //Asociamos el adapter al ViewPager.
        viewPager.setAdapter(pageAdapter);

    }

    /**
     * Método que apunta la valoración positiva de una foto
     * en el SharedPrefenrences de valoraciones de usuario.
     */
    public void apuntarMeGusta() {
        //Guardamos la valoración positiva del usuario.
        SharedPreferences sp = getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("valoracion"+ viewPager.getCurrentItem(), Constantes.VALORACION_POSITIVA);
        Log.d(getClass().getCanonicalName(), "El usuario ha dado a me gusta a la foto de " + tituloFotos[viewPager.getCurrentItem()]);
        editor.commit();
        if (viewPager.getCurrentItem() == Constantes.NUM_FOTOGRAFIAS - 1) {
            //El usuario ha terminado de valorar el carrusel de fotografias se le mostraran los resultados.
            Intent intent = new Intent(this,ReporteValoracionActivity.class);
            intent.putExtra("titulos",tituloFotos);
            startActivity(intent);

        } else {
            //Pasamos a la siguiente fotografia a valorar.
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }

    }

    /**
     * Método que apunta la valoración negativa de una foto
     * en el SharedPrefenrences de valoraciones de usuario.
     */

    public void apuntarNoMeGusta() {
        //Guardamos la valoración negativa del usuario.
        SharedPreferences sp = getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("valoracion"+ viewPager.getCurrentItem(), Constantes.VALORACION_NEGATIVA);
        Log.d(getClass().getCanonicalName(), "El usuario ha dado a no me gusta a la foto de " + tituloFotos[viewPager.getCurrentItem()]);
        editor.commit();
        if (viewPager.getCurrentItem() == Constantes.NUM_FOTOGRAFIAS - 1) {
            //El usuario ha terminado de valorar el carrusel de fotografias se le mostraran los resultados.
            Intent intent = new Intent(this, ReporteValoracionActivity.class);
            intent.putExtra("titulos",tituloFotos);
            //Lanzamos el intent del reporte de valoraciones del carrusel de fotos.
            startActivity(intent);
        } else {
            //Pasamos a la siguiente fotografia a valorar.
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }



}



