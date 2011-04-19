/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author goku
 */
public class VooComercial extends Voo implements Serializable{
    private ArrayList<Passageiro> passageirosSubstitutos;

    public VooComercial(String codigoVoo, String destino, GregorianCalendar horaPartida, String entidade, ArrayList<Passageiro> passageiros, ArrayList<Carga> carga) {
        super(codigoVoo, destino, horaPartida, entidade, passageiros, carga);
        passageirosSubstitutos = new ArrayList<Passageiro>();
    }

    public VooComercial(VooComercial v){
        super(v);
        passageirosSubstitutos = v.getPassageirosSubstitutos();
    }

    public ArrayList<Passageiro> getPassageirosSubstitutos(){ return passageirosSubstitutos; }

    public void setPassageirosSubstitutos(ArrayList<Passageiro> ps){ passageirosSubstitutos = ps; }

    @Override
    public void anulaPassageiro(Passageiro p){
        super.anulaPassageiro(p);
        if (!passageirosSubstitutos.isEmpty())
            super.adicionaPassageiro(passageirosSubstitutos.get(0).clone());
        passageirosSubstitutos.remove(passageirosSubstitutos.get(0));
    }

    public void adicionaPassageiroSubstituto(Passageiro p){
        passageirosSubstitutos.add(p);
    }

    @Override
    public VooComercial clone(){
        return new VooComercial(this);
    }
}
