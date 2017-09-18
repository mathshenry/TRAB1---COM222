package utils;

import Controllers.ContaController;
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
public class DatabaseController {

    private static Statement stm;
    private static final DecimalFormat DF = new DecimalFormat("0.##");

    private static void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javabank", "root", "");
            stm = c.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static boolean isCorrentistaValido(String cpf) throws SQLException {
        inicializaJdbc();
        ResultSet res = null;
        res = stm.executeQuery("SELECT * FROM correntista WHERE CPF = '" + cpf + "'");
        while (res.next()) {
            // Retorna True se existir conta com a senha informada.
            return true;
        }
        return false;
    }

    public static long cadastraConta(String Primeiro_Corr, String Segundo_Corr, String Terceiro_Corr, double saldo, double Limite, String senha) throws SQLException {
        inicializaJdbc();
        if (!Segundo_Corr.equals("") && !Terceiro_Corr.equals("")) {
            stm.execute("INSERT into conta (Primeiro_Corr, Segundo_Corr, Terceiro_Corr, Saldo, Limite, senha) values ('"
                    + Primeiro_Corr + "','" + Segundo_Corr + "','" + Terceiro_Corr + "','" + DF.format(saldo) + "','" + DF.format(Limite) + "','" + senha + "')");
        } else {
            if (!Segundo_Corr.equals("")) {
                stm.execute("INSERT into conta (Primeiro_Corr, Segundo_Corr, Saldo, Limite, senha) values ('"
                        + Primeiro_Corr + "','" + Segundo_Corr + "','" + DF.format(saldo) + "','" + DF.format(Limite) + "','" + senha + "')");
            } else {
                if (!Terceiro_Corr.equals("")) {
                    stm.execute("INSERT into conta (Primeiro_Corr, Terceiro_Corr, Saldo, Limite, senha) values ('"
                            + Primeiro_Corr + "','" + Terceiro_Corr + "','" + DF.format(saldo) + "','" + DF.format(Limite) + "','" + senha + "')");
                } else {
                    stm.execute("INSERT into conta (Primeiro_Corr, Saldo, Limite, senha) values ('"
                            + Primeiro_Corr + "','" + DF.format(saldo) + "','" + DF.format(Limite) + "','" + senha + "')");
                }
            }
        }

        ResultSet res = null;
        res = stm.executeQuery("SELECT * FROM conta WHERE Primeiro_Corr = '" + Primeiro_Corr + "' and senha = '" + senha + "'");

        if (res != null) {
            while (res.next()) {
                return res.getLong("Numero");
            }
        }
        return -1;
    }

    public static boolean isContaValida(long conta) {
        inicializaJdbc();

        ResultSet res = null;
        try {
            res = stm.executeQuery("SELECT * FROM conta WHERE Numero = '" + conta + "'");
            while (res.next()) {
                // Retorna True se existir a conta.
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean isSenhaValida(long Conta, String Senha) {
        inicializaJdbc();

        ResultSet res = null;
        try {
            res = stm.executeQuery("SELECT * FROM conta WHERE Numero = '" + Conta + "' and senha = '" + Senha + "'");
            while (res.next()) {
                // Retorna True se existir conta com a senha informada.
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static double getSaldoConta(long Conta) {
        inicializaJdbc();

        ResultSet res = null;

        try {
            res = stm.executeQuery("SELECT * FROM conta WHERE Numero = '" + Conta + "'");
            while (res.next()) {
                // Retorna True se existir conta com a senha informada.
                return res.getDouble("Saldo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static double getLimiteConta(long Conta) {
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

    public static void setSaldo(double Saldo, long Conta) throws SQLException {
        inicializaJdbc();
        stm.execute("UPDATE conta SET saldo = " + DF.format(Saldo) + " where Numero = " + Conta);
    }

    public static void setLimite(double Saldo, long Conta) throws SQLException {
        inicializaJdbc();
        stm.execute("UPDATE conta SET saldo = " + DF.format(Saldo) + " where Numero = " + Conta);
    }

    public static boolean cadastraCorrentista(String CPF, String Nome, String Endereco, String Email) throws SQLException {
        inicializaJdbc();

        try {
            stm.execute("INSERT into correntista (CPF, Nome, Endereco, Email) values ('"
                    + CPF + "','" + Nome + "','" + Endereco + "','" + Email + "')");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static int cadastraFuncionario(String nome, String email, String senha, String funcao) throws SQLException {
        inicializaJdbc();

        stm.execute("INSERT into funcionario (Nome, Email, Funcao, senha) values ('" + nome + "','" + email + "','" + funcao + "','" + senha + "')");

        ResultSet res = null;
        res = stm.executeQuery("SELECT * FROM funcionario WHERE Nome = '" + nome + "' and Email = '" + email + "' and senha = '" + senha + "'");

        while (res.next()) {
            return res.getInt("Codigo");
        }

        return -1;
    }

    public static boolean isUsuarioValido(String usuario, String senha) throws SQLException {
        ResultSet res = null;
        inicializaJdbc();
        res = stm.executeQuery("SELECT * FROM funcionario WHERE Codigo = " + usuario + " and senha = '" + senha + "'");
        if (res != null) {
            while (res.next()) {
                return true;
            }
        }
        return false;
    }

    public static void registraTransacao(String tipo, long Nro_Conta, long Nro_Conta_Transf, double Valor) throws SQLException {
        inicializaJdbc();

        if (Nro_Conta_Transf != 0) {
            stm.execute("INSERT into transacao (Tipo, Nro_Conta, Nro_Conta_Transf, Valor) values ('"
                    + tipo + "','" + Nro_Conta + "','" + Nro_Conta_Transf + "','" + DF.format(Valor) + "')");
        }else{
            stm.execute("INSERT into transacao (Tipo, Nro_Conta, Valor) values ('"
                    + tipo + "','" + Nro_Conta + "','" + DF.format(Valor) + "')");
        }
    }
    
    public static String getExtrato(long conta) throws SQLException{
        inicializaJdbc();
        String resultado = "<table><tr><th>Código</th><th>Tipo</th><th>Conta de Origem</th><th>Conta de Destino</th><th>Valor</th></tr>";
        ResultSet res = null;
        res = stm.executeQuery("SELECT * FROM transacao WHERE Nro_Conta = " + conta + " or Nro_Conta_Transf = '" + conta + "'");
        if (res != null) {
            while (res.next()) {
                resultado += "<tr><td>"+res.getInt("Codigo")+"</td><td>"+res.getString("Tipo")+"</td><td>"+res.getLong("Nro_Conta")+"</td><td>"+res.getLong("Nro_Conta_Transf")+
                        "</td><td>"+res.getDouble("Valor")+"</td></tr>";
            }
            resultado+="</table>";
        }
        
        if(resultado.equals("")){
            resultado = "Não há transações para esta conta!";
        }
        return resultado;
    }

}
