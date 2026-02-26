/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.totalVentas;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOtotalVentas {
    public void registrar(totalVentas totalventas) throws Exception;
    public void eliminar (totalVentas totalventas) throws Exception;
    public void modificar(totalVentas totalventas) throws Exception;
    public List<totalVentas> listar() throws Exception; 
}
