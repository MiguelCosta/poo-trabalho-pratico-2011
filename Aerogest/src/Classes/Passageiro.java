/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade Passageiro
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class Passageiro {

    /** Variaveis de instancia */
    private String codPassageiro;
    private String nome;
    private String nacionalidade;
    private String contacto;

    /** Construtores */
    /**
     * Construtor Passageiro
     */
    public Passageiro() {
        codPassageiro = "";
        nome = "";
        nacionalidade = "";
        contacto = "";
    }

    /**
     * Construtor Passageiro
     * @param codPassageiro
     * @param nome
     * @param nacionalidade
     * @param contacto 
     */
    public Passageiro(String codPassageiro, String nome, String nacionalidade, String contacto) {
        this.codPassageiro = codPassageiro;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.contacto = contacto;
    }

    /**
     * Construtor Passageiro
     * @param passageiro 
     */
    public Passageiro(Passageiro passageiro) {
        codPassageiro = passageiro.getCodPassageiro();
        nome = passageiro.getNome();
        nacionalidade = passageiro.getNacionalidade();
        contacto = passageiro.getContacto();
    }

    /** gets */
    /**
     * Codigo do Passageiro
     * @return String
     */
    public String getCodPassageiro() {
        return codPassageiro;
    }

    /**
     * Nome do Passageiro
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Nacionalidade do Passageiro
     * @return String
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Contacto do Passageiro
     * @return long
     */
    public String getContacto() {
        return contacto;
    }

    /** sets */
    /**
     * Alterar o codigo do passageiro
     * @param codPassageiro 
     */
    public void setCodPassageiro(String codPassageiro) {
        this.codPassageiro = codPassageiro;
    }

    /**
     * Alterar o nome do Passageiro
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Alterar a nacionalidade do Passageiro
     * @param nacionalidade 
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * Alterar o contacto do pasageiro
     * @param contacto 
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /** Equals | Clone | toString */
    /**
     * equals
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
        Passageiro passageiro = (Passageiro) o;
        if (this.codPassageiro.equals(passageiro.getCodPassageiro())
                && this.nome.equals(passageiro.getNome())
                && this.nacionalidade.equals(passageiro.getNacionalidade())
                && this.contacto.equals(passageiro.getContacto())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return Passageiro 
     */
    @Override
    public Passageiro clone() {
        return new Passageiro(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("PASSAGEIRO:\n");
        s.append("CodPassageiro: ");
        s.append(codPassageiro);
        s.append("\n");
        s.append("Nome: ");
        s.append(nome);
        s.append("\n");
        s.append("Nacionalidade: ");
        s.append(nacionalidade);
        s.append("\n");
        s.append("Contacto: ");
        s.append(contacto);
        s.append("\n");
        return s.toString();
    }
}
