/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.tipoProducto;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOtipoProducto {
   public void registrar(tipoProducto tipoprod) throws Exception;
    public void eliminar (tipoProducto tipoprod) throws Exception;
    public void modificar(tipoProducto tipoprod) throws Exception;
    public List<tipoProducto> listar() throws Exception; 
}
