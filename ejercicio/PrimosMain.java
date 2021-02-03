package ejercicio;

public class PrimosMain {
	/*
	Pedimos 3 numeros a un usuario por pantalla, a partir de esos numeros
	arrancamos 3 hilos y que cada hilo diga si el numero que le pasamos 
	es primo o no es primo

	Bonus, mostrar el tiempo de ejecucion de cada hilo

	- La clase date guarda el tiempo en milisegundos desde el año 1970
	Date date = new Date();
	date.getTime() //nos devuelve el numero de milisegundos*/
	public static void main(String[] args) {

		EjercicioPrimos hilo1 = new EjercicioPrimos(5);
		Thread t1 = new Thread(hilo1);
		t1.setName("Hilo1");
		
		EjercicioPrimos hilo2 = new EjercicioPrimos(15);
		Thread t2 = new Thread(hilo2);
		t2.setName("Hilo2");
		
		EjercicioPrimos hilo3 = new EjercicioPrimos(656601);
		Thread t3 = new Thread(hilo3);
		t3.setName("Hilo3");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		t3.start();
	}

}
