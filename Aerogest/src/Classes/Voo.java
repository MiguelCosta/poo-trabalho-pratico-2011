/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Voo
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public abstract class Voo implements Serializable {

    public static final String VooEspecificado = "Voo Especidicado";
    public static final String VooEmPreparacao1 = "Voo Em Preparação 1";
    public static final String VooEmPreparacao2 = "Voo Em Preparação 2";
    public static final String VooEmPreparacao2Atraso = "Voo Em Preparação 2 com Atraso";
    public static final String VooPronto = "Voo Pronto";
    public static final String VooCancelado = "Voo Cancelado";
    public static final String VooNoAr = "Voo no ar";
    /** Variaveis de instancia */
    private String codigoVoo;
    private String destino;
    private GregorianCalendar horaPartida;
    private String entidade;
    private ArrayList<Passageiro> passageiros;
    private ArrayList<Carga> carga;
    private Aeronave aeronave;
    private Porta porta;
    private Tripulacao tripulacao;
    private String estado;
    private String observacoes;
    private ArrayList<String> listaEmbarquePassageiros;
    private ArrayList<String> listaEmbarqueCarga; // listaCarregamento

    /** Construtores */
    /**
     * Construtor Voo
     * @param codigoVoo
     * @param destino
     * @param horaPartida
     * @param entidade
     * @param passageiros
     * @param carga 
     */
    public Voo(String codigoVoo, String destino, GregorianCalendar horaPartida,
            String entidade, ArrayList<Passageiro> passageiros, ArrayList<Carga> carga) {
        this.codigoVoo = codigoVoo;
        this.destino = destino;
        this.horaPartida = horaPartida;
        this.entidade = entidade;
        this.passageiros = passageiros;
        this.carga = carga;
        estado = VooEspecificado;
    }

    /**
     * Construtor Voo
     * @param voo 
     */
    public Voo(Voo voo) {
        codigoVoo = voo.getCodigoVoo();
        destino = voo.getDestino();
        horaPartida = voo.getHoraPartida();
        entidade = voo.getEntidade();
        passageiros = voo.getPassageiros();
        carga = voo.getCarga();
        estado = voo.getEstado();
    }

    /** gets */
    /**
     * Codigo do Voo
     * @return String
     */
    public String getCodigoVoo() {
        return codigoVoo;
    }

    /**
     * Destino do Voo
     * @return String
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Hora de Partida do Voo
     * @return GregorianCalendar
     */
    public GregorianCalendar getHoraPartida() {
        return horaPartida;
    }

    /**
     * Entidade do Voo
     * @return String
     */
    public String getEntidade() {
        return entidade;
    }

    /**
     * Array com os Passageiros do Voo
     * @return ArrayList<Passageiro>
     */
    public ArrayList<Passageiro> getPassageiros() {
        ArrayList<Passageiro> r = new ArrayList<Passageiro>();
        for (Passageiro p : passageiros) {
            r.add(p.clone());
        }
        return r;
    }

    /**
     * Carga do Voo 
     * @return ArrayList<Carga>
     */
    public ArrayList<Carga> getCarga() {
        ArrayList<Carga> r = new ArrayList<Carga>();
        for (Carga c : carga) {
            r.add(c.clone());
        }
        return r;
    }

    /**
     * Aeronave do Voo
     * @return Aeronave
     */
    public Aeronave getAeronave() {
        Aeronave a;
        try {
            a = aeronave.clone();
        } catch(NullPointerException e) {
            a = null;
        }
        return a;
    }

    /**
     * Porta do Voo
     * @return Porta
     */
    public Porta getPorta() {
        Porta p;
        try {
            p = porta.clone();
        } catch(NullPointerException e) {
            p = null;
        }
        return p;
    }

    /**
     * Tripulação do Voo
     * @return Tripulação
     */
    public Tripulacao getTripulacao() {
        return tripulacao;
    }

    /**
     * Estado do Voo
     * @return String
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Observações do Voo
     * @return String
     */
    public String getObservacoes() {
        return observacoes;
    }

    /** sets */
    /**
     * Alterar o Codigo do Vo
     * @param codigoVoo 
     */
    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    /**
     * Alterar o Destino do Voo
     * @param destino 
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Alterar a Hora de Partida do Voo
     * @param horaPartida 
     */
    public void setHoraPartida(GregorianCalendar horaPartida) {
        this.horaPartida = horaPartida;
    }

    /**
     * Alterar a Entidade do Voo
     * @param entidade 
     */
    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    /**
     * Alterar os Passageiros do Voo
     * @param passageiros 
     */
    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    /**
     * Alterar a carga do Voo
     * @param carga 
     */
    public void setCarga(ArrayList<Carga> carga) {
        this.carga = carga;
    }

    /**
     * Alterar a Aeronave do Voo
     * @param aeronave 
     */
    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    /**
     * Alterar a porta do Voo
     * @param porta 
     */
    public void setPorta(Porta porta) {
        this.porta = porta;
    }

    /**
     * Alterar a tripulacao do voo
     * @param tripulacao 
     */
    public void setTripulacao(Tripulacao tripulacao) {
        this.tripulacao = tripulacao;
    }

    /**
     * Alterar o estado do Voo
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Alterar as observações do Voo
     * @param observacoes 
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * Alterar o estado do Voo para VooEmPreparacao1
     * @param aeronave
     * @param tripulacao
     * @param porta
     */
    public void setVooEmPreparacao1(Aeronave a, Tripulacao t, Porta p) {
        aeronave = a;
        tripulacao = t;
        porta = p;
        estado = VooEmPreparacao1;
        observacoes = "";
        listaEmbarqueCarga = new ArrayList<String>();
        listaEmbarquePassageiros = new ArrayList<String>();
    }

    /**
     * Alterar o estado do Voo para VooEmPreparacao2
     */
    private void setVooEmPreparacao2() {
        estado = VooEmPreparacao2;
    }

    /**
     * Alterar o estado do Voo para VooPronto
     */
    public void setVooPronto() {
        estado = VooPronto;
    }

    /**
     * Alterar o estado do Voo para VooCancelado
     */
    public void setVooCancelado(String obs) {
        estado = VooCancelado;
        observacoes = obs;
    }

    /**
     * Alterar o estado do Voo para VooAtrasado
     * @param novaHora 
     */
    public void setVooAtrasado(GregorianCalendar novaHora) {
        estado = VooEmPreparacao2Atraso;
        observacoes = "Nova Hora : " + novaHora.getTime().getHours() + ":"
                + novaHora.getTime().getMinutes() + "\n";
        horaPartida = novaHora;
    }

    /**
     * Alterar o estado do Voo para VooNoAr
     */
    public void setVooAr() {
        estado = VooNoAr;
    }

    /**
     * Verificar se um passageiro está no Voo
     * @param passageiro
     * @return boolean
     */
    public boolean isPassagerVoo(Passageiro p) {
        boolean encontrou = false;
        for (int i = 0; i < passageiros.size() && !encontrou; i++) {
            if (passageiros.get(i).equals(p)) {
                encontrou = true;
            }
        }

        return encontrou;
    }

    /**
     * Verificar se uma carga está no voo
     * @param carga
     * @return boolean
     */
    public boolean isCargaVoo(Carga c) {
        boolean encontrou = false;
        for (int i = 0; i < carga.size() && !encontrou; i++) {
            if (carga.get(i).equals(c)) {
                encontrou = true;
            }
        }

        return encontrou;
    }

    /**
     * Embarcar um passageiro no Voo
     * @param passageiro
     */
    public void embarquePassageiro(Passageiro p) {
        if (isPassagerVoo(p)) {
            listaEmbarquePassageiros.add(p.getCodPassageiro());
            if (listaEmbarquePassageiros.size() == passageiros.size()) {
                setVooPronto();
            }
        }
    }

    /**
     * Embarcar a carga no Voo
     * @param c 
     */
    public void embarqueCarga(Carga c) {
        if (isCargaVoo(c)) {
            listaEmbarqueCarga.add(c.getCodigo());
            if (listaEmbarqueCarga.size() == carga.size()) {
                setVooEmPreparacao2();
            }
        }
    }
    
    
    /**
     * Embarcar um passageiro no Voo
     * @param passageiro
     */
    public void embarquePassageiroALL() {
        for(Passageiro p : passageiros){
            listaEmbarquePassageiros.add(p.getCodPassageiro());
        }
        setVooPronto();
    }

    /**
     * Embarcar a carga no Voo
     * @param c 
     */
    public void embarqueCargaALL() {
        for(Carga c : carga){
            listaEmbarqueCarga.add(c.getCodigo());
        }
        setVooEmPreparacao2();
    }

    /**
     * Retirar um passageiro do Voo
     * @param p 
     */
    public void anulaPassageiro(Passageiro p) {
        passageiros.remove(p);
    }

    /**
     * Adicionar um passageiro
     * @param passageiro
     */
    public void adicionaPassageiro(Passageiro p) {
        passageiros.add(p);
    }

    /**
     * clone
     * @return Voo 
     */
    @Override
    public abstract Voo clone();

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Codigo: ");
        s.append(this.getCodigoVoo());
        s.append("\n");
        s.append("Destino: ");
        s.append(this.getDestino());
        s.append("\n");

        s.append("Hora Partida: ");
        String hora_partida = "";
        hora_partida = hora_partida + this.getHoraPartida().get(Calendar.HOUR_OF_DAY);
        hora_partida = hora_partida + ":" + this.getHoraPartida().get(Calendar.MINUTE);
        s.append(hora_partida);
        s.append("\n");

        s.append("Entidade: ");
        s.append(this.getEntidade());
        s.append("\n");

        s.append("Passageiros: ");
        for (Passageiro p : this.getPassageiros()) {
            if (p != null) {
                s.append(p.toString());
            }
        }
        s.append("\n");

        s.append("Cargas: ");
        for (Carga c : this.getCarga()) {
            if (c != null) {
                s.append(c.toString());
            }
        }
        s.append("\n");

        Aeronave a = this.getAeronave();
        if (a != null) {
            if (a != null) {
                s.append(a.toString());
            }
        }
        s.append("\n");

        Porta p = this.getPorta();
        if (p != null) {
            s.append(p.toString());
        }
        s.append("\n");

        Tripulacao t = this.getTripulacao();
        if (t != null) {
            s.append(t.toString());
        }
        s.append("\n");

        s.append(this.getEstado());
        s.append("\n");
        s.append(this.getObservacoes());
        s.append("\n");

        return s.toString();
    }
}
