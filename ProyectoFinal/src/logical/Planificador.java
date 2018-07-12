package logical;

public class Planificador extends Diseñador {
	
	private int frecuenciaTarea;
	
	public int getFrecuenciaTarea() {
		return frecuenciaTarea;
	}
	public void setFrecuenciaTarea(int frecuenciaTarea) {
		this.frecuenciaTarea = frecuenciaTarea;
	}
	public Planificador(String id, String nomCom, String dir, String sexo, int edad, double salario, String nomProy,
			String evalAnual, boolean disponible, int frecuenciaTarea) {
		super(id, nomCom, dir, sexo, edad, salario, nomProy, evalAnual, disponible);
		this.frecuenciaTarea = frecuenciaTarea;
	}

}
