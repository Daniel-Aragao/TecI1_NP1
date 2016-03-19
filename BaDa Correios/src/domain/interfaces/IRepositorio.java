package domain.interfaces;

import java.util.ArrayList;

public interface IRepositorio <T>{
	
	public T getElementbyId(int id);
	public ArrayList<T> getAll();
	public ArrayList<T> getElements(String nome);
	
	public void removeElement(int id);
	
	public void addElement(T e);
	
}
