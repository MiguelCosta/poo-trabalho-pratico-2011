/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import java.io.Serializable;

/**
 *
 * @author goku
 */
public class Comandante extends Tripulante implements Serializable{


    public Comandante(){
        super();
        super.setFuncao("Comandante");
    }

    public Comandante(String nome, String nacionalidade){
        super("Comandante",nome,nacionalidade);
    }
    
}
