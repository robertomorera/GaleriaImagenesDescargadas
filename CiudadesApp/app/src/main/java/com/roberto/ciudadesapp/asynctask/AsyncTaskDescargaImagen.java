package com.roberto.ciudadesapp.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import com.roberto.ciudadesapp.activities.GaleriaActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Usr on 26/03/2017.
 */

public class AsyncTaskDescargaImagen extends AsyncTask<String[],Void,Bitmap[]> {

    private GaleriaActivity galeriaActivity;

    public AsyncTaskDescargaImagen(GaleriaActivity galeriaActivity){
        this.galeriaActivity=galeriaActivity;
    }

    @Override
    protected Bitmap[] doInBackground(String[]... params) {
        Bitmap[] imagenesDescargadas=null;
        //URL de la imagen a descargar.
        String url_imagen=null;
        //URL transformada;
        URL url_fotografia=null;
        //Conexion HTTP.
        HttpURLConnection httpURLConnection=null;
        //Código de respuesta de la petición HTTP.
        int codigoRespuesta=0;
        //Imagen Descargada.
        Bitmap imagenDescargada=null;
        InputStream inputStream=null;
        //Obtenemos la lista de URL de imagenes a descargar.
        String[] listaURLs=params[0];
        //Inicializamos el array de imagenes descargadas.
        imagenesDescargadas= new Bitmap[listaURLs.length];

        //Recorremos la lista de URLs a descargar.
        for(int i=0;i<listaURLs.length;i++){
           try {
               url_imagen = listaURLs[i];
               //Construimos la URL donde nos conectamos.
               url_fotografia = new URL(url_imagen);
               //Inicializamos la conexion.
               httpURLConnection=(HttpURLConnection)url_fotografia.openConnection();
               //Obtenemos el código de respuesta.
               codigoRespuesta=httpURLConnection.getResponseCode();
               //Comprobamos si la peticion es correcta.
               if(codigoRespuesta==HttpURLConnection.HTTP_OK){
                   Log.d(getClass().getCanonicalName(), "La petición se ha procesado correctamente");
                   //Accedemos al cuerpo del mensaje HTTP.
                   inputStream=httpURLConnection.getInputStream();
                   //Obtenemos el bitmap.
                   imagenDescargada= BitmapFactory.decodeStream(inputStream);
                   imagenesDescargadas[i]=imagenDescargada;
               }else {
                Log.e(getClass().getCanonicalName(), "La petición fue mal. No hay foto");
                imagenDescargada=null;
               }

           }catch(Throwable t){
               Log.e(getClass().getCanonicalName(),"Ha sucedido un error en la descargada de la imagen",t);
               imagenDescargada=null;

           }finally{
                httpURLConnection.disconnect();
            }
        }

        return imagenesDescargadas;

    }

    @Override
    protected void onPostExecute(Bitmap[] bitmaps) {
        Log.d(getClass().getCanonicalName(),"Se ha finalizado con éxito las descargas de las imagenes");
        galeriaActivity.getImagenesDescargadas(bitmaps);

    }
}
