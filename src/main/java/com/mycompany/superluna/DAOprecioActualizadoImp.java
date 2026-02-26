/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import com.mycompany.interfaces.DAOprecioActualizado;
import com.mycompany.models.detalleCompra;
import com.mycompany.models.precioActualizado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abarrotesluna
 */
public class DAOprecioActualizadoImp extends com.mycompany.db.Conexion implements DAOprecioActualizado {

    @Override
    public void registrar(precioActualizado p) throws Exception {
        String sql = """
        INSERT INTO precioActualizado
        (idProducto, precioAnterior, precioCompra, nuevoPrecio,
         idCompra, idDetalleCompra, fechaActualizacion)
        VALUES (?, ?, ?, ?, ?, ?, ?)
    """;

    try (PreparedStatement ps = Conexion.prepareStatement(sql)) {

        ps.setString(1, p.getIdProducto());
        ps.setDouble(2, p.getPrecioAnterior());
        ps.setDouble(3, p.getPrecioCompra());
        ps.setDouble(4, p.getNuevoPrecio());
        ps.setInt(5, p.getIdCompra());
        ps.setInt(6, p.getIdDetalleCompra());
        ps.setTimestamp(7, p.getFechaActualizacion());

        ps.executeUpdate();
    }
    }

    @Override
    public List<detalleCompra> listarPreciosSinActualizar() throws Exception {
        List<detalleCompra> lista = new ArrayList<>();

    String sql = """
        SELECT dc.idCompra,
               dc.idCompraDetalle,
               dc.idProducto,
               dc.subtotalCompra,
               dc.precioUni,
               dc.cantidad
        FROM detalleCompra dc
        LEFT JOIN precioActualizado pa
          ON pa.idCompra = dc.idCompra
         AND pa.idDetalleCompra = dc.idCompraDetalle
        WHERE pa.idDetalleCompra IS NULL
    """;

    PreparedStatement ps = Conexion.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
        detalleCompra d = new detalleCompra();
        d.setIdCompra(rs.getInt("idCompra"));
        d.setIdCompraDetalle(rs.getInt("idCompraDetalle"));
        d.setIdProducto(rs.getString("idProducto"));
        d.setSubtotalCompra(rs.getDouble("subtotalCompra"));
        d.setPrecioUni(rs.getDouble("precioUni"));
        d.setCantidad(rs.getInt("cantidad"));

        lista.add(d);
    }

    rs.close();
    ps.close();

    return lista;
    }
    
}
