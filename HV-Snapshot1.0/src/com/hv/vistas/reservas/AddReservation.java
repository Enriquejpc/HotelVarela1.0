package com.hv.vistas.reservas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;


public class AddReservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtReserva;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/*Calendario**/
	JCalendar a;

	/**
	 * Create the frame.
	 */
	public AddReservation() {
		
		setTitle("Registrar Reserva");
		setBounds(420, 155, 525, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblReserva = new JLabel("Reserva #:");
		lblReserva.setBounds(21, 40, 82, 14);
		contentPane.add(lblReserva);
		
		JLabel lblHuesped = new JLabel("Hu\u00E9sped:");
		lblHuesped.setBounds(21, 74, 46, 14);
		contentPane.add(lblHuesped);
		
		JLabel lblCheckIn = new JLabel("Check In:");
		lblCheckIn.setBounds(21, 109, 46, 14);
		contentPane.add(lblCheckIn);
		
		JLabel lblNoches = new JLabel("Noches:");
		lblNoches.setBounds(21, 143, 46, 14);
		contentPane.add(lblNoches);
		
		txtReserva = new JTextField();
		txtReserva.setBounds(92, 37, 149, 20);
		contentPane.add(txtReserva);
		txtReserva.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(92, 71, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 140, 149, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHabitacin = new JLabel("Habitaci\u00F3n:");
		lblHabitacin.setBounds(21, 191, 60, 14);
		contentPane.add(lblHabitacin);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 188, 149, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	
	}
	
}
