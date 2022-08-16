package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Analitica;
import com.softtek.repo.IAnalitica;
import com.softtek.repo.IGenericRepo;
import com.softtek.servicio.IAnaliticaServicio;

@Service
public class AnaliticaServicioImpl extends CRUDImp<Analitica, Integer> implements IAnaliticaServicio {

	@Autowired
	private IAnalitica repo;

	@Override
	protected IGenericRepo<Analitica, Integer> getRepo(){
		return repo;
	}
	
	
	
}
