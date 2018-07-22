package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Cliente;
import logical.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnModificar;
	private static JButton btnEliminar;
	private String cedula;

	public ListarClientes() {
		setTitle("Listado de Clientes");
		setBounds(100, 100, 559, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 533, 253);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					table = new JTable();
					scrollPane.setColumnHeaderView(table);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if(table.getSelectedRow()>=0){
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								int index = table.getSelectedRow();
								cedula = (String)table.getModel().getValueAt(index, 0);
							}
						}
					});
					
				}
				tableModel = new DefaultTableModel();
				String[] columnNames = {"Cedula","Nombre","Direccion"};
				tableModel.setColumnIdentifiers(columnNames);
				table.setModel(tableModel);
				loadTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!cedula.equalsIgnoreCase("")){
							Cliente cli = Empresa.getInstance().BuscarCliente(cedula);
							RegCliente regCliente = new RegCliente(cli);
							regCliente.setLocationRelativeTo(null);
							regCliente.setModal(true);
							regCliente.setVisible(true);
							 btnEliminar.setEnabled(false);
							 btnModificar.setEnabled(false);
							 loadTable();
			    	}
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!cedula.equalsIgnoreCase("")){
						 Cliente cli1 = Empresa.getInstance().BuscarCliente(cedula);
						 int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Cliente: " +(cli1.getNombre()),"Información",JOptionPane.WARNING_MESSAGE);
						  if(option == JOptionPane.OK_OPTION){
						    Empresa.getInstance().removeCliente(cli1);
						    btnEliminar.setEnabled(false);
						    btnModificar.setEnabled(false);
						    loadTable();
						}
					}
				}
			});
			btnEliminar.setEnabled(false);
			buttonPane.add(btnEliminar);
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

	private static void loadTable() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		for (Cliente aux : Empresa.getInstance().getMisClientes()) {
			fila[0] = aux.getIdentificador();
			fila[1] = aux.getNombre();
			fila[2] = aux.getDireccion();
			tableModel.addRow(fila);
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(180);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
	}
}
