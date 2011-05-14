/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import Classes.Passageiro;
import Classes.Carga;
import Classes.Comandante;
import Classes.Porta;
import Classes.Voo;
import Classes.VooMilitar;
import Importer.GerarDados;
import Importer.SaveLoadDB;
import Interface.JMain;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Possui todos os métodos necessários para iniciar o sistema
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class Main {

    public static AerogestSistema a;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

/*
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

        AerogestSistema as = new AerogestSistema();
        as.adicionaVoo(v);

        for (Map<String,Voo> voodia : as.getMapaVoos().values())
            for (Voo voo : voodia.values()){
                System.out.println("Voo: " + voo.getClass().getName());
                System.out.println("" + ((voo.getClass() == VooMilitar.class) ? true : false) );
            }

*/
        GerarDados.main();
        
        a = SaveLoadDB.loadDB("aeroguest.obj");
        
        System.out.println(a.getHoraActual().toString());

        String s = a.imprimePortas();
        
        System.out.print(s);
        
        JFrame j = new JMain();
        j.show(true);
        
    }

}
