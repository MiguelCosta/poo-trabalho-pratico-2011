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
public class CargaAnimal extends Carga implements Serializable{
    double volume;

    /** Construtores */
    public CargaAnimal(){
        super();
        volume = 0;
    }
    public CargaAnimal(String codigo, double peso, String descricao, double tempoCarregamento, double volume){
        super(codigo,peso,descricao,tempoCarregamento);
	this.volume = volume;
    }
    public CargaAnimal(CargaAnimal cargaAnimal){
        super(cargaAnimal);
    	volume = cargaAnimal.getVolume();
    }


	/** gets */
	public double getVolume(){ return volume; }


	/** sets */
	public void setVolume(double volume){ this.volume = volume;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		CargaAnimal cargaAnimal = (CargaAnimal) o;
		if (super.equals(cargaAnimal) && this.volume == cargaAnimal.getVolume()){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public CargaAnimal clone(){
		return new CargaAnimal(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("CARGA ANIMAL:\n");
                s.append(super.toString());
		s.append("Volume: " + volume + "\n");
		return s.toString();
	}
}
