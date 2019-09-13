package Reto0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BD {

	private static Connection conectar;
	private Planta p;

	// Conexion a la base de datos
	public static void conectarBD() {

		try {
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			System.out.println("Base de datos conectada.");

		} catch (SQLException e) {
			System.out.println("Error al conectar");
			e.printStackTrace();
		}

	}

	// Carga los datos de la planta 
	public void cargarDatosPlanta(String pselec) {

		try {
			conectarBD();
			
			Statement st = conectar.createStatement();
			System.out.println(st.executeQuery("SELECT * FROM aula WHERE nPlanta='" + pselec + "' "));
			ResultSet rs = st.executeQuery("SELECT * FROM aula WHERE nPlanta='1'");
			while (rs.next()) {
				p = new Planta();
				p.getAulas().add(new Aula((String) rs.getObject("nAula"), (int) rs.getObject("EstadoAlarma"),
						(int) rs.getObject("EstadoCalefaccion")));

			}

			st.close();
			rs.close();
			conectar.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		}

	}

	// Carga los datos de la aula seleccionada
	public Aula cargarDatoAula(String cod) {

		try {
			conectarBD();
			Statement st = conectar.createStatement();

			ResultSet rs = st
					.executeQuery("SELECT nAula, EstadoAlarma, EstadoCalefaccion from aula where nAula='" + cod + "'");

			ArrayList<Aula> datosAulas = new ArrayList<>();

			while (rs.next()) {

				Aula da = new Aula();

				da.setnAula(rs.getString("nAula"));
				da.setEstadoAlarma(rs.getInt("EstadoAlarma"));
				da.setEstadoCalefaccion(rs.getInt("EstadoCalefaccion"));
				datosAulas.add(da);

			}

			st.close();
			rs.close();
			conectar.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		}

		return new Aula();

	}

	// Actualiza el estado de la calefaccion o alarma de la aula seleccionada
	public void actualizarEstado(String codAula, String opSeleccionada) {

		try {
			conectarBD();
			Statement st = conectar.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM aula");

			boolean valorEstado;

			if (opSeleccionada.equals("Alarma")) {
				if ((boolean) rs.getObject("EstadoAlarma")) {
					valorEstado = false;
					String Ssql = "UPDATE aula SET EstadoAlarma =" + valorEstado;
					st.execute(Ssql);
				} else if (!(boolean) rs.getObject("EstadoAlarma")) {
					valorEstado = true;
					String Ssql = "UPDATE aula SET EstadoAlarma =" + valorEstado;
					st.execute(Ssql);
				}
			} else if (opSeleccionada.equals("Calefaccion")) {
				if ((boolean) rs.getObject("EstadoCalefaccion")) {
					valorEstado = false;
					String Ssql = "UPDATE aula SET EstadoCalefaccion =" + valorEstado;
					st.execute(Ssql);
				} else if (!(boolean) rs.getObject("EstadoCalefaccion")) {
					valorEstado = true;
					String Ssql = "UPDATE aula SET EstadoCalefaccion =" + valorEstado;
					st.execute(Ssql);
				}
			}

			st.close();
			rs.close();
			conectar.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		}

	}

	public boolean consultarAula() {
		return false;

	}

}
