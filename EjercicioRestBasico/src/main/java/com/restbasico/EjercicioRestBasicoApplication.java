package com.restbasico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.restbasico.model.Videojuego;

@SpringBootApplication
public class EjercicioRestBasicoApplication {

	public static ApplicationContext context;
	public static void main(String[] args) {
		context = SpringApplication.run(EjercicioRestBasicoApplication.class, args);
		
		Videojuego v1 = context.getBean("videojuego", Videojuego.class);
		v1.setId(1);
		v1.setNombre("Mario Bros");
		v1.setCompania("Nintendo");
		v1.setPrecio(49.99);
			
	}

}
