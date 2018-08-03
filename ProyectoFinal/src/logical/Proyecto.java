package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Proyecto implements Serializable, Comparable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3508396068274007524L;
	private String nombre;
	private String tipo;
	private String lenguaje;
	private ArrayList<Trabajador> miEquipo;
	private Date fechaIni;
	private Date fechaFin;
	private String miCliente;
	private String estado;
	
	public Proyecto(String nombre, String tipo, String lenguaje, ArrayList<Trabajador> miEquipo,Date fechaIni,Date fechaFin,String miCliente) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.lenguaje = lenguaje;
		this.miEquipo = miEquipo;
		this.fechaIni=fechaIni;
		this.fechaFin=fechaFin;
		this.miCliente = miCliente;
		this.estado = "A tiempo";
	}

	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(String miCliente) {
		this.miCliente = miCliente;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public ArrayList<Trabajador> getMiEquipo() {
		return miEquipo;
	}

	public void setMiEquipo(ArrayList<Trabajador> miEquipo) {
		this.miEquipo = miEquipo;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int compareTo(Object o) {
		Proyecto pro = (Proyecto)o;
		int days = Empresa.getInstance().daysBetween(pro.fechaIni, pro.fechaIni);
		
		return days - Empresa.getInstance().daysBetween(this.fechaIni, this.fechaFin);
	}
	

}
