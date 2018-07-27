package logical;

public class JefeDeProyecto extends Trabajador {

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

}
