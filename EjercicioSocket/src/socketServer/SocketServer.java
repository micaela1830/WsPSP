package socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

		public static final int PUERTO = 2021;
		public static final String IP_SERVER = "localhost"; 
		
		public static void main(String[] args) throws InterruptedException {
			System.out.println("      APLICACIÓN DE SERVIDOR      ");
			System.out.println("----------------------------------");
			

			ServerSocket servidorSocket = null; 
			
		
			Socket socketConexion = null;
			
			PrintStream salida = null; 
			InputStreamReader entrada = null; 
			
			try {
				servidorSocket = new ServerSocket();
				InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO); 
				
				servidorSocket.bind(direccion);
				
				
				
				 
				while(true){
					
					System.out.println("SERVIDOR: Esperando peticion...");
					socketConexion = servidorSocket.accept();
					
					
					entrada = new InputStreamReader(socketConexion.getInputStream());
					
					BufferedReader bf = new BufferedReader(entrada);
					
					
					
					String stringRecibido = bf.readLine();//"3-4"
					
					System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
					String[] operadores = stringRecibido.split("-");
					int iNumero1 = Integer.parseInt(operadores[0]);//3
					int iNumero2 = Integer.parseInt(operadores[1]);//4
					int codOperacion = Integer.parseInt(operadores[2]);
					
					if (codOperacion == 1) {
						
						int resS = iNumero1 + iNumero2;//7 
						Thread.sleep(10000);
						salida = new PrintStream(socketConexion.getOutputStream());
						salida.println(resS);
					} else if (codOperacion == 2) {
						int resR = iNumero1 - iNumero2;
						Thread.sleep(10000);
						salida = new PrintStream(socketConexion.getOutputStream());
						salida.println(resR);
					} else if(codOperacion == 3) {
						int resM = iNumero1 * iNumero2;
						Thread.sleep(10000);
						salida = new PrintStream(socketConexion.getOutputStream());
						salida.println(resM);
					} else if( codOperacion == 4) {
						int resD = iNumero1 / iNumero2;
						Thread.sleep(10000);
						salida = new PrintStream(socketConexion.getOutputStream());
						salida.println(resD);
					}
					
					
				}
			} catch (IOException excepcion) {
				System.out.println(excepcion);
			}finally {
				try {
					if(salida != null && entrada != null){
						salida.close();
						entrada.close();
						socketConexion.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

}
