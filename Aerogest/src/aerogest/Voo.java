/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author goku
 */
public class Voo {
    String codigoVoo;
    String destino;
    GregorianCalendar horaPartida;
    String entidade;
    ArrayList<Passageiro> passageiros;
    ArrayList<Carga> carga; // rever o tipo de dados para isto
    Aeronave aeronave;
    Tripulacao tripulacao;
    
}
