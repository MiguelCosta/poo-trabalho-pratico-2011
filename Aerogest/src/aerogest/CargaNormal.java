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
public class CargaNormal extends Carga implements Serializable{
    /** Construtores */
    public CargaNormal(){
        super();
    }
    public CargaNormal(String codigo, double peso, String descricao, double tempoCarregamento){
        super(codigo,peso,descricao,tempoCarregamento);
    }
    public CargaNormal(CargaNormal cargaNormal){
        super(cargaNormal);
    }

	@Override
	public CargaNormal clone(){
		return new CargaNormal(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("CARGA NORMAL:\n");
                s.append(super.toString());
		return s.toString();
	}
}
