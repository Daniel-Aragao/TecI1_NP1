package domain.entitys;

import java.util.Comparator;

public class Estado {
	private int id, paisId;
	private String nome, uf;
		
	public Estado(int id, String nome, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPaisId() {
		return paisId;
	}
	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public static Comparator<Estado> getNomeComparator(){
		return new Comparator<Estado>(){

			@Override
			public int compare(Estado a, Estado b) {
				return a.nome.compareTo(b.nome);
			}
			
		} ;
	}
}
