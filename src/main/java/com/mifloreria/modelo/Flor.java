package com.mifloreria.modelo;

/**
 * Clase que representa un producto (Flor) dentro del inventario.
 * Contiene los atributos básicos y los métodos para acceder a ellos.
 */
public class Flor {
    
    // Atributos del producto en el inventario
    private int idFlor;
    private String nombre;
    private double precio;
    private int stockAcumulado;

    /**
     * Constructor vacío necesario para instanciar el objeto sin datos iniciales.
     */
    public Flor() {
    }

    /**
     * Constructor con todos los parámetros para crear un producto completo.
     */
    public Flor(int idFlor, String nombre, double precio, int stockAcumulado) {
        this.idFlor = idFlor;
        this.nombre = nombre;
        this.precio = precio;
        this.stockAcumulado = stockAcumulado;
    }

    // --- Métodos Getters y Setters ---

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