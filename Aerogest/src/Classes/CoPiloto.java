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
}
