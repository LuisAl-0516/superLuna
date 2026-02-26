/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.interfaces;

import com.mycompany.models.usuarios;
import java.util.List;


/**
 *
 * @author luis-alberto
 */
public interface DAOusuarios {
    public void registrar(usuarios usuario) throws Exception;
    public void eliminar (usuarios usuario) throws Exception;
    public void modificar(usuarios usuario) throws Exception;
    public List<usuarios> listar() throws Exception;
    public usuarios getUserById(int userId) throws Exception;
}
