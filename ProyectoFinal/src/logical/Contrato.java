package logical;

public class Contrato {
	private String numCont;
	private String tipoPago;
	private Cliente miCliente;
	private Proyecto miProyecto;
	
	public Contrato(String numCont, String tipoPago, Cliente miCliente, Proyecto miProyecto) {
		super();
		this.numCont = numCont;
		this.tipoPago = tipoPago;
		this.miCliente = miCliente;
		this.miProyecto = miProyecto;
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
	
	
}
