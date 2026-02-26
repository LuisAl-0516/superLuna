/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

/**
 *
 * @author luis-alberto
 */
import com.mycompany.db.Conexion;
import com.mycompany.interfaces.DAOusuarios;
import com.mycompany.models.usuarios;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOusuariosImp extends Conexion implements DAOusuarios {
    
@Override
public void registrar(usuarios usuario) throws Exception {
    try {
        this.conectar();
        PreparedStatement st = this.Conexion.prepareStatement("INSERT INTO usuarios(nombreUsuario,pass,idTipoUsuario) VALUES(?,?,?);");
        st.setString(1, usuario.getNombreUsuario());
        st.setString(2, usuario.getPass());
        st.setInt(3, usuario.getIdTipoUsuario());
        st.executeUpdate();
        st.close();
    } catch (SQLIntegrityConstraintViolationException e) {
        JOptionPane.showMessageDialog(null, "El usuario '" + usuario.getNombreUsuario() + "' ya está registrado.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        this.cerrarConexion();
    }
}


    @Override
    public void eliminar(usuarios usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(usuarios usuario) throws Exception {
    try {
            this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("UPDATE usuarios SET nombreUsuario = ?,pass = ?, idTipoUsuario = ? WHERE idUsuario = ?");
            st.setString(1, usuario.getNombreUsuario());
            st.setString(2, usuario.getPass());
            st.setInt(3, usuario.getIdTipoUsuario());
            st.setInt(4, usuario.getIdUsuario());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally{
        this.cerrarConexion();
        }    
    }

    @Override
    public List<usuarios> listar() throws Exception {
        List<usuarios> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT * FROM usuarios;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            usuarios usuario = new usuarios();
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNombreUsuario(rs.getString("nombreUsuario"));
            usuario.setPass(rs.getString("pass"));
            usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
            lista.add(usuario);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public usuarios getUserById(int userId) throws Exception {
        usuarios usuario = new usuarios();
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT * FROM usuarios WHERE idUsuario= ? LIMIT 1;"); 
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while(rs.next()){  
            usuario.setIdUsuario(rs.getInt("idUsuario"));
            usuario.setNombreUsuario(rs.getString("nombreUsuario"));
            usuario.setPass(rs.getString("pass"));
            usuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));

            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return usuario;
    }
}
