/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import java.io.Serializable;

/**
 *
 * @author goku
 */
public class CargaQuimica extends Carga implements Serializable{
    private String estado;
    private String grauToxicidade; // grau de toxicidade

    /** Construtores */
    public CargaQuimica(){
        super();
        estado = "";
        grauToxicidade = "";
    }
    public CargaQuimica(String codigo, double peso, String descricao, double tempoCarregamento, String estado, String grauToxicidade){
        super(codigo,peso,descricao,tempoCarregamento);
	this.estado = estado;
        this.grauToxicidade = grauToxicidade;
    }
    public CargaQuimica(CargaQuimica cargaQuimica){
        super(cargaQuimica);
    	estado = cargaQuimica.getEstado();
        grauToxicidade = cargaQuimica.getGrauToxicidade();
    }


	/** gets */
	public String getEstado(){ return estado; }
        public String getGrauToxicidade(){ return grauToxicidade; }


	/** sets */
	public void setEstado(String estado){ this.estado = estado;}
        public void setGrauToxicidade(String grauToxicidade){ this.grauToxicidade = grauToxicidade;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		CargaQuimica cargaQuimica = (CargaQuimica) o;
		if (super.equals(cargaQuimica)
                        && this.estado.equals(cargaQuimica.getEstado())
                        && this.grauToxicidade.equals(cargaQuimica.getGrauToxicidade())){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public CargaQuimica clone(){
		return new CargaQuimica(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("CargaQuimica:\n");
                s.append(super.toString());
		s.append("estado: " + estado + "\n");
                s.append("grauToxicidade: " + grauToxicidade + "\n");
		return s.toString();
	}
}
