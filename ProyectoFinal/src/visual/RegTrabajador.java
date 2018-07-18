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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
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
			
			textField = new JTextField();
			textField.setBounds(124, 26, 245, 22);
			panel.add(textField);
			textField.setColumns(10);
			{
				JLabel lblDirreccion = new JLabel("Dirreccion:");
				lblDirreccion.setBounds(12, 65, 70, 16);
				panel.add(lblDirreccion);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(124, 58, 245, 22);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("Cedula:");
				lblNewLabel.setBounds(12, 94, 59, 16);
				panel.add(lblNewLabel);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(124, 91, 245, 22);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JLabel lblPosicion = new JLabel("Posicion:");
				lblPosicion.setBounds(12, 133, 56, 16);
				panel.add(lblPosicion);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(124, 130, 133, 22);
			panel.add(comboBox);
			
			JLabel lblLenguajes = new JLabel("Lenguajes*:");
			lblLenguajes.setBounds(12, 168, 83, 16);
			panel.add(lblLenguajes);
			
			textField_3 = new JTextField();
			textField_3.setBounds(124, 165, 133, 22);
			panel.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(394, 29, 56, 16);
			panel.add(lblSexo);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(445, 26, 83, 22);
			panel.add(comboBox_1);
			
			JLabel lblNewLabel_1 = new JLabel("Edad:");
			lblNewLabel_1.setBounds(394, 94, 44, 16);
			panel.add(lblNewLabel_1);
			
			textField_4 = new JTextField();
			textField_4.setBounds(445, 91, 83, 22);
			panel.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Sueldo:");
			lblNewLabel_2.setBounds(394, 162, 44, 16);
			panel.add(lblNewLabel_2);
			
			textField_5 = new JTextField();
			textField_5.setBounds(445, 159, 83, 22);
			panel.add(textField_5);
			textField_5.setColumns(10);
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
