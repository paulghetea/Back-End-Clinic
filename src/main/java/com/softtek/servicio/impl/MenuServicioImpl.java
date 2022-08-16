package com.softtek.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Menu;
import com.softtek.repo.IGenericRepo;
import com.softtek.repo.IMenu;
import com.softtek.servicio.IMenuServicio;

@Service
public class MenuServicioImpl extends CRUDImp<Menu, Integer> implements IMenuServicio {

	@Autowired
	private IMenu repo;
	
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		
		/*List<Menu> menus = new ArrayList<>();
		repo.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt (String.value0f(x[0]))));
			m.setIcono (String.value0f (x[1])); m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.value0f(x[3]));
			menus.add(m);
		});*/

		return repo.listarMenuPorUsuario(nombre);
	}

	@Override
	protected IGenericRepo <Menu, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	
	
}
