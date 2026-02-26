/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.detalleCompra;
import com.mycompany.models.precioActualizado;
import java.util.List;

/**
 *
 * @author abarrotesluna
 */
public interface DAOprecioActualizado {
    public void registrar(precioActualizado precioactualizado) throws Exception;
    public List<detalleCompra> listarPreciosSinActualizar() throws Exception;
}
