package com.softtek.servicio;

import java.util.List;


//Interface que para factorizar codigo y traer todos los metodos CRUD
public interface ICRUD<T, ID> {

	T registrar(T t )throws Exception;
	T modificar(T t)throws Exception;
	List<T> listar() throws Exception;
	T listarPorId(ID id) throws Exception;
	void eliminar (ID id) throws Exception;
}
