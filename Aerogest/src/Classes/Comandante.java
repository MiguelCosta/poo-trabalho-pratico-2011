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
    public Comandante(String codigo, String nome, String nacionalidade) {
        super(codigo, "Comandante", nome, nacionalidade);
    }
    
    /**
     * 
     * @param c 
     */
    public Comandante(Comandante c){
        super(c);
        super.setFuncao("Comandante");
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
    
    @Override
    public Comandante clone(){
        return new Comandante(this);
    }
}
