package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Empresa;
import logical.Proyecto;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class RegContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMonto;
	private JTextField txtFechIni;
	private JTextField txtFechaFin;
	private JTextField txtNumCont;
	private JTextField txtProyecto;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegContrato(Proyecto pro) {
		
		setBounds(100, 100, 591, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMontoAPagar = new JLabel("Monto a Pagar:");
			lblMontoAPagar.setBounds(309, 248, 87, 14);
			contentPanel.add(lblMontoAPagar);
		}
		{
			txtMonto = new JTextField();
			txtMonto.setEditable(false);
			txtMonto.setBounds(388, 245, 86, 20);
			contentPanel.add(txtMonto);
			txtMonto.setColumns(10);
			txtMonto.setText(Float.toString(Empresa.getInstance().calcularMonto()));
		}
		{
			JLabel lblRd = new JLabel("RD$");
			lblRd.setBounds(477, 248, 31, 14);
			contentPanel.add(lblRd);
		}
		{
			JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
			lblFechaInicio.setBounds(309, 22, 67, 14);
			contentPanel.add(lblFechaInicio);
		}
		{
			txtFechIni = new JTextField();
			txtFechIni.setEditable(false);
			txtFechIni.setBounds(388, 19, 86, 20);
			contentPanel.add(txtFechIni);
			txtFechIni.setColumns(10);
			txtFechIni.setText(pro.getFechaIni().getDate() + "-"+ pro.getFechaIni().getMonth() + "-"+(pro.getFechaIni().getYear()+1900));
		}
		{
			JLabel lblFechaFin = new JLabel("Fecha Fin:");
			lblFechaFin.setBounds(309, 59, 67, 14);
			contentPanel.add(lblFechaFin);
		}
		{
			txtFechaFin = new JTextField();
			txtFechaFin.setEditable(false);
			txtFechaFin.setBounds(388, 56, 86, 20);
			contentPanel.add(txtFechaFin);
			txtFechaFin.setColumns(10);
			txtFechaFin.setText(pro.getFechaFin().getDate() + "-"+ pro.getFechaFin().getMonth() + "-"+(pro.getFechaFin().getYear()+1900));
		}
		{
			JLabel lblProrroga = new JLabel("Prorroga:");
			lblProrroga.setBounds(309, 101, 56, 14);
			contentPanel.add(lblProrroga);
		}
		{
			JRadioButton rdbtnSi = new JRadioButton("Si");
			rdbtnSi.setBounds(388, 97, 47, 23);
			contentPanel.add(rdbtnSi);
		}
		{
			JRadioButton rdbtnNo = new JRadioButton("No");
			rdbtnNo.setBounds(437, 97, 56, 23);
			contentPanel.add(rdbtnNo);
		}
		{
			JLabel lblNumeroDeContrato = new JLabel("Numero de Contrato:");
			lblNumeroDeContrato.setBounds(21, 22, 112, 14);
			contentPanel.add(lblNumeroDeContrato);
		}
		{
			txtNumCont = new JTextField();
			txtNumCont.setEditable(false);
			txtNumCont.setBounds(159, 19, 112, 20);
			contentPanel.add(txtNumCont);
			txtNumCont.setColumns(10);
			txtNumCont.setText(Empresa.getInstance().getMisContratos().size()+1+ "-"+pro.getFechaIni().toString());
		}
		{
			JLabel lblNombreProyecto = new JLabel("Nombre Proyecto:");
			lblNombreProyecto.setBounds(21, 59, 112, 14);
			contentPanel.add(lblNombreProyecto);
		}
		{
			txtProyecto = new JTextField();
			txtProyecto.setEditable(false);
			txtProyecto.setBounds(159, 56, 112, 20);
			contentPanel.add(txtProyecto);
			txtProyecto.setColumns(10);
			txtProyecto.setText(pro.getNombre());
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setBounds(21, 101, 56, 14);
			contentPanel.add(lblCliente);
		}
		{
			txtCliente = new JTextField();
			txtCliente.setEditable(false);
			txtCliente.setBounds(158, 98, 113, 20);
			contentPanel.add(txtCliente);
			txtCliente.setColumns(10);
			//txtCliente.setText(pro.get);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
