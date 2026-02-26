/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.detalleVenta;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOdetalleVenta {
    public void registrar(detalleVenta detalleventa) throws Exception;
    public void eliminar (detalleVenta detalleventa) throws Exception;
    public void modificar(detalleVenta detalleventa) throws Exception;
    public List<detalleVenta> listar() throws Exception;
}
