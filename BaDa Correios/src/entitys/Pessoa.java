package entitys;

public class Pessoa extends Entity{
	private String rua, complemento, bairro, cep, estado, cidade;
	private int numero;
	public Pessoa(){
		
	}

	public Pessoa(String nome, String rua, String complemento, String bairro, String cep, String estado, String cidade,
			int numero) {
		this.nome = nome;
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
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