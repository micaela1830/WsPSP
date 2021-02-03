package entidad;

import utils.NumerosAleatorios;

public class Rezo extends Arma{
	

	@Override
	public int usar() {
		int daño = NumerosAleatorios.calcularNumero(getDañoMinimo(), getDañoMaximo());
		
		int padreNuestro = NumerosAleatorios.calcularNumero(1,100);
		if(padreNuestro <= 50) {
			System.out.println("Padre nuesto que estas en los cielos!!!!");
			int curacion = daño /2;
			System.out.println(getPersonaje().getNombre()+ " Me he curado " + curacion);
			int puntosVidaActuales = this.getPersonaje().getPuntosVida();
			this.getPersonaje().setPuntosVida(puntosVidaActuales + curacion);
		}
		return daño;
	}

}
