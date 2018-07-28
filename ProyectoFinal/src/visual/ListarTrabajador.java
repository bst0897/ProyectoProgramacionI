package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Diseñador;
import logical.Empresa;
import logical.JefeDeProyecto;
import logical.Planificador;
import logical.Programador;
import logical.Trabajador;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private String cedula;
	private JComboBox cbxTipoTraba;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarTrabajador dialog = new ListarTrabajador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarTrabajador() {
		setTitle("Listado De Trabajador");
		setBounds(100, 100, 691, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 11, 663, 263);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 35, 663, 228);
			panel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(table.getSelectedRow()>=0){
							btnEliminar.setEnabled(true);
							int index = table.getSelectedRow();
							cedula = (String)table.getModel().getValueAt(index, 0);
						}
					}
				});
			}
			tableModel = new DefaultTableModel();
			String[] columnNames = {"Cedula","Nombre Completo","Dirección", "Edad", "Sexo","Salario", "Cargo"};
			tableModel.setColumnIdentifiers(columnNames);
			table.setModel(tableModel);
			loadTrabajadoresTable(0);
			scrollPane.setColumnHeaderView(table);
			scrollPane.setViewportView(table);

			}	
			{
				JLabel lblTrabajadoresPorCargo = new JLabel("Trabajadores por cargo:");
				lblTrabajadoresPorCargo.setBounds(10, 10, 129, 14);
				panel.add(lblTrabajadoresPorCargo);
				lblTrabajadoresPorCargo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			}
			
			cbxTipoTraba = new JComboBox();
			cbxTipoTraba.setBounds(135, 4, 134, 20);
			panel.add(cbxTipoTraba);
			cbxTipoTraba.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selection = cbxTipoTraba.getSelectedIndex();
					loadTrabajadoresTable(selection);
				}
			});
			cbxTipoTraba.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Dise\u00F1ador", "Planificador", "Jefe de Proyecto", "Programador"}));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
	public static void loadTrabajadoresTable(int selection) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		switch (selection) {
		case 0:
			for (Trabajador aux : Empresa.getInstance().getMisTrabs()) {
				
				fila[0] = aux.getId();
				fila[1] = aux.getNomCom();
				fila[2] = aux.getDir();
				fila[3] = aux.getEdad();
				fila[4] = aux.getSexo();
				fila[5] = aux.getSalario();
				fila[6] = "Diseñador";
				if(aux instanceof JefeDeProyecto) {
					fila[6] = "Jefe de Proyecto";
				}
				if(aux instanceof Planificador) {
					fila[6] = "Planificador";
				}
				if(aux instanceof Programador) {
					fila[6] = "Programador";
				}
				tableModel.addRow(fila);
				String[] columnNames = {"Cedula","Nombre Completo","Dirección", "Edad", "Sexo","Salario", "Cargo"};
				tableModel.setColumnIdentifiers(columnNames);
			}
			
			break;
		case 1:
			for (Trabajador aux : Empresa.getInstance().getMisTrabs()) {
				if(aux instanceof Diseñador){
					fila[0] = aux.getId();
					fila[1] = aux.getNomCom();
					fila[2] = aux.getDir();
					fila[3] = aux.getEdad();
					fila[4] = aux.getSexo();
					fila[5] = aux.getSalario();
				tableModel.addRow(fila);
				String[] columnNames = {"Cedula","Nombre Completo","Dirección", "Edad", "Sexo","Salario", "Cargo"};
				tableModel.setColumnIdentifiers(columnNames);
				

				}
			}
			break;	
			
		case 2:
			for (Trabajador aux : Empresa.getInstance().getMisTrabs()) {
				if(aux instanceof Planificador){
					fila[0] = aux.getId();
					fila[1] = aux.getNomCom();
					fila[2] = aux.getDir();
					fila[3] = aux.getEdad();
					fila[4] = aux.getSexo();
					fila[5] = aux.getSalario();
					fila[6] = ((Planificador) aux).getFrecuenciaTarea();
					String[] columnNames = {"Cedula","Nombre Completo","Dirección", "Edad", "Sexo","Salario", "Frecuencia"};
					tableModel.setColumnIdentifiers(columnNames);


				tableModel.addRow(fila);
				}
			}
			break;	
		case 3:
			for (Trabajador aux : Empresa.getInstance().getMisTrabs()) {
				if(aux instanceof JefeDeProyecto){
					fila[0] = aux.getId();
					fila[1] = aux.getNomCom();
					fila[2] = aux.getDir();
					fila[3] = aux.getEdad();
					fila[4] = aux.getSexo();
					fila[5] = aux.getSalario();
					fila[6] = ((JefeDeProyecto) aux).getCantTrabajo();
					String[] columnNames = {"Cedula","Nombre Completo","Dirección", "Edad", "Sexo","Salario", "Cantidad de Trabajadores"};
					tableModel.setColumnIdentifiers(columnNames);
				tableModel.addRow(fila);
				}
			}
			break;	
		case 4:
			for (Trabajador aux : Empresa.getInstance().getMisTrabs()) {
				if(aux instanceof Programador){
					fila[0] = aux.getId();
					fila[1] = aux.getNomCom();
					fila[2] = aux.getDir();
					fila[3] = aux.getEdad();
					fila[4] = aux.getSexo();
					fila[5] = aux.getSalario();
					fila[6] = ((Programador) aux).getLenguajes();
					String[] columnNames = {"Cedula","Nombre Completo","Dirección", "Edad", "Sexo","Salario", "Lenguajes"};
					tableModel.setColumnIdentifiers(columnNames);
				tableModel.addRow(fila);
				}
			}
			break;	
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(180);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(180);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);
		columnModel.getColumn(5).setPreferredWidth(100);
		columnModel.getColumn(6).setPreferredWidth(100);
	}
}
