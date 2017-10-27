package com.hv.modelo;

public class HuespedesModel implements Comparable<HuespedesModel> {

	public static String NroHab;
	public static String Nombres;
	public static String FechaIngreso;
	public static String Noches;
	public HuespedesModel(String hab, String nom, String fecha, String noche) {
		this.NroHab = hab;
		this.Nombres = nom;
		this.FechaIngreso = fecha;
		this.Noches = noche;		
	}
	public static String getNroHab() {
		return NroHab;
	}
	
	public static String getNombres() {
		return Nombres;
	}
	
	public static String getFechaIngreso() {
		return FechaIngreso;
	}
	
	public static String getNoches() {
		return Noches;
	}
	@Override
	public int compareTo(HuespedesModel h) {
		String a=new String(this.getNroHab());
        String b=new String(h.getNroHab());
        return a.compareTo(b);
		
	}
	
	

}
