package logical;

public class JefeDeProyecto extends Diseñador {

	private int cantTrabajo;
	

	public int getCantTrabajo() {
		return cantTrabajo;
	}

	public void setCantTrabajo(int cantTrabajo) {
		this.cantTrabajo = cantTrabajo;
	}

	public JefeDeProyecto(String id, String nomCom, String dir, String sexo, int edad, double salario, String nomProy,
			String evalAnual, boolean disponible, int cantTrabajo) {
		super(id, nomCom, dir, sexo, edad, salario, nomProy, evalAnual, disponible);
		this.cantTrabajo = cantTrabajo;
	}

}
