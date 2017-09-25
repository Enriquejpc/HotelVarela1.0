package com.hv.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	public Utilidades() {
		// TODO Auto-generated constructor stub
	}
	public String getFchActual(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String retorno = dateFormat.format(date);
		return retorno;
		
	}
}
