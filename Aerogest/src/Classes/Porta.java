/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Porta
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class Porta implements Serializable{

    /** Variaveis de instancia */
    private String codPorta;
    private boolean livre;

    /** Construtores */
    /**
     * Construtor Porta
     */
    public Porta() {
        codPorta = "";
        livre = false;
    }

    /**
     * Construtor Porta
     * @param codPorta
     * @param livre 
     */
    public Porta(String codPorta, boolean livre) {
        this.codPorta = codPorta;
        this.livre = livre;
    }

    /**
     * Construtor Porta
     * @param porta 
     */
    public Porta(Porta porta) {
        codPorta = porta.getCodPorta();
        livre = porta.getLivre();
    }

    /** gets */
    /**
     * Codigo da Porta
     * @return String
     */
    public String getCodPorta() {
        return codPorta;
    }

    /**
     * Estado da Porta
     * @return 
     */
    public boolean getLivre() {
        return livre;
    }

    /** sets */
    /**
     * Alterar o codigo da Porta
     * @param codPorta 
     */
    public void setCodPorta(String codPorta) {
        this.codPorta = codPorta;
    }

    /**
     * Alterar o estado da Porta
     * @param livre 
     */
    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    /** Equals | Clone | toString */
    /**
     * equals
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Porta porta = (Porta) o;
        if (this.codPorta.equals(porta.getCodPorta()) && this.livre == porta.getLivre()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return Porta 
     */
    @Override
    public Porta clone() {
        return new Porta(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("PORTA:\n");
        s.append("CodPorta: " + codPorta + "\n");
        s.append("Livre: " + livre + "\n");
        return s.toString();
    }
}
