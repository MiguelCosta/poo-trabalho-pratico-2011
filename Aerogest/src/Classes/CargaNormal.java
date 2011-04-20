/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade CargaNormal
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class CargaNormal extends Carga implements Serializable {

    /** Construtores */
    /**
     * Cria Carga Normal
     */
    public CargaNormal() {
        super();
    }

    /**
     * Cria CargaNormal
     * @param codigo
     * @param peso
     * @param descricao
     * @param tempoCarregamento 
     */
    public CargaNormal(String codigo, double peso, String descricao, double tempoCarregamento) {
        super(codigo, peso, descricao, tempoCarregamento);
    }

    /**
     * Cria Carga Normal
     * @param cargaNormal 
     */
    public CargaNormal(CargaNormal cargaNormal) {
        super(cargaNormal);
    }

    /**
     * clone
     * @return CargaNormal 
     */
    @Override
    public CargaNormal clone() {
        return new CargaNormal(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("CARGA NORMAL:\n");
        s.append(super.toString());
        return s.toString();
    }
}
