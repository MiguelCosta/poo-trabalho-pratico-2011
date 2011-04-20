/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade CargaAlimentar
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class CargaAlimentar extends Carga implements Serializable {

    GregorianCalendar dataValidade;

    /** Construtores */
    /**
     * Cria Carga Alimentar
     */
    public CargaAlimentar() {
        super();
        dataValidade = new GregorianCalendar();
    }

    /**
     * Cria Carga Alimentar
     * @param codigo
     * @param peso
     * @param descricao
     * @param tempoCarregamento
     * @param dataValidade 
     */
    public CargaAlimentar(String codigo, double peso, String descricao, double tempoCarregamento, GregorianCalendar dataValidade) {
        super(codigo, peso, descricao, tempoCarregamento);
        this.dataValidade = dataValidade;
    }

    /**
     * Cria Carga Alimentar
     * @param cargaAlimentar 
     */
    public CargaAlimentar(CargaAlimentar cargaAlimentar) {
        super(cargaAlimentar);
        dataValidade = cargaAlimentar.getdataValidade();
    }

    /** gets */
    /**
     * Data de validade da carga alimentar
     * @return GregorianCalendar
     */
    public GregorianCalendar getdataValidade() {
        return dataValidade;
    }

    /** sets */
    /**
     * Alterar a data de validade
     * @param dataValidade 
     */
    public void setdataValidade(GregorianCalendar dataValidade) {
        this.dataValidade = dataValidade;
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
        CargaAlimentar CargaAlimentar = (CargaAlimentar) o;
        if (super.equals(CargaAlimentar) && this.dataValidade.equals(CargaAlimentar.getdataValidade())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return CargaAlimentar 
     */
    @Override
    public CargaAlimentar clone() {
        return new CargaAlimentar(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("CARGA ALIMENTAR:\n");
        s.append(super.toString());
        s.append("DataValidade: ");
        s.append(dataValidade.get(Calendar.YEAR));
        s.append("/");
        s.append(dataValidade.get(Calendar.MONTH));
        s.append("/");
        s.append(dataValidade.get(Calendar.DATE));
        s.append("\n");
        return s.toString();
    }
}
