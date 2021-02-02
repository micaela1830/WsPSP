package socketCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {

	public static final int PUERTO = 2021;
	public static final String IP_SERVER = "localhost";
	static final String OPCION_SUMA = "1";
	static final String OPCION_RESTA = "2";
	static final String OPCION_MULTIPLICAR = "3";
	static final String OPCION_DIVIDIR = "4";
	static Scanner sc;

	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");

		sc = new Scanner(System.in);

		String opcion = "";
		boolean datoOk = false;

		while (!datoOk) {
			opcion = mostrarMenu();

			switch (opcion) {
			case OPCION_SUMA:
				operacion("INTRODUZA DOS NUMEROS PARA SUMAR");
				break;

			case OPCION_RESTA:
				operacion("INTRODUZA DOS NUMEROS PARA RESTAR");
				break;

			case OPCION_MULTIPLICAR:
				operacion("INTRODUZA DOS NUMEROS PARA MULTIPLICAR");
				break;

			case OPCION_DIVIDIR:
				operacion("INTRODUZA DOS NUMEROS PARA DIVIDIR");
				break;

			default:
				break;
			}
		}
	}

	private static void operacion(String string) {

		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		
		try {
			boolean cont = true;
			do {
			socketCliente = new Socket();
			socketCliente.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

			entrada = new InputStreamReader(socketCliente.getInputStream());
			salida = new PrintStream(socketCliente.getOutputStream());

			String numero1 = sc.nextLine();
			String numero2 = sc.nextLine();
			String operandos = numero1 + "-" + numero2;
			salida.println(operandos);// 3-4

			BufferedReader bf = new BufferedReader(entrada);
			String resultado = bf.readLine();
			System.out.println("CLIENTE: " + resultado);// 7
			
			System.out.println("CLIENTE: El servidor me ha respondido: " + resultado);
			System.out.println("Quiere continuar? S/N");
			String sContinuar = sc.nextLine();
			if (sContinuar.equalsIgnoreCase("n")) {
				cont = false;
			}
			
			
			}while(cont);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		} finally {
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static String mostrarMenu() {

		System.out.println("Introduzca la acción a realizar");
		System.out.println("1 SUMAR");
		System.out.println("2 RESTAR");
		System.out.println("3 MULTIPLICAR");
		System.out.println("4 DIVIDIR");
		String res = sc.nextLine();

		return res;
	}

}
