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
	private Planta p;
	
	public static void conectarBD() {
		
		
		try {
			 conectar = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			System.out.println("Base de datos conectada.");
			
			
		} catch (SQLException e) {
			System.out.println("Error al conectar");
			e.printStackTrace();
		}
		
	} 
	
	public void cargarDatosPlanta(String pselec) {
		// TODO Auto-generated method stub
		
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/reto0"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "");
			Statement st = con.createStatement();	
			
			ResultSet rs = st.executeQuery("SELECT * FROM aula WHERE nplanta='"+ pselec +"' ");
			
			while (rs.next()){ 
	 
				p.getAulas().add(new Aula((String)rs.getObject("nAula"),(boolean)rs.getObject("EstadoAlarma"),(boolean)rs.getObject("EstadoCalefaccion")));
				
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

	public Aula cargarDatoAula(String cod) {
		// TODO Auto-generated method stub

		
		try{
			conectarBD();
			Statement st = conectar.createStatement();	
			
			ResultSet rs = st.executeQuery("SELECT nAula, EstadoAlarma, EstadoCalefaccion from aula where nAula='"+cod+"'");
			
			ArrayList<Aula> datosAulas=new ArrayList<>();
			
			while (rs.next()){ 
				
				Aula da =new Aula();
			
				da.setnAula(rs.getString("nAula"));
				da.setEstadoAlarma(rs.getBoolean("EstadoAlarma")); 
				da.setEstadoCalefaccion(rs.getBoolean("EstadoCalefaccion"));
				datosAulas.add(da);
				
				}
			
			st.close();	
			rs.close();
			conectar.close();
			
			}
		catch (SQLException sqle){
			sqle.printStackTrace();
			System.out.println("error");
		}

		return new Aula();

	}

	public void actualizarEstado(String codAula, String opSeleccionada) {
		
		try{
			conectarBD();
			Statement st = conectar.createStatement();		
			
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
			
			PreparedStatement prest = conectar.prepareStatement(Ssql);
        
			prest.setBoolean(1, valorEstado);
			prest.setString(2, Aula.getnAula());
			
        
			resultado = prest.executeUpdate();
			prest.close();
			
			
			st.close();	
			rs.close();
			conectar.close();
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
