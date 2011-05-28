/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Aeronave
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public abstract class Aeronave implements Serializable{

    /** Variaveis de instancia */
    private String matricula;
    private int capacidadePassageiros;
    private double capacidadeCarga; //toneladas
    private double velocidadeMaxima;
    private boolean livre;

    /**
     * Cria uma aeronave
     */
    public Aeronave() {
        matricula = "";
        capacidadePassageiros = 0;
        capacidadeCarga = 0;
        velocidadeMaxima = 0;
        livre = true;
    }

    /**
     * Cria uma aeronava
     * @param matricula
     * @param designacao
     * @param capacidadePassageiros
     * @param capacidadeCarga
     * @param velocidadeMaxima 
     */
    public Aeronave(String matricula, int capacidadePassageiros, double capacidadeCarga, double velocidadeMaxima) {
        this.matricula = matricula;
        this.capacidadePassageiros = capacidadePassageiros;
        this.capacidadeCarga = capacidadeCarga;
        this.velocidadeMaxima = velocidadeMaxima;
        livre = true;
    }

    /**
     * Cria uma aeronave
     * @param aeronave 
     */
    public Aeronave(Aeronave aeronave) {
        matricula = aeronave.getMatricula();
        capacidadePassageiros = aeronave.getCapacidadePassageiros();
        capacidadeCarga = aeronave.getCapacidadeCarga();
        velocidadeMaxima = aeronave.getVelocidadeMaxima();
        livre = aeronave.getOcupacao();
    }

    /** gets **/
    /**
     * Matricula da aeronave
     * @return String
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Lotação da aeronave
     * @return int
     */
    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    /**
     * Carga da aeronave
     * @return double
     */
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    /**
     * Velocidade Máxima da aeronave
     * @return double
     */
    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    /**
     * Estado de ocupação da aeronave
     * @return boolean
     */
    public boolean getOcupacao() {
        return livre;
    }

    /** sets */
    /**
     * Alterar matricula da aeronave
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Alterar a lotação da aeronave
     * @param capacidadePassageiros 
     */
    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    /**
     * Alterar a capacidade de carda da aeronave
     * @param capacidadeCarga 
     */
    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    /**
     * Alterar a velocidade máxima da aeronave
     * @param velocidadeMaxima 
     */
    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    /**
     * Alterar o estado de ocupação da aeronave
     * @param boolean
     */
    public void setLivre(boolean b) {
        livre = b;
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
        Aeronave aeronave = (Aeronave) o;
        if (this.matricula.equals(aeronave.getMatricula())
                && this.capacidadePassageiros == aeronave.getCapacidadePassageiros()
                && this.capacidadeCarga == aeronave.getCapacidadeCarga()
                && this.velocidadeMaxima == aeronave.getVelocidadeMaxima()
                && this.livre == aeronave.getOcupacao()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return Aeronave 
     */
    @Override
    public abstract Aeronave clone();

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("AERONAVE:\n");
        s.append("Matricula: ").append(matricula).append("\n");
        s.append("CapacidadePassageiros: ").append(capacidadePassageiros).append("\n");
        s.append("CapacidadeCarga: ").append(capacidadeCarga).append("\n");
        s.append("VelocidadeMaxima: ").append(velocidadeMaxima).append("\n");
        s.append("Ocupação: ").append(livre ? "livre" : "ocupado").append("\n");
        return s.toString();
    }
}
