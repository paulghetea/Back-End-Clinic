package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Medico;
import com.softtek.repo.IGenericRepo;
import com.softtek.repo.IMedico;
import com.softtek.servicio.IMedicoServicio;

@Service
public class MedicoServicioImp extends CRUDImp<Medico, Integer> implements IMedicoServicio {

	@Autowired
	private IMedico repo;
	
	@Override
	protected IGenericRepo<Medico, Integer> getRepo(){
		return repo;
	}

}
