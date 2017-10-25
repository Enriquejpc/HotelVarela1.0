package com.hv.principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.hv.utilidades.Utilidades;
import com.hv.vistas.habitaciones.AddRooms;
import com.hv.vistas.habitaciones.ReadRooms;
import com.hv.vistas.huespedes.AddGuest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Principal {

	private JFrame frmHotelVarela;
	private JTextField txtUSD;
	private JTextField txtEUR;
	private JTextField txtSingle;
	private JTextField txtDouble;
	private JTextField txtDoubleB;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmHotelVarela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotelVarela = new JFrame();
		frmHotelVarela.setTitle("Hotel Varela");
		frmHotelVarela.setBounds(100, 100, 568, 415);
		frmHotelVarela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmHotelVarela.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {		
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		mnInicio.add(mntmSalir);
		
		JMenu mnHabitaciones = new JMenu("Habitaciones");
		menuBar.add(mnHabitaciones);
		
		JMenuItem mntmVerHabitaciones = new JMenuItem("Agregar Habitaci\u00F3n");
		mntmVerHabitaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				AddRooms roomFrame = new AddRooms();
				roomFrame.setVisible(true);				
			}
		});
		mnHabitaciones.add(mntmVerHabitaciones);
		
		JMenuItem mntmVerHabitaciones_1 = new JMenuItem("Ver Habitaciones");
		mntmVerHabitaciones_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ReadRooms ReadRoomsFrame = new ReadRooms();
				ReadRoomsFrame.setVisible(true);
			}
		});
		mnHabitaciones.add(mntmVerHabitaciones_1);
		
		JMenu mnReservas = new JMenu("Reservas");
		menuBar.add(mnReservas);
		
		JMenuItem mntmAadirReserva = new JMenuItem("A\u00F1adir Reserva");
		mnReservas.add(mntmAadirReserva);
		
		JMenuItem mntmConsultarReserva = new JMenuItem("Consultar Reserva");
		mnReservas.add(mntmConsultarReserva);
		
		JMenu mnHuspedes = new JMenu("Hu\u00E9spedes");
		menuBar.add(mnHuspedes);
		
		JMenuItem mntmAadir = new JMenuItem("Registrar");
		mntmAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Abrir frame de añadir");
				AddGuest frame = new AddGuest();
				frame.setVisible(true);
			}
		});
		mnHuspedes.add(mntmAadir);
		
		JMenu mnCuentas = new JMenu("Cuentas");
		menuBar.add(mnCuentas);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		frmHotelVarela.getContentPane().setLayout(null);
		
		JLabel lblbienvenido = new JLabel("\u00A1BIENVENIDO!");
		lblbienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbienvenido.setBounds(10, 4, 134, 22);
		frmHotelVarela.getContentPane().add(lblbienvenido);
		
		JLabel lblFecha = new JLabel(new Utilidades().getFchActual());
		lblFecha.setBounds(478, 11, 74, 14);
		frmHotelVarela.getContentPane().add(lblFecha);
		
		JLabel lblFecha_1 = new JLabel("Fecha");
		lblFecha_1.setBounds(433, 11, 46, 14);
		frmHotelVarela.getContentPane().add(lblFecha_1);
		
		JLabel lblTasaDeCambio = new JLabel("Tasa de Cambio (USD)");
		lblTasaDeCambio.setBounds(10, 65, 134, 14);
		frmHotelVarela.getContentPane().add(lblTasaDeCambio);
		
		JLabel lblTasaDeCambio_1 = new JLabel("Tasa de Cambio (EUR)");
		lblTasaDeCambio_1.setBounds(10, 90, 134, 14);
		frmHotelVarela.getContentPane().add(lblTasaDeCambio_1);
		
		JLabel lblPrecioHabitacinSingle = new JLabel("Precio habitaci\u00F3n Single");
		lblPrecioHabitacinSingle.setBounds(10, 153, 163, 14);
		frmHotelVarela.getContentPane().add(lblPrecioHabitacinSingle);
		
		JLabel lblPrecioHabitacinDoble = new JLabel("Precio habitaci\u00F3n doble s/Ba\u00F1o");
		lblPrecioHabitacinDoble.setBounds(10, 191, 186, 14);
		frmHotelVarela.getContentPane().add(lblPrecioHabitacinDoble);
		
		JLabel lblPrecioHabitacinDoble_1 = new JLabel("Precio habitaci\u00F3n doble c/Ba\u00F1o");
		lblPrecioHabitacinDoble_1.setBounds(10, 229, 186, 14);
		frmHotelVarela.getContentPane().add(lblPrecioHabitacinDoble_1);
		
		txtUSD = new JTextField();
		txtUSD.setBounds(206, 62, 86, 20);
		frmHotelVarela.getContentPane().add(txtUSD);
		txtUSD.setColumns(10);
		
		txtEUR = new JTextField();
		txtEUR.setBounds(206, 87, 86, 20);
		frmHotelVarela.getContentPane().add(txtEUR);
		txtEUR.setColumns(10);
		
		txtSingle = new JTextField();
		txtSingle.setBounds(206, 150, 86, 20);
		frmHotelVarela.getContentPane().add(txtSingle);
		txtSingle.setColumns(10);
		
		txtDouble = new JTextField();
		txtDouble.setBounds(206, 188, 86, 20);
		frmHotelVarela.getContentPane().add(txtDouble);
		txtDouble.setColumns(10);
		
		txtDoubleB = new JTextField();
		txtDoubleB.setBounds(206, 226, 86, 20);
		frmHotelVarela.getContentPane().add(txtDoubleB);
		txtDoubleB.setColumns(10);
		
		JLabel lblTasaDeCambio_2 = new JLabel("Tasa de Cambio (BRL)");
		lblTasaDeCambio_2.setBounds(10, 115, 150, 14);
		frmHotelVarela.getContentPane().add(lblTasaDeCambio_2);
		
		textField = new JTextField();
		textField.setBounds(206, 112, 86, 20);
		frmHotelVarela.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(336, 225, 89, 23);
		frmHotelVarela.getContentPane().add(btnGuardar);
	}
}
