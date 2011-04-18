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
public class CargaVeiculo extends Carga implements Serializable{
    private String tipo;

    /** Construtores */
    public CargaVeiculo(){
        super();
        tipo = "";
    }
    public CargaVeiculo(String codigo, double peso, String descricao, double tempoCarregamento, String tipo){
        super(codigo,peso,descricao,tempoCarregamento);
	this.tipo = tipo;
    }
    public CargaVeiculo(CargaVeiculo cargaVeiculo){
        super(cargaVeiculo);
    	tipo = cargaVeiculo.getTipo();
    }


	/** gets */
	public String getTipo(){ return tipo; }


	/** sets */
	public void setTipo(String tipo){ this.tipo = tipo;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		CargaVeiculo cargaVeiculo = (CargaVeiculo) o;
		if (super.equals(cargaVeiculo) && this.tipo.equals(cargaVeiculo.getTipo())){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public CargaVeiculo clone(){
		return new CargaVeiculo(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("CARGAVEICULO:\n");
                s.append(super.toString());
		s.append("Tipo: " + tipo + "\n");
		return s.toString();
	}
}
