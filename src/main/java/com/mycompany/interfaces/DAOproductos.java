/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.productos;
import com.mycompany.models.usuarios;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOproductos {
    public void registrar(productos producto) throws Exception;
    public void eliminar (productos producto) throws Exception;
    public void modificar(productos producto) throws Exception;
    public void aumentarExistencias(String idProducto, int cantidad) throws Exception;
    public List<productos> listar() throws Exception;
    public List<productos> listaCremeria() throws Exception;
    public List<productos> listaAbarrotes() throws Exception;
    public List<productos> listaPanaderia() throws Exception;
    public List<productos> listaVerduras() throws Exception;
    public List<productos> listaBultos() throws Exception;
    public productos obtenerProductosTipo(String identificador) throws Exception;
    public productos obtenerProductoId(String codigoBarras) throws Exception;
    public List<productos> buscar(String texto) throws Exception;
}
