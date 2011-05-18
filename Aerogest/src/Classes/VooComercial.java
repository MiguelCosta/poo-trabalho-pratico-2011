/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade VooComercial
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class VooComercial extends Voo implements Serializable {
    private ArrayList<Passageiro> passageirosSubstitutos;

    /**
     * Construtor de Voo Comercial
     * @param codigoVoo
     * @param destino
     * @param horaPartida
     * @param entidade
     * @param passageiros
     * @param carga 
     */
    public VooComercial(String codigoVoo, String destino, GregorianCalendar horaPartida,
            String entidade, ArrayList<Passageiro> passageiros, ArrayList<Carga> carga) {
        super(codigoVoo, destino, horaPartida, entidade, passageiros, carga);
        passageirosSubstitutos = new ArrayList<Passageiro>();
    }

    /**
     * Construtor de Voo Comercial
     * @param vooComercial
     */
    public VooComercial(VooComercial v) {
        super(v);
        passageirosSubstitutos = v.getPassageirosSubstitutos();
    }

    /**
     * Lista de passageiros do vooComercial
     * @return 
     */
    public ArrayList<Passageiro> getPassageirosSubstitutos() { return passageirosSubstitutos; }

    /**
     * Lista de passageiros substitutos do Voo Comercial
     * @param ps 
     */
    public void setPassageirosSubstitutos(ArrayList<Passageiro> ps) { passageirosSubstitutos = ps; }

    /**
     * Anular passageiro da lista de passageiros substitutos
     * @param p 
     */
    @Override
    public void anulaPassageiro(Passageiro p) {
        super.anulaPassageiro(p);
        if (!passageirosSubstitutos.isEmpty())
            super.adicionaPassageiro(passageirosSubstitutos.get(0).clone());
        passageirosSubstitutos.remove(passageirosSubstitutos.get(0));
    }

    /**
     * Adicionar passageiro à lista de passageiros substitutos
     * @param p 
     */
    public void adicionaPassageiroSubstituto(Passageiro p) {
        passageirosSubstitutos.add(p);
    }

    /**
     * clone
     * @return 
     */
    @Override
    public VooComercial clone() {
        return new VooComercial(this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n\n_Voo Comercial_\n");
        
        s.append(super.toString());
        
        return s.toString();
    }
}
