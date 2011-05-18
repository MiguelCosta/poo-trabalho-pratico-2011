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
 * Possui todos os métodos necessários para criar e gerir a entidade VooMilitar
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class VooMilitar extends Voo implements Serializable {

    public final String Marinha = "Marinha";
    public final String Exercito = "Exército";
    public final String ForcaAerea = "Força Aérea";
    private GregorianCalendar horaChegada;
    private int duracao; //minutos : max 1 440 (1 dia)
    private String ramo; // Ramo das forças armadas
    private String codigoComunicacao;

    public VooMilitar(String codigoVoo, String destino, GregorianCalendar horaPartida,
            String entidade, ArrayList<Passageiro> passageiros, ArrayList<Carga> carga,
            int duracao, String ramo, String codigoComunicacao) {
        super(codigoVoo, destino, horaPartida, entidade, passageiros, carga);
        horaChegada = horaPartida;
        horaChegada.add(GregorianCalendar.MINUTE, duracao);
        this.duracao = duracao;
        this.ramo = ramo;
        this.codigoComunicacao = codigoComunicacao;
    }

    public VooMilitar(VooMilitar voo) {
        super(voo);
        horaChegada = voo.getHoraChegada();
        duracao = voo.getDuracao();
        ramo = voo.getRamo();
        codigoComunicacao = voo.getCodigoComunicacao();
    }

    public GregorianCalendar getHoraChegada() {
        return horaChegada;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getRamo() {
        return ramo;
    }

    public String getCodigoComunicacao() {
        return codigoComunicacao;
    }

    public void setHoraChegada(GregorianCalendar horaCheagada) {
        this.horaChegada = horaCheagada;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public void setCodigoComunicacao(String codigoComunicacao) {
        this.codigoComunicacao = codigoComunicacao;
    }

    @Override
    public void setVooAtrasado(GregorianCalendar novaHora) {
        super.setEstado(super.VooEmPreparacao2Atraso);
        super.setObservacoes("Nova Hora : " + novaHora.getTime().getHours() + ":"
                + novaHora.getTime().getMinutes() + "\n");
        super.setHoraPartida(novaHora);
        horaChegada = novaHora;
        horaChegada.add(GregorianCalendar.MINUTE, duracao);
    }

    @Override
    public VooMilitar clone() {
        return new VooMilitar(this);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n\n_Voo Militar_\n");

        s.append(super.toString());

        s.append("Hora Chegada: ");
        String hora_chegada = "";
        hora_chegada = hora_chegada + this.getHoraPartida().get(Calendar.HOUR_OF_DAY);
        hora_chegada = hora_chegada + ":" + this.getHoraPartida().get(Calendar.MINUTE);
        s.append(hora_chegada);
        s.append("\n");

        s.append("Duracao: ");
        s.append(duracao);
        s.append("\n");

        s.append("Ramo: ");
        s.append(ramo);
        s.append("\n");
        
        s.append("Codigo de Comunicacao: ");
        s.append(codigoComunicacao);
        s.append("\n");
        
        return s.toString();
    }
}
