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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade AerogestSistema
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class AerogestSistema implements  Serializable{

    private TreeMap<GregorianCalendar, TreeMap<String, Voo>> mapaVoos;
    private Set<Comandante> comandantes; // TreeMap ?
    private Set<CoPiloto> coPilotos; // TreeMap ?
    private Set<Tripulante> tribulantesAdicionais; // TreeMap ?
    private Map<String, Aeronave> aeronaves;
    private Map<String, Porta> portas;
    private Set<String> funcoesValidas;
    private GregorianCalendar dataActual;

    public AerogestSistema(){
        mapaVoos = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        comandantes = new HashSet<Comandante>();
        coPilotos = new HashSet<CoPiloto>();
        tribulantesAdicionais = new HashSet<Tripulante>();
        aeronaves = new TreeMap<String, Aeronave>();
        portas = new TreeMap<String, Porta>();
        funcoesValidas = new HashSet<String>();
        dataActual = new GregorianCalendar();
    }

    /**
     * Devolve uma copia do mapa de voos
     * @return 
     */
    public Map<GregorianCalendar, Map<String, Voo>> getMapaVoos()
    {
        // apontador para os valores no mapaVoos
        Map<String, Voo> a_voos = new TreeMap<String, Voo>();
        a_voos = (Map<String, Voo>) mapaVoos.values();
        
        // copia os voos
        Map<String, Voo> voos_copia = new TreeMap<String, Voo>();
        for(Voo v : a_voos.values()){
            voos_copia.put(v.getEntidade()+v.getCodigoVoo(), v.clone()); // aqui é suposto ter clone ?? 
        }
        
        Map<GregorianCalendar, Map<String, Voo>> r = new TreeMap<GregorianCalendar, Map<String, Voo>>();
        r.put(dataActual, voos_copia);
        
        return r;
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
    public Map<String,Voo> getVoosPorDia(GregorianCalendar dia) {
        return mapaVoos.get(dia);
    }

    /**
     * Lista dos comandantes
     * @return list
     */
    public Set getComandantes() {
        return comandantes;
    }

    /**
     * Lista com os CoPilots
     * @return list
     */
    public Set getCoPilotos() {
        return coPilotos;
    }

    /**
     * Lista com os tripulantes adicionais
     * @return list
     */
    public Set getTripulantesAdicionais() {
        return tribulantesAdicionais;
    }

    /**
     * Mapa das aeronaves
     * @return map
     */
    public Map<String,Aeronave> getAeronave_All() {
        return aeronaves;
    }

    /**
     * Aeronave de com uma determinada matricula
     * @param matricula
     * @return aeronave
     */
    public Aeronave getAeronave_One(String matricula){
        return aeronaves.get(matricula);
    }
    /**
     * Mapa das portas
     * @return map
     */
    public Map<String,Porta> getPortas() {
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
    
    /**
     * Imprimir todas as portas de AerogestSistema
     * @return 
     */
    public String imprimePortas(){
        StringBuilder s = new StringBuilder("**Todas as Portas**\n");
        
        for(Porta p : portas.values()){
            s.append(p.toString());
            s.append("\n");
        }
        return s.toString();
    }
}
