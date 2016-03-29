package domain.entitys;

import com.sun.jmx.snmp.Timestamp;

public class Movimentacao {

	private String descricao, objeto_numero;
	private int posto_id, Id;
	private Timestamp data_hora;

	public Movimentacao(String descricao, String objeto_numero, int posto_id) {
		super();
		this.descricao = descricao;
		this.objeto_numero = objeto_numero;
		this.posto_id = posto_id;
		this.data_hora = data_hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObjeto_numero() {
		return objeto_numero;
	}

	public void setObjeto_numero(String objeto_numero) {
		this.objeto_numero = objeto_numero;
	}

	public int getPosto_id() {
		return posto_id;
	}

	public void setPosto_id(int posto_id) {
		this.posto_id = posto_id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Timestamp getData_hora() {
		return data_hora;
	}

	public void setData_hora(Timestamp data_hora) {
		this.data_hora = data_hora;
	}
}
