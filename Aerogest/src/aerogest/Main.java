/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import Classes.Passageiro;
import Classes.Carga;
import Classes.VooMilitar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Miguel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String codVoo = "Voo";
        String destino = "ola";
        GregorianCalendar horaPartida = new GregorianCalendar();
        String entidade = "TAP";
        ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
        ArrayList<Carga> carga = new ArrayList<Carga>();
        int duracao = 180;
        String ramo = "";
        String codComunicacao = "BETA02";

        VooMilitar v = new VooMilitar(codVoo, destino, horaPartida, entidade,
                passageiros, carga, duracao, ramo, codComunicacao);

        System.out.println("Hora Chegada : " + v.getHoraChegada().getTime().getHours() + ":" +
                v.getHoraChegada().getTime().getMinutes());
    }

}
