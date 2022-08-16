package com.softtek.repo;

import com.softtek.modelo.Usuario;

public interface IUsuario extends IGenericRepo<Usuario, Integer> {

	//Recupera el nombre de usuario
	Usuario findOneByUsername(String username);
	
}
