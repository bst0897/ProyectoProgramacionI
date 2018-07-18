package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setTitle("Registro de Clientes");
		setBounds(100, 100, 465, 261);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Registro de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel label = new JLabel("C\u00E9dula");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			label.setBounds(10, 24, 70, 14);
			panel.add(label);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 49, 156, 20);
			panel.add(textField);
			
			JLabel lblNombreCompleto = new JLabel("Nombre Completo");
			lblNombreCompleto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNombreCompleto.setBounds(204, 24, 110, 14);
			panel.add(lblNombreCompleto);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(204, 49, 218, 20);
			panel.add(textField_1);
			
			JLabel label_1 = new JLabel("Direcci\u00F3n");
			label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			label_1.setBounds(10, 93, 70, 14);
			panel.add(label_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(10, 124, 245, 20);
			panel.add(textField_2);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
			spinner.setBounds(282, 124, 45, 20);
			panel.add(spinner);
			
			JLabel lblCantidadDePoryectos = new JLabel("Cantidad de Poryectos");
			lblCantidadDePoryectos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblCantidadDePoryectos.setBounds(279, 93, 126, 14);
			panel.add(lblCantidadDePoryectos);
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
				JButton cancelButton = new JButton("Cancelar");
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
