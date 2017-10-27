package com.hv.vistas.huespedes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

public class ReadGuest extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	final String[] Cabecera = { "Habitación", "Datos del Huesped", "Fecha de Ingreso", "Noches" };
	

	/**
	 * Create the frame.
	 */
	public ReadGuest() {
		setTitle("Consultar Huespedes");
		setBounds(120, 150, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		/**
		 * Implementar Datos Tabla*/
		Object datos[][] = {
				{ new Integer(1), "Single", "Si", new Integer(450) }};
		/**Fin Implementar Datos Tabla*/
		table = new JTable(datos, Cabecera);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(datos, Cabecera));
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,null, null));
		table.setBounds(95, 94, 337, 107);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 38, 479, 199);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
	}

}
