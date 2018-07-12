package logical;

import java.util.Date;

public class Contrato {
	private String numCont;
	private String tipoPago;
	private Cliente miCliente;
	private Proyecto miProyecto;
	private Date fechaIni;
	private Date fechaFin;
	
	public Contrato(String numCont, String tipoPago, Cliente miCliente, Proyecto miProyecto, Date fechaIni,
			Date fechaFin) {
		super();
		this.numCont = numCont;
		this.tipoPago = tipoPago;
		this.miCliente = miCliente;
		this.miProyecto = miProyecto;
		this.setFechaIni(fechaIni);
		this.setFechaFin(fechaFin);
	}
	
	public String getNumCont() {
		return numCont;
	}

	public void setNumCont(String numCont) {
		this.numCont = numCont;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
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