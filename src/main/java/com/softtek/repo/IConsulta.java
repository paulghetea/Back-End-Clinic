package com.softtek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.softtek.modelo.Consulta;

public interface IConsulta extends IGenericRepo<Consulta, Integer> {
	
	
	//Llamas a una funcion de la base de datos usando el lenguaje SQL
	@Query(value = "select * from tabla_reportes()", nativeQuery = true)
    List<Object[]> getConsultas();

}
