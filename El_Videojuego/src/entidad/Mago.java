package entidad;

public class Mago extends Personaje{
	
	private int inteligencia;
	@Override
	public void atacar(Personaje p) {
		System.out.println("ALACAZAM");
		int daño = getArma().usar();
		if(getArma() instanceof Hechizo) {
			daño += inteligencia;
		}
		p.setPuntosVida(p.getPuntosVida() - daño);
		
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	

}
