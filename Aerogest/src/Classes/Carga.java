/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;

/**
 *
 * @author goku
 */
public class Carga implements Serializable{
        /** Variaveis de instancia */
	private String codigo;
	private double peso;
	private String descricao;
	private double tempoCarregamento;


	/** Construtores */
	public Carga(){
		codigo = "";
		peso = 0;
		descricao = "";
		tempoCarregamento = 0;
	}
	public Carga(String codigo, double peso, String descricao, double tempoCarregamento){
		this.codigo = codigo;
		this.peso = peso;
		this.descricao = descricao;
		this.tempoCarregamento = tempoCarregamento;
	}
	public Carga(Carga carga){
		codigo = carga.getCodigo();
		peso = carga.getPeso();
		descricao = carga.getDescricao();
		tempoCarregamento = carga.getTempoCarregamento();
	}


	/** gets */
	public String getCodigo(){ return codigo; }
	public double getPeso(){ return peso; }
	public String getDescricao(){ return descricao; }
	public double getTempoCarregamento(){ return tempoCarregamento; }


	/** sets */
	public void setCodigo(String codigo){ this.codigo = codigo;}
	public void setPeso(double peso){ this.peso = peso;}
	public void setDescricao(String descricao){ this.descricao = descricao;}
	public void setTempoCarregamento(double tempoCarregamento){ this.tempoCarregamento = tempoCarregamento;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		Carga carga = (Carga) o;
		if (this.codigo.equals(carga.getCodigo())
                        && this.peso == carga.getPeso()
                        && this.descricao.equals(carga.getDescricao())
                        && this.tempoCarregamento == carga.getTempoCarregamento()){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public Carga clone(){
		return new Carga(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("CARGA:\n");
		s.append("Codigo: " + codigo + "\n");
		s.append("Peso: " + peso + "\n");
		s.append("Descricao: " + descricao + "\n");
		s.append("TempoCarregamento: " + tempoCarregamento + "\n");
		return s.toString();
	}
}
