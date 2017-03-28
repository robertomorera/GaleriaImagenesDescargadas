package com.roberto.ciudadesapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.roberto.ciudadesapp.R;
import com.roberto.ciudadesapp.entidades.Valoracion;
import com.roberto.ciudadesapp.adapters.ListadoValoracionesAdapter;
import com.roberto.ciudadesapp.data.Constantes;
import com.roberto.ciudadesapp.listeners.ListenerMenuItem;

import java.util.ArrayList;

public class ReporteValoracionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ListadoValoracionesAdapter listadoValoracionesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_valoracion);
        //Obtenemos las URLS y descargamos las imagenes.
        //Obtenemos referencia del recycler view.
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        //Asignamos el adaptar al recycler view.
        ArrayList<Valoracion> valoraciones=prepararDatos();
        listadoValoracionesAdapter=new ListadoValoracionesAdapter(valoraciones);
        recyclerView.setAdapter(listadoValoracionesAdapter);
        //Asignamos la orientacion del recycler view.
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        //Obtenemos el item asociado al menu.
        MenuItem menuItem1=menu.getItem(0);
        MenuItem menuItem2=menu.getItem(1);
        //Creamos su listener.
        ListenerMenuItem listenerMenuItem=new ListenerMenuItem(this);
        //Asociamos el listener del menu al item.
        menuItem1.setOnMenuItemClickListener(listenerMenuItem);
        menuItem2.setOnMenuItemClickListener(listenerMenuItem);
        return true;
    }


    public ArrayList<Valoracion> prepararDatos() {
        ArrayList<Valoracion> valoraciones= new  ArrayList<Valoracion>();
        Bitmap[] imagenes=GaleriaActivity.imagenes;
        String[] titulos=getIntent().getStringArrayExtra("titulos");
        //Obtenemos las valoraciones del usuario.
        SharedPreferences sp = getSharedPreferences("resultadosValoracion", Context.MODE_PRIVATE);
        Valoracion valoracion =null;
        int imagen_valoracion=0;
        for (int i = 0; i < imagenes.length; i++) {
            //Obtenemos la valoracion asociada a la foto.
            String val= sp.getString("valoracion"+i, "");
            //Ponemos la imagen asociada a cada tipo de valoración del usuario.
            if (val.equals(Constantes.VALORACION_POSITIVA)) {
                imagen_valoracion=R.drawable.valoracion_positiva;
            } else if (val.equals(Constantes.VALORACION_NEGATIVA)) {
                imagen_valoracion=R.drawable.valoracion_negativa;
            } else {
                imagen_valoracion=R.drawable.ic_remove_black_24dp;
            }
            valoracion=new Valoracion(imagenes[i],titulos[i],imagen_valoracion);
            valoraciones.add(valoracion);

        }

        return valoraciones;

    }









}
