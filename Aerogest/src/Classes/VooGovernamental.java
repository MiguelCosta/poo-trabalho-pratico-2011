/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author goku
 */
public class VooGovernamental extends Voo implements Serializable {

    private ArrayList<MembroGoverno> membrosGoverno;
    private ArrayList<Passageiro> jornalistas;
    private ArrayList<Passageiro> convidados;

    /**
     * Construtor Voo Governamental
     * @param codigoVoo
     * @param destino
     * @param horaPartida
     * @param entidade
     * @param carga
     * @param membrosGoverno
     * @param jornalistas
     * @param convidados 
     */
    public VooGovernamental(String codigoVoo, String destino, GregorianCalendar horaPartida,
            String entidade, ArrayList<Carga> carga, ArrayList<MembroGoverno> membrosGoverno,
            ArrayList<Passageiro> jornalistas, ArrayList<Passageiro> convidados) {
        super(codigoVoo, destino, horaPartida, entidade, new ArrayList<Passageiro>(), carga);
        for (Passageiro p : membrosGoverno) {
            super.adicionaPassageiro(p.clone());
        }
        for (Passageiro p : jornalistas) {
            super.adicionaPassageiro(p.clone());
        }
        for (Passageiro p : convidados) {
            super.adicionaPassageiro(p.clone());
        }
        this.membrosGoverno = membrosGoverno;
        this.jornalistas = jornalistas;
        this.convidados = convidados;
    }

    /**
     * Construtor Voo Governamental
     * @param vg 
     */
    public VooGovernamental(VooGovernamental vg) {
        super(vg);

    }

    /**
     * Membros Governo no Voo
     * @return ArrayList<MembroGoverno>
     */
    public ArrayList<MembroGoverno> getMembrosGoverno() {
        return membrosGoverno;
    }

    /**
     * Jornalistas no Voo
     * @return ArrayList<Passageiro>
     */
    public ArrayList<Passageiro> getJornalistas() {
        return jornalistas;
    }

    /**
     * Convidados no Voo
     * @return <Passageiro>
     */
    public ArrayList<Passageiro> getConvidados() {
        return convidados;
    }

    /**
     * Alterar os Membros do Governo do Voo
     * @param membrosGoverno 
     */
    public void setMembrosGoverno(ArrayList<MembroGoverno> membrosGoverno) {
        this.membrosGoverno = membrosGoverno;
    }

    /**
     * Alterar os Jornlistas no Voo
     * @param jornalistas 
     */
    public void setJornalistas(ArrayList<Passageiro> jornalistas) {
        this.jornalistas = jornalistas;
    }

    /**
     * Alterar os convidados do Voo
     * @param convidados 
     */
    public void setConvidados(ArrayList<Passageiro> convidados) {
        this.convidados = convidados;
    }

    /**
     * Adicionar um Membro do Governo ao Voo
     * @param mg 
     */
    public void adicionaMembroGoverno(MembroGoverno mg) {
        membrosGoverno.add(mg);
        super.adicionaPassageiro(mg);
    }

    /**
     * Adicionar um Jornalista ao Voo
     * @param j 
     */
    public void adicionaJornalista(Passageiro j) {
        jornalistas.add(j);
        super.adicionaPassageiro(j);
    }

    /**
     * Adicionar um convidado ao Voo
     */
    public void adicionaConvidado(Passageiro c) {
        convidados.add(c);
        super.adicionaPassageiro(c);
    }

    /**
     * clone
     * @return VooGovernamental
     */
    @Override
    public VooGovernamental clone() {
        return new VooGovernamental(this);
    }
}
