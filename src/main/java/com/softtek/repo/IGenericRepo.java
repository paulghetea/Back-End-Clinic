package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//Clase que extiende de JPA para obtener las funciones de la base de datos (CRUD)
@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T,ID> {

}
