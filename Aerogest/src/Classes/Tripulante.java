/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Tripulante
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class Tripulante implements Serializable {

    /** Variaveis de instancia */
    private String codigo;
    private String funcao;
    private String nome;
    private String nacionalidade;
    private boolean livre;
    

    /** Construtores */
    /**
     * Construtor Tripulante
     */
    public Tripulante() {
        funcao = "";
        nome = "";
        nacionalidade = "";
        livre = true;
        codigo = "";
    }

    /**
     * Construtor Tripulante
     * @param funcao
     * @param nome
     * @param nacionalidade 
     */
    public Tripulante(String codigo, String funcao, String nome, String nacionalidade) {
        this.codigo = codigo;
        this.funcao = funcao;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        livre = true;
    }

    /**
     * Construtor Tripulante
     * @param tripulante 
     */
    public Tripulante(Tripulante tripulante) {
        codigo = tripulante.getCodigo();
        funcao = tripulante.getFuncao();
        nome = tripulante.getNome();
        nacionalidade = tripulante.getNacionalidade();
        livre = tripulante.getLivre();
    }

    /** gets */
    
    /**
     * Codigo do tripulante
     * @return 
     */
    public String getCodigo(){
        return codigo;
    }
    
    /**
     * Função do Tripulante
     * @return 
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * Nome do Tripulante
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Nacionalidade do Tripulante
     * @return 
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Estado de ocupação do Tripulante
     * @return 
     */
    public boolean getLivre() {
        return livre;
    }

    /** sets */
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    /**
     * Alterar a função do Tripulante
     * @param funcao 
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * Alterar o nome do Tripulante
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Alterar a nacionalidade do Tripulante
     * @param nacionalidade 
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * Alterar o estado do tripulante
     * @param livre 
     */
    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    /** Equals | Clone | toString */
    /**
     * equlas
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Tripulante tripulante = (Tripulante) o;
        if (this.funcao.equals(tripulante.getFuncao())
                && this.codigo.equals(tripulante.getCodigo())
                && this.nome.equals(tripulante.getNome())
                && this.nacionalidade.equals(tripulante.getNacionalidade())
                && this.livre == tripulante.getLivre()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return Tripulante 
     */
    @Override
    public Tripulante clone() {
        return new Tripulante(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("TRIPULANTE:\n");
        s.append("Codigo: ");
        s.append(codigo);
        s.append("\n");
        s.append("Funcao: ");
        s.append(funcao);
        s.append("\n");
        s.append("Nome: ");
        s.append(nome);
        s.append("\n");
        s.append("Nacionalidade: ");
        s.append(nacionalidade);
        s.append("\n");
        s.append("Ocupação: ");
        s.append(livre ? "livre" : "ocupado");
        s.append("\n");
        return s.toString();
    }
}