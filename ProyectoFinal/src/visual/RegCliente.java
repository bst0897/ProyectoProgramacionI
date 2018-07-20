package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import logical.Cliente;
import logical.Empresa;

import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private Cliente cliente;
			
	
		public RegCliente(Cliente cli) {
			this.cliente = cli;
			setResizable(false);
			if(cli == null){
			setTitle("Registro de Clientes");
			}else{
			  setTitle("Modificar Cliente");	
			}		
		setTitle("Registro de Clientes");
		setBounds(100, 100, 465, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Registro de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblCdula.setBounds(10, 24, 70, 14);
			panel.add(lblCdula);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(10, 49, 156, 20);
			panel.add(txtCedula);
			
			JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
			lblNombreCompleto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNombreCompleto.setBounds(204, 24, 110, 14);
			panel.add(lblNombreCompleto);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(204, 49, 218, 20);
			panel.add(txtNombre);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblDireccin.setBounds(10, 93, 70, 14);
			panel.add(lblDireccin);
			
			JTextArea txtDireccion = new JTextArea();
			txtDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			txtDireccion.setBounds(20, 118, 294, 60);
			panel.add(txtDireccion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						if(cli==null) {
							Cliente cli = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText());
							Empresa.getInstance().insertCliente(cli);
							JOptionPane.showMessageDialog(null, "Operaci�n satisfactoria", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
							clean();
							}
						else{
								
								cli.setIdentificador(txtCedula.getText());
								cli.setNombre(txtNombre.getText());
								cli.setDireccion(txtDireccion.getText());
								Empresa.getInstance().ModificarCliente(cli);
								JOptionPane.showMessageDialog(null, "Operaci�n satisfactoria", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}

					
					}
				});
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
		private void clean() {
			txtNombre.setText("");
			txtCedula.setText("");
			txtDireccion.setText("");
		}
}
