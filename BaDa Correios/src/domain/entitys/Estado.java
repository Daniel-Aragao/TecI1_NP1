package domain.entitys;

public class Estado {
	private int id, paisId;
	private String nome, uf;
	
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
}
