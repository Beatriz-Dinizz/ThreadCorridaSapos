package controller;

public class ThreadCorridaSapos extends Thread{
	private static int colocacao = 1;
	private int tamanhoPulo;
	private int distancia;
	private int numeroSapo;
	
	public ThreadCorridaSapos(int tamanhoPulo, int distancia, int numeroSapo) {
		this.tamanhoPulo = tamanhoPulo;
		this.distancia = distancia;
		this.numeroSapo = numeroSapo;
	}
	
	public void run() {
		corridaSapos();
	}
	
	private void corridaSapos() {
		double metrosPercorrida = 0;
		int numeroSaltos = 0;
		
		while(metrosPercorrida < distancia) {
			double salto =  Math.round(Math.random() * (tamanhoPulo + 1)* 100) / 100.0;
			metrosPercorrida += salto;
			numeroSaltos++;
		
			if(metrosPercorrida >= distancia) {
				synchronized (ThreadCorridaSapos.class) {
					System.out.println(colocacao + "° lugar - Sapo" + (numeroSapo + 1) +  
							" concluiu a corrida de " + distancia + "m com " + numeroSaltos + " saltos.");
					colocacao++;
				}
				break;
			}else {
				System.out.println("Sapo" + (numeroSapo + 1) +  " saltou " + salto + 
						"m e percorreu " + metrosPercorrida + "m dos " + distancia + "m da corrida.");
			}
		}
	}
}