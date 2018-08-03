package logical;

import java.io.Serializable;

public abstract class Trabajador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4429461014725391848L;
	protected String id;
	protected String nomCom;
	protected String dir;
	protected String sexo;
	protected int edad;
	protected double salario;
	protected String evalAnual;
	protected boolean disponible;
	protected int cantpro;
	
	public Trabajador(String id, String nomCom, String dir, String sexo, int edad, double salario) {
		super();
		this.id = id;
		this.nomCom = nomCom;
		this.dir = dir;
		this.sexo = sexo;
		this.edad = edad;
		this.salario = salario;
		this.disponible=true;
		this.cantpro = 0;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomCom() {
		return nomCom;
	}

	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEvalAnual() {
		return evalAnual;
	}

	public void setEvalAnual(String evalAnual) {
		this.evalAnual = evalAnual;
	}

	public int getCantpro() {
		return cantpro;
	}

	public void setCantpro(int cantpro) {
		this.cantpro = cantpro;
	}
	

}
