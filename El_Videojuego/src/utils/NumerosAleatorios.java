package utils;

import java.util.concurrent.ThreadLocalRandom;

public class NumerosAleatorios {
	
	public static int calcularNumero(int n1, int n2) {
		//Este metodo calcular un numero aleatorio entre dos numeros
				int randomNum = ThreadLocalRandom.current().nextInt(n1, n2 + 1);
				return randomNum;
	}
}
