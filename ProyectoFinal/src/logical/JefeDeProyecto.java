package logical;

import java.io.Serializable;

public class JefeDeProyecto extends Trabajador implements Serializable{

	private int cantTrabajo;
	

	public int getCantTrabajo() {
		return cantTrabajo;
	}

	public void setCantTrabajo(int cantTrabajo) {
		this.cantTrabajo = cantTrabajo;
	}

	public JefeDeProyecto(String id, String nomCom, String dir, String sexo, int edad, double salario, int cantTrabajo) {
		super(id, nomCom, dir, sexo, edad, salario);
		this.cantTrabajo = cantTrabajo;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
