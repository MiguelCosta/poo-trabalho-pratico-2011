/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author goku
 */
public class VooGovernamental extends Voo implements Serializable{
    private ArrayList<MembroGoverno> membrosGoverno;
    private ArrayList<Passageiro> jornalistas;
    private ArrayList<Passageiro> convidados;

    public VooGovernamental(String codigoVoo, String destino, GregorianCalendar horaPartida,
            String entidade, ArrayList<Carga> carga, ArrayList<MembroGoverno> membrosGoverno,
            ArrayList<Passageiro> jornalistas, ArrayList<Passageiro> convidados){
        super(codigoVoo, destino, horaPartida, entidade, new ArrayList<Passageiro>(), carga);
        for(Passageiro p : membrosGoverno)
            super.adicionaPassageiro(p.clone());
        for(Passageiro p : jornalistas)
            super.adicionaPassageiro(p.clone());
        for(Passageiro p : convidados)
            super.adicionaPassageiro(p.clone());
        this.membrosGoverno = membrosGoverno;
        this.jornalistas = jornalistas;
        this.convidados = convidados;
    }

    public VooGovernamental(VooGovernamental vg){
        super(vg);

    }

    public ArrayList<MembroGoverno> getMembrosGoverno() { return membrosGoverno; }
    public ArrayList<Passageiro> getJornalistas() { return jornalistas; }
    public ArrayList<Passageiro> getConvidados() { return convidados; }

    public void getMembrosGoverno(ArrayList<MembroGoverno> membrosGoverno) { this.membrosGoverno = membrosGoverno; }
    public void getJornalistas(ArrayList<Passageiro> jornalistas) { this.jornalistas = jornalistas; }
    public void getConvidados(ArrayList<Passageiro> convidados) { this.convidados = convidados; }

    public void adicionaMembroGoverno(MembroGoverno mg) {
        membrosGoverno.add(mg);
        super.adicionaPassageiro(mg);
    }

    public void adicionaJornalista(Passageiro j) {
        jornalistas.add(j);
        super.adicionaPassageiro(j);
    }

    public void adicionaConvidado(Passageiro c) {
        convidados.add(c);
        super.adicionaPassageiro(c);
    }

    @Override
    public VooGovernamental clone() {
        return new VooGovernamental(this);
    }
}
