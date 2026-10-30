package com.example.segundo_parcial;

public class Moto {
    private String modelo;
    private String marca;
    private String cilindraje;
    private String precio;
    private int imagenResId;

    public Moto(String modelo, String marca, String cilindraje, String precio, int imagenResId) {
        this.modelo = modelo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.imagenResId = imagenResId;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public String getPrecio() {
        return precio;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}