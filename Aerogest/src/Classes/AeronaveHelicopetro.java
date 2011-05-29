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
public class AeronaveHelicopetro extends Aeronave implements Serializable {
    /**
     * Cria um Helicopetro
     */
    public AeronaveHelicopetro() {
        super();
    }

    /**
     * Cria um Helicopetro
     * @param matricula
     * @param capacidadePassageiros
     * @param capacidadeCarga
     * @param velocidadeMaxima 
     */
    public AeronaveHelicopetro(String matricula, int capacidadePassageiros, double capacidadeCarga, double velocidadeMaxima) {
        super(matricula, capacidadePassageiros, capacidadeCarga, velocidadeMaxima);
    }

    /**
     * Através de um Helicopetro cria outro
     * @param a 
     */
    public AeronaveHelicopetro(AeronaveHelicopetro a) {
        super(a);
    }

    @Override
    public AeronaveHelicopetro clone() {
        return new AeronaveHelicopetro(this);
    }
}
