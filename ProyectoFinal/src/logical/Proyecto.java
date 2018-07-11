package logical;

import java.util.ArrayList;

public class Proyecto {
	
	private String tipo;
	private String lenguaje;
	private ArrayList<Trabajador> miEquipo;
	private float montoPagar;
	
	public Proyecto(String tipo, String lenguaje, ArrayList<Trabajador> miEquipo, float montoPagar) {
		super();
		this.tipo = tipo;
		this.lenguaje = lenguaje;
		this.miEquipo = miEquipo;
		this.montoPagar = montoPagar;
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

	public float getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(float montoPagar) {
		this.montoPagar = montoPagar;
	}
	

}
