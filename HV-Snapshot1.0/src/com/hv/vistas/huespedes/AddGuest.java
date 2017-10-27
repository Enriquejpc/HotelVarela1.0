package com.hv.vistas.huespedes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.hv.modelo.HuespedesModel;
import com.hv.utilidades.Utilidades;

import java.io.*;
import java.util.ArrayList;
public class AddGuest extends JFrame {

	private JPanel contentPane;
	private JTextField txtDocs;
	private JTextField txtEdad;
	private JTextField txtHab;
	private JTextField txtNb;
	private JTextField txtCont;
	private int limite  = 2;
	private JTextField textOrigen;
	private JTextField txtNoches;
	private JTextField MontoTotal;
	String dni = "";
	String cedula = "";
	String pasaporte = "";
	String moneda = "";
	String observaciones = ""; 
	boolean exito = false;
	HuespedesModel huesped;
	ArrayList<HuespedesModel> aList = new ArrayList<HuespedesModel>();
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
	public AddGuest() {
		setTitle("Registrar Huesped");
		setBounds(420, 155, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setBounds(10, 11, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Contacto:");
		lblApellidos.setBounds(10, 244, 65, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblTipoDeDocumento = new JLabel("Documento(s): ");
		lblTipoDeDocumento.setBounds(10, 73, 102, 14);
		contentPane.add(lblTipoDeDocumento);
		
		JLabel lblNroDocumentos = new JLabel("Nro. Documento(s):");
		lblNroDocumentos.setBounds(10, 109, 116, 14);
		contentPane.add(lblNroDocumentos);
		
		JLabel lblEdades = new JLabel("Edad(es):");
		lblEdades.setBounds(10, 139, 57, 14);
		contentPane.add(lblEdades);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 176, 102, 14);
		contentPane.add(lblObservaciones);
		
		final JTextArea txtObservaciones = new JTextArea();
		txtObservaciones.setWrapStyleWord(true);
		txtObservaciones.setBackground(new Color(211, 211, 211));
		txtObservaciones.setLineWrap(true);
		txtObservaciones.setText("Indicar");
		txtObservaciones.setBounds(122, 171, 234, 57);
		contentPane.add(txtObservaciones);
		
		txtDocs = new JTextField();
		txtDocs.setBounds(122, 106, 234, 20);
		contentPane.add(txtDocs);
		txtDocs.setColumns(10);
		
		final JCheckBox chckbxDni = new JCheckBox("DNI");
		chckbxDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			if(	chckbxDni.isSelected())
				dni += "DNI";
			else
				dni = "";
			}
		});
		chckbxDni.setBackground(Color.WHITE);
		chckbxDni.setBounds(121, 69, 50, 23);
		contentPane.add(chckbxDni);
		
		final JCheckBox chckbxCedula = new JCheckBox("CEDULA");
		chckbxCedula.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(	chckbxCedula.isSelected())
					cedula += "CEDULA";
				else
					cedula = "";
				}
			}
		);
		chckbxCedula.setBackground(Color.WHITE);
		chckbxCedula.setBounds(173, 69, 85, 23);
		contentPane.add(chckbxCedula);
		
		final JCheckBox chckbxPasaporte = new JCheckBox("PASAPORTE");
		chckbxPasaporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(	chckbxPasaporte.isSelected())
					pasaporte += "PASAPORTE";
				else
					pasaporte = "";
			}
			
		});
		chckbxPasaporte.setBackground(Color.WHITE);
		chckbxPasaporte.setBounds(260, 69, 102, 23);
		contentPane.add(chckbxPasaporte);
		
		txtEdad = new JTextField();
		txtEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				 char caracter = e.getKeyChar();
				
				if(txtEdad.getText().length()>=5 || ((caracter < '0') || (caracter > '9'))){
					e.consume();
				}
				if(txtEdad.getText().length()==2){
					txtEdad.setText( txtEdad.getText() + "/"); 
				}
			}
		});
		txtEdad.setBounds(122, 136, 234, 20);
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
		
		
		
		txtNb = new JTextField();
		txtNb.setBounds(122, 11, 234, 20);
		contentPane.add(txtNb);
		txtNb.setColumns(10);
		
		txtCont = new JTextField();
		txtCont.setBounds(122, 241, 234, 20);
		contentPane.add(txtCont);
		txtCont.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad(es):");
		lblNacionalidad.setBounds(10, 44, 102, 14);
		contentPane.add(lblNacionalidad);
		
		textOrigen = new JTextField();
		textOrigen.setBounds(122, 42, 234, 20);
		contentPane.add(textOrigen);
		textOrigen.setColumns(10);
		
		JLabel lblNoches = new JLabel("Noches");
		lblNoches.setBounds(366, 44, 46, 14);
		contentPane.add(lblNoches);
		
		txtNoches = new JTextField();
		txtNoches.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent k) {
				char caracter = k.getKeyChar();				 
			      // Verificar si la tecla pulsada no es un digito				 
			      if(((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) || (txtNoches.getText().length() >= limite) )
			      {	    	 
			    	 k.consume();  // ignorar el evento de teclado
			      }
			}
		});
		txtNoches.setBounds(441, 41, 39, 20);
		contentPane.add(txtNoches);
		txtNoches.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(366, 244, 39, 14);
		contentPane.add(lblTotal);
		
		MontoTotal = new JTextField();
		MontoTotal.setBounds(415, 239, 86, 20);
		contentPane.add(MontoTotal);
		MontoTotal.setColumns(10);
		
		JLabel lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(366, 73, 46, 14);
		contentPane.add(lblMoneda);
		
		final JComboBox MoncomboBox = new JComboBox();
		MoncomboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		MoncomboBox.setModel(new DefaultComboBoxModel(new String[] {"ARS", "USD", "BRL"}));
		MoncomboBox.setBounds(441, 72, 58, 20);
		contentPane.add(MoncomboBox);
		
		JLabel lblTipoHabitacin = new JLabel("Tipo Habitaci\u00F3n");
		lblTipoHabitacin.setBounds(366, 154, 114, 14);
		contentPane.add(lblTipoHabitacin);
		
		JCheckBox chckbxSingle = new JCheckBox("Single");
		chckbxSingle.setBackground(Color.WHITE);
		chckbxSingle.setBounds(390, 170, 97, 19);
		contentPane.add(chckbxSingle);
		
		JCheckBox chckbxDoble = new JCheckBox("Doble s/Ba\u00F1o");
		chckbxDoble.setBackground(Color.WHITE);
		chckbxDoble.setBounds(390, 192, 111, 18);
		contentPane.add(chckbxDoble);
		
		JCheckBox chckbxDobleB = new JCheckBox("Doble c/Ba\u00F1o");
		chckbxDobleB.setBackground(Color.WHITE);
		chckbxDobleB.setBounds(390, 213, 111, 20);
		contentPane.add(chckbxDobleB);
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				observaciones = txtObservaciones.getText();	
				moneda = MoncomboBox.getSelectedItem().toString();
				if(	chckbxPasaporte.isSelected())
					pasaporte += "PASAPORTE";
				if(	chckbxDni.isSelected())
					dni += "DNI";
				if(	chckbxCedula.isSelected())
					cedula += "CEDULA";
				exito = RegistrarHuesped();	
				if(exito){
					MostrarAlerta(exito);
					txtNb.setText("");
					txtCont.setText("");
					textOrigen.setText("");
					chckbxDni.setSelected(false);
					chckbxCedula.setSelected(false);
					chckbxPasaporte.setSelected(false);
					txtDocs.setText("");
					txtEdad.setText("");
					txtObservaciones.setText("");
					txtNoches.setText("");
					MontoTotal.setText("");
				}else{
					MostrarAlerta(exito);					
					txtNb.setText("");
					txtCont.setText("");
					textOrigen.setText("");
					chckbxDni.setSelected(false);
					chckbxCedula.setSelected(false);
					chckbxPasaporte.setSelected(false);
					txtDocs.setText("");
					txtEdad.setText("");
					txtObservaciones.setText("");
					txtNoches.setText("");
					MontoTotal.setText("");
				}
				
			}
		});
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
	}
	
	public boolean RegistrarHuesped(){
		FileWriter fichero = null;
		FileWriter ficheroListado = null;
        PrintWriter pw = null;
        PrintWriter pwListado = null;
        boolean retorno = false;
        String linea = "";
        try
        {
        	String habitacion = txtHab.getText();
        	String nombre = txtNb.getText();
        	String documentos = txtDocs.getText();
        	if(habitacion.length()>1 || nombre.length()>1 ||  documentos.length()>1){
        	   fichero = new FileWriter("Archivos\\Hab"+habitacion+".txt");
        	   pw = new PrintWriter(fichero);
	           pw.println("Hospedados en la Habitación: "+habitacion);
	           pw.println("Nombres: "+(txtNb.getText()).toUpperCase());
	           pw.println("País: "+textOrigen.getText());
	           pw.println("Documento: "+dni + "/"+cedula+"/"+pasaporte);
	           pw.println("Numero de Documento: "+txtDocs.getText());
	           pw.println("Edad: "+txtEdad.getText());
	           pw.println("Fecha de Ingreso: "+new Utilidades().getFchActual());
	           pw.println("Noches: "+txtNoches.getText());
	           pw.println("Moneda de pago: "+moneda);
	           pw.println("Total a pagar: "+MontoTotal.getText());
	           pw.println("Contacto: "+(txtCont.getText()).toUpperCase());
	           pw.print("Observaciones: "+observaciones);
	           /*Escribo los datos en un archivo general que me servira para generar un listado de los huespedes**/
	           ficheroListado = new FileWriter("Archivos\\ListadoHuespedes.txt");
	           huesped = new HuespedesModel( habitacion,(txtNb.getText()).toUpperCase(),new Utilidades().getFchActual(),txtNoches.getText());
	           aList.add(huesped);	           
	           linea = habitacion+","+(txtNb.getText()).toUpperCase()+","+new Utilidades().getFchActual()+","+txtNoches.getText();
	           pwListado = new PrintWriter(ficheroListado);
	           pwListado.println(linea);
	           /*Fin**/
        	retorno = true;
        	}else{
        		retorno = false;
        	}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           	  ficheroListado.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        return retorno;
	}
	public void MostrarAlerta(boolean registro){
		if(registro)
			javax.swing.JOptionPane.showMessageDialog(this,"Registro Exitoso!");
		else
			javax.swing.JOptionPane.showMessageDialog(this,"Error!","Error",JOptionPane.ERROR_MESSAGE);
	}
}
