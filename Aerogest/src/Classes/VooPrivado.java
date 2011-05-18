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
 * Possui todos os métodos necessários para criar e gerir a entidade VooPrivado
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class VooPrivado extends Voo implements Serializable {

    
    public VooPrivado(String codigoVoo, String destino, GregorianCalendar horaPartida,
            String entidade, ArrayList<Passageiro> passageiros, ArrayList<Carga> carga) {
        super(codigoVoo, destino, horaPartida, entidade, passageiros, carga);
    }
    
    public VooPrivado(VooPrivado v){
        super(v);
    }

    @Override
    public Voo clone() {
        return new VooPrivado(this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n\n_Voo Privado_\n");
        s.append(super.toString());
        
        return s.toString();
    }
}
