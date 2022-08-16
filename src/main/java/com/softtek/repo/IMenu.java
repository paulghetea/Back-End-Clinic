package com.softtek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.modelo.Menu;

public interface IMenu extends IGenericRepo<Menu, Integer> {
	
	
	//Hacer select de 2 tablas a partir de una sentencia SQL con inner join
	@Query(value="select m.* from menu_rol mr inner join usuario_rol ur on ur.id_rol = mr.id_rol inner join menu m on m.id_menu = mr.id_menu inner join usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre", nativeQuery = true)
    List<Menu> listarMenuPorUsuario(@Param("nombre") String nombre);

}
