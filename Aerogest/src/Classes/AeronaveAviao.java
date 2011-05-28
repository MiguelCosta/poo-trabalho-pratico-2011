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
public class AeronaveAviao extends Aeronave implements Serializable {

    /**
     * Cria um Aviao
     */
    public AeronaveAviao() {
        super();
    }

    /**
     * Cria um Avião
     * @param matricula
     * @param capacidadePassageiros
     * @param capacidadeCarga
     * @param velocidadeMaxima 
     */
    public AeronaveAviao(String matricula, int capacidadePassageiros, double capacidadeCarga, double velocidadeMaxima) {
        super(matricula, capacidadePassageiros, capacidadeCarga, velocidadeMaxima);
    }
    
    /**
     * Através de um Avião cria outro
     * @param a 
     */
    public AeronaveAviao(AeronaveAviao a){
        super(a);
    }

    @Override
    public AeronaveAviao clone() {
        return new AeronaveAviao(this);
    }
    
    
    
}
