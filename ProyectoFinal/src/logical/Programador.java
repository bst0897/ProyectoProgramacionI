package logical;

import java.util.ArrayList;

public class Programador extends Diseñador {
	
    private ArrayList<String> lenguajes; 
    
	
	
	public Programador(String id, String nomCom, String dir, String sexo, int edad, double salario, String nomProy,
			String evalAnual, boolean disponible, ArrayList <String> lenguajes) {
		super(id, nomCom, dir, sexo, edad, salario, nomProy, evalAnual, disponible);
		this.lenguajes = lenguajes;
	}

}
