/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.detalleCompra;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOdetalleCompra {
        public void registrar(detalleCompra detallecompra) throws Exception;
    public void eliminar (detalleCompra detallecompra) throws Exception;
    public void modificar(detalleCompra detallecompra) throws Exception;
    public List<detalleCompra> listar() throws Exception;
    
}
