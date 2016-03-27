package domain.entitys;

public class Cidade {
	private int id, estadoId;
	private String nome;
	
	public Cidade(int id, int estadoId, String nome) {
		super();
		this.id = id;
		this.estadoId = estadoId;
		this.nome = nome;
	}
}
