package DAO;

import java.util.ArrayList;

import entitys.Entity;

public class RepositorioPosto_e_Localizacao implements IRepositorio{

	@Override
	public Entity getElementbyId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entity> getElements(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Entity> getUfs(){
		ArrayList<Entity> ufs = new ArrayList<Entity>();
		
		
		return ufs;
	}
	
	public ArrayList<Entity> getCidades(int uf){
		ArrayList<Entity> cidades = new ArrayList<Entity>();
		
		return cidades;
	}
}
