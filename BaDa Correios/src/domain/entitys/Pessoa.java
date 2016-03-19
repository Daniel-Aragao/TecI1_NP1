package domain.entitys;

public class Pessoa{
	private String nome, rua, complemento, bairro, cep; 
	private int estadoId, cidadeId, paisId;
	private int numero;
	public Pessoa(){
		
	}

	public Pessoa(String nome, String rua, String complemento, String bairro, String cep, int pais, int estado, int cidade,
			int numero) {
		this.nome = nome;
		
		this.rua = rua;
		this.complemento = complemento;
		
		this.bairro = bairro;
		this.cep = cep;
		
		this.estadoId = estado;
		this.cidadeId = cidade;
		this.paisId = pais;
		
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