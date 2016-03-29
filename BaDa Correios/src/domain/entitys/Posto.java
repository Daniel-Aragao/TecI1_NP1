package domain.entitys;

public class Posto{
	
	private String nome, endereco;
	private int id, cidadeId;
	
	

	public Posto(String nome, String endereco, int id, int cidadeId) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.id = id;
		this.cidadeId = cidadeId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(int cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Posto(){
		
	}
}
