/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maths
 */
public class TransacaoController {

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

    public void registraTransacao(String tipo, long Nro_Conta, long Nro_Conta_Transf, double Valor) throws SQLException {
        inicializaJdbc();

        stm.execute("INSERT into transacao (Tipo, Nro_Conta, Nro_Conta_Transfer, Valor) values ('"
                + tipo + "','" + Nro_Conta + "','" + Nro_Conta_Transf + "','" + df.format(Valor) + "')");

    }

    public boolean realizaSaque(long conta, double valor) {

        ContaController c = new ContaController();
        double saldoCliente = c.SaldoConta(conta);
        double limiteDisponivel = c.LimiteConta(conta);

        if (valor <= (saldoCliente + limiteDisponivel)) {
            if (saldoCliente >= valor) {
                try {
                    c.atualizaSaldo((saldoCliente - valor), conta);
                } catch (SQLException ex) {
                    Logger.getLogger(TransacaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    c.atualizaSaldo(0, conta);
                } catch (SQLException ex) {
                    Logger.getLogger(TransacaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    c.atualizaLimite((limiteDisponivel - (valor - saldoCliente)), conta);
                } catch (SQLException ex) {
                    Logger.getLogger(TransacaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                registraTransacao("saque", conta, 0, valor);
            } catch (SQLException ex) {
                Logger.getLogger(TransacaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return true;
            
        }else{
            return false;
        }

    }

}
