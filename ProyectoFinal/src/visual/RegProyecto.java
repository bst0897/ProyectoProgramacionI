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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtFechIni;

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
		setTitle("Proyecto Nuevo");
		setBounds(100, 100, 523, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombreDelSoftware = new JLabel("Nombre del Software:");
		lblNombreDelSoftware.setBounds(10, 25, 128, 14);
		contentPanel.add(lblNombreDelSoftware);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(289, 25, 80, 14);
		contentPanel.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(289, 61, 66, 14);
		contentPanel.add(lblFechaFin);
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 22, 137, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 103, 46, 14);
		contentPanel.add(lblTipo);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Web", "Sistema Operativo", "Administracion/Contabilidad", "IDE", "Educativo", "Otro/a"}));
		cbxTipo.setBounds(138, 103, 137, 20);
		contentPanel.add(cbxTipo);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 61, 58, 14);
		contentPanel.add(lblCliente);
		
		JComboBox cbxCliente = new JComboBox();
		cbxCliente.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		cbxCliente.setBounds(138, 58, 137, 20);
		contentPanel.add(cbxCliente);
		
		JList lsTrabDisp = new JList();
		lsTrabDisp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lsTrabDisp.setBounds(38, 189, 161, 96);
		contentPanel.add(lsTrabDisp);
		
		JList lsEquipo = new JList();
		lsEquipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lsEquipo.setBounds(304, 189, 161, 96);
		contentPanel.add(lsEquipo);
		
		JLabel lblTrabajadoresDisponibles = new JLabel("Trabajadores Disponibles");
		lblTrabajadoresDisponibles.setBounds(58, 164, 166, 14);
		contentPanel.add(lblTrabajadoresDisponibles);
		
		JLabel lblEquipoDeProyecto = new JLabel("Equipo de Proyecto");
		lblEquipoDeProyecto.setBounds(334, 164, 111, 14);
		contentPanel.add(lblEquipoDeProyecto);
		
		JButton btnAgregar = new JButton("->");
		btnAgregar.setBounds(229, 206, 46, 23);
		contentPanel.add(btnAgregar);
		
		JButton btnEliminar = new JButton("<-");
		btnEliminar.setBounds(229, 247, 46, 23);
		contentPanel.add(btnEliminar);
		
		txtFechIni = new JTextField();
		txtFechIni.setEditable(false);
		txtFechIni.setBounds(365, 22, 100, 20);
		contentPanel.add(txtFechIni);
		txtFechIni.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(365, 61, 100, 20);
		contentPanel.add(dateChooser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//RegContrato rgContrato = new RegContrato();
						//rgContrato.setVisible(true);
						//rgContrato.setLocationRelativeTo(null);
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
	}
}
