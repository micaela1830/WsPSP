package psp.pojo;

import java.util.ArrayList;

public class Casa {
	private double precio;
	private Propietario persona;
	private Direcciones direccion;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Propietario> listaInquilinos;
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Propietario getPersona() {
		return persona;
	}
	public void setPersona(Propietario persona) {
		this.persona = persona;
	}
	public Direcciones getDireccion() {
		return direccion;
	}
	public void setDireccion(Direcciones direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}
	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}
	public ArrayList<Propietario> getListaInquilinos() {
		return listaInquilinos;
	}
	public void setListaInquilinos(ArrayList<Propietario> listaInquilinos) {
		this.listaInquilinos = listaInquilinos;
	}
	@Override
	public String toString() {
		return "Casa [precio=" + precio + ", persona=" + persona + ", direccion=" + direccion + ", listaHabitaciones="
				+ listaHabitaciones + ", listaInquilinos=" + listaInquilinos + "]";
	}
	
	public double clacularM2() {
		int m2totales = 0;
		for (Habitacion h:listaHabitaciones) {
			m2totales += h.getM2();
			
		}
		return m2totales;
	}
	
}
