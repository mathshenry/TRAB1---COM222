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
public class Transacao {
    private long codigo, nro_conta, nro_conta_transf;
    private String tipo;
    private double valor;

    public Transacao() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getNro_conta() {
        return nro_conta;
    }

    public void setNro_conta(long nro_conta) {
        this.nro_conta = nro_conta;
    }

    public long getNro_conta_transf() {
        return nro_conta_transf;
    }

    public void setNro_conta_transf(long nro_conta_transf) {
        this.nro_conta_transf = nro_conta_transf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
