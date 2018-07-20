package visual;

import java.awt.BorderLayout;
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

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtFechIni;
	private JTextField txtFechFin;

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
		lblTipo.setBounds(10, 61, 46, 14);
		contentPanel.add(lblTipo);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setBounds(138, 58, 137, 20);
		contentPanel.add(cbxTipo);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 109, 58, 14);
		contentPanel.add(lblCliente);
		
		JComboBox cbxCliente = new JComboBox();
		cbxCliente.setBounds(138, 106, 137, 20);
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
		
		txtFechFin = new JTextField();
		txtFechFin.setBounds(365, 58, 100, 20);
		contentPanel.add(txtFechFin);
		txtFechFin.setColumns(10);
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
