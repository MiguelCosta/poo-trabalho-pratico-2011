/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade CoPiloto
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class CoPiloto extends Tripulante implements Serializable {

    /**
     * Construtor CoPiloto
     */
    public CoPiloto() {
        super();
        super.setFuncao("CoPiloto");
    }

    /**
     * Construtor CoPiloto
     * @param nome
     * @param nacionalidade 
     */
    public CoPiloto(String codigo, String nome, String nacionalidade) {
        super(codigo, "CoPiloto", nome, nacionalidade);
    }
    
    /**
     * 
     * @param c 
     */
    public CoPiloto(CoPiloto c) {
        super(c);
        super.setFuncao("CoPiloto");
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
    public CoPiloto clone(){
        return new CoPiloto(this);
    }
}
