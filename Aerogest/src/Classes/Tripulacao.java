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
    private String codigo;
    private Comandante comandante;
    private CoPiloto coPiloto;
    private ArrayList<Tripulante> tripulantesAdicionais;
    private boolean ocupado;

    /** Construtores */
    /**
     * Construtor Tripulacao
     */
    public Tripulacao() {
        codigo = "";
        comandante = new Comandante();
        coPiloto = new CoPiloto();
        tripulantesAdicionais = new ArrayList<Tripulante>();
        ocupado = false;
    }

    /**
     * Construtor Tripulação
     * @param comandante
     * @param coPiloto
     * @param tripulantesAdicionais 
     */
    public Tripulacao(String codigo, Comandante comandante, CoPiloto coPiloto, ArrayList<Tripulante> tripulantesAdicionais) {
        this.codigo = codigo;
        this.comandante = comandante;
        this.coPiloto = coPiloto;
        this.tripulantesAdicionais = tripulantesAdicionais;
        ocupado = false;
    }

    /**
     * Construtor Tripulação
     * @param tripulacao 
     */
    public Tripulacao(Tripulacao tripulacao) {
        codigo = tripulacao.getCodigo();
        comandante = tripulacao.getComandante();
        coPiloto = tripulacao.getCoPiloto();
        tripulantesAdicionais = tripulacao.getTripulantesAdicionais();
        ocupado = false;
    }

    /** gets */
    /**
     * Comandante da Tripulação
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }

    public Comandante getComandante() {
        return comandante.clone();
    }

    /**
     * CoPiloto da Tripulação
     * @return 
     */
    public CoPiloto getCoPiloto() {
        return coPiloto.clone();
    }

    /**
     * ArrayList com o resto da Tripulação
     * @return 
     */
    public ArrayList<Tripulante> getTripulantesAdicionais() {
        ArrayList<Tripulante> r = new ArrayList<Tripulante>();
        for (Tripulante t : tripulantesAdicionais) {
            r.add(t.clone());
        }
        return r;
    }

    public boolean  getOcupacao(){
        return ocupado;
    }
    public void setOcupacao(boolean b){
        ocupado = b;
    }

    /** sets */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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
    
    public void addTripulante(Tripulante t) {
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
        if (this.codigo.equalsIgnoreCase(tripulacao.getCodigo())
                && this.comandante == tripulacao.getComandante()
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
        StringBuilder s = new StringBuilder("***TRIPULACAO:***\n");
        s.append("Comandante: ");
        s.append(comandante.toString());
        s.append("\n");
        s.append("CoPiloto: ");
        s.append(coPiloto.toString());
        s.append("\n");
        s.append("TripulantesAdicionais: ");
        for (Tripulante t : tripulantesAdicionais) {
            s.append(t.toString());
        }
        s.append("*******************\n");
        return s.toString();
    }
}
