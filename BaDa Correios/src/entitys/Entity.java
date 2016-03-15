package entitys;

public abstract class Entity {
	protected String codigo;//numero / codigo
	protected String nome;
	
	public String  getNome(){
		return this.nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
