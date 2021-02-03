package entidad;

public abstract class Personaje {
	private String nombre;
	private int puntosVida;
	private Arma arma;
	private int iniciativA;
	
	public abstract void atacar(Personaje p);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getIniciativA() {
		return iniciativA;
	}

	public void setIniciativA(int iniciativA) {
		this.iniciativA = iniciativA;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", puntosVida=" + puntosVida + ", arma=" + arma + ", iniciativA="
				+ iniciativA + "]";
	}
	
	
	
}
