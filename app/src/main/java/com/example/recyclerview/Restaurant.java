package com.example.recyclerview;

public class Restaurant {

    private  String nombre;
    private  String URLPhoto;
    private  float Rate;
    private  String Direccion;

    public Restaurant(String nombre, String URLPhoto, float rate, String direccion) {
        this.nombre = nombre;
        this.URLPhoto = URLPhoto;
        Rate = rate;
        Direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getURLPhoto() {
        return URLPhoto;
    }

    public void setURLPhoto(String URLPhoto) {
        this.URLPhoto = URLPhoto;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
