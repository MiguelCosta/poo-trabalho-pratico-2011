/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Carga Veiculo
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class CargaVeiculo extends Carga implements Serializable {

    private String tipo;

    /** Construtores */
    /**
     * Cria Carga Veiculo
     */
    public CargaVeiculo() {
        super();
        tipo = "";
    }

    /**
     * Cria Carga Veiculo
     * @param codigo
     * @param peso
     * @param descricao
     * @param tempoCarregamento
     * @param tipo 
     */
    public CargaVeiculo(String codigo, double peso, String descricao, double tempoCarregamento, String tipo) {
        super(codigo, peso, descricao, tempoCarregamento);
        this.tipo = tipo;
    }

    /**
     * Cria Carga Veiculo
     * @param cargaVeiculo 
     */
    public CargaVeiculo(CargaVeiculo cargaVeiculo) {
        super(cargaVeiculo);
        tipo = cargaVeiculo.getTipo();
    }

    /** gets */
    /**
     * Tipo da Carga Veiculo
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /** sets */
    /**
     * Alterar o tipo da Carga Veiculo
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        CargaVeiculo cargaVeiculo = (CargaVeiculo) o;
        if (super.equals(cargaVeiculo) && this.tipo.equals(cargaVeiculo.getTipo())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return CargaVeiculo
     */
    @Override
    public CargaVeiculo clone() {
        return new CargaVeiculo(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("CARGA VEICULO:\n");
        s.append(super.toString());
        s.append("Tipo: ").append(tipo).append("\n");
        return s.toString();
    }
}
