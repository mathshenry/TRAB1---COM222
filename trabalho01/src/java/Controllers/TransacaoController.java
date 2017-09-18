/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.SQLException;
import java.util.Arrays;
import utils.DatabaseController;

/**
 *
 * @author maths
 */
public class TransacaoController {
    
    public static final String TRANSFERENCIA = "transf";
    public static final String SAQUE = "saque";
    public static final String DEPOSITO = "deposito";
    public static final String PAGAMENTODECONTA = "pagto";

    public void registraTransacao(String tipo, long Nro_Conta, long Nro_Conta_Transf, double Valor) throws SQLException {
        DatabaseController.registraTransacao(tipo, Nro_Conta, Nro_Conta_Transf, Valor);
    }

    public boolean realizaSaque(long conta, double valor) {

        ContaController c = new ContaController();
        if (c.isContaValida(conta)) {
            double saldoCliente = c.getSaldoConta(conta);
            double limiteDisponivel = c.getLimiteConta(conta);

            if (valor <= (saldoCliente + limiteDisponivel)) {
                try {
                    c.setSaldo((saldoCliente - valor), conta);
                    registraTransacao(SAQUE, conta, 0, valor);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean realizaPagamentoDeConta(long conta, double valor) {

        ContaController c = new ContaController();
        if (c.isContaValida(conta)) {
            double saldoCliente = c.getSaldoConta(conta);
            double limiteDisponivel = c.getLimiteConta(conta);

            if (valor <= (saldoCliente + limiteDisponivel)) {
                try {
                    c.setSaldo((saldoCliente - valor), conta);
                    registraTransacao(PAGAMENTODECONTA, conta, 0, valor);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean realizaDeposito(long conta, double valor) {

        ContaController c = new ContaController();
        if (c.isContaValida(conta)) {
            try {
                c.setSaldo((c.getSaldoConta(conta))+valor, conta);
                registraTransacao(DEPOSITO, conta, 0, valor);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean realizaTransferencia(long contaOrigem, long contaDestino, double valor){
        
        ContaController contaController = new ContaController();
        
        try{       
            if(contaController.isContaValida(contaOrigem) && contaController.isContaValida(contaDestino)){
                double saldoOrigem = contaController.getSaldoConta(contaOrigem);
                double saldoDestino = contaController.getSaldoConta(contaDestino);
                if(valor < saldoOrigem+contaController.getLimiteConta(contaOrigem)){
                    contaController.setSaldo(saldoOrigem-valor, contaOrigem);
                    contaController.setSaldo(saldoDestino+valor, contaDestino);
                    registraTransacao(TRANSFERENCIA, contaOrigem, contaDestino, valor);
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
