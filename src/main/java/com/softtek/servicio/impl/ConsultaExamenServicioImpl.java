package com.softtek.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.ConsultaAnalitica;
import com.softtek.repo.IConsultaExamen;
import com.softtek.servicio.IConsultaExamenServicio;

@Service
public class ConsultaExamenServicioImpl implements IConsultaExamenServicio {
 
    @Autowired
    private IConsultaExamen repo;

    @Override
    public List<ConsultaAnalitica> listarExamenesPorConsulta(Integer idconsulta) {
        return repo.listarExamenesPorConsulta(idconsulta);
    }
}