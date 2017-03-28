package com.roberto.ciudadesapp.entidades;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Usr on 26/03/2017.
 */

public class Valoracion implements Serializable {

    private Bitmap imagenMonumento;

    private String nombreMonumento;

    private int imagenValoracion;

    public Valoracion(Bitmap imagenMonumento, String nombreMonumento, int imagenValoracion) {
        this.imagenMonumento = imagenMonumento;
        this.nombreMonumento = nombreMonumento;
        this.imagenValoracion = imagenValoracion;
    }

    public Bitmap getImagenMonumento() {
        return imagenMonumento;
    }

    public void setImagenMonumento(Bitmap imagenMonumento) {
        this.imagenMonumento = imagenMonumento;
    }

    public String getNombreMonumento() {
        return nombreMonumento;
    }

    public void setNombreMonumento(String nombreMonumento) {
        this.nombreMonumento = nombreMonumento;
    }

    public int getImagenValoracion() {
        return imagenValoracion;
    }

    public void setImagenValoracion(int imagenValoracion) {
        this.imagenValoracion = imagenValoracion;
    }
}
