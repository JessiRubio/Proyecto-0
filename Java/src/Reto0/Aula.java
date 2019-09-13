package Reto0;

import java.io.Serializable;


// CLASE AULA

public class Aula implements Comparable<Aula>, Serializable{
	
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private static String nAula;
	private String EstadoCalefaccion;
	private String EstadoAlarma;
=======
>>>>>>> branch 'master' of https://github.com/JessiRubio/Proyecto-0
	
	// VARIABLES
	
	private String nAula;
	private boolean EstadoCalefaccion;
	private boolean EstadoAlarma;
	
	
	//CONSTRUCTOR POR DEFECTO
	
	Aula(){
		this.nAula = "";
		this.EstadoAlarma = new rmBoolean().getBool();
		this.EstadoCalefaccion = false;
	}
	
	
	// CONSTRUCTOR
	
	Aula(String nAula, boolean EstadoAlarma, boolean EstadoCalefaccion){
		this.nAula = nAula;
		this.EstadoAlarma = EstadoAlarma;
		this.EstadoCalefaccion = EstadoCalefaccion;
	}

<<<<<<< HEAD
	public static String getnAula() {
=======
	
	// GET nAula
	
	public String getnAula() {
>>>>>>> branch 'master' of https://github.com/JessiRubio/Proyecto-0
		return nAula;
	}

	
	
	// SET nAula
	
	public void setnAula(String nAula) {
		this.nAula = nAula;
	}

	
	// GET EstadoCalefaccion
	
	public boolean getEstadoCalefaccion() {
		return EstadoCalefaccion;
	}

	
	// SET EstadoCalefaccion
	
	public void setEstadoCalefaccion(boolean estadoCalefaccion) {
		EstadoCalefaccion = estadoCalefaccion;
	}

	
	// GER EstadoAlarma
	
	public boolean getEstadoAlarma() {
		return EstadoAlarma;
	}

	
	// SET EstadoAlarma
	
	public void setEstadoAlarma(boolean estadoAlarma) {
		EstadoAlarma = estadoAlarma;
	}

	
	// HASHCODE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (EstadoAlarma ? 1231 : 1237);
		result = prime * result + (EstadoCalefaccion ? 1231 : 1237);
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
