package logical;

import java.util.ArrayList;




public class Empresa {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Trabajador> misTrabs;
	private ArrayList<Contrato> misContratos;
	private ArrayList<Proyecto> misProyectos;
	private static Empresa emp = null;
	
	private Empresa() {
		super();
		misClientes = new ArrayList<>();
		misTrabs = new ArrayList<>();
		misContratos = new ArrayList<>();
		misProyectos = new ArrayList<>();
	}
	
	 public static Empresa getInstance(){
		 if(emp == null){
			 emp = new Empresa();
		 }
		 
		 return emp;
	 } 
	 

	public ArrayList<Proyecto> getMisProyectos() {
		return misProyectos;
	}

	public void setMisProyectos(ArrayList<Proyecto> misProyectos) {
		this.misProyectos = misProyectos;
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
	
	public void insertCliente(Cliente aux){
		misClientes.add(aux);
	}
	
	public void insertTrabajador(Trabajador aux){
		misTrabs.add(aux);
	}
	
	public void insertContrato(Contrato aux){
		misContratos.add(aux);
	}
	
	public boolean crearProyecto() {
		
		return true;
	}
	public boolean crearContrato() {
		
		return true;
	}
	public void ModificarCliente(Cliente cli){
		boolean encontrado = false;
		int i=0;
		while (i<misClientes.size()&&!encontrado) {
			if(misClientes.get(i).getIdentificador().equalsIgnoreCase(cli.getIdentificador())) {
				encontrado = true;
				cli = misClientes.get(i) ;
			}
			i++;
		}
	}

	public Cliente BuscarCliente(String cedula) {
		Cliente cli=null;
		boolean find = false;
		int i=0;
		while (i<misClientes.size()&&!find) {
			if(misClientes.get(i).getIdentificador().equalsIgnoreCase(cedula)){
				cli = misClientes.get(i);
				find = true;
			}
			i++;
		}
		return cli;
	}

	public void removeCliente(Cliente aux) {
		misClientes.remove(aux);
	}

	public float calcularMonto() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Trabajador findTrab(String name) {
		Trabajador aux=null;
		for (Trabajador trab : misTrabs) {
			if(trab.getNomCom().equalsIgnoreCase(name)) {
				aux=trab;
			}
		}
		
		return aux;
	}
	
	public Cliente findCli(String name) {
		Cliente cli =null;
		for (Cliente cliente : misClientes) {
			if(cliente.getNombre().equalsIgnoreCase(name)) {
				cli=cliente;
			}
		}
		return cli;
	}
	

}
