package Reto0;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Index extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 464511367223122109L;
	private JPanel contentPane;
	
	//Panel principal
	private JPanel pnInicio;
	private JButton btnAlarma;
	private JButton btnCalefaccion;
	private JLabel lblInicio;
	
	//Panel Aulas 
	private JPanel pnMenuAulas;
	private JButton btnAtrasAulas;
	private JLabel lblOpcionElegidaAulas;
	private JLabel lblAulas;
	private JButton btnHomeMenuAulas;
	private JButton btnEspacio1;
	private JButton btnEspacio2;
	private JButton btnEspacio3;
	private JButton btnEspacio4;
	private JButton btnEspacio5;
	private JButton btnEspacio6;
	private JButton btnEspacio7;
	private JButton btnEspacio8;
	private JButton btnEspacio9;
	private JButton btnEspacio10;
	private JButton btnEspacio11;
	private JButton btnEspacio12;
	private JButton btnEspacio13;
	private JButton btnEspacio14;
	private JButton btnEspacio15;
	
	//Panel Plantas
	private JPanel pnMenuPlanta;
	private JLabel lblOpcionElegidaPlanta;
	private JButton btnPlanta1;
	private JButton btnPlanta2;
	private JButton btnPlanta3;
	private JPanel pnAula;
	private JLabel lblAulaSeleccionada;
	private JButton btnHomeAulaSeleccionada;
	private JButton btnHomePlantas;
	
	// Panel aula seleccionada
	private JButton btnAtrasAulaSeleccionada;
	private JLabel lblEstado;
	private JPanel pnSelecAula;
	private JButton btnCambiarEstado;
	
	//Variables necesarias
	private String opSeleccionada;
	
	// Base de datos
	private BD BBDD;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		
		configuracionInicio();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btnCalefaccion || o == btnAlarma) {
			opSeleccionada = (String)((JButton) o).getText();
			configuracionPlanta();
		}
		else if (o == btnHomeAulaSeleccionada || o == btnHomeMenuAulas || o == btnHomePlantas) {
			configuracionInicio();
		}
		else if(o ==btnPlanta1) {
			BBDD.cargarDatosPlanta("p1");
			configuracionMenuAulas();
		}
		else if(o ==btnPlanta2) {
			BBDD.cargarDatosPlanta("p2");
			configuracionMenuAulas();
		}
		else if(o ==btnPlanta3) {
			BBDD.cargarDatosPlanta("p3");
			configuracionMenuAulas();
		}
		else if (o == btnAtrasAulaSeleccionada) {
			configuracionAulasAtras();
		}
		else if(o == btnAtrasAulas) {
			configuracionPlanta();
		}
		else if(o == btnEspacio1 || o == btnEspacio2 || o == btnEspacio3 || o == btnEspacio4 
				|| o == btnEspacio5 || o == btnEspacio6 || o == btnEspacio7 || o == btnEspacio8
				|| o == btnEspacio9 || o == btnEspacio10 || o == btnEspacio11 || o == btnEspacio12
				|| o == btnEspacio13 || o == btnEspacio14 || o == btnEspacio15) {
			configuracionAula((String)((JButton)o).getText());
		}
		
	}


	private void configuracionInicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ik_2dm3\\Desktop\\Proyecto 0\\logo.png"));
		setTitle("FP Txurdinaga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 431);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnMenuAulas = new JPanel();
		pnMenuAulas.setVisible(false);
		
		pnMenuPlanta = new JPanel();
		pnMenuPlanta.setVisible(false);
		
		pnInicio = new JPanel();
		pnInicio.setVisible(true);
		pnInicio.setBounds(5, 5, 248, 376);
		contentPane.add(pnInicio);
		pnInicio.setLayout(null);
		
		btnAlarma = new JButton("Alarma");
		btnAlarma.setBackground(new Color(135, 206, 250));
		btnAlarma.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnAlarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlarma.setBounds(28, 114, 198, 68);
		pnInicio.add(btnAlarma);
		
		btnCalefaccion = new JButton("Calefacci\u00F3n");
		btnCalefaccion.setBackground(new Color(0, 255, 127));
		btnCalefaccion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCalefaccion.setBounds(28, 234, 198, 68);
		pnInicio.add(btnCalefaccion);
		
		lblInicio = new JLabel("Inicio");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblInicio.setBounds(28, 11, 198, 56);
		pnInicio.add(lblInicio);
		pnMenuPlanta.setBounds(0, 0, 258, 392);
		contentPane.add(pnMenuPlanta);
		pnMenuPlanta.setLayout(null);
		
		lblOpcionElegidaPlanta = new JLabel("Alarma");
		lblOpcionElegidaPlanta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblOpcionElegidaPlanta.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionElegidaPlanta.setBounds(39, 30, 161, 35);
		pnMenuPlanta.add(lblOpcionElegidaPlanta);
		
		btnPlanta1 = new JButton("Planta 1");
		btnPlanta1.setBackground(new Color(255, 0, 0));
		btnPlanta1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPlanta1.setBounds(39, 116, 190, 59);
		pnMenuPlanta.add(btnPlanta1);
		
		btnPlanta2 = new JButton("Planta 2");
		btnPlanta2.setBackground(new Color(138, 43, 226));
		btnPlanta2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPlanta2.setBounds(39, 192, 190, 59);
		pnMenuPlanta.add(btnPlanta2);
		
		btnPlanta3 = new JButton("Planta 3");
		btnPlanta3.setBackground(new Color(34, 139, 34));
		btnPlanta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlanta3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPlanta3.setBounds(39, 262, 190, 59);
		pnMenuPlanta.add(btnPlanta3);
		
		btnHomePlantas = new JButton("");
		btnHomePlantas.setIcon(new ImageIcon(Index.class.getResource("/Imagenes/home.png")));
		btnHomePlantas.setBorder(null);
		btnHomePlantas.setBackground(SystemColor.menu);
		btnHomePlantas.setBounds(10, 11, 39, 39);
		pnMenuPlanta.add(btnHomePlantas);
		pnMenuAulas.setBounds(0, 0, 258, 392);
		contentPane.add(pnMenuAulas);
		pnMenuAulas.setLayout(null);
		
		btnAtrasAulas = new JButton("");
		btnAtrasAulas.setBorder(null);
		btnAtrasAulas.setBackground(new Color(240,240,240));
		btnAtrasAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtrasAulas.setIcon(new ImageIcon(Index.class.getResource("/Imagenes/Atras.png")));
		btnAtrasAulas.setBounds(209, 11, 39, 39);
		pnMenuAulas.add(btnAtrasAulas);
		
		lblOpcionElegidaAulas = new JLabel("Alarma");
		lblOpcionElegidaAulas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblOpcionElegidaAulas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionElegidaAulas.setBounds(34, 11, 165, 39);
		pnMenuAulas.add(lblOpcionElegidaAulas);
		
		lblAulas = new JLabel("Aulas");
		lblAulas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAulas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAulas.setBounds(100, 58, 46, 14);
		pnMenuAulas.add(lblAulas);
		
		pnSelecAula = new JPanel();
		pnSelecAula.setVisible(false);
		pnSelecAula.setBounds(5, 81, 248, 300);
		pnMenuAulas.add(pnSelecAula);
		pnSelecAula.setLayout(null);
		
		btnEspacio1 = new JButton("Aula 101");
		btnEspacio1.setBounds(0, 0, 75, 50);
		pnSelecAula.add(btnEspacio1);
		
		btnEspacio2 = new JButton("Aula 101");
		btnEspacio2.setBounds(85, 0, 75, 50);
		pnSelecAula.add(btnEspacio2);
		
		btnEspacio3 = new JButton("Aula 101");
		btnEspacio3.setBounds(170, 0, 75, 50);
		pnSelecAula.add(btnEspacio3);
		
		btnEspacio4 = new JButton("Aula 101");
		btnEspacio4.setBounds(0, 64, 75, 50);
		pnSelecAula.add(btnEspacio4);
		
		btnEspacio5 = new JButton("Aula 101");
		btnEspacio5.setBounds(85, 64, 75, 50);
		pnSelecAula.add(btnEspacio5);
		
		btnEspacio6 = new JButton("Aula 101");
		btnEspacio6.setBounds(170, 64, 75, 50);
		pnSelecAula.add(btnEspacio6);
		
		btnEspacio7 = new JButton("Aula 101");
		btnEspacio7.setBounds(0, 125, 75, 50);
		pnSelecAula.add(btnEspacio7);
		
		btnEspacio8 = new JButton("Aula 101");
		btnEspacio8.setBounds(85, 125, 75, 50);
		pnSelecAula.add(btnEspacio8);
		
		btnEspacio9 = new JButton("Aula 101");
		btnEspacio9.setBounds(170, 125, 75, 50);
		pnSelecAula.add(btnEspacio9);
		
		btnEspacio10 = new JButton("Aula 101");
		btnEspacio10.setBounds(0, 186, 75, 50);
		pnSelecAula.add(btnEspacio10);
		
		btnEspacio11 = new JButton("Aula 101");
		btnEspacio11.setBounds(85, 186, 75, 50);
		pnSelecAula.add(btnEspacio11);
		
		btnEspacio12 = new JButton("Aula 101");
		btnEspacio12.setBounds(170, 186, 75, 50);
		pnSelecAula.add(btnEspacio12);
		
		btnEspacio13 = new JButton("Aula 101");
		btnEspacio13.setBounds(0, 250, 75, 50);
		pnSelecAula.add(btnEspacio13);
		
		btnEspacio14 = new JButton("Aula 101");
		btnEspacio14.setBounds(85, 250, 75, 50);
		pnSelecAula.add(btnEspacio14);
		
		btnEspacio15 = new JButton("Aula 101");
		btnEspacio15.setBounds(170, 250, 75, 50);
		pnSelecAula.add(btnEspacio15);
		
		btnHomeMenuAulas = new JButton("");
		btnHomeMenuAulas.setIcon(new ImageIcon(Index.class.getResource("/Imagenes/home.png")));
		btnHomeMenuAulas.setBorder(null);
		btnHomeMenuAulas.setBackground(SystemColor.menu);
		btnHomeMenuAulas.setBounds(5, 11, 39, 39);
		pnMenuAulas.add(btnHomeMenuAulas);
		
		pnAula = new JPanel();
		pnAula.setVisible(false);
		pnAula.setBounds(0, 0, 258, 392);
		contentPane.add(pnAula);
		pnAula.setLayout(null);
		
		lblAulaSeleccionada = new JLabel("Aula 101");
		lblAulaSeleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		lblAulaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblAulaSeleccionada.setBounds(10, 68, 238, 73);
		pnAula.add(lblAulaSeleccionada);
		
		btnAtrasAulaSeleccionada = new JButton("");
		btnAtrasAulaSeleccionada.setBorder(null);
		btnAtrasAulaSeleccionada.setIcon(new ImageIcon(Index.class.getResource("/Imagenes/Atras.png")));
		btnAtrasAulaSeleccionada.setBackground(SystemColor.menu);
		btnAtrasAulaSeleccionada.setBounds(209, 11, 39, 39);
		pnAula.add(btnAtrasAulaSeleccionada);
		
		lblEstado = new JLabel("");
		lblEstado.setOpaque(true);
		lblEstado.setBackground(Color.CYAN);
		lblEstado.setBounds(54, 152, 155, 73);
		pnAula.add(lblEstado);
		
		btnHomeAulaSeleccionada = new JButton("");
		btnHomeAulaSeleccionada.setBorder(null);
		btnHomeAulaSeleccionada.setIcon(new ImageIcon(Index.class.getResource("/Imagenes/home.png")));
		btnHomeAulaSeleccionada.setBackground(SystemColor.menu);
		btnHomeAulaSeleccionada.setBounds(10, 11, 39, 39);
		pnAula.add(btnHomeAulaSeleccionada);
		
		btnCambiarEstado = new JButton("On");
		btnCambiarEstado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCambiarEstado.setBounds(54, 248, 155, 39);
		pnAula.add(btnCambiarEstado);
		
	}
	
	private void configuracionPlanta() {
		pnInicio.setVisible(false);
		pnMenuPlanta.setVisible(true);
		lblOpcionElegidaPlanta.setText(opSeleccionada);
		pnMenuAulas.setVisible(false);
		pnAula.setVisible(false);	
	}
	
	private void configuracionMenuAulas() {
		pnInicio.setVisible(false);
		pnMenuPlanta.setVisible(false);
		pnMenuAulas.setVisible(true);
		lblOpcionElegidaAulas.setText(opSeleccionada);
		pnAula.setVisible(false);
	}
	
	private void configuracionAulasAtras() {
		pnInicio.setVisible(false);
		pnMenuPlanta.setVisible(false);
		pnMenuAulas.setVisible(true);
		pnAula.setVisible(false);
	}
	
	private void configuracionAula(String cod) {
		BBDD.cargarDatoAula(cod);
		
	}
}
