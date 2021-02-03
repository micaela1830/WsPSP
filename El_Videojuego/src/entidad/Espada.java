package entidad;

import utils.NumerosAleatorios;

//respinde a la pregunta es un de algo? por lo tantonto extiende ade alguna clase
public class Espada extends Arma {
	
	@Override
	public int usar() {
		int daño = NumerosAleatorios.calcularNumero(getDañoMinimo(), getDañoMaximo());
		return daño;
	}
	

}
