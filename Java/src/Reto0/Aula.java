package Java;

public class Aula{

	private int nAula;
	private String EstadoCalefaccion;
	private String EstadoAlarma;
	
	Aula(){
		this.nAula = 0;
		this.EstadoAlarma = "";
		this.EstadoCalefaccion = "";
	}
	
	Aula(int nAula, String EstadoAlarma, String EstadoCalefaccion){
		this.nAula = nAula;
		this.EstadoAlarma = EstadoAlarma;
		this.EstadoCalefaccion = EstadoCalefaccion;
	}
	
	Aula(Aula A){
		this.nAula = A.nAula;
		this.EstadoAlarma = A.EstadoAlarma;
		this.EstadoCalefaccion = A.EstadoCalefaccion;
	}

	public int getnAula() {
		return nAula;
	}

	public void setnAula(int nAula) {
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
		result = prime * result + nAula;
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
		if (nAula != other.nAula)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Aula [nAula=" + nAula + ", EstadoCalefaccion=" + EstadoCalefaccion + ", EstadoAlarma=" + EstadoAlarma
				+ "]";
	}

}
