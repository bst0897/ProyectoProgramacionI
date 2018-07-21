package logical;

public class Planificador extends Dise�ador {
	
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
