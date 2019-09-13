package Reto0;

import java.util.Random;

public class rmBoolean {
	
	private int n;

	//  Estado aleatorio 0 o 1
	public rmBoolean() {
		Random rnd = new Random();
		n = rnd.nextInt(2);
		
	}

	public int getBool() {
		return n;
	}

	public void setBool(int n) {
		this.n = n;
	}
	
	
	
}
