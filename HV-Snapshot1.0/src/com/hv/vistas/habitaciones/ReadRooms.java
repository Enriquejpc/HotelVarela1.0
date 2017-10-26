package com.hv.vistas.habitaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class ReadRooms extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	final String[] Cabecera = { "Habitación", "Tipo", "Baño", "Precio",
			"Disponible" };
	static int precio = 0;

	/**
	 * Create the frame.
	 */
	public ReadRooms() {
		LlenarTabla();
		setTitle("Consultar Habitaciones");
		setBounds(120, 150, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/**
		 * Implementacion de tabla
		 */

		Object datos[][] = {
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" },
				{ new Integer(1), "Single", "Si", new Integer(450), "Si" } };
		/** Fin */
		table = new JTable(datos, Cabecera);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(datos, Cabecera));
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		table.setBounds(95, 94, 337, 107);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 38, 443, 199);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
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
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
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
}
