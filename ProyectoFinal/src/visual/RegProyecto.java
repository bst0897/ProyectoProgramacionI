package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;

import logical.Dise�ador;
import logical.Empresa;
import logical.JefeDeProyecto;
import logical.Planificador;
import logical.Programador;
import logical.Proyecto;
import logical.Trabajador;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtFechIni;
	private JComboBox cbxCliente;
	private JList lsTrabDisp;
	private JList lsEquipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegProyecto dialog = new RegProyecto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public RegProyecto() {
		
		DefaultListModel  model = new DefaultListModel();
		DefaultListModel  model2 = new DefaultListModel();
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		
		setTitle("Proyecto Nuevo");
		setBounds(100, 100, 570, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreDelSoftware = new JLabel("Nombre del Software:");
		lblNombreDelSoftware.setBounds(10, 25, 128, 14);
		contentPanel.add(lblNombreDelSoftware);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(324, 25, 80, 14);
		contentPanel.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(324, 61, 66, 14);
		contentPanel.add(lblFechaFin);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 22, 157, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 103, 46, 14);
		contentPanel.add(lblTipo);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Web", "Sistema Operativo", "Administracion/Contabilidad", "IDE", "Educativo", "Otro/a"}));
		cbxTipo.setBounds(138, 103, 157, 20);
		contentPanel.add(cbxTipo);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 61, 58, 14);
		contentPanel.add(lblCliente);
		
		cbxCliente = new JComboBox();
		cbxCliente.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		cbxCliente.setBounds(138, 58, 157, 20);
		contentPanel.add(cbxCliente);
		
		lsTrabDisp = new JList(model);
		lsTrabDisp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lsTrabDisp.setBounds(52, 189, 161, 96);
		contentPanel.add(lsTrabDisp);
		
		for (int i = 0; i < Empresa.getInstance().getMisTrabs().size(); i++) {
			if(Empresa.getInstance().getMisTrabs().get(i).isDisponible()) 
			{
				if(Empresa.getInstance().getMisTrabs().get(i) instanceof Dise�ador) {
					model.add(i, Empresa.getInstance().getMisTrabs().get(i).getNomCom() + " Dise�ador" );
				}else if (Empresa.getInstance().getMisTrabs().get(i) instanceof Planificador) {
					model.add(i, Empresa.getInstance().getMisTrabs().get(i).getNomCom() + " Planificador" );

				}else if (Empresa.getInstance().getMisTrabs().get(i) instanceof Programador) {
					model.add(i, Empresa.getInstance().getMisTrabs().get(i).getNomCom() + " Programador" );

				}else if (Empresa.getInstance().getMisTrabs().get(i) instanceof JefeDeProyecto) {
					model.add(i, Empresa.getInstance().getMisTrabs().get(i).getNomCom() + " Jefe De Proyecto" );

				}
			}
		}
		
		lsEquipo = new JList(model2);
		lsEquipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lsEquipo.setBounds(342, 189, 161, 96);
		contentPanel.add(lsEquipo);
		
		JLabel lblTrabajadoresDisponibles = new JLabel("Trabajadores Disponibles");
		lblTrabajadoresDisponibles.setBounds(75, 164, 166, 14);
		contentPanel.add(lblTrabajadoresDisponibles);
		
		JLabel lblEquipoDeProyecto = new JLabel("Equipo de Proyecto");
		lblEquipoDeProyecto.setBounds(377, 164, 111, 14);
		contentPanel.add(lblEquipoDeProyecto);
		
		JButton btnAgregar = new JButton("->");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnAgregar.setBounds(260, 213, 46, 23);
		contentPanel.add(btnAgregar);
		
		JButton btnEliminar = new JButton("<-");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnEliminar.setBounds(260, 246, 46, 23);
		contentPanel.add(btnEliminar);
		
		txtFechIni = new JTextField();
		txtFechIni.setEditable(false);
		txtFechIni.setBounds(412, 22, 132, 20);
		contentPanel.add(txtFechIni);
		txtFechIni.setColumns(10);
		txtFechIni.setText(date.getDate() + "-"+ date.getMonth() + "-"+(date.getYear()+1900));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(412, 55, 132, 20);
		contentPanel.add(dateChooser);
		
		JLabel lblLenguaje = new JLabel("Lenguaje:");
		lblLenguaje.setBounds(324, 103, 73, 14);
		contentPanel.add(lblLenguaje);
		
		JComboBox cbxLenguaje = new JComboBox();
		cbxLenguaje.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Java", "Python", "C/C++", "C#"}));
		cbxLenguaje.setBounds(412, 100, 132, 20);
		contentPanel.add(cbxLenguaje);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Trabajador> team = new ArrayList<>();
						Proyecto pro = new Proyecto(txtNombre.getText(), cbxTipo.getSelectedItem().toString(),cbxLenguaje.getSelectedItem().toString() , team,date,dateChooser.getDate(),cbxCliente.getSelectedItem().toString());
						Empresa.getInstance().getMisProyectos().add(pro);
						RegContrato rgContrato = new RegContrato(pro);
						rgContrato.setVisible(true);
						rgContrato.setLocationRelativeTo(null);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadClientes();
	}
	
	private void loadClientes() {
		for (int i = 0; i < Empresa.getInstance().getMisClientes().size(); i++) {
			cbxCliente.addItem(new String(Empresa.getInstance().getMisClientes().get(i).getNombre()));	
		}
		cbxCliente.insertItemAt("<Seleccione>", 0);
		cbxCliente.setSelectedIndex(0);
		
	}
}
