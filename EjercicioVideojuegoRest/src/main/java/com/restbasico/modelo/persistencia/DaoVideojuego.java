package com.restbasico.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restbasico.modelo.entidad.Videojuego;

@Component
public class DaoVideojuego {
	
	private List<Videojuego> listaVideojuego;
	private int contador =0;
	
	public DaoVideojuego() {
		
		Videojuego vd1 = new Videojuego();
		vd1.setId(contador++);
		vd1.setNombre("Fortnite");
		vd1.setCompania("Epic");
		vd1.setPrecio(34.78);
		vd1.setPuntuacion(5);
		
		Videojuego vd2 = new Videojuego();
		vd2.setId(contador++);
		vd2.setNombre("Mario Bros");
		vd2.setCompania("Nintendo");
		vd2.setPrecio(50.78);
		vd2.setPuntuacion(4);
		
		Videojuego vd3 = new Videojuego();
		vd3.setId(contador++);
		vd3.setNombre("Sonic");
		vd3.setCompania("Sega");
		vd3.setPrecio(20.78);
		vd3.setPuntuacion(4);
		
		listaVideojuego = new ArrayList<Videojuego>();
		listaVideojuego.add(vd1);
		listaVideojuego.add(vd2);
		listaVideojuego.add(vd3);
			
	}
	
	//Tendriamos que hacer los metodos de get, post, put, delete
	public List<Videojuego> listado(){
		return listaVideojuego;
	}
	
	/**
	 * Metodo que busca una persona por un id
	 * @param id representa el id a buscar
	 * @return retorna la Persona con el id a buscar o null en caso de que la persona
	 * no exista
	 */
	
	public Videojuego buscar(int id) {
		Videojuego vd = null;
		
		for (Videojuego v : listaVideojuego) {
			if(v.getId() == id) {
				vd = v;
			}
		}
		return vd;
	}
	
	//para dar de alta una persona
	public Videojuego alta(Videojuego vd) {
		vd.setId(contador++);
		listaVideojuego.add(vd);
		return vd;
	}
	/**
	 * Metodo que modifica una persona a partir de un ID
	 * @param pModificar la persona que queremos modificar, dentro del atributo
	 * id contendra el id que queremos modificar
	 * @return Persona modificada o null en caso de que no encontremos el id
	 * de la persona
	 */
	public Videojuego modificar(Videojuego pModificar) {
		Videojuego v = buscar(pModificar.getId());
		if(v != null) { 
			v.setNombre(pModificar.getNombre());
			v.setCompania(pModificar.getCompania());
			v.setPrecio(pModificar.getPrecio());
			v.setPuntuacion(pModificar.getPuntuacion());
		}		
		return v;
	}
	
	public Videojuego borrar(int id) {
		Videojuego vd = buscar(id);
		if(vd != null) {
			listaVideojuego.remove(id);
		}
		return vd;
	}
}
