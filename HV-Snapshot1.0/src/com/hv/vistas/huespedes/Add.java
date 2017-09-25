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

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField txtDocs;
	private JTextField txtEdad;
	private JTextField txtHab;
	private JTextField txtNb;
	private JTextField txtAp;
	private int limite  = 2;
	private JTextField textField;
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
		setTitle("Registrar Huesped");
		setBounds(120, 150, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setBounds(10, 11, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellido(s):");
		lblApellidos.setBounds(10, 44, 65, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblTipoDeDocumento = new JLabel("Documento(s): ");
		lblTipoDeDocumento.setBounds(10, 104, 102, 14);
		contentPane.add(lblTipoDeDocumento);
		
		JLabel lblNroDocumentos = new JLabel("Nro. Documento(s):");
		lblNroDocumentos.setBounds(10, 140, 116, 14);
		contentPane.add(lblNroDocumentos);
		
		JLabel lblEdades = new JLabel("Edad(es):");
		lblEdades.setBounds(10, 170, 57, 14);
		contentPane.add(lblEdades);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 207, 102, 14);
		contentPane.add(lblObservaciones);
		
		JTextArea txtObservaciones = new JTextArea();
		txtObservaciones.setText("Indicar");
		txtObservaciones.setBounds(122, 202, 234, 57);
		contentPane.add(txtObservaciones);
		
		txtDocs = new JTextField();
		txtDocs.setBounds(122, 137, 234, 20);
		contentPane.add(txtDocs);
		txtDocs.setColumns(10);
		
		final JCheckBox chckbxDni = new JCheckBox("DNI");
		chckbxDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			System.out.println(	chckbxDni.isSelected());
			}
		});
		chckbxDni.setBackground(Color.LIGHT_GRAY);
		chckbxDni.setBounds(121, 100, 50, 23);
		contentPane.add(chckbxDni);
		
		JCheckBox chckbxCedula = new JCheckBox("CEDULA");
		chckbxCedula.setBackground(Color.LIGHT_GRAY);
		chckbxCedula.setBounds(173, 100, 85, 23);
		contentPane.add(chckbxCedula);
		
		JCheckBox chckbxPasaporte = new JCheckBox("PASAPORTE");
		chckbxPasaporte.setBackground(Color.LIGHT_GRAY);
		chckbxPasaporte.setBounds(260, 100, 116, 23);
		contentPane.add(chckbxPasaporte);
		
		txtEdad = new JTextField();
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar());
				 char caracter = e.getKeyChar();
				
				if(txtEdad.getText().length()>=5 || ((caracter < '0') || (caracter > '9'))){
					e.consume();
				}
				if(txtEdad.getText().length()==2){
					txtEdad.setText( txtEdad.getText() + "."); 
				}
			}
		});
		txtEdad.setBounds(122, 167, 234, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblHabitacin = new JLabel("Habitaci\u00F3n");
		lblHabitacin.setBounds(366, 11, 65, 14);
		contentPane.add(lblHabitacin);
		
		txtHab = new JTextField();
		txtHab.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				 char caracter = k.getKeyChar();				 
			      // Verificar si la tecla pulsada no es un digito				 
			      if(((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) || (txtHab.getText().length() >= limite) )
			      {	    	 
			    	 k.consume();  // ignorar el evento de teclado
			      }
			}
		});
		txtHab.setBounds(441, 8, 39, 20);
		contentPane.add(txtHab);
		txtHab.setColumns(2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(291, 269, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			setVisible(false);
			}
		});
		btnCancelar.setBounds(390, 269, 89, 23);
		contentPane.add(btnCancelar);
		
		txtNb = new JTextField();
		txtNb.setBounds(122, 11, 234, 20);
		contentPane.add(txtNb);
		txtNb.setColumns(10);
		
		txtAp = new JTextField();
		txtAp.setBounds(122, 41, 234, 20);
		contentPane.add(txtAp);
		txtAp.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad(es):");
		lblNacionalidad.setBounds(10, 75, 102, 14);
		contentPane.add(lblNacionalidad);
		
		textField = new JTextField();
		textField.setBounds(122, 73, 234, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
