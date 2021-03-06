package logical;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;




public class Empresa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2415696500563981654L;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Trabajador> misTrabs;
	private ArrayList<Contrato> misContratos;
	private ArrayList<Proyecto> misProyectos;
	private static Empresa emp = null;


	
	private Empresa () {
		super();
		misClientes = new ArrayList<>();
		misTrabs = new ArrayList<>();
		misContratos = new ArrayList<>();
		misProyectos = new ArrayList<>();
	}
	
	public static void setInstance(Empresa aux) {
		emp = aux;
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

	public float calcularMonto(Proyecto pro) {
		float monto=0;
		int cantDias = daysBetween(pro.getFechaIni(), pro.getFechaFin());
		float sueldoTot=0;
		for (Trabajador trab : pro.getMiEquipo()) {
			sueldoTot+=trab.getSalario();
		}
		monto = cantDias*8*sueldoTot;
		monto *=1.15;
		return monto;
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
	
	public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
}

	public boolean hacerProrroga(Contrato con,Date d1) {
		boolean prorroga = false;
		int dias = daysBetween(con.getFechaFin(), d1);
		//double monto = con.getMontoPagar();
		if(dias>0) {
			con.setFechaFin(d1);
			//con.setMontoPagar(monto- (monto*(dias*0.01)));
			//con.getMiProyecto().setEstado("Atrasado");
			con.getMiProyecto().setFechaFin(d1);
			prorroga = true;
		}
		
		return prorroga;
	}
	public Contrato findContrato(String num) {
		Contrato con = null;
		for (Contrato contrato : misContratos) {
			if(contrato.getNumCont().equalsIgnoreCase(num)) {
				con = contrato;
			}
		}
		return con;
	}
	
	public int puntTrab(String name) {
		int punt = 0;
		for (Trabajador trabajador : misTrabs) {
			if(trabajador.getNomCom().equalsIgnoreCase(name)) {
				punt=trabajador.getPuntos();
			}
		}
		return punt;
	}
	public Proyecto findProyecto(String name) {
		Proyecto pro = null;
		for (Proyecto proy : misProyectos) {
			if(proy.getNombre().equalsIgnoreCase(name)) {
				pro = proy;
			}
		}
		return pro;
	}
	

}
