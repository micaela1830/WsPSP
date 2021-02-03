package psp.pojo;

public class Propietario {
	private String nombre;
	private int edad;
	private String dni;
	private Direcciones direccion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Direcciones getDireccion() {
		return direccion;
	}
	public void setDireccion(Direcciones direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", direccion=" + direccion + "]";
	}
	
}
