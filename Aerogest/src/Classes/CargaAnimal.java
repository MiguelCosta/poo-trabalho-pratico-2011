/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade CargaAnimal
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class CargaAnimal extends Carga implements Serializable {

    double volume;

    /** Construtores */
    /**
     * Cria Carga Animal
     */
    public CargaAnimal() {
        super();
        volume = 0;
    }

    /**
     * Cria Carga Animal
     * @param codigo
     * @param peso
     * @param descricao
     * @param tempoCarregamento
     * @param volume 
     */
    public CargaAnimal(String codigo, double peso, String descricao, double tempoCarregamento, double volume) {
        super(codigo, peso, descricao, tempoCarregamento);
        this.volume = volume;
    }

    /**
     * Cria Carga Animal
     * @param cargaAnimal 
     */
    public CargaAnimal(CargaAnimal cargaAnimal) {
        super(cargaAnimal);
        volume = cargaAnimal.getVolume();
    }

    /** gets */
    /**
     * Volume da carga animal
     * @return double
     */
    public double getVolume() {
        return volume;
    }

    /** sets */
    /**
     * alterar volume da carga animal
     * @param volume 
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

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
        CargaAnimal cargaAnimal = (CargaAnimal) o;
        if (super.equals(cargaAnimal) && this.volume == cargaAnimal.getVolume()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return CargaAnimal 
     */
    @Override
    public CargaAnimal clone() {
        return new CargaAnimal(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("CARGA ANIMAL:\n");
        s.append(super.toString());
        s.append("Volume: ").append(volume).append("\n");
        return s.toString();
    }
}
