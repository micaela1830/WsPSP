package com.restbasico.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restbasico.model.Videojuego;

@RestController
public class ServicioVideojuego {
	
	@Autowired
	private Videojuego v1;
	
	/*
	 * a)Perdir que nos mande un videojuego, el videojuego tendra
	los siguientes campos. ID, nombre, compañia y precio. Cada alumno 
	podra el videojuego que quiera (1-Sonic-sega-30).
	Podemos hacer el recurso "videojuego" con el verbo GET
	 */
	@GetMapping("videojuego")
	public Videojuego obtenerVideojuego() {
		System.out.println("Se Ha recibido una petición HTTP");
		v1.setId(1);
		v1.setNombre("Mario Bros");
		v1.setCompania("Nintendo");
		v1.setPrecio(49.99);
		return v1;
	}
	
	@PutMapping("videojuego")
	public Videojuego modifPrecio() {
		System.out.println("Se ha realizado dicha modificación");
		
		double n1 = v1.getPrecio() + 10;
		
		v1.setPrecio(n1);
		return v1 ;
		
	}

}
