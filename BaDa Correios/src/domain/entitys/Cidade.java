package domain.entitys;

import java.util.Comparator;

public class Cidade {
	private int id, estadoId;
	private String nome;
	
	public Cidade(int id, int estadoId, String nome) {
		super();
		this.id = id;
		this.estadoId = estadoId;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public static Comparator<Cidade> getNomeComparator(){
		return new Comparator<Cidade>(){

			@Override
			public int compare(Cidade a, Cidade b) {
				return a.nome.compareTo(b.nome);
			}
			
		} ;
	}
}
