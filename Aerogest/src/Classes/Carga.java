/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Carga
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public abstract class Carga implements Serializable {

    /** Variaveis de instancia */
    private String codigo;
    private double peso;
    private String descricao;
    private double tempoCarregamento;

    /** Construtores */
    /**
     * Cria Carga
     */
    public Carga() {
        codigo = "";
        peso = 0;
        descricao = "";
        tempoCarregamento = 0;
    }

    /**
     * Cria Carga
     * @param codigo
     * @param peso
     * @param descricao
     * @param tempoCarregamento 
     */
    public Carga(String codigo, double peso, String descricao, double tempoCarregamento) {
        this.codigo = codigo;
        this.peso = peso;
        this.descricao = descricao;
        this.tempoCarregamento = tempoCarregamento;
    }

    /**
     * Cria Carga
     * @param carga 
     */
    public Carga(Carga carga) {
        codigo = carga.getCodigo();
        peso = carga.getPeso();
        descricao = carga.getDescricao();
        tempoCarregamento = carga.getTempoCarregamento();
    }

    /** gets */
    /**
     * Codigo da carga
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Peso da carga
     * @return double
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Descrição da carga
     * @return String
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Tempo de carregamento da carga
     * @return double
     */
    public double getTempoCarregamento() {
        return tempoCarregamento;
    }

    /** sets */
    /**
     * Alterar o codigo da carga
     * @param codigo 
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Alterar peso da carga
     * @param peso 
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Alterar descrição da carga
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Alterar tempo de carregamento da carga
     * @param tempoCarregamento 
     */
    public void setTempoCarregamento(double tempoCarregamento) {
        this.tempoCarregamento = tempoCarregamento;
    }

    /**
     * equals
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Carga carga = (Carga) o;
        if (this.codigo.equals(carga.getCodigo())
                && this.peso == carga.getPeso()
                && this.descricao.equals(carga.getDescricao())
                && this.tempoCarregamento == carga.getTempoCarregamento()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return Carga
     */
    @Override
    public abstract Carga clone();

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("CARGA:\n");
        s.append("Codigo: ").append(codigo).append("\n");
        s.append("Peso: ").append(peso).append("\n");
        s.append("Descricao: ").append(descricao).append("\n");
        s.append("TempoCarregamento: ").append(tempoCarregamento).append("\n");
        return s.toString();
    }
}
