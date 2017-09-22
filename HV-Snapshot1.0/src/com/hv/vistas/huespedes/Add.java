package com.hv.vistas.huespedes;

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

public class Add extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Add frame = new Add();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Add() {
		setBounds(120, 150, 505, 321);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblAadirHuesped = new JLabel("A\u00F1adir Huesped");
		lblAadirHuesped.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAadirHuesped.setBounds(155, 11, 103, 14);
		contentPane.add(lblAadirHuesped);
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setBounds(10, 36, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellido(s):");
		lblApellidos.setBounds(10, 69, 65, 14);
		contentPane.add(lblApellidos);
		
		JTextPane txtpnIntroduzcaNombre = new JTextPane();
		txtpnIntroduzcaNombre.setText("Introduzca nombre");
		txtpnIntroduzcaNombre.setBounds(102, 36, 208, 22);
		contentPane.add(txtpnIntroduzcaNombre);
		
		JLabel lblTipoDeDocumento = new JLabel("Documento(s): ");
		lblTipoDeDocumento.setBounds(10, 104, 82, 14);
		contentPane.add(lblTipoDeDocumento);
		
		JLabel lblNroDocumentos = new JLabel("Nro. Documento(s):");
		lblNroDocumentos.setBounds(10, 140, 103, 14);
		contentPane.add(lblNroDocumentos);
		
		JLabel lblEdades = new JLabel("Edad(es):");
		lblEdades.setBounds(10, 170, 57, 14);
		contentPane.add(lblEdades);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 207, 82, 14);
		contentPane.add(lblObservaciones);
		
		JTextArea txtrIndicar = new JTextArea();
		txtrIndicar.setText("Indicar");
		txtrIndicar.setBounds(102, 202, 251, 57);
		contentPane.add(txtrIndicar);
	}
}
