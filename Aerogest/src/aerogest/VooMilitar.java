/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import aerogest.Voo;
import java.util.GregorianCalendar;

/**
 *
 * @author goku
 */
public class VooMilitar extends Voo{
    final String Marinha = "Marinha";
    final String Exercito = "Exército";
    final String ForcaAerea = "Força Aérea";

    GregorianCalendar horaChegada;
    int duracao; //minutos
    String ramo; // Ramo das forças armadas
    String codigoComunicacao;
}
