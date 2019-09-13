package Reto0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





public class BD {
	
	private static Connection conectar;
	
	public static void conectarBD() {
		
		
		try {
			 conectar = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			System.out.println("Base de datos conectada.");
			
			
			
			
			conectar.close();
			
		} catch (SQLException e) {
			System.out.println("Error al conectar");
			e.printStackTrace();
		}
		
	} 
	
	public void cargarDatosPlanta(String string) {
		// TODO Auto-generated method stub
		
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			Statement st = con.createStatement();	
			
			ResultSet rs = st.executeQuery("SELECT nAula FROM aula WHERE nplanta='"+Planta.getnPlanta()+"' ");
			
			ArrayList<Aula> aulas=new ArrayList<>();
			
			while (rs.next()){ 
				
				Aula a =new Aula();
			
				a.setnAula(rs.getString("nAula")); 
				aulas.add(a);
				
				}
			
			st.close();	
			rs.close();
			con.close();
			}
		catch (SQLException sqle){
			sqle.printStackTrace();
			System.out.println("error");
		}

		
	}

	public void cargarDatoAula(String cod) {
		// TODO Auto-generated method stub
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			Statement st = con.createStatement();	
			
			ResultSet rs = st.executeQuery("SELECT nAula, EstadoAlarma, EstadoCalefaccion from aula where nAula='"+cod+"'");
			
			ArrayList<Aula> datosAulas=new ArrayList<>();
			
			while (rs.next()){ 
				
				Aula da =new Aula();
			
				da.setnAula(rs.getString("nAula"));
				da.setEstadoAlarma(rs.getString("EstadoAlarma")); 
				da.setEstadoCalefaccion(rs.getString("EstadoCalefaccion"));
				datosAulas.add(da);
				
				}
			
			st.close();	
			rs.close();
			con.close();
			
			}
		catch (SQLException sqle){
			sqle.printStackTrace();
			System.out.println("error");
		}
	}

	public void actualizarEstado(String codAula, String opSeleccionada) {
		// TODO Auto-generated method stub
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			Statement st = con.createStatement();		
			
			ResultSet rs = st.executeQuery("SELECT * FROM aula");

			int resultado;
			boolean valorEstado;
			
			
			String Ssql = "UPDATE aula SET "+opSeleccionada+"=?  WHERE "+codAula+"=?";
        
			if (opSeleccionada.equals("true")) {
				valorEstado=false;
			}
			else {
				valorEstado=true;
			}
			
			PreparedStatement prest = con.prepareStatement(Ssql);
        
			prest.setBoolean(1, valorEstado);
			prest.setString(2, Aula.getnAula());
			
        
			resultado = prest.executeUpdate();
			prest.close();
			
			
			st.close();	
			rs.close();
			con.close();
			}
		catch (SQLException sqle){
			sqle.printStackTrace();
			System.out.println("error");
		}
		
	}
	
	public boolean consultarAula() {
		// TODO Auto-generated method stub
		return false;
		
	}

	

}
