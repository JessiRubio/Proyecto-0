package Reto0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
	
	
	public static void conectarBD() {
		
		try {
			Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			System.out.println("Base de datos conectada.");
			
		} catch (SQLException e) {
			System.out.println("Error al conectar");
			e.printStackTrace();
		}
	} 
	
	public void cargarDatosPlanta(String string) {
		// TODO Auto-generated method stub
		
	}

	public void cargarDatoAula(String cod) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarEstado(String codAula, String opSeleccionada) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean consultarAula() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
