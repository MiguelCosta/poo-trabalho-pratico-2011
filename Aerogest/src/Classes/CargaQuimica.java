/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Carga Quimica
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class CargaQuimica extends Carga implements Serializable {

    private String estado;
    private String grauToxicidade; // grau de toxicidade

    /** Construtores */
    /**
     * Cria Carga Quimica
     */
    public CargaQuimica() {
        super();
        estado = "";
        grauToxicidade = "";
    }
/**
     * Cria Carga Quimica
     * @param codigo
     * @param peso
     * @param descricao
     * @param tempoCarregamento
     * @param estado
     * @param grauToxicidade 
     */
    public CargaQuimica(String codigo, double peso, String descricao, double tempoCarregamento, String estado, String grauToxicidade) {
        super(codigo, peso, descricao, tempoCarregamento);
        this.estado = estado;
        this.grauToxicidade = grauToxicidade;
    }

    /**
     * Cria Carga Quimica
     * @param cargaQuimica 
     */
    public CargaQuimica(CargaQuimica cargaQuimica) {
        super(cargaQuimica);
        estado = cargaQuimica.getEstado();
        grauToxicidade = cargaQuimica.getGrauToxicidade();
    }

    /** gets */
    /**
     * Estado da carga quimica
     * @return String
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Grau de Toxicidade da carga quimica
     * @return String
     */
    public String getGrauToxicidade() {
        return grauToxicidade;
    }

    /** sets */
    /**
     * Alterar o estado da carga quimica
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Alterar o grau de toxicidade
     * @param grauToxicidade 
     */
    public void setGrauToxicidade(String grauToxicidade) {
        this.grauToxicidade = grauToxicidade;
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
        CargaQuimica cargaQuimica = (CargaQuimica) o;
        if (super.equals(cargaQuimica)
                && this.estado.equals(cargaQuimica.getEstado())
                && this.grauToxicidade.equals(cargaQuimica.getGrauToxicidade())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return CargaQuimica 
     */
    @Override
    public CargaQuimica clone() {
        return new CargaQuimica(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("CARGA QUIMICA:\n");
        s.append(super.toString());
        s.append("Estado: ").append(estado).append("\n");
        s.append("GrauToxicidade: ").append(grauToxicidade).append("\n");
        return s.toString();
    }
}
