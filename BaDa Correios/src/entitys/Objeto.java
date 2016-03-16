package entitys;

public class Objeto extends Entity{

	private String numero;
	private String descricao;
	private double peso, altura, largura, profundidade, valor;
	
}

/*
- Número* (caixa de texto);
- Remetente* (combo com as pessoas cadastrados no BD – exibir o nome e enviar o código);
- Destinatário* (combo com as pessoas cadastrados no BD – exibir o nome e enviar o código);
- Descrição do objeto* (área de texto);
- Peso* (caixa de texto);
- Dimensão* (três caixas de texto para informar a largura, a altura e profundidade);
- Valor (caixa de texto desabilitada, com botão ao lado, onde o valor calculado é mostrado após clicar no botão);
- Posto dos Correios de origem* (combo com os postos previamente cadastrados no BD – exibir o nome e enviar o código);
- Descrição da movimentação no posto de origem (área de texto).

*/