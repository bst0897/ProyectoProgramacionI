package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaContratos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaContratos dialog = new ListaContratos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaContratos() {
		setBounds(100, 100, 630, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					scrollPane.setViewportView(table);
				}
			}
		}
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String[] columnNames = {"Num de Contrato","Estado","Cliente","Fecha Inicio","Fecha Fin","Monto (RD$)"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		loadTable();
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

	private void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getMisProyectos().size(); i++) {
			fila[0] = Empresa.getInstance().getMisContratos().get(i).getNumCont();
			fila[1] = Empresa.getInstance().getMisProyectos().get(i).getEstado();
			fila[2] = Empresa.getInstance().getMisProyectos().get(i).getMiCliente();
			fila[3] = Empresa.getInstance().getMisProyectos().get(i).getFechaIni().getDate() + "-"+
					(Empresa.getInstance().getMisProyectos().get(i).getFechaIni().getMonth()+1) + "-"+
					(Empresa.getInstance().getMisProyectos().get(i).getFechaIni().getYear()+1900);
			
			fila[4] = Empresa.getInstance().getMisProyectos().get(i).getFechaFin().getDate() + "-"+
					(Empresa.getInstance().getMisProyectos().get(i).getFechaFin().getMonth()+1) + "-"+
					(Empresa.getInstance().getMisProyectos().get(i).getFechaFin().getYear()+1900);
			
			fila[5]=Empresa.getInstance().getMisContratos().get(i).getMontoPagar();
			
			model.addRow(fila);
	}

}
}
