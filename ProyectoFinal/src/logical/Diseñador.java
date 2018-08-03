package logical;

import java.io.Serializable;

public class Diseñador extends Trabajador implements Serializable{

	public Diseñador(String id, String nomCom, String dir, String sexo, int edad, double salario) {
		super(id, nomCom, dir, sexo, edad, salario);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
