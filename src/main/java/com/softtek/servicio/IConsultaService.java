package com.softtek.servicio;

import java.util.List;

import com.softtek.dto.ConsultaFechaDTO;
import com.softtek.modelo.Analitica;
import com.softtek.modelo.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer> {

	Consulta registrarTransaccional(Consulta consulta, List<Analitica> examenes) throws Exception;

	List<ConsultaFechaDTO> listarResumen();

	byte[] generarReporte();

}
