package com.softtek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.modelo.ConsultaAnalitica;

public interface IConsultaExamen extends IGenericRepo<ConsultaAnalitica, Integer>{
	 
    
	//Es una anotaccion que se usa para realizar funciones como INSERT, UPDATE o DELETE
    @Modifying
    
	//Llamas a una funcion de la base de datos usando el lenguaje SQL
    @Query(value = "INSERT INTO consulta_analitica(id_consulta, id_analitica) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
    Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);

    
    //Hacer select de 2 tablas a partir de una sentencia PSQL
    @Query("FROM ConsultaAnalitica ce where ce.consulta.idConsulta = :idConsulta")
    List<ConsultaAnalitica> listarExamenesPorConsulta(@Param("idConsulta") Integer idconsulta);
    //[consulta, examen]
    //[consulta, examen]
    //[consulta, examen]
 

}