/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author maths
 */
public class Conta {
    
    private long numero;
    private String primeiro_corr, segundo_corr, terceito_corr;
    private double saldo, limite;

    public Conta() {
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getPrimeiro_corr() {
        return primeiro_corr;
    }

    public void setPrimeiro_corr(String primeiro_corr) {
        this.primeiro_corr = primeiro_corr;
    }

    public String getSegundo_corr() {
        return segundo_corr;
    }

    public void setSegundo_corr(String segundo_corr) {
        this.segundo_corr = segundo_corr;
    }

    public String getTerceito_corr() {
        return terceito_corr;
    }

    public void setTerceito_corr(String terceito_corr) {
        this.terceito_corr = terceito_corr;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
    
}