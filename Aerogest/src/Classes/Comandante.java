/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Comandante
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class Comandante extends Tripulante implements Serializable {

    /**
     * Construtor Comandante
     */
    public Comandante() {
        super();
        super.setFuncao("Comandante");
    }

    /**
     * Construtor Comandante
     * @param nome
     * @param nacionalidade 
     */
    public Comandante(String nome, String nacionalidade) {
        super("Comandante", nome, nacionalidade);
    }
    
    public String toString(){
        return super.toString();
    }
}
