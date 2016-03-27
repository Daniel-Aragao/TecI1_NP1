package domain.entitys;

public class Pessoa{
	private String nome, rua, complemento, bairro, cep; 
	private int estadoId, cidadeId, paisId;
	private int numero;
	public Pessoa(){
		
	}

	public Pessoa(String nome, String rua, String complemento, String bairro, String cep, 
			int estadoId, int cidadeId, int numero) {
		this.nome = nome;
		
		this.rua = rua;
		this.complemento = complemento;
		
		this.bairro = bairro;
		this.cep = cep;
		
		this.estadoId = estadoId;
		this.cidadeId = cidadeId;
		
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public int getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(int cidadeId) {
		this.cidadeId = cidadeId;
	}

	public int getPaisId() {
		return paisId;
	}

	public void setPaisId(int paisId) {
		this.paisId = paisId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
/*- Nome* (caixa de texto);
- Rua* (caixa de texto);
- Número* (caixa de texto);
- Complemento (caixa de texto);
- Bairro* (caixa de texto);
- CEP* (caixa de texto com formatação para CEP);
- Estado* (combobox);
- Cidade* (combobox).
*/