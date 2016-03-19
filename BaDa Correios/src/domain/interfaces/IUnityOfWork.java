package domain.interfaces;

import domain.entitys.Movimentacao;
import domain.entitys.Objeto;
import domain.entitys.Pessoa;
import domain.entitys.Posto;

public interface IUnityOfWork {
	
	IRepositorio<Movimentacao> movimentacoes;
	IRepositorio<Posto> postos;
	IRepositorio<Pessoa> pessoas;
	IRepositorio<Objeto> objetos;
	
	void saveChanges();
}
