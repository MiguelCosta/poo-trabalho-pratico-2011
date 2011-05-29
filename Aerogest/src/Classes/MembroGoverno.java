/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Possui todos os métodos necessários para criar e gerir a entidade MembroGoverno
 * 
 * @author Fábio Costa, Miguel Costa, Sofia Vieira
 */
public class MembroGoverno extends Passageiro {

    public static final String Ministerio = "Ministério";
    public static final String Presidencia = "Presidência";
    private String origem;

    /**
     * Construtor Membro Governo
     * @param codPassageiro
     * @param nome
     * @param nacionalidade
     * @param contacto
     * @param origem 
     */
    
    public MembroGoverno(String codPassageiro, String nome, String nacionalidade,
            String contacto, String origem) {
        super(codPassageiro, nome, nacionalidade, contacto);
        this.origem = origem;
    }

    /**
     * Construtor Membro Governo
     * @param membroGoverno
     */
    public MembroGoverno(MembroGoverno mg) {
        super(mg);
        origem = mg.getOrigem();
    }

    /**
     * Origem do menbro do governo
     * @return String
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Alterar a origem do membro do governo
     * @param origem 
     */
    public void setOrigem(String origem) {
        this.origem = origem;
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
        MembroGoverno mg = (MembroGoverno) o;
        if (super.equals(mg) && this.origem.equals(mg.getOrigem())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * clone
     * @return MembroGoverno 
     */
    @Override
    public MembroGoverno clone() {
        return new MembroGoverno(this);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("MEMBRO GOVERNO:\n");
        s.append(super.toString());
        s.append("Origem: ");
        s.append(origem);
        s.append("\n");
        return s.toString();
    }
}
