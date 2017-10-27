package com.hv.vistas.habitaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import com.hv.modelo.HabitacionesModel;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReadRooms extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	final String[] Cabecera = { "Habitación", "Tipo", "Baño", "Precio","Disponible" };
	static int precio = 0;
	static Object datos[][];
	static int CantidadRegistros = 0;
	HabitacionesModel habMod = new HabitacionesModel();
	private JButton btnDescargar;
	/**
	 * Create the frame.
	 */
	public ReadRooms() {
		NroRegistros();
		LlenarTabla();
		setTitle("Consultar Habitaciones");
		setBounds(420, 155, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/**
		 * Implementacion de tabla
		 */
		datos = new Object[CantidadRegistros][5];
		for(int i=0;i<CantidadRegistros;i++){
			datos[i][0]= habMod.NroHab[i];
			datos[i][1]= habMod.Tipo[i];
			datos[i][2]= habMod.Bath[i];
			datos[i][3]= habMod.Precio[i];
			datos[i][4]= habMod.Disponible[i];
		}
		
		/** Fin */
		table = new JTable(datos, Cabecera);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(datos, Cabecera));
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		table.setBounds(95, 94, 337, 107);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 44, 462, 223);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		JLabel lblListadoDeHabitaciones = new JLabel("Listado de Habitaciones");
		lblListadoDeHabitaciones.setBounds(20, 19, 131, 14);
		contentPane.add(lblListadoDeHabitaciones);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setVisible(false);
			}
		});
		btnCerrar.setBounds(398, 269, 89, 23);
		contentPane.add(btnCerrar);
		
		btnDescargar = new JButton("Descargar");
		btnDescargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DescargarListado();
			}
		});
		btnDescargar.setBounds(289, 269, 99, 23);
		contentPane.add(btnDescargar);
	}

	public void NroRegistros() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Archivos\\ListadoHabitaciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			String lineaAux;
			while ((linea = br.readLine()) != null){				
				CantidadRegistros++;
				}
			
			habMod.NroHab = new int [CantidadRegistros];
			habMod.Tipo = new String [CantidadRegistros];
			habMod.Bath = new String[CantidadRegistros]; 
			habMod.Precio = new double[CantidadRegistros]; 
			habMod.Disponible = new String[CantidadRegistros]; 		
			
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
	
	public void LlenarTabla() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Archivos\\ListadoHabitaciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String lineaAux;			
			int auxRegistros = 0;
			while ((lineaAux = br.readLine()) != null){				
				habMod.NroHab[auxRegistros] = Integer.parseInt(lineaAux.split(",")[0]);
				habMod.Tipo[auxRegistros] = lineaAux.split(",")[1];
				habMod.Bath[auxRegistros] = lineaAux.split(",")[2]; 
				habMod.Precio[auxRegistros] = Double.parseDouble(lineaAux.split(",")[3]);
				habMod.Disponible[auxRegistros] = lineaAux.split(",")[4];
				auxRegistros++;
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

	public void DescargarListado(){
		try {
			File inFile = new File("Archivos\\ListadoHabitaciones.txt");
			File outFile = new File("C:\7-Zip\\ListadoHabitaciones.txt");

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while ((c = in.read()) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch (IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}

	}
}
