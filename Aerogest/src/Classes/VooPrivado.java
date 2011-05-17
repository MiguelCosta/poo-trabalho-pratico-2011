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
        s.append("Codigo: ");
        s.append(this.getCodigoVoo());
        s.append("\n");
        s.append("Destino: ");
        s.append(this.getDestino());
        s.append("\n");
        
        s.append("Hora Partida: ");
        String hora_partida = "";
        hora_partida = hora_partida + this.getHoraPartida().get(Calendar.HOUR_OF_DAY);
        hora_partida = hora_partida + ":" + this.getHoraPartida().get(Calendar.MINUTE); 
        s.append(hora_partida);
        s.append("\n");
        
        s.append("Entidade: ");
        s.append(this.getEntidade());
        s.append("\n");
        
        s.append("Passageiros: ");
        for(Passageiro p : this.getPassageiros()){
            s.append(p.toString());
        }
        s.append("\n");
        
        s.append("Cargas: ");
        for(Carga c : this.getCarga()){
            s.append(c.toString());
        }
        s.append("\n");
        
        Aeronave a = this.getAeronave();
        if(a != null) s.append(a.toString());
        s.append("\n");
        
        Porta p = this.getPorta();
        if(p != null) s.append(p.toString());
        s.append("\n");
        
        Tripulacao t = this.getTripulacao();
        if(t != null) s.append(t.toString());
        s.append("\n");
        
        s.append(this.getEstado());
        s.append("\n");
        s.append(this.getObservacoes());
        s.append("\n");
        
        return s.toString();
    }
}
