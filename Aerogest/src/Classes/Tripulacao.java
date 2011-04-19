/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author goku
 */
public class Tripulacao implements Serializable{
    /** Variaveis de instancia */
	private Comandante comandante;
	private CoPiloto coPiloto;
	private ArrayList<Tripulante> tripulantesAdicionais;


	/** Construtores */
	public Tripulacao(){
		comandante = new Comandante();
		coPiloto = new CoPiloto();
		tripulantesAdicionais = new ArrayList<Tripulante>();
	}
	public Tripulacao(Comandante comandante, CoPiloto coPiloto, ArrayList<Tripulante> tripulantesAdicionais){
		this.comandante = comandante;
		this.coPiloto = coPiloto;
		this.tripulantesAdicionais = tripulantesAdicionais;
	}
	public Tripulacao(Tripulacao tripulacao){
		comandante = tripulacao.getComandante();
		coPiloto = tripulacao.getCoPiloto();
		tripulantesAdicionais = tripulacao.getTripulantesAdicionais();
	}


	/** gets */
	public Comandante getComandante(){ return comandante; }
	public CoPiloto getCoPiloto(){ return coPiloto; }
	public ArrayList<Tripulante> getTripulantesAdicionais(){ return tripulantesAdicionais; }


	/** sets */
	public void setComandante(Comandante comandante){ this.comandante = comandante;}
	public void setCoPiloto(CoPiloto coPiloto){ this.coPiloto = coPiloto;}
	public void setTripulantesAdicionais(ArrayList<Tripulante> tripulantesAdicionais){ this.tripulantesAdicionais = tripulantesAdicionais;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		Tripulacao tripulacao = (Tripulacao) o;
		if (this.comandante == tripulacao.getComandante() 
                        && this.coPiloto == tripulacao.getCoPiloto() 
                        && this.tripulantesAdicionais.size() == tripulacao.getTripulantesAdicionais().size()){
                    boolean iguais = true;
                    for (int i = 0 ; i < tripulantesAdicionais.size() && iguais ; i++ )
                        if (!tripulantesAdicionais.get(i).equals(tripulacao.getTripulantesAdicionais().get(i)))
                            iguais = false;
                    return iguais;
		} else {
                    return false;
		}
	}

	@Override
	public Tripulacao clone(){
		return new Tripulacao(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("TRIPULACAO:\n");
		s.append("Comandante: " + comandante + "\n");
		s.append("CoPiloto: " + coPiloto + "\n");
		s.append("TripulantesAdicionais: " + tripulantesAdicionais + "\n");
		return s.toString();
	}
}
