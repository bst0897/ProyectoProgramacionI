package logical;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Trabajador> misTrabs;
	private ArrayList<Contrato> misContratos;
	
	public Empresa(ArrayList<Cliente> misClientes, ArrayList<Trabajador> misTrabs, ArrayList<Contrato> misContratos) {
		super();
		this.misClientes = misClientes;
		this.misTrabs = misTrabs;
		this.misContratos = misContratos;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Trabajador> getMisTrabs() {
		return misTrabs;
	}

	public void setMisTrabs(ArrayList<Trabajador> misTrabs) {
		this.misTrabs = misTrabs;
	}

	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}

	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
	}
	
	public boolean crearProyecto() {
		
		return true;
	}
	public boolean crearContrato() {
		
		return true;
	}
	

}
