package Reto0;

import java.io.Serializable;
import java.util.ArrayList;

public class Planta implements Comparable<Planta>, Serializable{


	private static final long serialVersionUID = 1L;
	private String nPlanta;
	private ArrayList<Aula> aulas;
	
	Planta(){
		this.nPlanta = "";
		this.aulas = new ArrayList<Aula>();
	}

	public String getnPlanta() {
		return nPlanta;
	}

	public void setnPlanta(String nPlanta) {
		this.nPlanta = nPlanta;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((nPlanta == null) ? 0 : nPlanta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (nPlanta == null) {
			if (other.nPlanta != null)
				return false;
		} else if (!nPlanta.equals(other.nPlanta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Planta [nPlanta=" + nPlanta + ", aulas=" + aulas + "]";
	}

	@Override
	public int compareTo(Planta A) {
		String n1,n2;
		n1 = this.nPlanta;
		n2 = A.nPlanta ;
		
		return n1.compareTo(n2);
	}

	

}
