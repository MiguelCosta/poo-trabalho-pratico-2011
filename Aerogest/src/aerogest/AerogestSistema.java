/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import Classes.Voo;
import Classes.CoPiloto;
import Classes.Comandante;
import Classes.Aeronave;
import Classes.Porta;
import Classes.Tripulante;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeMap;

/**
 *
 * @author goku
 */
public class AerogestSistema {
    private TreeMap<GregorianCalendar,TreeMap<String,Voo>> mapaVoos;
    private ArrayList<Comandante> comandantes; // TreeMap ?
    private ArrayList<CoPiloto> coPilotos; // TreeMap ?
    private ArrayList<Tripulante> tribulantesAdicionais; // TreeMap ?
    private TreeMap<String,Aeronave> aeronaves;
    private TreeMap<String,Porta> portas;
    private ArrayList<String> funcoesValidas;
    private GregorianCalendar dataActual;

    /** Adicionar um voo ao mapa de voos */
    public void adicionaVoo(Voo v)
    {
        
    }

    /** Adicionar um comandante ao array de comandantes */
    public void adicionaComandante(Comandante c)
    {

    }

    /** Remover um comandante ao array de comandantes */
    public void removeComandante(Comandante c)
    {

    }

    /** Adicionar um co Piloto ao array de CoPilotos */
    public void adicionaCoPiloto(CoPiloto c)
    {

    }


    public void removeCoPiloto(CoPiloto c)
    {

    }


    public void adicionaTripulante(Tripulante t)
    {

    }


    public void removeTripulante(Tripulante t)
    {

    }


    public void adicionaAeronave(Aeronave a)
    {

    }


    public void removeAeronave(Aeronave a)
    {

    }


    public void adicionaPorta(Porta p)
    {

    }


    public void removePorta(Porta p)
    {

    }


    public void adicionaFuncaoValida(String funcao)
    {

    }


    public void removeFuncaoValida(String funcao)
    {

    }


    public void getVoosPorDia(GregorianCalendar dia)
    {
        
    }


    public void getComandantes()
    {

    }


    public void getCoPilotos()
    {

    }


    public void getTripulantesAdicionais()
    {

    }


    public void getAeronaves()
    {

    }


    public void getPortas()
    {

    }

    
    public void getHoraActual()
    {

    }
}
