package domain.entitys;

import java.util.Comparator;

public class Objeto{

	private String numero;
	private String descricao;
	private double peso, altura, largura, profundidade, valor;
	private int remetendeId, destinatarioId;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getRemetendeId() {
		return remetendeId;
	}
	public void setRemetendeId(int remetendeId) {
		this.remetendeId = remetendeId;
	}
	public int getDestinatarioId() {
		return destinatarioId;
	}
	public void setDestinatarioId(int destinatarioId) {
		this.destinatarioId = destinatarioId;
	}
	
	public static Comparator<Objeto> getNomeComparator(){
		return new Comparator<Objeto>(){

			@Override
			public int compare(Objeto a, Objeto b) {
				return a.numero.compareTo(b.numero);
			}
			
		} ;
	}
	
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