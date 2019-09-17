package Reto0;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

	private static Connection conectar;
	private Planta p;
	private static Aula a;
	static boolean fuego = false;

	// Conexion a la base de datos
	public static void conectarBD() {

		try {
			conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");

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
				if (Index.opSeleccionada.equals("Alarma")) {
					funcionamientoalarma();
				} else if (Index.opSeleccionada.equals("Calefacción")) {
					funcionamientocalefaccion();
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

	// Carga los datos de la aula seleccionada
	public static Aula cargarDatoAula(String cod) {

		try {
			conectarBD();
			Statement st = conectar.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM `aula` WHERE `nAula` = " + cod);

			// ArrayList<Aula> datosAulas = new ArrayList<>();

			while (rs.next()) {

				a.setnAula((int) rs.getObject("nAula"));
				a.setEstadoCalefaccion((int) rs.getObject("EstadoCalefaccion"));

			}

			st.close();
			rs.close();
			conectar.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		}

		return a;

	}

	// Actualiza el estado de la calefaccion o alarma de la aula seleccionada
	public void actualizarEstado(int nAula) {

		try {
			conectarBD();
			Statement st = conectar.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `aula` WHERE `nAula` = " + nAula);
			
			while (rs.next()) {
				a.setnAula((int) rs.getObject("nAula"));
				a.setEstadoCalefaccion((int) rs.getObject("EstadoCalefaccion"));
			}
			
			int valorEstado;
			if (a.getEstadoCalefaccion() == 1) {
				valorEstado = 0;
				String Ssql = "UPDATE `aula` SET `EstadoCalefaccion` = '" + valorEstado + "' WHERE `nAula` = " + nAula;
				st.execute(Ssql);
			} else if (a.getEstadoCalefaccion() == 0) {
				valorEstado = 1;
				String Ssql = "UPDATE `aula` SET `EstadoCalefaccion` = '" + valorEstado + "' WHERE `nAula` = " + nAula;
				st.execute(Ssql);
			}

			st.close();
			rs.close();
			conectar.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		}

	}

	// Asigna el nombre a los botones cogiendo el numero de aula de la base de datos
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
		} else if (Index.btnEspacio11.getText().isEmpty()) {
			Index.btnEspacio11.setText(Integer.toString(a.getnAula()));
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

	// Resetea todos los botones. Les activa, les quita el titulo y les pone el
	// fondo por defecto.
	private void resetearbotones() {
		Index.btnEspacio1.setEnabled(true);
		Index.btnEspacio1.setText("");
		Index.btnEspacio1.setBackground(null);

		Index.btnEspacio2.setEnabled(true);
		Index.btnEspacio2.setText("");
		Index.btnEspacio2.setBackground(null);

		Index.btnEspacio3.setEnabled(true);
		Index.btnEspacio3.setText("");
		Index.btnEspacio3.setBackground(null);

		Index.btnEspacio4.setEnabled(true);
		Index.btnEspacio4.setText("");
		Index.btnEspacio4.setBackground(null);

		Index.btnEspacio5.setEnabled(true);
		Index.btnEspacio5.setText("");
		Index.btnEspacio5.setBackground(null);

		Index.btnEspacio6.setEnabled(true);
		Index.btnEspacio6.setText("");
		Index.btnEspacio6.setBackground(null);

		Index.btnEspacio7.setEnabled(true);
		Index.btnEspacio7.setText("");
		Index.btnEspacio7.setBackground(null);

		Index.btnEspacio8.setEnabled(true);
		Index.btnEspacio8.setText("");
		Index.btnEspacio8.setBackground(null);

		Index.btnEspacio9.setEnabled(true);
		Index.btnEspacio9.setText("");
		Index.btnEspacio9.setBackground(null);

		Index.btnEspacio10.setEnabled(true);
		Index.btnEspacio10.setText("");
		Index.btnEspacio10.setBackground(null);

		Index.btnEspacio11.setEnabled(true);
		Index.btnEspacio11.setText("");
		Index.btnEspacio11.setBackground(null);

		Index.btnEspacio12.setEnabled(true);
		Index.btnEspacio12.setText("");
		Index.btnEspacio12.setBackground(null);

		Index.btnEspacio13.setEnabled(true);
		Index.btnEspacio13.setText("");
		Index.btnEspacio13.setBackground(null);

		Index.btnEspacio14.setEnabled(true);
		Index.btnEspacio14.setText("");
		Index.btnEspacio14.setBackground(null);

		Index.btnEspacio15.setEnabled(true);
		Index.btnEspacio15.setText("");
		Index.btnEspacio15.setBackground(null);

	}

	// Funcionamiento de la alarma
	private void funcionamientoalarma() {

		// Desactivar el funcionamiento de los botones
		Index.btnEspacio1.setEnabled(false);
		Index.btnEspacio2.setEnabled(false);
		Index.btnEspacio3.setEnabled(false);
		Index.btnEspacio4.setEnabled(false);
		Index.btnEspacio5.setEnabled(false);
		Index.btnEspacio6.setEnabled(false);
		Index.btnEspacio7.setEnabled(false);
		Index.btnEspacio8.setEnabled(false);
		Index.btnEspacio9.setEnabled(false);
		Index.btnEspacio10.setEnabled(false);
		Index.btnEspacio11.setEnabled(false);
		Index.btnEspacio12.setEnabled(false);
		Index.btnEspacio13.setEnabled(false);
		Index.btnEspacio14.setEnabled(false);
		Index.btnEspacio15.setEnabled(false);

		// Si el estado de la alarma es 0
		if (a.getEstadoAlarma() == 0) {
			// fuego pasa a true
			fuego = true;

			int rojooscuro = 100;
			botonesarojo(rojooscuro);
			

			// Si el estado de la alarma es 1
		} else if (a.getEstadoAlarma() == 1) {

			
			int verdeoscuro = 100;
			botonesaverde(verdeoscuro);
			
		}

	}
	
	public void funcionamientocalefaccion() {
		// Si el estado de la calefaccion es 0
				if (a.getEstadoCalefaccion() == 0) {
					int rojoclaro = 255;
					botonesarojo(rojoclaro);

					// Si el estado de la calefaccion es 1
				} else if (a.getEstadoCalefaccion() == 1) {
					int verdeclaro = 255;
					botonesaverde(verdeclaro);
				}
	}

	public void botonesarojo(int rojo) {
		// Si se trata del boton 1. Cambia el color del fondo a rojo
		if (Integer.toString(a.getnAula()).equals(Index.btnEspacio1.getText())) {
			Index.btnEspacio1.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 2. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio2.getText())) {
			Index.btnEspacio2.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 3. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio3.getText())) {
			Index.btnEspacio3.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 4. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio4.getText())) {
			Index.btnEspacio4.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 5. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio5.getText())) {
			Index.btnEspacio5.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 6. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio6.getText())) {
			Index.btnEspacio6.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 7. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio7.getText())) {
			Index.btnEspacio7.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 8. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio8.getText())) {
			Index.btnEspacio8.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 9. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio9.getText())) {
			Index.btnEspacio9.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 10. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio10.getText())) {
			Index.btnEspacio10.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 11. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio11.getText())) {
			Index.btnEspacio11.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 12. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio12.getText())) {
			Index.btnEspacio12.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 13. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio13.getText())) {
			Index.btnEspacio13.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 14. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio14.getText())) {
			Index.btnEspacio14.setBackground(new Color(rojo, 0, 0));

			// Si se trata del boton 15. Cambia el color del fondo a rojo
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio15.getText())) {
			Index.btnEspacio15.setBackground(new Color(rojo, 0, 0));
		}
	}
	
	public void botonesaverde(int verde) {
		// Si se trata del boton 1. Cambia el color del fondo a verde
		if (Integer.toString(a.getnAula()).equals(Index.btnEspacio1.getText())) {
			Index.btnEspacio1.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 2. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio2.getText())) {
			Index.btnEspacio2.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 3. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio3.getText())) {
			Index.btnEspacio3.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 4. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio4.getText())) {
			Index.btnEspacio4.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 5. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio5.getText())) {
			Index.btnEspacio5.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 6. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio6.getText())) {
			Index.btnEspacio6.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 7. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio7.getText())) {
			Index.btnEspacio7.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 8. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio8.getText())) {
			Index.btnEspacio8.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 9. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio9.getText())) {
			Index.btnEspacio9.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 10. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio10.getText())) {
			Index.btnEspacio10.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 11. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio11.getText())) {
			Index.btnEspacio11.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 12. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio12.getText())) {
			Index.btnEspacio12.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 13. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio13.getText())) {
			Index.btnEspacio13.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 14. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio14.getText())) {
			Index.btnEspacio14.setBackground(new Color(0, verde, 0));

			// Si se trata del boton 15. Cambia el color del fondo a verde
		} else if (Integer.toString(a.getnAula()).equals(Index.btnEspacio15.getText())) {
			Index.btnEspacio15.setBackground(new Color(0, verde, 0));
		}
	}

}
