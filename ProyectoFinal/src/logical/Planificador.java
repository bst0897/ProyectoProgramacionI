package logical;

import java.io.Serializable;

public class Planificador extends Trabajador implements Serializable {
	
	private int frecuenciaTarea;
	
	public int getFrecuenciaTarea() {
		return frecuenciaTarea;
	}
	public void setFrecuenciaTarea(int frecuenciaTarea) {
		this.frecuenciaTarea = frecuenciaTarea;
	}
	public Planificador(String id, String nomCom, String dir, String sexo, int edad, double salario, int frecuenciaTarea) {
		super(id, nomCom, dir, sexo, edad, salario);
		this.frecuenciaTarea = frecuenciaTarea;
	}

}
