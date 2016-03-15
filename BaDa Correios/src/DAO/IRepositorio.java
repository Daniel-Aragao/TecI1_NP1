package DAO;

import java.util.ArrayList;

import entitys.Entity;

public interface IRepositorio {
	public Entity getElementbyId();
	public ArrayList<Entity> getElements(String nome);
	
	
	
	
}
