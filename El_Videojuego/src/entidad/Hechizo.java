package entidad;

import utils.NumerosAleatorios;

public class Hechizo extends Arma {

	@Override
	public int usar() {
		int daño = NumerosAleatorios.calcularNumero(getDañoMinimo(), getDañoMaximo());
		
		int magiaCaos = NumerosAleatorios.calcularNumero(1,100);
		if(magiaCaos <= 25) {
			System.out.println("Magia del Caos!!!!!");
			daño *=2;//en caso de magia del caos doble daño 
		}
		return daño;
	}
	
	
	

}
