package entitys;

public class Objeto extends Entity{

	private String numero;
	private String descricao;
	private double peso, altura, largura, profundidade, valor;
	
}

/*
- N�mero* (caixa de texto);
- Remetente* (combo com as pessoas cadastrados no BD � exibir o nome e enviar o c�digo);
- Destinat�rio* (combo com as pessoas cadastrados no BD � exibir o nome e enviar o c�digo);
- Descri��o do objeto* (�rea de texto);
- Peso* (caixa de texto);
- Dimens�o* (tr�s caixas de texto para informar a largura, a altura e profundidade);
- Valor (caixa de texto desabilitada, com bot�o ao lado, onde o valor calculado � mostrado ap�s clicar no bot�o);
- Posto dos Correios de origem* (combo com os postos previamente cadastrados no BD � exibir o nome e enviar o c�digo);
- Descri��o da movimenta��o no posto de origem (�rea de texto).

*/