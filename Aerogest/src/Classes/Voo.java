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
public class Voo implements Serializable {
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
	public Voo(Voo voo) {
		codigoVoo = voo.getCodigoVoo();
		destino = voo.getDestino();
		horaPartida = voo.getHoraPartida();
		entidade = voo.getEntidade();
		passageiros = voo.getPassageiros();
		carga = voo.getCarga();
		estado = VooEspecificado;
	}


	/** gets */
	public String getCodigoVoo() { return codigoVoo; }
	public String getDestino() { return destino; }
	public GregorianCalendar getHoraPartida() { return horaPartida; }
	public String getEntidade() { return entidade; }
	public ArrayList<Passageiro> getPassageiros() { return passageiros; }
	public ArrayList<Carga> getCarga() { return carga; }
	public Aeronave getAeronave() { return aeronave; }
	public Porta getPorta() { return porta; }
	public Tripulacao getTripulacao() { return tripulacao; }
	public String getEstado() { return estado; }
        public String getObservacoes() { return observacoes; }


	/** sets */
	public void setCodigoVoo(String codigoVoo) { this.codigoVoo = codigoVoo;}
	public void setDestino(String destino) { this.destino = destino;}
	public void setHoraPartida(GregorianCalendar horaPartida) { this.horaPartida = horaPartida;}
	public void setEntidade(String entidade) { this.entidade = entidade;}
	public void setPassageiros(ArrayList<Passageiro> passageiros) { this.passageiros = passageiros;}
	public void setCarga(ArrayList<Carga> carga) { this.carga = carga;}
	public void setAeronave(Aeronave aeronave) { this.aeronave = aeronave;}
	public void setPorta(Porta porta) { this.porta = porta;}
	public void setTripulacao(Tripulacao tripulacao) { this.tripulacao = tripulacao;}
	public void setEstado(String estado) { this.estado = estado;}
        public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

        public void setVooEmPreparacao1(Aeronave a, Tripulacao t, Porta p) {
            aeronave = a;
            tripulacao = t;
            porta = p;
            estado = VooEmPreparacao1;
            observacoes = "";
            listaEmbarqueCarga = new ArrayList<String>();
            listaEmbarquePassageiros = new ArrayList<String>();
        }

        private void setVooEmPreparacao2() {
            estado = VooEmPreparacao2;
        }

        public void setVooPronto() {
            estado = VooPronto;
        }

        public void setVooCancelado(String obs) {
            estado = VooCancelado;
            observacoes = obs;
        }

        public void setVooAtrasado(GregorianCalendar novaHora) {
            estado = VooEmPreparacao2Atraso;
            observacoes = "Nova Hora : " + novaHora.getTime().getHours() + ":" +
                    novaHora.getTime().getMinutes() + "\n";
            horaPartida = novaHora;
        }

        public void setVooAr() {
            estado = VooNoAr;
        }

        public boolean isPassagerVoo(Passageiro p) {
            boolean encontrou = false;
            for (int i = 0 ; i < passageiros.size() && !encontrou ; i++)
                if (passageiros.get(i).equals(p))
                    encontrou = true;

            return encontrou;
        }

        public boolean isCargaVoo(Carga c) {
            boolean encontrou = false;
            for (int i = 0 ; i < carga.size() && !encontrou ; i++)
                if (carga.get(i).equals(c))
                    encontrou = true;

            return encontrou;
        }

        public void embarquePassageiro(Passageiro p) {
            if (isPassagerVoo(p)){
                listaEmbarquePassageiros.add(p.getCodPassageiro());
                if (listaEmbarquePassageiros.size() == passageiros.size())
                    setVooPronto();
            }
        }

        public void embarqueCarga(Carga c) {
            if (isCargaVoo(c)){
                listaEmbarqueCarga.add(c.getCodigo());
                if (listaEmbarqueCarga.size() == carga.size())
                    setVooEmPreparacao2();
            }
        }

        public void anulaPassageiro(Passageiro p) {
            passageiros.remove(p);
        }

        public void adicionaPassageiro(Passageiro p) {
            passageiros.add(p);
        }

	@Override
	public Voo clone() {
		return new Voo(this);
	}
}
