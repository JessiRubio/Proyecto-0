package Reto0;

import java.io.Serializable;


// CLASE AULA

public class Aula implements Comparable<Aula>, Serializable{
	
	private static final long serialVersionUID = 1L;

	// VARIABLES
	private String nAula;
	private int EstadoCalefaccion;
	private int EstadoAlarma;
	
	
	//CONSTRUCTOR POR DEFECTO
	
	Aula(){
		this.nAula = "";
		this.EstadoAlarma = new rmBoolean().getBool();
		this.EstadoCalefaccion = 0;
	}
	
	
	// CONSTRUCTOR
	
	/*Aula(String nAula, boolean EstadoAlarma, boolean EstadoCalefaccion){
		this.nAula = nAula;
		this.EstadoAlarma = EstadoAlarma;
		this.EstadoCalefaccion = EstadoCalefaccion;
	}*/
	
	Aula(String nAula, int EstadoAlarma, int EstadoCalefaccion){
		this.nAula = nAula;
		this.EstadoAlarma = EstadoAlarma;
		this.EstadoCalefaccion = EstadoCalefaccion;
	}


	// GET nAula
	
	public String getnAula() {

		return nAula;
	}

	
	// SET nAula
	
	public void setnAula(String nAula) {
		this.nAula = nAula;
	}

	
	// GET EstadoCalefaccion
	
	public int getEstadoCalefaccion() {
		return EstadoCalefaccion;
	}

	
	// SET EstadoCalefaccion
	
	public void setEstadoCalefaccion(int estadoCalefaccion) {
		EstadoCalefaccion = estadoCalefaccion;
	}

	
	// GER EstadoAlarma
	
	public int getEstadoAlarma() {
		return EstadoAlarma;
	}

	
	// SET EstadoAlarma
	
	public void setEstadoAlarma(int estadoAlarma) {
		EstadoAlarma = estadoAlarma;
	}

	
	// HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EstadoAlarma;
		result = prime * result + EstadoCalefaccion;
		result = prime * result + ((nAula == null) ? 0 : nAula.hashCode());
		return result;
	}
	
	
	// EQUALS

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if (EstadoAlarma != other.EstadoAlarma)
			return false;
		if (EstadoCalefaccion != other.EstadoCalefaccion)
			return false;
		if (nAula == null) {
			if (other.nAula != null)
				return false;
		} else if (!nAula.equals(other.nAula))
			return false;
		return true;
	}

	
	// TO STRING
	
	@Override
	public String toString() {
		return "Aula [nAula=" + nAula + ", EstadoCalefaccion=" + EstadoCalefaccion + ", EstadoAlarma=" + EstadoAlarma
				+ "]";
	}

	
	// COMPARE TO
	
	@Override
	public int compareTo(Aula A) {
		String n1,n2;
		n1 = this.nAula;
		n2 = A.nAula ;
		
		return n1.compareTo(n2);
	}

}
