/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.presentacionProducto;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOpresentacionProducto {
   public void registrar(presentacionProducto presentacionprod) throws Exception;
    public void eliminar (presentacionProducto presentacionprod) throws Exception;
    public void modificar(presentacionProducto presentacionprod) throws Exception;
    public List<presentacionProducto> listar() throws Exception; 
}
