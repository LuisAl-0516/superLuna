/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.tipoUsuarios;
import java.util.List;

/**
 *
 * @author luis-alberto
 */
public interface DAOtipoUsuarios {
    public void registrar(tipoUsuarios tipoUsuario) throws Exception;
    public void eliminar (tipoUsuarios tipoUsuario) throws Exception;
    public void modificar(tipoUsuarios tipoUsuario) throws Exception;
    public List<tipoUsuarios> listar() throws Exception; 
}
