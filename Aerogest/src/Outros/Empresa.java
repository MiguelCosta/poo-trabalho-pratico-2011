/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Outros;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author goku
 */
public class Empresa {
    /** Variaveis de instancia */
	private String nome;
	private Map<String,Produto> stock;


	/** Construtores */
        public Empresa(){
		nome = "";
		stock = new TreeMap<String,Produto>();
	}
	public Empresa(String nome){
		this.nome = nome;
		stock = new TreeMap<String,Produto>();
	}
	public Empresa(String nome, Map<String,Produto> stock){
		this.nome = nome;
		this.stock = new TreeMap<String, Produto>();
                /*
                 for ( String s : stock.keySet() )
                    this.stock.put(s, stock.get(s).clone());

                 for ( Produto p : stock.values() )
                    this.stock.put(p.getCodigo,p.clone());
                */
                for (Map.Entry<String,Produto> e : stock.entrySet())
                    stock.put(e.getKey(), e.getValue().clone()); //mais eficiente
                /*
                 Outra alternativa seria this.stock = cloneStock(stock);
                */
	}
	public Empresa(Empresa empresa){
		nome = empresa.getNome();
		stock = empresa.getStock();
	}


	/** gets */
	public String getNome(){ return nome; }
	public Map<String,Produto> getStock(){
            Map<String,Produto> prods = new TreeMap<String, Produto>();

            for (Map.Entry<String,Produto> e : stock.entrySet())
                    prods.put(e.getKey(), e.getValue().clone());

            return prods;

            /*
             Alternativa seria
             return cloneStock(stock);
            */
        }

        private Map<String,Produto> cloneStock(Map<String,Produto> stock){
            Map<String,Produto> prods = new TreeMap<String, Produto>();

            for (Map.Entry<String,Produto> e : stock.entrySet())
                    prods.put(e.getKey(), e.getValue().clone());

            return prods;
        }

	/** sets */
	public void setNome(String nome){ this.nome = nome;}
	public void setStock(Map<String,Produto> stock){ this.stock = stock;}


	/** Equals | Clone | toString */
        /*
	@Override
	public boolean equals(Object o){
		if (this == o) { return true; }
		if (o == null || o.getClass() != this.getClass()) { return false; }
		Empresa empresa = (Empresa) o;
		if (this.nome.equals(empresa.getNome()) && this.stock == empresa.getStock()){
			return true;
		} else {
 			return false;
		}
	}*/

	@Override
	public Empresa clone(){
		return new Empresa(this);
	}

        /*
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("EMPRESA:\n");
		s.append("Nome: " + nome + "\n");
		s.append("Stock: " + stock + "\n");
		return s.toString();
	}
        */

        public Set<String> getCodProds(){
            return stock.keySet();
        }
}
