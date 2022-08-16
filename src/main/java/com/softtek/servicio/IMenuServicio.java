package com.softtek.servicio;

import java.util.List;

import com.softtek.modelo.Menu;

public interface IMenuServicio extends ICRUD<Menu, Integer> {

	//Metodo para proporcionar un menu X a un usuario
	List<Menu> listarMenuPorUsuario(String nombre);
	
}
