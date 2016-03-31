package domain.entitys;

import java.util.Comparator;

public class Pessoa{
	private String nome, rua, complemento, bairro, cep; 
	private int estadoId, cidadeId, paisId;
	private int id, numero;
	public Pessoa(){
		
	}

	public Pessoa(int id, String nome, String rua, String complemento, String bairro, String cep, 
			int estadoId, int cidadeId, int numero) {
		if(id == 0 || nome == null || rua == null || complemento == null || bairro == null || cep == null
				|| estadoId == 0 || cidadeId == 0 || numero == 0){
			throw new RuntimeException("Nenhum parametro de Pessoa pode ser nulo");
		}
		
		this.setId(id);
		this.nome = nome;
		
		this.rua = rua;
		this.complemento = complemento;
		
		this.bairro = bairro;
		this.cep = cep;
		
		this.estadoId = estadoId;
		this.cidadeId = cidadeId;
		
		this.numero = numero;
	}
	
	public Pessoa(String nome, String rua, String complemento, String bairro, String cep, 
			int estadoId, int cidadeId, int numero) {
		if(nome == null || rua == null || complemento == null || bairro == null || cep == null
				|| estadoId == 0 || cidadeId == 0 || numero == 0){
			throw new RuntimeException("Nenhum parametro de Pessoa pode ser nulo");
		}
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static Comparator<Pessoa> getNomeComparator(){
		return new Comparator<Pessoa>(){

			@Override
			public int compare(Pessoa a, Pessoa b) {
				return a.nome.toLowerCase().compareTo(b.nome.toLowerCase());
			}
			
		} ;
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