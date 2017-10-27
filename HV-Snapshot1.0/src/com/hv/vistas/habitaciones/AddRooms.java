package com.hv.vistas.habitaciones;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.hv.modelo.HabitacionesModel;

public class AddRooms extends JFrame {

	private JPanel contentPane;
	private JTextField txtHab;
	private JTextField txtPrecio;
	String tipoHab = "";
	String piso = "";
	String bath = "";
	String disponible = "";
	public HabitacionesModel modelHab = new HabitacionesModel();
	int cantidadRegistros = 0;
	boolean exito = false;
	/**
	 * Create the frame.
	 */
	public AddRooms() {

		cantidadRegistros = NrodeHabitaciones();
		modelHab.NroHab = new int[cantidadRegistros];
		modelHab.Tipo = new String[cantidadRegistros];
		modelHab.Bath = new String[cantidadRegistros];
		modelHab.Precio = new double[cantidadRegistros];
		modelHab.Disponible = new String[cantidadRegistros];
		CargarDatosHab();

		setTitle("Registrar Habitaci\u00F3n");
		setBounds(420, 155, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNmeroDeHabitacin = new JLabel(
				"N\u00FAmero de Habitaci\u00F3n");
		lblNmeroDeHabitacin.setBounds(25, 32, 138, 14);
		contentPane.add(lblNmeroDeHabitacin);

		txtHab = new JTextField();
		txtHab.setBounds(196, 29, 86, 20);
		contentPane.add(txtHab);
		txtHab.setColumns(10);

		JLabel lblBao = new JLabel("Ba\u00F1o");
		lblBao.setBounds(25, 111, 46, 14);
		contentPane.add(lblBao);

		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setBounds(25, 136, 66, 14);
		contentPane.add(lblUbicacin);

		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(26, 164, 102, 14);
		contentPane.add(lblObservaciones);

		JTextPane txtpnObservaciones = new JTextPane();
		txtpnObservaciones.setText("Observaciones");
		txtpnObservaciones.setBackground(Color.LIGHT_GRAY);
		txtpnObservaciones.setBounds(196, 164, 224, 68);
		contentPane.add(txtpnObservaciones);

		final JCheckBox checkDisponibilidad = new JCheckBox("Disponible");
		checkDisponibilidad.setSelected(true);
		checkDisponibilidad.setBounds(397, 28, 97, 23);
		contentPane.add(checkDisponibilidad);

		final JComboBox comboBath = new JComboBox();
		comboBath
				.setModel(new DefaultComboBoxModel(new String[] { "Si", "No" }));
		comboBath.setBounds(197, 108, 85, 20);
		contentPane.add(comboBath);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(25, 82, 46, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(196, 79, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblTipoDeHabitacin = new JLabel("Tipo de Habitaci\u00F3n");
		lblTipoDeHabitacin.setBounds(25, 57, 138, 14);
		contentPane.add(lblTipoDeHabitacin);

		final JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] { "Single",
				"Doble" }));
		comboTipo.setBounds(196, 54, 86, 20);
		contentPane.add(comboTipo);

		final JComboBox comboPiso = new JComboBox();
		comboPiso.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));
		comboPiso.setBounds(196, 133, 86, 20);
		contentPane.add(comboPiso);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tipoHab = comboTipo.getSelectedItem().toString();
				piso = comboPiso.getSelectedItem().toString();
				bath = comboBath.getSelectedItem().toString();
				if (checkDisponibilidad.isSelected())
					disponible = "Si";
				else
					disponible = "No";				
				exito = GuardarHabitacion();
				MostrarAlerta(exito);
			}
		});
		btnGuardar.setBounds(285, 256, 102, 23);
		contentPane.add(btnGuardar);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
			}
		});
		btnCerrar.setBounds(397, 256, 102, 23);
		contentPane.add(btnCerrar);
	}

	public boolean GuardarHabitacion() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		boolean retorno = false;
		String linea = "";
		int indice = 0;
		try {
			String habitacion = txtHab.getText();
			String precio = txtPrecio.getText();
			for (int i = 0; i < cantidadRegistros; i++) {
				if (modelHab.NroHab[i] == (Integer.parseInt(habitacion))) {
					indice = i;
				}
			}
			modelHab.NroHab[indice] = Integer.parseInt(habitacion);
			modelHab.Tipo[indice] = tipoHab;
			modelHab.Bath[indice] = bath;
			modelHab.Precio[indice] = Double.parseDouble(precio);
			modelHab.Disponible[indice] = disponible;

			if (habitacion.length() > 1 || tipoHab.length() > 1) {
				fichero = new FileWriter("Archivos\\ListadoHabitaciones.txt");
				pw = new PrintWriter(fichero);
				for (int i = 0; i < cantidadRegistros; i++) {
					if (modelHab.NroHab[i] < 10) {
						linea = "0" + String.valueOf(modelHab.NroHab[i]) + ","
								+ modelHab.Tipo[i] + "," + modelHab.Bath[i]
								+ "," + String.valueOf(modelHab.Precio[i])
								+ "," + modelHab.Disponible[i];
					} else {
						linea = String.valueOf(modelHab.NroHab[i]) + ","
								+ modelHab.Tipo[i] + "," + modelHab.Bath[i]
								+ "," + String.valueOf(modelHab.Precio[i])
								+ "," + modelHab.Disponible[i];
					}
					pw.println(linea);
				}

				retorno = true;
			} else {
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return retorno;
	}

	public int NrodeHabitaciones() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int NroRegistros = 0;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Archivos\\ListadoHabitaciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				NroRegistros++;
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
		return NroRegistros;
	}

	public void CargarDatosHab() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int NroRegistros = 0;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("Archivos\\ListadoHabitaciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				modelHab.NroHab[NroRegistros] = Integer.parseInt(linea
						.split(",")[0]);
				modelHab.Tipo[NroRegistros] = linea.split(",")[1];
				modelHab.Bath[NroRegistros] = linea.split(",")[2];
				modelHab.Precio[NroRegistros] = Double.parseDouble(linea
						.split(",")[3]);
				modelHab.Disponible[NroRegistros] = linea.split(",")[4];
				NroRegistros++;
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
	public void MostrarAlerta(boolean registro){
		if(registro)
			javax.swing.JOptionPane.showMessageDialog(this,"Registro Exitoso!");
		else
			javax.swing.JOptionPane.showMessageDialog(this,"Error!","Error",JOptionPane.ERROR_MESSAGE);
	}
}
