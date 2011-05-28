/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class AeronaveJacto extends Aeronave implements Serializable {

    /**
     * Cria um Jacto
     */
    public AeronaveJacto() {
        super();
    }

    /**
     * Cria um Avião
     * @param matricula
     * @param capacidadePassageiros
     * @param capacidadeCarga
     * @param velocidadeMaxima 
     */
    public AeronaveJacto(String matricula, int capacidadePassageiros, double capacidadeCarga, double velocidadeMaxima) {
        super(matricula, capacidadePassageiros, capacidadeCarga, velocidadeMaxima);
    }

    /**
     * Através de um Jacto cria outro
     * @param a 
     */
    public AeronaveJacto(AeronaveJacto a) {
        super(a);
    }

    @Override
    public AeronaveJacto clone() {
        return new AeronaveJacto(this);
    }
}
