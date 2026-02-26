/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.sql.Timestamp;

/**
 *
 * @author abarrotesluna
 */
public class precioActualizado {
    private int idActualizacion;
    private String idProducto;
    private double precioAnterior;
    private double precioCompra;
    private double nuevoPrecio;
    private int idCompra;
    private int idDetalleCompra;
    private Timestamp fechaActualizacion;

    public int getIdActualizacion() {
        return idActualizacion;
    }

    public void setIdActualizacion(int idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(double precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getNuevoPrecio() {
        return nuevoPrecio;
    }

    public void setNuevoPrecio(double nuevoPrecio) {
        this.nuevoPrecio = nuevoPrecio;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
}
