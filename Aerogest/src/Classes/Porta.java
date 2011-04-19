/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author goku
 */
public class Porta {
        /** Variaveis de instancia */
	private String codPorta;
	private boolean livre;


	/** Construtores */
	public Porta(){
		codPorta = "";
		livre = false;
	}
	public Porta(String codPorta, boolean livre){
		this.codPorta = codPorta;
		this.livre = livre;
	}
	public Porta(Porta porta){
		codPorta = porta.getCodPorta();
		livre = porta.getLivre();
	}


	/** gets */
	public String getCodPorta(){ return codPorta; }
	public boolean getLivre(){ return livre; }


	/** sets */
	public void setCodPorta(String codPorta){ this.codPorta = codPorta;}
	public void setLivre(boolean livre){ this.livre = livre;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		Porta porta = (Porta) o;
		if (this.codPorta.equals(porta.getCodPorta()) && this.livre == porta.getLivre()){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public Porta clone(){
		return new Porta(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("PORTA:\n");
		s.append("CodPorta: " + codPorta + "\n");
		s.append("Livre: " + livre + "\n");
		return s.toString();
	}
}
