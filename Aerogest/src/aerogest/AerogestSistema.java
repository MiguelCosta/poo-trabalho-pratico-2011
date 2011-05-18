/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aerogest;

import Classes.Voo;
import Classes.CoPiloto;
import Classes.Comandante;
import Classes.Aeronave;
import Classes.Carga;
import Classes.Porta;
import Classes.Tripulacao;
import Classes.Tripulante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
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
public class AerogestSistema implements Serializable {

    private TreeMap<GregorianCalendar, TreeMap<String, Voo>> mapaVoos;
    private Map<String, Comandante> comandantes;
    private Map<String, CoPiloto> coPilotos;
    private Map<String, Tripulante> tribulantesAdicionais;
    private List<Tripulacao> tripulacao;
    private Map<String, Aeronave> aeronaves;
    private Map<String, Porta> portas;
    private Map<String, Carga> cargas;
    private Set<String> funcoesValidas;
    private GregorianCalendar dataActual;

    public AerogestSistema() {
        mapaVoos = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        comandantes = new HashMap<String, Comandante>();
        coPilotos = new HashMap<String, CoPiloto>();
        tribulantesAdicionais = new HashMap<String, Tripulante>();
        tripulacao = new ArrayList<Tripulacao>();
        aeronaves = new TreeMap<String, Aeronave>();
        portas = new TreeMap<String, Porta>();
        cargas = new HashMap<String, Carga>();
        funcoesValidas = new HashSet<String>();
        dataActual = new GregorianCalendar();
    }

    public AerogestSistema(AerogestSistema a) {
        mapaVoos = a.getMapaVoos();
        comandantes = a.getComandantes();
        coPilotos = a.getCoPilotos();
        tribulantesAdicionais = a.getTripulantesAdicionais();
        tripulacao = a.getTripulacao();
        aeronaves = a.getAeronave_All();
        portas = a.getPortas();
        cargas = a.getCargas();
        funcoesValidas = a.getFuncoesValidas();
        dataActual = a.getHoraActual();
    }

    /**
     * Devolve o mapa de voos
     * @return 
     */
    public TreeMap<GregorianCalendar, TreeMap<String, Voo>> getMapaVoos() {

        TreeMap<GregorianCalendar, TreeMap<String, Voo>> r = new TreeMap<GregorianCalendar, TreeMap<String, Voo>>();
        for (GregorianCalendar d : mapaVoos.keySet()) {
            TreeMap<String, Voo> tmp_v = new TreeMap<String, Voo>();
            for (Voo voo : mapaVoos.get(d).values()) {
                tmp_v.put(voo.getEntidade()+voo.getCodigoVoo(), voo);
            }
            r.put(d, tmp_v);
        }

        return r;
    }

    /**
     * Mapa de voos do dia
     * @param dia
     * @return Map
     */
    public Map<String, Voo> getVoosPorDia(GregorianCalendar dia) {
        return mapaVoos.get(dia);
    }

    /**
     * Lista dos comandantes
     * @return list
     */
    public Map<String, Comandante> getComandantes() {
        Map<String, Comandante> r = new HashMap<String, Comandante>();
        for (Comandante c : comandantes.values()) {
            r.put(c.getCodigo(), c);
        }
        return r;
    }

    /**
     * Lista com os CoPilots
     * @return list
     */
    public Map<String, CoPiloto> getCoPilotos() {
        return coPilotos;
    }

    /**
     * Lista com os tripulantes adicionais
     * @return list
     */
    public Map<String, Tripulante> getTripulantesAdicionais() {
        return tribulantesAdicionais;
    }

    /**
     * Tripulacao do sistema
     * @return List<Tripulcao>
     */
    public List<Tripulacao> getTripulacao() {
        return tripulacao;
    }

    /**
     * Mapa das aeronaves
     * @return map
     */
    public Map<String, Aeronave> getAeronave_All() {
        return aeronaves;
    }

    /**
     * Aeronave de com uma determinada matricula
     * @param matricula
     * @return aeronave
     */
    public Aeronave getAeronave_One(String matricula) {
        return aeronaves.get(matricula);
    }

    /**
     * Mapa das portas
     * @return map
     */
    public Map<String, Porta> getPortas() {
        return portas;
    }

    /**
     * Cargas do Sistema
     * @return Map<String, Carga>
     */
    public Map<String, Carga> getCargas() {
        Map<String, Carga> r = new HashMap<String, Carga>();
        for (Carga c : cargas.values()) {
            r.put(c.getCodigo(), c.clone());
        }
        return r;
    }

    /**
     * Hora actual do sistema
     * @return GregorianCalendar
     */
    public GregorianCalendar getHoraActual() {
        return dataActual;
    }

    /**
     * Funcoes Validas do Sistemas
     * @return Set<String> 
     */
    public Set<String> getFuncoesValidas() {
        Set<String> r = new HashSet<String>();

        for (String f : funcoesValidas) {
            r.add(f);
        }
        return r;
    }

    /**
     * Alterar a data actual do AerogestSistema
     * @param data
     */
    public void setHoraActual(GregorianCalendar d) {
        dataActual = d;
    }

    /**
     * Imprimir todas as portas de AerogestSistema
     * @return 
     */
    public String imprimePortas() {
        StringBuilder s = new StringBuilder("**Todas as Portas**\n");

        for (Porta p : portas.values()) {
            s.append(p.toString());
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Imprime todos os voos do sistema         NÃO ESTÁ A FUNCIONAR
     * @return 
     */
    public String imprimeVoos() {
        StringBuilder s = new StringBuilder("***MAPA DE VOOS***miguel\n");

        for (GregorianCalendar d : mapaVoos.keySet()) {
            s.append("DIA: ").append(d.get(Calendar.DAY_OF_MONTH)).append("\n");
            s.append("MES: ").append(d.get(Calendar.MONTH)).append("\n");
            s.append("ANO: ").append(d.get(Calendar.YEAR)).append("\n");

            for (TreeMap<String, Voo> mv : mapaVoos.values()) {
                for (Voo v : mv.values()) {
                    s.append("Codigo de Voo: ").append(v.getCodigoVoo()).append("\n");
                    s.append("Entidade: ").append(v.getEntidade()).append("\n");
                }
            }
        }

        return s.toString();
    }

    /**
     * Imprime todos os comandantes do Sistema
     * @return 
     */
    public String imprimeComandantes() {
        StringBuilder s = new StringBuilder("**COMANDANTES**\n");

        for (String c : comandantes.keySet()) {
            s.append(comandantes.get(c).toString());
        }


        return s.toString();
    }

    /**
     * Imprime a informacao de todas as tripulacoes
     * @return 
     */
    public String imprimeTripulacoes() {
        StringBuilder s = new StringBuilder("TRIPULACOES\n**************************\n");

        for (Tripulacao t : tripulacao) {
            s.append(t.toString());
        }

        return s.toString();
    }

    /**
     * Adicionar um voo ao mapa de voos
     * @param voo 
     */
    public void adicionaVoo(Voo v) {

        if (mapaVoos.get(v.getHoraPartida()) == null) {
            TreeMap<String, Voo> x = new TreeMap<String, Voo>();
            x.put(v.getEntidade() + v.getCodigoVoo(), v);

            mapaVoos.put(v.getHoraPartida(), x);
        } else {
            TreeMap<String, Voo> x = mapaVoos.get(v.getHoraPartida());
            x.put(v.getEntidade() + v.getCodigoVoo(), v);
        }
    }

    /**
     * Adicionar um comandante ao array de comandantes 
     * @param comandante 
     */
    public void adicionaComandante(Comandante c) {
        comandantes.put(c.getCodigo(), c);
    }

    /**
     * Remover um comandante ao array de comandantes    
     * @param c omandante
     */
    public void removeComandante(Comandante c) {
        comandantes.remove(c.getCodigo());
    }

    /**
     * Adicionar um array com comandantes ao array de comandantes
     * @param c 
     */
    public void adicionaComandateArray(List<Comandante> c) {
        for (Comandante x : c) {
            comandantes.put(x.getCodigo(), x);
        }
    }

    /**
     * Adicionar um co Piloto ao array de CoPilotos
     * @param coPiloto 
     */
    public void adicionaCoPiloto(CoPiloto c) {
        coPilotos.put(c.getCodigo(), c);
    }

    /**
     * Remover um CoPiloto do array de CoPilotos
     * @param coPiloto
     */
    public void removeCoPiloto(CoPiloto c) {
        coPilotos.remove(c.getCodigo());
    }

    /**
     * Adicionar um array com copilotos ao array de CoPilotos
     * @param coPiloto 
     */
    public void adicionaCoPilotoArray(List<CoPiloto> c) {
        for (CoPiloto x : c) {
            coPilotos.put(x.getCodigo(), x);
        }
    }

    /**
     * Adicionar um tripulante ao array de tripulantes
     * @param tripulante
     */
    public void adicionaTripulante(Tripulante t) {
        tribulantesAdicionais.put(t.getCodigo(), t);
    }

    /**
     * Remover um tripulante do array de tripulantes
     * @param tripulante
     */
    public void removeTripulante(Tripulante t) {
        tribulantesAdicionais.remove(t.getCodigo());
    }

    /**
     * Adicionar um array com tripulantes ao array de tripulantes
     * @param t 
     */
    public void adicionaTripulanteArray(List<Tripulante> t) {
        for (Tripulante x : t) {
            tribulantesAdicionais.put(x.getCodigo(), x);
        }
    }

    /**
     * Adicionar uma Tripulcao ao sistema
     * @param t 
     */
    public void adicionaTripulacao(Tripulacao t) {
        tripulacao.add(t);
    }

    /**
     * Remove um tripulante do sistema
     * @param t 
     */
    public void removeTripulacao(Tripulacao t) {
        tripulacao.remove(t);
    }

    /**
     * Adiciona um array com tripulacoes ao sistema
     * @param t 
     */
    public void adicionaTripulacaoArray(List<Tripulacao> t) {
        for (Tripulacao x : t) {
            tripulacao.add(x);
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
     * Adicionar uma carga ao sistema
     * @param carga
     */
    public void adicionaCarga(Carga carga) {
        cargas.put(carga.getCodigo(), carga);
    }

    /**
     * Remover uma carga do sistema
     * @param carga 
     */
    public void removerCarga(Carga carga) {
        cargas.remove(carga.getCodigo());
    }

    public void adicionaCargaList(List<Carga> cs) {
        for (Carga c : cs) {
            cargas.put(c.getCodigo(), c.clone());
        }
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
    public void adicionaFuncaoValidaList(List<String> f) {
        for (String s : f) {
            funcoesValidas.add(s);
        }
    }

    /**
     * Adiciona ao sistema o mapa de voos
     * @param mv 
     */
    public void adicionaMapaVoos(TreeMap<GregorianCalendar, TreeMap<String, Voo>> mv) {
        for (GregorianCalendar d : mv.keySet()) {
            TreeMap<String, Voo> temp_v = new TreeMap<String, Voo>();
            for (Voo voo : mv.get(d).values()) {
                temp_v.put(voo.getEntidade() + voo.getCodigoVoo(), voo);
            }
            mapaVoos.put(d, temp_v);
        }
    }
}
