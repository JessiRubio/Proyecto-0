package Reto0;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BD {

	private static Connection conectar;
	private Planta p;
	private Aula a;

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

			resetearbotones();
			
			Statement st = conectar.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM aula WHERE nPlanta='" + pselec + "'");

			while (rs.next()) {
				p = new Planta((String) rs.getObject("nPlanta"));
				a = new Aula((int) rs.getObject("nAula"), (int) rs.getObject("EstadoAlarma"),
						(int) rs.getObject("EstadoCalefaccion"));
				p.getAulas().add(a);

				// PONER EL NOMBRE A LOS BOTONES
				nombrebotones();
				
				// PONER EL BOTON EN ROJO SI EL ESTADO DE LA ALARMA ES 0
				// FALTA EVITAR QUE LO PONGA EN ROJO CUANDO ESTAS EN EL MENU DE CALEFACCION
				if (Index.opSeleccionada.equals("Alarma")) {
					funcionamientoalarma();
				}
				
				System.out.println(p.toString());

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

			ResultSet rs = st.executeQuery("SELECT nAula, EstadoAlarma, EstadoCalefaccion FROM aula WHERE nAula='101'");// "
																														// +
																														// cod
																														// +
																														// "'");

			ArrayList<Aula> datosAulas = new ArrayList<>();

			while (rs.next()) {

				Aula da = new Aula();

				da.setnAula(rs.getInt("nAula"));
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

	public void nombrebotones() {
		if (Index.btnEspacio1.getText().isEmpty()) {
			Index.btnEspacio1.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio2.getText().isEmpty()) {
			Index.btnEspacio2.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio3.getText().isEmpty()) {
			Index.btnEspacio3.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio4.getText().isEmpty()) {
			Index.btnEspacio4.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio5.getText().isEmpty()) {
			Index.btnEspacio5.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio6.getText().isEmpty()) {
			Index.btnEspacio6.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio7.getText().isEmpty()) {
			Index.btnEspacio7.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio8.getText().isEmpty()) {
			Index.btnEspacio8.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio9.getText().isEmpty()) {
			Index.btnEspacio9.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio10.getText().isEmpty()) {
			Index.btnEspacio10.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio12.getText().isEmpty()) {
			Index.btnEspacio12.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio13.getText().isEmpty()) {
			Index.btnEspacio13.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio14.getText().isEmpty()) {
			Index.btnEspacio14.setText(Integer.toString(a.getnAula()));
		} else if (Index.btnEspacio15.getText().isEmpty()) {
			Index.btnEspacio15.setText(Integer.toString(a.getnAula()));
		}
	}
	
	private void resetearbotones() {
		Index.btnEspacio1.setText("");
		Index.btnEspacio1.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio2.setText("");
		Index.btnEspacio2.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio3.setText("");
		Index.btnEspacio3.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio4.setText("");
		Index.btnEspacio4.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio5.setText("");
		Index.btnEspacio5.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio6.setText("");
		Index.btnEspacio6.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio7.setText("");
		Index.btnEspacio7.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio8.setText("");
		Index.btnEspacio8.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio9.setText("");
		Index.btnEspacio9.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio10.setText("");
		Index.btnEspacio10.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio11.setText("");
		Index.btnEspacio11.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio12.setText("");
		Index.btnEspacio12.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio13.setText("");
		Index.btnEspacio13.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio14.setText("");
		Index.btnEspacio14.setBackground(new Color(170, 250, 75, 50));
		Index.btnEspacio15.setText("");
		Index.btnEspacio15.setBounds(170, 250, 75, 50);
	}
	
	private void funcionamientoalarma() {
		if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio1.getText())) {
			Index.btnEspacio1.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio2.getText())) {
			Index.btnEspacio2.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio3.getText())) {
			Index.btnEspacio3.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio4.getText())) {
			Index.btnEspacio4.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio5.getText())) {
			Index.btnEspacio5.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio6.getText())) {
			Index.btnEspacio6.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio7.getText())) {
			Index.btnEspacio7.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio8.getText())) {
			Index.btnEspacio8.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio9.getText())) {
			Index.btnEspacio9.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio10.getText())) {
			Index.btnEspacio10.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio11.getText())) {
			Index.btnEspacio11.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio12.getText())) {
			Index.btnEspacio12.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio13.getText())) {
			Index.btnEspacio13.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio14.getText())) {
			Index.btnEspacio14.setBackground(new Color(255, 0, 0));
		} else if (a.getEstadoAlarma()==0 && Integer.toString(a.getnAula()).equals(Index.btnEspacio15.getText())) {
			Index.btnEspacio15.setBackground(new Color(255, 0, 0));
		} 
	}

	
	public boolean consultarAula() {
		return false;

	}

}
