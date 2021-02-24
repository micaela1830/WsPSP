package com.restbasico.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restbasico.modelo.entidad.Videojuego;
import com.restbasico.modelo.persistencia.DaoVideojuego;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	@GetMapping("videojuego")
	public ResponseEntity<List<Videojuego>>listar(){
		
		List<Videojuego> listaVideojuego = daoVideojuego.listado();
		
		ResponseEntity<List<Videojuego>> respuesta = new ResponseEntity<List<Videojuego>>(listaVideojuego, HttpStatus.OK);		
		return respuesta;
	}
	
	
	
	@GetMapping("videojuego/{id}")
	public ResponseEntity<Videojuego> obtener(@PathVariable("id") int id_videoj){
		
		System.out.println("El id a buscar es: " + id_videoj);
		
		Videojuego v1 = daoVideojuego.buscar(id_videoj);
		
		HttpStatus hs = null;
		
		if(v1 != null) {
			hs = HttpStatus.OK;
		}else {
			hs = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Videojuego> respuesta = new ResponseEntity<Videojuego>(v1,hs);
		
		return respuesta;
	}
	
	@PostMapping("videojuego")
	public ResponseEntity<Videojuego> alta(@RequestBody Videojuego vd) {
		
		Videojuego vAlta = daoVideojuego.alta(vd);
		
		ResponseEntity<Videojuego> respuesta = new ResponseEntity<Videojuego>(vAlta,HttpStatus.CREATED);
		return respuesta;
	}
	

	@PutMapping("videojuego/{id}")
	public ResponseEntity<Videojuego> modificar(@RequestBody Videojuego vd,@PathVariable("id") int id_videoj){

		vd.setId(id_videoj);
		
		Videojuego vModificada = daoVideojuego.modificar(vd);
		
		HttpStatus hs = null;
		
		if(vModificada != null) {
			hs = HttpStatus.OK;
		}else {
			hs = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(vModificada,hs);
		
		return re;
	}
	
	@DeleteMapping("videojuego/{id}")
	public ResponseEntity<Videojuego> borrar(@PathVariable("id") int id_videoj){
		
		Videojuego vd = daoVideojuego.borrar(id_videoj);
		
		HttpStatus hs = null;
		
		if(vd != null) {
			hs = HttpStatus.OK;
		}else {
			hs = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Videojuego> re = new ResponseEntity<Videojuego>(vd,hs);
		
		return re;
	}
}
