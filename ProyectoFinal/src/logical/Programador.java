package logical;

public class Programador extends Diseñador {
	
    private String lenguaje; 
    
	
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public Programador(String id, String nomCom, String dir, String sexo, int edad, double salario, String nomProy,
			String evalAnual, boolean disponible, String lenguaje) {
		super(id, nomCom, dir, sexo, edad, salario, nomProy, evalAnual, disponible);
		this.lenguaje = lenguaje;
	}

}
