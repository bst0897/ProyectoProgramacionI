package logical;

import java.io.Serializable;

public class Diseñador extends Trabajador implements Serializable{

	public Diseñador(String id, String nomCom, String dir, String sexo, int edad, double salario) {
		super(id, nomCom, dir, sexo, edad, salario);
	}

}
