package logical;

import java.util.ArrayList;

public class Programador extends Trabajador {
	
    private ArrayList<String> lenguajes; 
    
	
	
	public Programador(String id, String nomCom, String dir, String sexo, int edad, double salario, ArrayList <String> lenguajes) {
		super(id, nomCom, dir, sexo, edad, salario);
		this.lenguajes = lenguajes;
	}



	public ArrayList<String> getLenguajes() {
		return lenguajes;
	}



	public void setLenguajes(ArrayList<String> lenguajes) {
		this.lenguajes = lenguajes;
	}

}
