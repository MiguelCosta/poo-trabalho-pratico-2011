/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.io.Serializable;

/**
 *
 * @author goku
 */
public class Tripulante implements Serializable {
    /** Variaveis de instancia */
    private String funcao;
    private String nome;
    private String nacionalidade;
    private boolean livre;


    /** Construtores */
    public Tripulante() {
    	funcao = "";
	nome = "";
	nacionalidade = "";
        livre = true;
    }

    public Tripulante(String funcao, String nome, String nacionalidade) {
	this.funcao = funcao;
	this.nome = nome;
	this.nacionalidade = nacionalidade;
        livre = true;
    }

    public Tripulante(Tripulante tripulante) {
        funcao = tripulante.getFuncao();
	nome = tripulante.getNome();
	nacionalidade = tripulante.getNacionalidade();
        livre = tripulante.getLivre();
    }


    /** gets */
    public String getFuncao() { return funcao; }
    public String getNome() { return nome; }
    public String getNacionalidade() { return nacionalidade; }
    public boolean getLivre() { return livre; }

    /** sets */
    public void setFuncao(String funcao) { this.funcao = funcao;}
    public void setNome(String nome) { this.nome = nome;}
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade;}
    public void setLivre(boolean livre) { this.livre = livre;}

    /** Equals | Clone | toString */
    @Override
    public boolean equals(Object o) {
    	if (this == o) { return true; }
	if (o == null || o.getClass() != this.getClass()) { return false; }
	Tripulante tripulante = (Tripulante) o;
	if (this.funcao.equals(tripulante.getFuncao())
                && this.nome.equals(tripulante.getNome())
                && this.nacionalidade.equals(tripulante.getNacionalidade())
                && this.livre == tripulante.getLivre()){
		return true;
	} else {
		return false;
	}
    }

    @Override
    public Tripulante clone() {
    	return new Tripulante(this);
    }

    @Override
    public String toString() {
	StringBuilder s = new StringBuilder("TRIPULANTE:\n");
	s.append("Funcao: " + funcao + "\n");
	s.append("Nome: " + nome + "\n");
        s.append("Nacionalidade: " + nacionalidade + "\n");
        s.append("Ocupação: " + (livre ? "livre" : "ocupado") + "\n");
	return s.toString();
    }
}