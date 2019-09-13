package Reto0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Fichero {

	private int nA = 1;
	private int nP = 1;
	private String PnP;


	public void crearDatos() {
		try {
			FileOutputStream fos = new FileOutputStream("datos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			do {
				do {
					nA++;
					PnP = "P" + nP;
					String nAula = Integer.toString(100 * nP + nA);
					boolean bool = new rmBoolean().getBool();
					new Planta(PnP).getAulas().add(new Aula(nAula, bool, false));
					System.out.println(new Planta(PnP).getAulas().add(new Aula(nAula, bool, false)));
					oos.writeObject(new Planta(PnP).getAulas().add(new Aula(nAula, bool, false)));
				} while (nA <= 15);
				nA = 1;
				nP++;
			} while (nP <= 3);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Planta leerDatos() {
		try {
		FileInputStream fis = new FileInputStream("datos.dat");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		Planta valor;
		while(fis.available()>0) {
			valor = (Planta) ois.readObject();
			
			
		}
		return;
		ois.close();
		fis.close();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
