package logical;

import java.util.Date;

public class Contrato {
	private String numCont;
	private Cliente miCliente;
	private Proyecto miProyecto;
	private Date fechaIni;
	private Date fechaFin;
	private double montoPagar;
	
	public Contrato(String numCont, Cliente miCliente, Proyecto miProyecto, Date fechaIni,
			Date fechaFin,float montoPagar) {
		
		super();
		this.numCont = numCont;
		this.miCliente = miCliente;
		this.miProyecto = miProyecto;
		this.setFechaIni(fechaIni);
		this.setFechaFin(fechaFin);
		this.montoPagar = montoPagar;
	}
	
	
	public double getMontoPagar() {
		return montoPagar;
	}


	public void setMontoPagar(double montoPagar) {
		this.montoPagar = montoPagar;
	}


	public String getNumCont() {
		return numCont;
	}

	public void setNumCont(String numCont) {
		this.numCont = numCont;
	}


	public Cliente getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

	public Proyecto getMiProyecto() {
		return miProyecto;
	}

	public void setMiProyecto(Proyecto miProyecto) {
		this.miProyecto = miProyecto;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

}
