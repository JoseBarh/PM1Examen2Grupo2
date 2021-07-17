package com.example.pm1examen2grupo2;

import android.graphics.Bitmap;

public class Contactos {
    private Integer id;
    private Bitmap img;
    private String nombre;
    private String telefono;
    private String latitud;
    private String longitud;

    public Contactos (){

    }

    public Contactos(Integer id, Bitmap img, String nombre, String telefono, String latitud, String longitud) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

}
