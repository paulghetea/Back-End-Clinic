package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Especialidad;
import com.softtek.repo.IEspecialidad;
import com.softtek.repo.IGenericRepo;
import com.softtek.servicio.IEspecialidadServicio;

@Service
public class EspecialidadServicioImpl extends CRUDImp<Especialidad, Integer> implements IEspecialidadServicio {

	@Autowired
	private IEspecialidad repo;
	
	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo(){
		return repo;
	}
	
}
