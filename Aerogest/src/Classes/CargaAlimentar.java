/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author goku
 */
public class CargaAlimentar extends Carga implements Serializable{
    GregorianCalendar dataValidade;

    /** Construtores */
    public CargaAlimentar(){
        super();
        dataValidade = new GregorianCalendar();
    }
    public CargaAlimentar(String codigo, double peso, String descricao, double tempoCarregamento, GregorianCalendar dataValidade){
        super(codigo,peso,descricao,tempoCarregamento);
	this.dataValidade = dataValidade;
    }
    public CargaAlimentar(CargaAlimentar cargaAlimentar){
        super(cargaAlimentar);
    	dataValidade = cargaAlimentar.getdataValidade();
    }


	/** gets */
	public GregorianCalendar getdataValidade(){ return dataValidade; }


	/** sets */
	public void setdataValidade(GregorianCalendar dataValidade){ this.dataValidade = dataValidade;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		CargaAlimentar CargaAlimentar = (CargaAlimentar) o;
		if (super.equals(CargaAlimentar) && this.dataValidade.equals(CargaAlimentar.getdataValidade())){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public CargaAlimentar clone(){
		return new CargaAlimentar(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("CARGA ALIMENTAR:\n");
                s.append(super.toString());
		s.append("DataValidade: " + dataValidade.getTime().getYear() + "/" +
                        dataValidade.getTime().getMonth() + "/" +
                        dataValidade.getTime().getDay() + "\n");
		return s.toString();
	}
}
