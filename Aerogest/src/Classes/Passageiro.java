/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author goku
 */
public class Passageiro {
        /** Variaveis de instancia */
	private String codPassageiro;
	private String nome;
	private String nacionalidade;
	private long contacto;


	/** Construtores */
	public Passageiro(){
		codPassageiro = "";
		nome = "";
		nacionalidade = "";
		contacto = 0;
	}
	public Passageiro(String codPassageiro, String nome, String nacionalidade, long contacto){
		this.codPassageiro = codPassageiro;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.contacto = contacto;
	}
	public Passageiro(Passageiro passageiro){
		codPassageiro = passageiro.getCodPassageiro();
		nome = passageiro.getNome();
		nacionalidade = passageiro.getNacionalidade();
		contacto = passageiro.getContacto();
	}


	/** gets */
	public String getCodPassageiro(){ return codPassageiro; }
	public String getNome(){ return nome; }
	public String getNacionalidade(){ return nacionalidade; }
	public long getContacto(){ return contacto; }


	/** sets */
	public void setCodPassageiro(String codPassageiro){ this.codPassageiro = codPassageiro;}
	public void setNome(String nome){ this.nome = nome;}
	public void setNacionalidade(String nacionalidade){ this.nacionalidade = nacionalidade;}
	public void setContacto(long contacto){ this.contacto = contacto;}


	/** Equals | Clone | toString */
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		Passageiro passageiro = (Passageiro) o;
		if (this.codPassageiro.equals(passageiro.getCodPassageiro())
                        && this.nome.equals(passageiro.getNome())
                        && this.nacionalidade.equals(passageiro.getNacionalidade())
                        && this.contacto == passageiro.getContacto()){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public Passageiro clone(){
		return new Passageiro(this);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("PASSAGEIRO:\n");
		s.append("CodPassageiro: " + codPassageiro + "\n");
		s.append("Nome: " + nome + "\n");
		s.append("Nacionalidade: " + nacionalidade + "\n");
		s.append("Contacto: " + contacto + "\n");
		return s.toString();
	}
}
