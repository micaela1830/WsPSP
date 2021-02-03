package ejercicio;

import java.util.Date;
//Runnable

public class EjercicioPrimos implements Runnable {
	
	private int numero;

	public EjercicioPrimos(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		//el tiempo que se ha tardado en realizar el cálculo
		Date inicio = new Date(); //toma la fecha para saber cual es el tiempo inicial 
		
		System.out.println("---------------------------------------");
		
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName()); //aqui arranca el hilo

		System.out.println(esPrimo(numero) ? numero + " Es primo" : numero + " No es primo");
		
		Date fin = new Date();
		
		System.out.println("Tiempo de ejecución en ms: " + (fin.getTime() - inicio.getTime()));

		System.out.println("---------------------------------------");

	}

	public boolean esPrimo(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false; //en caso de que sea divisible cortamos la ejecución de si es primo o no
			}
		}
		return true; //en caso de que se recorra todos  y no hayamos
	}
	
	/*
	 * Instant start = Instant.now();
		
		System.out.println("---------------------------------------");
		
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		System.out.println(esPrimo(numero) ? numero + " Es primo" : numero + " No es primo");
		
		Instant end = Instant.now();
		
		System.out.println("Tiempo de ejecución en ms: " + (Duration.between(start, end)));

		System.out.println("---------------------------------------");
	 */

}