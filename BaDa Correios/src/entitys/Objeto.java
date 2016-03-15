package entitys;

import java.util.ArrayList;

public class Objeto {
	private int numero, remetenteId, destinatarioId;
	private String descricao;
	private Pessoa remetente, destinatario;
	private double altura, largura, profundidade;
	private double valor;
	private Posto origem;
	private ArrayList<Posto> movimentacao;
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