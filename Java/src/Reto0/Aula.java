package Reto0;

import java.io.Serializable;

public class Aula implements Comparable<Aula>, Serializable{

	
	private static final long serialVersionUID = 1L;
	private String nAula;
	private String EstadoCalefaccion;
	private String EstadoAlarma;
	
	//Constructora
	Aula(){
		this.nAula = "";
		this.EstadoAlarma = "";
		this.EstadoCalefaccion = "";
	}
	
	Aula(String nAula, String EstadoAlarma, String EstadoCalefaccion){
		this.nAula = nAula;
		this.EstadoAlarma = EstadoAlarma;
		this.EstadoCalefaccion = EstadoCalefaccion;
	}

	public String getnAula() {
		return nAula;
	}

	public void setnAula(String nAula) {
		this.nAula = nAula;
	}

	public String getEstadoCalefaccion() {
		return EstadoCalefaccion;
	}

	public void setEstadoCalefaccion(String estadoCalefaccion) {
		EstadoCalefaccion = estadoCalefaccion;
	}

	public String getEstadoAlarma() {
		return EstadoAlarma;
	}

	public void setEstadoAlarma(String estadoAlarma) {
		EstadoAlarma = estadoAlarma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EstadoAlarma == null) ? 0 : EstadoAlarma.hashCode());
		result = prime * result + ((EstadoCalefaccion == null) ? 0 : EstadoCalefaccion.hashCode());
		result = prime * result + ((nAula == null) ? 0 : nAula.hashCode());
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
		Aula other = (Aula) obj;
		if (EstadoAlarma == null) {
			if (other.EstadoAlarma != null)
				return false;
		} else if (!EstadoAlarma.equals(other.EstadoAlarma))
			return false;
		if (EstadoCalefaccion == null) {
			if (other.EstadoCalefaccion != null)
				return false;
		} else if (!EstadoCalefaccion.equals(other.EstadoCalefaccion))
			return false;
		if (nAula == null) {
			if (other.nAula != null)
				return false;
		} else if (!nAula.equals(other.nAula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aula [nAula=" + nAula + ", EstadoCalefaccion=" + EstadoCalefaccion + ", EstadoAlarma=" + EstadoAlarma
				+ "]";
	}

	@Override
	public int compareTo(Aula A) {
		String n1,n2;
		n1 = this.nAula;
		n2 = A.nAula ;
		
		return n1.compareTo(n2);
	}

}
