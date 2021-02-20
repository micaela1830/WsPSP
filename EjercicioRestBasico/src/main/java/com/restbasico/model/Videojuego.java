package com.restbasico.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //queremos que esta persona sea gestionada por el contexto de spring
@Scope("prototype")
public class Videojuego {
	
	private int id;
	private String nombre;
	private String compania;
	private double precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
