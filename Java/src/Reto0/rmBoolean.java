package Reto0;

import java.util.Random;

public class rmBoolean {
	
	private boolean bool;

	//  Estado aleatorio 0 o 1
	public rmBoolean() {
		Random rnd = new Random();
		int numero = rnd.nextInt(2);
		if (numero == 0) {
			bool = false;
		} else if (numero == 1) {
			bool = true;
		}
	}

	public boolean getBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
	
	
}
