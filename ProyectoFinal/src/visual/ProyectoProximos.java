package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Collection;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Empresa;

import javax.swing.JLabel;

public class ProyectoProximos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProyectoProximos dialog = new ProyectoProximos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProyectoProximos() {
		setTitle("Proyectos Proximos");
		setBounds(100, 100, 730, 575);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lbl1 = new JLabel("New label");
		lbl1.setBounds(310, 83, 113, 32);
		contentPanel.add(lbl1);
		
		lbl2 = new JLabel("New label");
		lbl2.setBounds(310, 137, 113, 32);
		contentPanel.add(lbl2);
		
		lbl3 = new JLabel("New label");
		lbl3.setBounds(310, 195, 113, 32);
		contentPanel.add(lbl3);
		
		lbl4 = new JLabel("New label");
		lbl4.setBounds(310, 258, 113, 32);
		contentPanel.add(lbl4);
		
		lbl5 = new JLabel("New label");
		lbl5.setBounds(310, 323, 113, 32);
		contentPanel.add(lbl5);
		
		Collections.sort(Empresa.getInstance().getMisProyectos());
		
		lbl1.setText(Empresa.getInstance().getMisProyectos().get(0).getNombre());
		lbl2.setText(Empresa.getInstance().getMisProyectos().get(1).getNombre());
		lbl3.setText(Empresa.getInstance().getMisProyectos().get(2).getNombre());
		lbl4.setText(Empresa.getInstance().getMisProyectos().get(3).getNombre());
		lbl5.setText(Empresa.getInstance().getMisProyectos().get(4).getNombre());
		lbl1.setForeground(Color.green);
		lbl2.setForeground(Color.green);
		lbl3.setForeground(Color.yellow);
		lbl4.setForeground(Color.red);
		lbl5.setForeground(Color.red);
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
