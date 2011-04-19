/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aerogest;

/**
 *
 * @author goku
 */
public class MembroGoverno extends Passageiro {
    public final String Ministerio = "Ministério";
    public final String Presidencia = "Presidência";

    private String origem;

    public MembroGoverno(String origem) {
        super();
        this.origem = origem;
    }

    public MembroGoverno(MembroGoverno mg) {
        super(mg);
        origem = mg.getOrigem();
    }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    /** Equals | Clone | toString */
	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		MembroGoverno mg = (MembroGoverno) o;
		if (super.equals(mg) && this.origem.equals(mg.getOrigem())){
			return true;
		} else {
 			return false;
		}
	}

	@Override
	public MembroGoverno clone() {
		return new MembroGoverno(this);
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("MEMBRO GOVERNO:\n");
                s.append(super.toString());
		s.append("Origem: " + origem + "\n");
		return s.toString();
	}
}
