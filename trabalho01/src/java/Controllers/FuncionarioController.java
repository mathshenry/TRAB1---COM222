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

/**
 *
 * @author maths
 */
public class FuncionarioController {
   
   private Statement stm; 
   
   private void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javabank", "root", "");
            stm = c.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
   public int cadastraFuncionario(String nome, String email, String senha, String funcao) throws SQLException{
       inicializaJdbc();
       
       stm.execute("INSERT into funcionario (Nome, Email, Funcao, senha) values ('"+nome+"','"+email+"','"+funcao+"','"+senha+"')");
       
       ResultSet res = null;
       res = stm.executeQuery("SELECT * FROM funcionario WHERE Email = '" + email + "' and senha = '" + senha + "'");

        while (res.next()) {
            return res.getInt("Codigo");
        }
        
       return 0;
   }
   
   public boolean verificaUsuário(String usuario, String senha) throws SQLException {
        ResultSet res = null;
        inicializaJdbc();
        res = stm.executeQuery("SELECT * FROM funcionario WHERE Codigo = " + usuario + " and senha = '" + senha + "'");

        while (res.next()) {
            return true;
        }
        
        return false;
    }
    
}
