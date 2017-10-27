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
import com.hv.vistas.huespedes.ReadGuest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.Color;

public class Principal {

	private JFrame frmHotelVarela;
	private JTextField txtUSD;
	private JTextField txtEUR;
	private JTextField txtSingle;
	private JTextField txtDouble;
	private JTextField txtDoubleB;
	private JTextField textFieldBRL;
	String[] parametros = new String[100];
	int cantParametros = 0;
	public static String[] codigoParametro;
	public static double[] valorParametro;
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
		LlenarParametros();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotelVarela = new JFrame();
		frmHotelVarela.getContentPane().setForeground(Color.WHITE);
		frmHotelVarela.setTitle("Hotel Varela");
		frmHotelVarela.setBounds(400, 150, 568, 415);
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
				
				AddGuest frame = new AddGuest();
				frame.setVisible(true);
			}
		});
		mnHuspedes.add(mntmAadir);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ReadGuest frame = new ReadGuest();
				frame.setVisible(true);
			}
		});
		mnHuspedes.add(mntmBuscar);

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

		JLabel lblPrecioHabitacinSingle = new JLabel(
				"Precio habitaci\u00F3n Single");
		lblPrecioHabitacinSingle.setBounds(10, 153, 163, 14);
		frmHotelVarela.getContentPane().add(lblPrecioHabitacinSingle);

		JLabel lblPrecioHabitacinDoble = new JLabel(
				"Precio habitaci\u00F3n doble s/Ba\u00F1o");
		lblPrecioHabitacinDoble.setBounds(10, 191, 186, 14);
		frmHotelVarela.getContentPane().add(lblPrecioHabitacinDoble);

		JLabel lblPrecioHabitacinDoble_1 = new JLabel(
				"Precio habitaci\u00F3n doble c/Ba\u00F1o");
		lblPrecioHabitacinDoble_1.setBounds(10, 229, 186, 14);
		frmHotelVarela.getContentPane().add(lblPrecioHabitacinDoble_1);

		txtUSD = new JTextField();
		txtUSD.setEditable(false);
		txtUSD.setBounds(206, 62, 86, 20);
		frmHotelVarela.getContentPane().add(txtUSD);
		txtUSD.setColumns(10);

		txtEUR = new JTextField();
		txtEUR.setEditable(false);
		txtEUR.setBounds(206, 87, 86, 20);
		frmHotelVarela.getContentPane().add(txtEUR);
		txtEUR.setColumns(10);

		txtSingle = new JTextField();
		txtSingle.setEditable(false);
		txtSingle.setBounds(206, 150, 86, 20);
		frmHotelVarela.getContentPane().add(txtSingle);
		txtSingle.setColumns(10);

		txtDouble = new JTextField();
		txtDouble.setEditable(false);
		txtDouble.setBounds(206, 188, 86, 20);
		frmHotelVarela.getContentPane().add(txtDouble);
		txtDouble.setColumns(10);

		txtDoubleB = new JTextField();
		txtDoubleB.setEditable(false);
		txtDoubleB.setBounds(206, 226, 86, 20);
		frmHotelVarela.getContentPane().add(txtDoubleB);
		txtDoubleB.setColumns(10);

		JLabel lblTasaDeCambio_2 = new JLabel("Tasa de Cambio (BRL)");
		lblTasaDeCambio_2.setBounds(10, 115, 150, 14);
		frmHotelVarela.getContentPane().add(lblTasaDeCambio_2);

		textFieldBRL = new JTextField();
		textFieldBRL.setEditable(false);
		textFieldBRL.setBounds(206, 112, 86, 20);
		frmHotelVarela.getContentPane().add(textFieldBRL);
		textFieldBRL.setColumns(10);
		
		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtUSD.setEditable(false);				
				txtEUR.setEditable(false);
				textFieldBRL.setEditable(false);
				txtSingle.setEditable(false);
				txtDouble.setEditable(false);
				txtDoubleB.setEditable(false);
				GuardarValores();
			}
		});
		btnGuardar.setBounds(453, 302, 89, 23);
		frmHotelVarela.getContentPane().add(btnGuardar);
		
		JButton btnActivar = new JButton("Editar");
		btnActivar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				txtUSD.setEditable(true);
				btnGuardar.setEnabled( true);
			}
		});
		btnActivar.setBounds(303, 61, 74, 23);
		frmHotelVarela.getContentPane().add(btnActivar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtEUR.setEditable(true);
				btnGuardar.setEnabled( true);
			}
		});
		btnEditar.setBounds(302, 86, 76, 23);
		frmHotelVarela.getContentPane().add(btnEditar);
		
		JButton btnEditBRL = new JButton("Editar");
		btnEditBRL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textFieldBRL.setEditable(true);
				btnGuardar.setEnabled( true);
			}
		});
		btnEditBRL.setBounds(302, 111, 76, 23);
		frmHotelVarela.getContentPane().add(btnEditBRL);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtSingle.setEditable(true);
				btnGuardar.setEnabled( true);
			}
		});
		btnEditar_1.setBounds(302, 149, 76, 23);
		frmHotelVarela.getContentPane().add(btnEditar_1);
		
		JButton btnEditar_2 = new JButton("Editar");
		btnEditar_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtDouble.setEditable(true);
				btnGuardar.setEnabled( true);
			}
		});
		btnEditar_2.setBounds(302, 187, 75, 23);
		frmHotelVarela.getContentPane().add(btnEditar_2);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtDoubleB.setEditable(true);
				btnGuardar.setEnabled( true);
			}
		});
		btnNewButton.setBounds(302, 225, 75, 23);
		frmHotelVarela.getContentPane().add(btnNewButton);
	}

	/*
	 * parametros codigo,valor 
	 * usd,17.50 
	 * eur,20.53 
	 * brl,5.37 
	 * s,450 -> Single
	 * dsb,550 -> Doble sin baño
	 * dcb,800 -> Doble con baño*
	 */

	public void LlenarParametros() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Archivos\\Parametros.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {				
				parametros[cantParametros] = linea;
				cantParametros++;
			}
			codigoParametro = new String[cantParametros];
			valorParametro = new double[cantParametros];
			
			for(int i=0;i<cantParametros;i++){
				codigoParametro[i] = parametros[i].split(",")[0];
				if(codigoParametro[i].equalsIgnoreCase("usd")){
				valorParametro[i]  = Double.parseDouble(  parametros[i].split(",")[1]);
				txtUSD.setText(String.valueOf( valorParametro[i]));
				}
				if(codigoParametro[i].equalsIgnoreCase("eur")){
					valorParametro[i]  = Double.parseDouble(  parametros[i].split(",")[1]);
					txtEUR.setText(String.valueOf( valorParametro[i]));
					}
				if(codigoParametro[i].equalsIgnoreCase("brl")){
					valorParametro[i]  = Double.parseDouble(  parametros[i].split(",")[1]);
					textFieldBRL.setText(String.valueOf( valorParametro[i]));
					}
				if(codigoParametro[i].equalsIgnoreCase("s")){
					valorParametro[i]  = Double.parseDouble(  parametros[i].split(",")[1]);
					txtSingle.setText(String.valueOf( valorParametro[i]));
					}
				if(codigoParametro[i].equalsIgnoreCase("dsb")){
					valorParametro[i]  = Double.parseDouble(  parametros[i].split(",")[1]);
					txtDouble.setText(String.valueOf( valorParametro[i]));
					}
				if(codigoParametro[i].equalsIgnoreCase("dcb")){
					valorParametro[i]  = Double.parseDouble(  parametros[i].split(",")[1]);
					txtDoubleB.setText(String.valueOf( valorParametro[i]));
					}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	public void GuardarValores(){
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Archivos\\Parametros.txt");
            pw = new PrintWriter(fichero);

           pw.println("usd,"+txtUSD.getText());
           pw.println("eur,"+txtEUR.getText());
           pw.println("brl,"+textFieldBRL.getText());
           pw.println("s,"+txtSingle.getText());
           pw.println("dsb,"+txtDouble.getText());
           pw.print("dcb,"+txtDoubleB.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
}
