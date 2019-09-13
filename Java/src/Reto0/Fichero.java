package Reto0;

public class Fichero {

	private int nA = 1;
	private int nP = 1;
	private Aula A;
	private Planta P;
	private String PnP;

	public void crearFichero() {

	}

	public void crearDatos() {
		
		do {
			do {
				nA++;
				PnP = "P" + nP;
				A = new Aula();
				P = new Planta(PnP, A);
			} while (nA <= 15);
			nA = 1;
			nP++;
		} while (nP <= 3);
	}
}
