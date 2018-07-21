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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class RegTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtLenguajes;
	private JTextField txtEdad;
	private JTextField txtSueldo;
	private JSpinner spnCantTrab;
	private JLabel lblLenguajes; 
	private JLabel lblCantidadDeTrabajadores;

	
	public static void main(String[] args) {
		try {
			RegTrabajador dialog = new RegTrabajador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegTrabajador() {
		setTitle("Registrar Trabajador");
		setBounds(100, 100, 661, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre Completo:");
			lblNombre.setBounds(10, 61, 116, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(169, 58, 245, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			{
				JLabel lblDirreccion = new JLabel("Direcci\u00F3n:");
				lblDirreccion.setBounds(10, 122, 70, 16);
				panel.add(lblDirreccion);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(169, 119, 245, 22);
				panel.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00E9dula:");
				lblNewLabel.setBounds(10, 88, 59, 16);
				panel.add(lblNewLabel);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(169, 86, 245, 22);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblPosicion = new JLabel("Posici\u00F3n:");
				lblPosicion.setBounds(10, 34, 56, 16);
				panel.add(lblPosicion);
			}
			
			JComboBox cbxPosicion = new JComboBox();
			cbxPosicion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Diseñador")) {
						txtLenguajes.setVisible(false);
						spnCantTrab.setVisible(false);
						lblLenguajes.setVisible(false);
						lblCantidadDeTrabajadores.setVisible(false);
					}
					if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Jefe de Proyecto")) {
						txtLenguajes.setVisible(false);
						//spnCantTrab.setVisible(false);
						lblLenguajes.setVisible(false);
					//	lblCantidadDeTrabajadores.setVisible(false);
					}
					if(cbxPosicion.getSelectedItem().toString().equalsIgnoreCase("Programador")) {
						//txtLenguajes.setVisible(false);
						spnCantTrab.setVisible(false);
						//lblLenguajes.setVisible(false);
						lblCantidadDeTrabajadores.setVisible(false);
					}
				}
			});
			cbxPosicion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Jefe de proyecto", "Dise\u00F1ador", "Programador", "Planificador"}));
			cbxPosicion.setBounds(169, 31, 124, 22);
			panel.add(cbxPosicion);
			
			JLabel lblLenguajes = new JLabel("Lenguaje Especializacion:");
			lblLenguajes.setBounds(10, 149, 149, 16);
			panel.add(lblLenguajes);
			
			txtLenguajes = new JTextField();
			txtLenguajes.setBounds(169, 152, 150, 22);
			panel.add(txtLenguajes);
			txtLenguajes.setColumns(10);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(447, 34, 44, 16);
			panel.add(lblSexo);
			
			JComboBox cbxSexo = new JComboBox();
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
			cbxSexo.setBounds(501, 31, 107, 22);
			panel.add(cbxSexo);
			
			JLabel lblNewLabel_1 = new JLabel("Edad:");
			lblNewLabel_1.setBounds(447, 61, 44, 16);
			panel.add(lblNewLabel_1);
			
			txtEdad = new JTextField();
			txtEdad.setBounds(501, 58, 83, 22);
			panel.add(txtEdad);
			txtEdad.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Sueldo:");
			lblNewLabel_2.setBounds(447, 88, 44, 16);
			panel.add(lblNewLabel_2);
			
			txtSueldo = new JTextField();
			txtSueldo.setBounds(501, 85, 83, 22);
			panel.add(txtSueldo);
			txtSueldo.setColumns(10);
			
			JSpinner spnCantTrab = new JSpinner();
			spnCantTrab.setBounds(169, 183, 29, 20);
			panel.add(spnCantTrab);
			
			JLabel lblCantidadDeTrabajadores = new JLabel("Cantidad de Trabajadores:");
			lblCantidadDeTrabajadores.setBounds(10, 185, 163, 16);
			panel.add(lblCantidadDeTrabajadores);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
