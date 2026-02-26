/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.compras;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOcompras {
    public int registrar(compras compra) throws Exception;
    public void eliminar (compras compra) throws Exception;
    public void modificar(compras compra) throws Exception;
    public List<compras> listar() throws Exception;
}
