/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Tripulação
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class Tripulacao implements Serializable {

    /** Variaveis de instancia */
    private Comandante comandante;
    private CoPiloto coPiloto;
    private ArrayList<Tripulante> tripulantesAdicionais;

    /** Construtores */
    /**
     * Construtor Tripulacao
     */
    public Tripulacao() {
        comandante = new Comandante();
        coPiloto = new CoPiloto();
        tripulantesAdicionais = new ArrayList<Tripulante>();
    }

    /**
     * Construtor Tripulação
     * @param comandante
     * @param coPiloto
     * @param tripulantesAdicionais 
     */
    public Tripulacao(Comandante comandante, CoPiloto coPiloto, ArrayList<Tripulante> tripulantesAdicionais) {
        this.comandante = comandante;
        this.coPiloto = coPiloto;
        this.tripulantesAdicionais = tripulantesAdicionais;
    }

    /**
     * Construtor Tripulação
     * @param tripulacao 
     */
    public Tripulacao(Tripulacao tripulacao) {
        comandante = tripulacao.getComandante();
        coPiloto = tripulacao.getCoPiloto();
        tripulantesAdicionais = tripulacao.getTripulantesAdicionais();
    }

    /** gets */
    /**
     * Comandante da Tripulação
     * @return 
     */
    public Comandante getComandante() {
        return comandante;
    }

    /**
     * CoPiloto da Tripulação
     * @return 
     */
    public CoPiloto getCoPiloto() {
        return coPiloto;
    }

    /**
     * ArrayList com o resto da Tripulação
     * @return 
     */
    public ArrayList<Tripulante> getTripulantesAdicionais() {
        return tripulantesAdicionais;
    }

    /** sets */
    /**
     * Alterar o Comandante da Tripulação
     * @param comandante 
     */
    public void setComandante(Comandante comandante) {
        this.comandante = comandante;
    }

    /**
     * Alterar o CoPiloto da Tripulação
     * @param coPiloto 
     */
    public void setCoPiloto(CoPiloto coPiloto) {
        this.coPiloto = coPiloto;
    }

    /**
     * Alterar os Tripulantes Adicionais
     * @param tripulantesAdicionais 
     */
    public void setTripulantesAdicionais(ArrayList<Tripulante> tripulantesAdicionais) {
        this.tripulantesAdicionais = tripulantesAdicionais;
    }
    
    public void addTripulante(Tripulante t){
        tripulantesAdicionais.add(t);
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
        Tripulacao tripulacao = (Tripulacao) o;
        if (this.comandante == tripulacao.getComandante()
                && this.coPiloto == tripulacao.getCoPiloto()
                && this.tripulantesAdicionais.size() == tripulacao.getTripulantesAdicionais().size()) {
            boolean iguais = true;
            for (int i = 0; i < tripulantesAdicionais.size() && iguais; i++) {
                if (!tripulantesAdicionais.get(i).equals(tripulacao.getTripulantesAdicionais().get(i))) {
                    iguais = false;
                }
            }
            return iguais;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return Tripulacao 
     */
    @Override
    public Tripulacao clone() {
        return new Tripulacao(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("TRIPULACAO:\n");
        s.append("Comandante: ");
        s.append(comandante);
        s.append("\n");
        s.append("CoPiloto: ");
        s.append(coPiloto);
        s.append("\n");
        s.append("TripulantesAdicionais: ");
        s.append(tripulantesAdicionais);
        s.append("\n");
        return s.toString();
    }
}
