package com.softtek.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Clase que representa una tabla en la base de datos

//Indica que esta clase es un pojo
@Entity

//Declara el nombre de la tabla en la base de datos
@Table(name = "analiticas")
public class Analitica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnalitica;
	
	@Column(name = "descripcion", nullable = false, length = 500)
	private String descripcion;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	
	//constructores
	public Analitica() {
		super();
	}

	public Analitica(Integer idAnalitica, String descripcion, String nombre) {
		super();
		this.idAnalitica = idAnalitica;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	
	//getter and setters
	public Integer getIdAnalitica() {
		return idAnalitica;
	}

	public void setIdAnalitica(Integer idAnalitica) {
		this.idAnalitica = idAnalitica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Analitica [idAnalitica=" + idAnalitica + ", descripcion=" + descripcion + ", nombre=" + nombre
				+ "]";
	}
	
}
