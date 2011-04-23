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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade AerogestSistema
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
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

    public AerogestSistema(){
        mapaVoos = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        comandantes = new ArrayList<Comandante>();
        coPilotos = new ArrayList<CoPiloto>();
        tribulantesAdicionais = new ArrayList<Tripulante>();
        aeronaves = new TreeMap<String, Aeronave>();
        portas = new TreeMap<String, Porta>();
        funcoesValidas = new ArrayList<String>();
        dataActual = new GregorianCalendar();
    }

    public TreeMap<GregorianCalendar, TreeMap<String, Voo>> getMapaVoos()
    {
        return mapaVoos;
    }

    /**
     * Adicionar um voo ao mapa de voos
     * @param voo 
     */
    public void adicionaVoo(Voo v) {

        if (mapaVoos.get(v.getHoraPartida()) == null){
            TreeMap<String, Voo> x = new TreeMap<String, Voo>();
            x.put(v.getEntidade() + v.getCodigoVoo(), v);

            mapaVoos.put(v.getHoraPartida(), x);
        }
        else{
            TreeMap<String,Voo> x = mapaVoos.get(v.getHoraPartida());
            x.put(v.getEntidade() + v.getCodigoVoo(), v);
        }
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
     * Adicionar um array com comandantes ao array de comandantes
     * @param c 
     */
    public void adicionaComandateArray(List<Comandante> c) {
        for (Comandante x : c) {
            comandantes.add(x);
        }
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
     * Adicionar um array com copilotos ao array de CoPilotos
     * @param coPiloto 
     */
    public void adicionaCoPilotoArray(List<CoPiloto> c) {
        for (CoPiloto x : c) {
            coPilotos.add(x);
        }
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
     * Adicionar um array com tripulantes ao array de tripulantes
     * @param t 
     */
    public void adicionaTripulanteArray(List<Tripulante> t) {
        for (Tripulante x : t) {
            tribulantesAdicionais.add(x);
        }
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
     * Adicionar um mapa com aeronaves ao Mapa de aeronaves
     * @param aeronaves
     */
    public void adicionaAeronaveMap(Map a) {
        aeronaves.putAll(a);
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
     * Adicionar um mapa com portas ao mada de portas
     * @param porta 
     */
    public void adicionaPortaMap(Map p) {
        portas.putAll(p);
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
    
    /**
     * Adicionar uma lista com funções à lista de funções
     * @param funcoes
     */
    public void adicionaFuncaoValidaList(List<String> f){
        for(String s : f){
            funcoesValidas.add(s);
        }
    }

    /**
     * Mapa de voos do dia
     * @param dia
     * @return Map
     */
    public Map getVoosPorDia(GregorianCalendar dia) {
        return mapaVoos.get(dia);
    }

    /**
     * Lista dos comandantes
     * @return list
     */
    public List getComandantes() {
        return comandantes;
    }

    /**
     * Lista com os CoPilots
     * @return list
     */
    public List getCoPilotos() {
        return coPilotos;
    }

    /**
     * Lista com os tripulantes adicionais
     * @return list
     */
    public List getTripulantesAdicionais() {
        return tribulantesAdicionais;
    }

    /**
     * Mapa das aeronaves
     * @return map
     */
    public Map getAeronaves() {
        return aeronaves;
    }

    /**
     * Mapa das portas
     * @return map
     */
    public Map getPortas() {
        return portas;
    }

    /**
     * Hora actual do sistema
     * @return GregorianCalendar
     */
    public GregorianCalendar getHoraActual() {
        return dataActual;
    }
    
    /**
     * Alterar a data actual do AerogestSistema
     * @param data
     */
    public void setHoraActual(GregorianCalendar d){
        dataActual = d;
    }
}
