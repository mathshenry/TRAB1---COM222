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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maths
 */
public class ContaController {

    private Statement stm;
    private final DecimalFormat df = new DecimalFormat("0.##");

    private void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javabank", "root", "");
            stm = c.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public long cadastraConta(String Primeiro_Corr, String Segundo_Corr, String Terceiro_Corr, double saldo, double Limite, String senha) throws SQLException {
        inicializaJdbc();

        stm.execute("INSERT into conta (Primeiro_Corr, Segundo_Corr, Terceiro_Corr, Saldo, Limite, senha) values ('"
                + Primeiro_Corr + "','" + Segundo_Corr + "','" + Terceiro_Corr + "','" + df.format(saldo) + "','" + df.format(Limite) + "','" + senha + "')");

        ResultSet res = null;
        res = stm.executeQuery("SELECT * FROM conta WHERE Primeiro_Corr = '" + Primeiro_Corr + "' and senha = '" + senha + "'");

        while (res.next()) {
            return res.getLong("Numero");
        }
        return 0;
    }

    public boolean VerificaSenha(int Conta, String Senha) {
        inicializaJdbc();

        ResultSet res = null;

        try {
            res = stm.executeQuery("SELECT * FROM conta WHERE Numero = '" + Conta + "' and senha = '" + Senha + "'");
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            while (res.next()) {
                // Retorna True se existir conta com a senha informada.
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public double SaldoConta(long Conta) {
        inicializaJdbc();

        ResultSet res = null;

        try {
            res = stm.executeQuery("SELECT * FROM conta WHERE Numero = '" + Conta + "'");
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            while (res.next()) {
                // Retorna True se existir conta com a senha informada.
                return res.getDouble("Saldo");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }

    public double LimiteConta(long Conta) {
        inicializaJdbc();

        ResultSet res = null;

        try {
            res = stm.executeQuery("SELECT * FROM conta WHERE Numero = '" + Conta + "'");
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            while (res.next()) {
                // Retorna True se existir conta com a senha informada.
                return res.getDouble("Limite");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public void atualizaSaldo(double Saldo, long Conta) throws SQLException {
        inicializaJdbc();

        stm.execute("UPDATE conta SET saldo = " + df.format(Saldo) + " where Numero = " + Conta);

    }
    
    public void atualizaLimite(double Saldo, long Conta) throws SQLException {
        inicializaJdbc();

        stm.execute("UPDATE conta SET saldo = " + df.format(Saldo) + " where Numero = " + Conta);

    }

}
