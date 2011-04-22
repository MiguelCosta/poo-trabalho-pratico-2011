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

    private TreeMap<GregorianCalendar, TreeMap<String, Voo>> mapaVoos;
    private ArrayList<Comandante> comandantes; // TreeMap ?
    private ArrayList<CoPiloto> coPilotos; // TreeMap ?
    private ArrayList<Tripulante> tribulantesAdicionais; // TreeMap ?
    private TreeMap<String, Aeronave> aeronaves;
    private TreeMap<String, Porta> portas;
    private ArrayList<String> funcoesValidas;
    private GregorianCalendar dataActual;

    /**
     * Adicionar um voo ao mapa de voos
     * @param voo 
     */
    public void adicionaVoo(Voo v) {
        TreeMap<String, Voo> x = new TreeMap<String, Voo>();
        x.put(v.getCodigoVoo(), v);
        
        mapaVoos.put(new GregorianCalendar(), x);
    }

    /**
     * Adicionar um comandante ao array de comandantes 
     * @param comandante 
     */
    public void adicionaComandante(Comandante c) {
        comandantes.add(c);
    }

    /**
     * Remover um comandante ao array de comandantes    
     * @param c omandante
     */
    public void removeComandante(Comandante c) {
        comandantes.remove(c);
    }

    
    /**
     * Adicionar um co Piloto ao array de CoPilotos
     * @param coPiloto 
     */
    public void adicionaCoPiloto(CoPiloto c) {
        coPilotos.add(c);
    }
    
    /**
     * Remover um CoPiloto do array de CoPilotos
     * @param coPiloto
     */
    public void removeCoPiloto(CoPiloto c) {
        coPilotos.remove(c);
    }
    
    /**
     * Adicionar um tripulante ao array de tripulantes
     * @param tripulante
     */
    public void adicionaTripulante(Tripulante t) {
        tribulantesAdicionais.add(t);
    }
    
    /**
     * Remover um tripulante do array de tripulantes
     * @param tripulante
     */
    public void removeTripulante(Tripulante t) {
        tribulantesAdicionais.remove(t);
    }
    
    /**
     * Adicionar uma aeronave ao mapa de aeronaves
     * @param aeronave
     */
    public void adicionaAeronave(Aeronave a) {
        aeronaves.put(a.getMatricula(), a);
    }
    
    /**
     * Remover uma aeronave do mapa de aeronaves
     * @param aeronave
     */
    public void removeAeronave(Aeronave a) {
        aeronaves.remove(a.getMatricula());
    }
    
    /**
     * Adicionar uma Porta ao mapa de portas
     * @param porta
     */
    public void adicionaPorta(Porta p) {
        portas.put(p.getCodPorta(), p);
    }
    
    /**
     * Remover uma porta do mapa de portas
     * @param porta
     */
    public void removePorta(Porta p) {
        portas.remove(p.getCodPorta());
    }
    
    /**
     * Adicionar uma função ao array de funções
     * @param funcao 
     */
    public void adicionaFuncaoValida(String funcao) {
        funcoesValidas.add(funcao);
    }
    
    /**
     * Remover uma função do array de funções
     * @param funcao 
     */
    public void removeFuncaoValida(String funcao) {
        funcoesValidas.remove(funcao);
    }
    
    
    
    public void getVoosPorDia(GregorianCalendar dia) {
        
    }
    
    public void getComandantes() {
        
    }
    
    public void getCoPilotos() {
        
    }
    
    public void getTripulantesAdicionais() {
        
    }
    
    public void getAeronaves() {
        
    }
    
    public void getPortas() {
        
    }
    
    public void getHoraActual() {
        
    }
}
