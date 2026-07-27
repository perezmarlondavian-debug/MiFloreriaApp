package com.mifloreria.modelo;

public class Flor {
    

    private int idFlor;
    private String nombre;
    private double precio;
    private int stockAcumulado;

   
    public Flor() {
    }

    
    public Flor(int idFlor, String nombre, double precio, int stockAcumulado) {
        this.idFlor = idFlor;
        this.nombre = nombre;
        this.precio = precio;
        this.stockAcumulado = stockAcumulado;
    }



    public int getIdFlor() {
        return idFlor;
    }

    public void setIdFlor(int idFlor) {
        this.idFlor = idFlor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockAcumulado() {
        return stockAcumulado;
    }

    public void setStockAcumulado(int stockAcumulado) {
        this.stockAcumulado = stockAcumulado;
    }
}