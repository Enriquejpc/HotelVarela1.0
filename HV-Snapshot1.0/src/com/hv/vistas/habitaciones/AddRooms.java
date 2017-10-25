package com.hv.vistas.habitaciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddRooms extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddRooms() {
		setTitle("Registrar Habitaci\u00F3n");
		setBounds(120, 150, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNmeroDeHabitacin = new JLabel("N\u00FAmero de Habitaci\u00F3n");
		lblNmeroDeHabitacin.setBounds(25, 32, 121, 14);
		contentPane.add(lblNmeroDeHabitacin);
		
		textField = new JTextField();
		textField.setBounds(196, 29, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBao = new JLabel("Ba\u00F1o");
		lblBao.setBounds(25, 63, 46, 14);
		contentPane.add(lblBao);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 60, 46, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setBounds(25, 94, 66, 14);
		contentPane.add(lblUbicacin);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 91, 121, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(25, 130, 102, 14);
		contentPane.add(lblObservaciones);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(196, 122, 224, 68);
		contentPane.add(textPane);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(285, 256, 102, 23);
		contentPane.add(btnGuardar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(397, 256, 102, 23);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxDisponible = new JCheckBox("Disponible");
		chckbxDisponible.setSelected(true);
		chckbxDisponible.setBounds(397, 28, 97, 23);
		contentPane.add(chckbxDisponible);
	}
}
