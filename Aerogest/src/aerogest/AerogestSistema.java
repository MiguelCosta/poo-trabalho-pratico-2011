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
import java.util.AbstractMap;
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
        comandantes = new HashMap<String, Comandante>();                    // TreeMap??
        coPilotos = new HashMap<String, CoPiloto>();                        // TreeMap??
        tribulantesAdicionais = new HashMap<String, Tripulante>();          // TreeMap??
        tripulacao = new ArrayList<Tripulacao>();                           // e aqui ??
        aeronaves = new TreeMap<String, Aeronave>();
        portas = new TreeMap<String, Porta>();
        cargas = new HashMap<String, Carga>();                              //TreeMap??
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
                tmp_v.put(voo.getEntidade() + voo.getCodigoVoo(), voo.clone());
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
            r.put(c.getCodigo(), c.clone());
        }
        return r;
    }

    /**
     * Lista com os CoPilots
     * @return list
     */
    public Map<String, CoPiloto> getCoPilotos() {
        Map<String, CoPiloto> r = new TreeMap<String, CoPiloto>();
        for (CoPiloto c : coPilotos.values()) {
            r.put(c.getCodigo(), c.clone());
        }
        return r;
    }

    /**
     * Lista com os tripulantes adicionais
     * @return list
     */
    public Map<String, Tripulante> getTripulantesAdicionais() {
        Map<String, Tripulante> r = new TreeMap<String, Tripulante>();
        for (Tripulante t : tribulantesAdicionais.values()) {
            r.put(t.getCodigo(), t.clone());
        }

        return r;
    }

    /**
     * Tripulacao do sistema
     * @return List<Tripulcao>
     */
    public List<Tripulacao> getTripulacao() {
        List<Tripulacao> r = new ArrayList<Tripulacao>();
        for (Tripulacao t : tripulacao) {
            r.add(t.clone());
        }
        return r;
    }

    /**
     * Mapa das aeronaves
     * @return map
     */
    public Map<String, Aeronave> getAeronave_All() {
        Map<String, Aeronave> r = new TreeMap<String, Aeronave>();
        for (Aeronave a : aeronaves.values()) {
            r.put(a.getMatricula(), a.clone());
        }
        return aeronaves;
    }

    /**
     * Aeronave de com uma determinada matricula
     * @param matricula
     * @return aeronave
     */
    public Aeronave getAeronave_One(String matricula) {
        return aeronaves.get(matricula).clone();
    }

    /**
     * Mapa das portas
     * @return map
     */
    public Map<String, Porta> getPortas() {
        Map<String, Porta> r = new TreeMap<String, Porta>();
        for (Porta p : portas.values()) {
            r.put(p.getCodPorta(), p.clone());
        }
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
            x.put(v.getEntidade() + v.getCodigoVoo(), v.clone());

            mapaVoos.put(v.getHoraPartida(), x);
        } else {
            TreeMap<String, Voo> x = mapaVoos.get(v.getHoraPartida());
            x.put(v.getEntidade() + v.getCodigoVoo(), v.clone());
        }
    }

    /**
     * Adicionar um comandante ao array de comandantes 
     * @param comandante 
     */
    public void adicionaComandante(Comandante c) {
        comandantes.put(c.getCodigo(), c.clone());
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
            comandantes.put(x.getCodigo(), x.clone());
        }
    }

    /**
     * Adicionar um co Piloto ao array de CoPilotos
     * @param coPiloto 
     */
    public void adicionaCoPiloto(CoPiloto c) {
        coPilotos.put(c.getCodigo(), c.clone());
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
            coPilotos.put(x.getCodigo(), x.clone());
        }
    }

    /**
     * Adicionar um tripulante ao array de tripulantes
     * @param tripulante
     */
    public void adicionaTripulante(Tripulante t) {
        tribulantesAdicionais.put(t.getCodigo(), t.clone());
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
            tribulantesAdicionais.put(x.getCodigo(), x.clone());
        }
    }

    /**
     * Adicionar uma Tripulcao ao sistema
     * @param t 
     */
    public void adicionaTripulacao(Tripulacao t) {
        tripulacao.add(t.clone());
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
            tripulacao.add(x.clone());
        }
    }

    /**
     * Adicionar uma aeronave ao mapa de aeronaves
     * @param aeronave
     */
    public void adicionaAeronave(Aeronave a) {
        aeronaves.put(a.getMatricula(), a.clone());
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
        portas.put(p.getCodPorta(), p.clone());
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
        cargas.put(carga.getCodigo(), carga.clone());
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
                temp_v.put(voo.getEntidade() + voo.getCodigoVoo(), voo.clone());
            }
            mapaVoos.put(d, temp_v);
        }
    }

    public boolean vooTemAeronave(String codigoVoo) {
        Voo v;

        v = mapaVoos.get(dataActual).get(codigoVoo);
        
        Aeronave a = v.getAeronave();
        
        return a!=null;
    }
    
    public List<Aeronave> aeronavesLivers(){
        List<Aeronave> r = new ArrayList<Aeronave>();
        
        for(Aeronave a : aeronaves.values()){
            if(a.getOcupacao()) r.add(a.clone());
        }
        
        return r;
    }
    
    public void alteraEstadoAeronave(String codigo){
        aeronaves.get(codigo).setLivre(false);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("###################################################\n");
        s.append("############### AEROGEST SISTEMA ##################\n");
        s.append("###################################################\n");

        //mapa de voos
        s.append("\n*************** Mapa de voos **********************\n");
        for (GregorianCalendar d : mapaVoos.keySet()) {
            s.append("DIA: ");
            s.append(diaEmString(d));
            s.append("\n");
            for (Voo voo : mapaVoos.get(d).values()) {
                s.append(voo.toString());
            }
        }

        //comandantes
        s.append("\n*************** Comandantes ***********************\n");
        for (Comandante c : comandantes.values()) {
            s.append(c.toString());
        }

        //copiloto
        s.append("\n**************** Copilotos ************************\n");
        for (CoPiloto c : coPilotos.values()) {
            s.append(c.toString());
        }

        //tripulantes adicionais
        s.append("\n*********** Tripulantes Adicionais ****************\n");
        for (Tripulante t : tribulantesAdicionais.values()) {
            s.append(t.toString());
        }

        // falta a tripulação

        //aeronaves
        s.append("\n***************** Aeronaves ***********************\n");
        for (Aeronave a : aeronaves.values()) {
            s.append(a.toString());
        }

        //portas
        s.append("\n******************* Portas ************************\n");
        for (Porta p : portas.values()) {
            s.append(p.toString());
        }

        //cargas
        s.append("\n******************* Cargas ************************\n");
        for (Carga c : cargas.values()) {
            s.append(c.toString());
        }

        //funcoes validas
        s.append("\n*************** Funcoes Validas *******************\n");
        for (String f : funcoesValidas) {
            s.append(f);
        }

        //Data Actual
        s.append("\n***************** Data Actual *********************\n");
        s.append(diaEmString(dataActual));

        return s.toString();
    }

    // metodo auxiliar
    private static String diaEmString(GregorianCalendar d) {
        String s = "";
        s = s + d.get(Calendar.DAY_OF_MONTH);
        s = s + "/";
        s = s + (d.get(Calendar.MONDAY) + 1);
        s = s + "/";
        s = s + d.get(Calendar.YEAR);
        return s;
    }

    public void atribui_aeronave_voo(String codAeronave, String voo ){
        Aeronave a = aeronaves.get(codAeronave);

        alteraEstadoAeronave(codAeronave);
        mapaVoos.get(dataActual).get(voo).setAeronave(a);
    }

    public void atribui_porta(String codPorta, String voo){
        Porta p = portas.get(codPorta);

        portas.get(codPorta).setLivre(false);

        mapaVoos.get(dataActual).get(voo).setPorta(p);
    }
    
    public boolean vooTemPorta(String voo){
        return mapaVoos.get(dataActual).get(voo).getPorta() != null;
    }

    public List<Porta> portasLivres(){
        List<Porta> ps = new ArrayList<Porta>();

        for (Porta p : portas.values())
            if (p.getLivre())
                ps.add(p);
        return ps;
    }

    public void atribui_carga(String codCarga, String voo){
        Carga c = cargas.get(codCarga);

        List<Carga> cs = new ArrayList<Carga>();
        cs.add(c);

        mapaVoos.get(dataActual).get(voo).setCarga((ArrayList<Carga>) cs);
    }

    public void  vooMudaEstado(String codvoo,String novoEstado){
        mapaVoos.get(dataActual).get(codvoo).setEstado(novoEstado);
    }

    public List<Carga> cargasLivres(){
        return new ArrayList<Carga>(cargas.values());
    }

    public void transitaAutomatico(){
        for( Voo v : mapaVoos.get(dataActual).values())
            if (v.getEstado().equals(Voo.VooEmPreparacao2Atraso) &&
            (new GregorianCalendar()).after(v.getHoraPartida()))
                v.setEstado(Voo.VooPronto);
    }

    public void adicionaObservacao(String voo, String obs){
        mapaVoos.get(dataActual).get(voo).setObservacoes(obs);
        System.out.println(mapaVoos.get(dataActual).get(voo).toString());
        System.out.println(obs);
    }

    public boolean vooTemTripulacao(String voo){
        return mapaVoos.get(dataActual).get(voo).getTripulacao() != null;
    }

    public void tripulacaoMudaEstado(String cod, boolean estado){
        boolean found = false;
        for (int i = 0 ; i < tripulacao.size() && !found ; i++)
            if ( tripulacao.get(i).getCodigo().equals(cod)){
                found = true;
                tripulacao.get(i).setOcupacao(estado);
            }
    }

    public void atribui_tripulacao(String cod, String voo){
        Tripulacao t = null;
        boolean found = false;
        for (int i = 0 ; i < tripulacao.size() && !found ; i++)
            if ( tripulacao.get(i).getCodigo().equals(cod)){
                found = true;
                t = tripulacao.get(i);
            }

        mapaVoos.get(dataActual).get(voo).setTripulacao(t);
    }
}
