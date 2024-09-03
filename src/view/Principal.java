package view;

import java.util.Scanner;
import controller.ThreadCorridaSapos;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		 
		 System.out.println("Informe a quantidade de sapos: ");
		 int sapos = ler.nextInt();
		 ler.nextLine();
		 
		 System.out.println("Informe o tamanho do pulo máximo (em metros) de cada sapo: ");
		 int pulo = ler.nextInt();
		 ler.nextLine();
		 
		 System.out.println("Informe a distância total da corrida (em metros): ");
		 int distancia = ler.nextInt();
		 ler.nextLine();
		 
		 for(int i = 0; i < sapos; i++) {
			 ThreadCorridaSapos t = new ThreadCorridaSapos(pulo, distancia, i);
			 t.start();
		 }
		 
		 ler.close();
	 }
}
