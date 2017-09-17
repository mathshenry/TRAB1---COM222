/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DatabaseController;

/**
 *
 * @author maths
 */
public class FuncionarioController {
    
   public int cadastraFuncionario(String nome, String email, String senha, String funcao) throws SQLException{
       return DatabaseController.cadastraFuncionario(nome, email, senha, funcao);
   }
   
   public boolean isUsuarioValido(String usuario, String senha) throws SQLException {
        return DatabaseController.isUsuarioValido(usuario, senha);
    }
    
}
