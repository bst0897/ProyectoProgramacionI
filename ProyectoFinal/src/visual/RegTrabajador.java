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

public class RegTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtLenguajes;
	private JTextField txtEdad;
	private JTextField txtSueldo;

	
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
		setBounds(100, 100, 588, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre Completo:");
			lblNombre.setBounds(12, 29, 116, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(124, 26, 245, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			{
				JLabel lblDirreccion = new JLabel("Direcci\u00F3n:");
				lblDirreccion.setBounds(12, 65, 70, 16);
				panel.add(lblDirreccion);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(124, 58, 245, 22);
				panel.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00E9dula:");
				lblNewLabel.setBounds(12, 94, 59, 16);
				panel.add(lblNewLabel);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(124, 91, 245, 22);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblPosicion = new JLabel("Posici\u00F3n:");
				lblPosicion.setBounds(12, 133, 56, 16);
				panel.add(lblPosicion);
			}
			
			JComboBox cbxPosicion = new JComboBox();
			cbxPosicion.setBounds(124, 130, 133, 22);
			panel.add(cbxPosicion);
			
			JLabel lblLenguajes = new JLabel("Lenguajes:");
			lblLenguajes.setBounds(12, 168, 83, 16);
			panel.add(lblLenguajes);
			
			txtLenguajes = new JTextField();
			txtLenguajes.setBounds(124, 165, 133, 22);
			panel.add(txtLenguajes);
			txtLenguajes.setColumns(10);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(394, 29, 56, 16);
			panel.add(lblSexo);
			
			JComboBox cbxSexo = new JComboBox();
			cbxSexo.setBounds(445, 26, 83, 22);
			panel.add(cbxSexo);
			
			JLabel lblNewLabel_1 = new JLabel("Edad:");
			lblNewLabel_1.setBounds(394, 94, 44, 16);
			panel.add(lblNewLabel_1);
			
			txtEdad = new JTextField();
			txtEdad.setBounds(445, 91, 83, 22);
			panel.add(txtEdad);
			txtEdad.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Sueldo:");
			lblNewLabel_2.setBounds(394, 162, 44, 16);
			panel.add(lblNewLabel_2);
			
			txtSueldo = new JTextField();
			txtSueldo.setBounds(445, 159, 83, 22);
			panel.add(txtSueldo);
			txtSueldo.setColumns(10);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
