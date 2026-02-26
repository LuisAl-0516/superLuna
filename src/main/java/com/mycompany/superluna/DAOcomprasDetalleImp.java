/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import com.mycompany.interfaces.DAOdetalleCompra;
import com.mycompany.models.detalleCompra;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author abarrotesluna
 */
public class DAOcomprasDetalleImp extends com.mycompany.db.Conexion implements DAOdetalleCompra{

    @Override
public void registrar(detalleCompra detalle) throws Exception {

    String sql = """
        INSERT INTO detalleCompra
        (idCompra, idProducto, subtotalCompra, cantidad, precioUni)
        VALUES (?, ?, ?, ?, ?)
    """;

    try (PreparedStatement ps = Conexion.prepareStatement(sql)) {

        ps.setInt(1, detalle.getIdCompra());
        ps.setString(2, detalle.getIdProducto());
        ps.setDouble(3, detalle.getSubtotalCompra());
        ps.setInt(4, detalle.getCantidad());
        ps.setDouble(5, detalle.getPrecioUni());

        ps.executeUpdate();
    }
}
 

    @Override
    public void eliminar(detalleCompra detallecompra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(detalleCompra detallecompra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<detalleCompra> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
