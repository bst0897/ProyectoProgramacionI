package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Contrato;
import logical.Diseñador;
import logical.Empresa;
import logical.JefeDeProyecto;
import logical.Planificador;
import logical.Programador;
import logical.Proyecto;
import logical.Trabajador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

public class RegContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMonto;
	private JTextField txtFechIni;
	private JTextField txtFechaFin;
	private JTextField txtNumCont;
	private JTextField txtProyecto;
	private JTextField txtCliente;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JLabel lblFechaDeProrroga;
	private JDateChooser dateChooser;
	private Contrato con;
	private JLabel lblProrroga;

	
	public RegContrato(Proyecto pro,Contrato con) {
		
		
		this.con=con;
		if(con==null) {
			setTitle("Registro de Contrato");
		}else {
			setTitle("Modificacion de Contrato");
		}
		
		DefaultListModel  model = new DefaultListModel();

		
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
			txtMonto.setBounds(401, 245, 86, 20);
			contentPanel.add(txtMonto);
			txtMonto.setColumns(10);
			txtMonto.setText(Float.toString(Empresa.getInstance().calcularMonto(pro)));
		}
		{
			JLabel lblRd = new JLabel("RD$");
			lblRd.setBounds(497, 248, 31, 14);
			contentPanel.add(lblRd);
		}
		{
			JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
			lblFechaInicio.setBounds(309, 22, 108, 14);
			contentPanel.add(lblFechaInicio);
		}
		{
			txtFechIni = new JTextField();
			txtFechIni.setEditable(false);
			txtFechIni.setBounds(429, 19, 118, 20);
			contentPanel.add(txtFechIni);
			txtFechIni.setColumns(10);
			txtFechIni.setText(pro.getFechaIni().getDate() + "-"+ (pro.getFechaIni().getMonth()+1) + "-"+(pro.getFechaIni().getYear()+1900));
		}
		{
			JLabel lblFechaFin = new JLabel("Fecha Fin:");
			lblFechaFin.setBounds(309, 59, 67, 14);
			contentPanel.add(lblFechaFin);
		}
		{
			txtFechaFin = new JTextField();
			txtFechaFin.setEditable(false);
			txtFechaFin.setBounds(429, 56, 118, 20);
			contentPanel.add(txtFechaFin);
			txtFechaFin.setColumns(10);
			txtFechaFin.setText(pro.getFechaFin().getDate() + "-"+ (pro.getFechaFin().getMonth()+1) + "-"+(pro.getFechaFin().getYear()+1900));
		}
		{
			lblProrroga = new JLabel("Prorroga:");
			lblProrroga.setBounds(309, 101, 56, 14);
			contentPanel.add(lblProrroga);
			lblProrroga.setVisible(false);
		}
		{
			rdbtnSi = new JRadioButton("Si");
			rdbtnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnSi.isSelected()) {
					rdbtnNo.setSelected(false);
					lblFechaDeProrroga.setVisible(true);
					dateChooser.setVisible(true);
					}
					
				}
			});
			rdbtnSi.setBounds(442, 101, 47, 23);
			contentPanel.add(rdbtnSi);
			rdbtnSi.setVisible(false);
		}
		{
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.setSelected(true);
			rdbtnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnNo.isSelected()) {
					rdbtnSi.setSelected(false);
					lblFechaDeProrroga.setVisible(false);
					dateChooser.setVisible(false);
					}
				}
			});
			rdbtnNo.setBounds(491, 101, 56, 23);
			contentPanel.add(rdbtnNo);
			rdbtnNo.setVisible(false);
			
		}
		{
			JLabel lblNumeroDeContrato = new JLabel("Numero de Contrato:");
			lblNumeroDeContrato.setBounds(21, 22, 137, 14);
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
			txtCliente.setText(pro.getMiCliente());
		}
		{
			JLabel lblEquipo = new JLabel("Equipo:");
			lblEquipo.setBounds(21, 139, 46, 14);
			contentPanel.add(lblEquipo);
		}
		{
			lblFechaDeProrroga = new JLabel("Fecha de Prorroga:");
			lblFechaDeProrroga.setBounds(307, 139, 112, 14);
			contentPanel.add(lblFechaDeProrroga);
			lblFechaDeProrroga.setVisible(false);

		}
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setVisible(false);
		dateChooser.setBounds(429, 133, 118, 20);
		contentPanel.add(dateChooser);
		
		if(con!=null) {
			rdbtnNo.setVisible(true);
			rdbtnSi.setVisible(true);
			lblProrroga.setVisible(true);
			//lblFechaDeProrroga.setVisible(true);
			//dateChooser.setVisible(true);

		}
		
		JList list = new JList(model);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(77, 139, 194, 146);
		contentPanel.add(list);
		for (int i = 0; i < pro.getMiEquipo().size(); i++) {
			String aux = "";
			if(pro.getMiEquipo().get(i) instanceof Programador) {
				aux = "Programador";
			}else if(pro.getMiEquipo().get(i) instanceof Diseñador) {
				aux = "Diseñador";

			}else if(pro.getMiEquipo().get(i) instanceof JefeDeProyecto) {
				aux = "JefeDeProyecto";

			}else if(pro.getMiEquipo().get(i) instanceof Planificador) {
				aux = "Planificador";

			}
				
			model.add(i, pro.getMiEquipo().get(i).getNomCom() + " " + aux);

		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				if (con==null) {
					okButton.setText("Registrar");
				}else {
					okButton.setText("Modificar");

				}
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (con==null) {
						Empresa.getInstance().getMisProyectos().add(pro);
						Contrato con = new Contrato(txtNumCont.getText(), Empresa.getInstance().BuscarCliente(pro.getMiCliente()), pro, pro.getFechaIni(), pro.getFechaFin(), Empresa.getInstance().calcularMonto(pro));
						Empresa.getInstance().getMisContratos().add(con);
						for (Trabajador aux : pro.getMiEquipo()) {
							if(aux instanceof JefeDeProyecto) {
								aux.setCantpro(aux.getCantpro()+1);
								if(aux.getCantpro()==3) {
									aux.setDisponible(false);
								}
							}
							if(aux instanceof Planificador) {
								aux.setCantpro(aux.getCantpro()+1);
								if(aux.getCantpro()==4) {
									aux.setDisponible(false);
								}
							}
							if(aux instanceof Programador) {
								aux.setCantpro(aux.getCantpro()+1);
							}
							if(aux instanceof Diseñador) {
								aux.setCantpro(aux.getCantpro()+1);
								if(aux.getCantpro()==3) {
									aux.setDisponible(false);
								}
							}
						}
						/*Empresa.getInstance().BuscarCliente(pro.getMiCliente()).setCantProyectos(Empresa.getInstance().BuscarCliente(pro.getMiCliente()).getCantProyectos()+1);
						if(Empresa.getInstance().BuscarCliente(pro.getMiCliente()).getCantProyectos()==5) {
							
							Empresa.getInstance().BuscarCliente(pro.getMiCliente()).setDisponible(false);
						}*/
						JOptionPane.showMessageDialog(null, "Operacion Satisfactoria!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						}else {
							
							
							if(rdbtnSi.isSelected()) {
								
								Empresa.getInstance().hacerProrroga(con,dateChooser.getDate());
								JOptionPane.showMessageDialog(null, "Operacion Satisfactoria!", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								ListaContratos.loadTable();
								dispose();
									

							}
							
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
