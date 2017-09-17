package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DatabaseController;

/**
 *
 * @author maths
 */
public class ContaController {

    public long cadastraConta(String Primeiro_Corr, String Segundo_Corr, String Terceiro_Corr, double saldo, double Limite, String senha) throws SQLException {
        
        return DatabaseController.cadastraConta(Primeiro_Corr, Segundo_Corr, Terceiro_Corr, saldo, Limite, senha);
    }

    public boolean isSenhaValida(int Conta, String Senha) {
        return DatabaseController.isSenhaValida(Conta, Senha);
    }
    
    public boolean isContaValida(long conta){
        return DatabaseController.isContaValida(conta);
    }

    public double getSaldoConta(long Conta) {
        return DatabaseController.getSaldoConta(Conta);
    }

    public double getLimiteConta(long Conta) {
        return DatabaseController.getLimiteConta(Conta);
    }

    public void setSaldo(double Saldo, long Conta) throws SQLException {
        DatabaseController.setSaldo(Saldo, Conta);
    }
    
    public void setLimite(double Saldo, long Conta) throws SQLException {
        DatabaseController.setLimite(Saldo, Conta);
    }

}
