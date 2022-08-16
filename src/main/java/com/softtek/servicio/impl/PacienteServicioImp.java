package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Paciente;
import com.softtek.repo.IGenericRepo;
import com.softtek.repo.IPaciente;
import com.softtek.servicio.IPacienteServicio;

@Service
public class PacienteServicioImp extends CRUDImp<Paciente, Integer> implements IPacienteServicio{

	@Autowired
	private IPaciente repo;
	
	@Override
	protected IGenericRepo<Paciente, Integer> getRepo(){
		return repo;
	}

}
