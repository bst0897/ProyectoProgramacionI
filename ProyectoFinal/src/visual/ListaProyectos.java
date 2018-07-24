package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logical.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaProyectos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private static DefaultTableModel model;

	
	public ListaProyectos() {
		setBounds(100, 100, 516, 354);
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
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnNames = {"Estado","Nombre","Tipo","Fecha Inicio","Fecha Fin"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					loadTable();
					table.setBorder(null);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnModificar = new JButton("Modificar");
				buttonPane.add(btnModificar);
			}
			{
				JButton okButton = new JButton("Terminado");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
	public static void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getMisProyectos().size(); i++) {
			fila[0] = Empresa.getInstance().getMisProyectos().get(i).getEstado();
			fila[1] = Empresa.getInstance().getMisProyectos().get(i).getNombre();
			fila[2] = Empresa.getInstance().getMisProyectos().get(i).getTipo();
			fila[3] = Empresa.getInstance().getMisProyectos().get(i).getFechaIni().getDate() + "-"+
					Empresa.getInstance().getMisProyectos().get(i).getFechaIni().getMonth() + "-"+
					(Empresa.getInstance().getMisProyectos().get(i).getFechaIni().getYear()+1900);
			
			fila[4] = Empresa.getInstance().getMisProyectos().get(i).getFechaFin().getDate() + "-"+
					Empresa.getInstance().getMisProyectos().get(i).getFechaFin().getMonth() + "-"+
					(Empresa.getInstance().getMisProyectos().get(i).getFechaFin().getYear()+1900);
			
			model.addRow(fila);
			
		}
	}
}
