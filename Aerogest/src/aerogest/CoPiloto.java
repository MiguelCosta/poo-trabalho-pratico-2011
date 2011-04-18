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
public class CoPiloto extends Tripulante implements Serializable{

    public CoPiloto(){
        super();
        super.setFuncao("CoPiloto");
    }

    public CoPiloto(String nome, String nacionalidade){
        super("CoPiloto",nome,nacionalidade);
    }
}
