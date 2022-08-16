package com.softtek.servicio;

import java.util.List;

import com.softtek.modelo.ConsultaAnalitica;

public interface IConsultaExamenServicio {
	 
    List<ConsultaAnalitica> listarExamenesPorConsulta(Integer idconsulta);
 
}