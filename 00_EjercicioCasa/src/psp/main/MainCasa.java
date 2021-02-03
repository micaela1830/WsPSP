package psp.main;

import java.util.ArrayList;

import psp.pojo.Casa;
import psp.pojo.Direcciones;
import psp.pojo.Habitacion;
import psp.pojo.Propietario;

public class MainCasa {

	public static void main(String[] args) {
		
		Direcciones direccioncasa = new  Direcciones();
		direccioncasa.setNombreVia("Joguarts");
		direccioncasa.setTipoVia("avenida flotante");
		direccioncasa.setCp("45678");
		direccioncasa.setNumero("23");
		
		Propietario propietario = new Propietario();
		propietario.setNombre("Voldemor");
		propietario.setDni("4433434");
		propietario.setEdad(125);
		propietario.setDireccion(direccioncasa);
		
		Habitacion salon = new Habitacion();
		salon.setM2(35);
		salon.setTipoHabitacion("salon");
		
		Habitacion cocina = new Habitacion();
		cocina.setM2(15);
		cocina.setTipoHabitacion("COCINA");
		
		Propietario inquilino1 = new Propietario();
		inquilino1.setNombre("Harry");
		inquilino1.setDni("23");
		inquilino1.setEdad(16);
		inquilino1.setDireccion(direccioncasa);
		
		Propietario inquilino2 = new Propietario();
		inquilino2.setNombre("Ernion");
		inquilino2.setDni("25");
		inquilino2.setEdad(18);
		inquilino2.setDireccion(direccioncasa);
		
		Casa casa = new Casa();
		casa.setDireccion(direccioncasa);
		casa.setPrecio(1000);
		casa.setPersona(propietario);
		
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>(); //esto sería una instancia
		listaHabitaciones.add(cocina);
		listaHabitaciones.add(salon);
		
		casa.setListaHabitaciones(listaHabitaciones);
		
		ArrayList<Propietario> listaInquilino = new ArrayList<Propietario>();
		listaInquilino.add(inquilino1);
		listaInquilino.add(inquilino2);
		
		casa.setListaInquilinos(listaInquilino);
		
		//inquilino2.getDireccion().setNombreVia("Gran vía"); v a a salir por panatlla la nueva dirección no la antiguaamente creada
		
		System.out.println(casa);
		
		
		
	}

}
