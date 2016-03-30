package domain.interfaces;

import java.util.ArrayList;

public interface IRepositorio <T>{
	
	public boolean adicionar(T elemento);
	
	public boolean alterar(T elemento);
	
	public T get(int id);
	
	public ArrayList<T> getList(String param);
	public ArrayList<T> getAll();
	
	public boolean removeElement(int id);
	
}
