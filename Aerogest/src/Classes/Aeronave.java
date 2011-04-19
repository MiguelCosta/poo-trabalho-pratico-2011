/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author goku
 */
public class Aeronave {
        /** Variaveis de instancia */
	private String matricula;
	private String designacao;
	private int capacidadePassageiros;
	private double capacidadeCarga; //toneladas
	private double velocidadeMaxima;
        boolean livre;


	/** Construtores */
	public Aeronave(){
		matricula = "";
		designacao = "";
		capacidadePassageiros = 0;
		capacidadeCarga = 0;
		velocidadeMaxima = 0;
                livre = true;
	}
	public Aeronave(String matricula, String designacao, int capacidadePassageiros, double capacidadeCarga, double velocidadeMaxima){
		this.matricula = matricula;
		this.designacao = designacao;
		this.capacidadePassageiros = capacidadePassageiros;
		this.capacidadeCarga = capacidadeCarga;
		this.velocidadeMaxima = velocidadeMaxima;
                livre = true;
	}
	public Aeronave(Aeronave aeronave){
		matricula = aeronave.getMatricula();
		designacao = aeronave.getDesignacao();
		capacidadePassageiros = aeronave.getCapacidadePassageiros();
		capacidadeCarga = aeronave.getCapacidadeCarga();
		velocidadeMaxima = aeronave.getVelocidadeMaxima();
                livre = aeronave.getOcupacao();
	}


	/** gets */
	public String getMatricula(){ return matricula; }
	public String getDesignacao(){ return designacao; }
	public int getCapacidadePassageiros(){ return capacidadePassageiros; }
	public double getCapacidadeCarga(){ return capacidadeCarga; }
	public double getVelocidadeMaxima(){ return velocidadeMaxima; }
        public boolean getOcupacao(){ return livre; }


	/** sets */
	public void setMatricula(String matricula){ this.matricula = matricula;}
	public void setDesignacao(String designacao){ this.designacao = designacao;}
	public void setCapacidadePassageiros(int capacidadePassageiros){ this.capacidadePassageiros = capacidadePassageiros;}
	public void setCapacidadeCarga(double capacidadeCarga){ this.capacidadeCarga = capacidadeCarga;}
	public void setVelocidadeMaxima(double velocidadeMaxima){ this.velocidadeMaxima = velocidadeMaxima;}
        public void setLivre(boolean b){ livre = b; }

	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		Aeronave aeronave = (Aeronave) o;
		if (this.matricula.equals(aeronave.getMatricula())
                        && this.designacao.equals(aeronave.getDesignacao())
                        && this.capacidadePassageiros == aeronave.getCapacidadePassageiros()
                        && this.capacidadeCarga == aeronave.getCapacidadeCarga()
                        && this.velocidadeMaxima == aeronave.getVelocidadeMaxima()
                        && this.livre == aeronave.getOcupacao()){
			return true;
		} else { 
 			return false;
		}
	}

	@Override
	public Aeronave clone(){
		return new Aeronave(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("AERONAVE:\n");
		s.append("Matricula: " + matricula + "\n");
		s.append("Designacao: " + designacao + "\n");
		s.append("CapacidadePassageiros: " + capacidadePassageiros + "\n");
		s.append("CapacidadeCarga: " + capacidadeCarga + "\n");
		s.append("VelocidadeMaxima: " + velocidadeMaxima + "\n");
                s.append("Ocupação: " + (livre ? "livre" : "ocupado") + "\n");
		return s.toString();
	}
}
