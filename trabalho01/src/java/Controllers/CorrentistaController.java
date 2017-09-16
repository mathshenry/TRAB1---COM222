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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maths
 */
public class CorrentistaController {
    
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

    public void cadastraCorrentista(String CPF, String Nome, String Endereco, String Email) throws SQLException {
        inicializaJdbc();

        stm.execute("INSERT into correntista (CPF, Nome, Endereco, Email) values ('"
                + CPF + "','" + Nome + "','" + Endereco + "','" + Email +  "')");

    }
    
    public int CriaContaTitulares(String Primeiro_Corr, String Segundo_Corr, String Terceiro_Corr, double saldo, double Limite, String senha){
        
        ContaController c = new ContaController();
        
        try {
            // Retorna o numero da Conta
            return c.cadastraConta(Primeiro_Corr, Segundo_Corr, Terceiro_Corr, saldo, Limite, senha);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CorrentistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 1;
    }
    
}
