package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Diseñador;
import logical.Empresa;
import logical.JefeDeProyecto;
import logical.Planificador;
import logical.Programador;
import logical.Trabajador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class RegTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtSueldo;
	private JSpinner spnCantTrab;
	private JComboBox cbxSexo;
	private JLabel lblLenguajes; 
	private JLabel lblCantidadDeTrabajadores;
	private JTextField txtfrecuenciaTarea;
	private JRadioButton rdbjefe;
	private JRadioButton rdbdise;
	private JRadioButton rdbprogramador;
	private JRadioButton rdbplanificador;
	private JLabel lblNewLabel_4;
	private JFormattedTextField txtffechanaci;
	private JDateChooser dateChooser;
	private JList lsLenguajesDisp;
	private JList lsLengSelec;
	private JButton btnRemLang;
	private JButton btnAddLang;
	private ArrayList<String> lenguajes = new ArrayList<String>();
	DefaultListModel  model = new DefaultListModel();
	DefaultListModel  model2 = new DefaultListModel();
	
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
		setBounds(100, 100, 662, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre Completo:");
			lblNombre.setBounds(10, 34, 116, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(169, 31, 245, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			{
				JLabel lblDirreccion = new JLabel("Direcci\u00F3n:");
				lblDirreccion.setBounds(10, 104, 70, 16);
				panel.add(lblDirreccion);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(169, 101, 245, 22);
				panel.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00E9dula:");
				lblNewLabel.setBounds(10, 69, 59, 16);
				panel.add(lblNewLabel);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setBounds(169, 66, 245, 22);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblPosicion = new JLabel("Posici\u00F3n Del Trabajador:");
				lblPosicion.setBounds(83, 136, 162, 16);
				panel.add(lblPosicion);
			}
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(447, 34, 44, 16);
			panel.add(lblSexo);
			
			cbxSexo = new JComboBox();
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Masculino", "Femenino"}));
			cbxSexo.setBounds(501, 31, 106, 22);
			panel.add(cbxSexo);
			
			JLabel lblNewLabel_2 = new JLabel("Sueldo:");
			lblNewLabel_2.setBounds(447, 72, 44, 16);
			panel.add(lblNewLabel_2);
			
			txtSueldo = new JTextField();
			txtSueldo.setBounds(501, 69, 106, 22);
			panel.add(txtSueldo);
			txtSueldo.setColumns(10);
			
			spnCantTrab = new JSpinner();
			spnCantTrab.setModel(new SpinnerNumberModel(2, 2, 4, 1));
			spnCantTrab.setBounds(488, 187, 29, 20);
			panel.add(spnCantTrab);
			
			JLabel lblCantidadDeTrabajadores = new JLabel("Cantidad de Trabajadores:");
			lblCantidadDeTrabajadores.setBounds(328, 189, 163, 16);
			panel.add(lblCantidadDeTrabajadores);
			
			JLabel lblNewLabel_3 = new JLabel("$");
			lblNewLabel_3.setBounds(617, 72, 29, 16);
			panel.add(lblNewLabel_3);
			
			rdbjefe = new JRadioButton("Jefe De Proyecto");
			rdbjefe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbjefe.setSelected(true);
					rdbprogramador.setSelected(false);
					rdbdise.setSelected(false);
					rdbplanificador.setSelected(false);
					txtfrecuenciaTarea.setVisible(false);
					spnCantTrab.setVisible(true);
					lblCantidadDeTrabajadores.setVisible(true);
					lblNewLabel_4.setVisible(false);
					lsLenguajesDisp.setVisible(false);
					lsLengSelec.setVisible(false);
					btnAddLang.setVisible(false);
					btnRemLang.setVisible(false);
					
					
				}
			});
			rdbjefe.setBounds(10, 162, 127, 25);
			panel.add(rdbjefe);
			
			rdbdise = new JRadioButton("Dise\u00F1ador");
			rdbdise.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbjefe.setSelected(false);
					rdbprogramador.setSelected(false);
					rdbdise.setSelected(true);
					rdbplanificador.setSelected(false);
					txtfrecuenciaTarea.setVisible(false);
					spnCantTrab.setVisible(false);
					lblCantidadDeTrabajadores.setVisible(false);
					lblNewLabel_4.setVisible(false);
					lsLenguajesDisp.setVisible(false);
					lsLengSelec.setVisible(false);
					btnAddLang.setVisible(false);
					btnRemLang.setVisible(false);
				}
			});
			rdbdise.setBounds(190, 162, 106, 25);
			panel.add(rdbdise);
			
			rdbprogramador = new JRadioButton("Programador");
			rdbprogramador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbjefe.setSelected(false);
					rdbprogramador.setSelected(true);
					rdbdise.setSelected(false);
					rdbplanificador.setSelected(false);
					txtfrecuenciaTarea.setVisible(false);
					spnCantTrab.setVisible(false);
					lblCantidadDeTrabajadores.setVisible(false);
					lblNewLabel_4.setVisible(false);
					lsLenguajesDisp.setVisible(true);
					lsLengSelec.setVisible(true);
					btnAddLang.setVisible(true);
					btnRemLang.setVisible(true);
				}
			});
			rdbprogramador.setBounds(10, 201, 127, 25);
			panel.add(rdbprogramador);
			
			rdbplanificador = new JRadioButton("Planificador");
			rdbplanificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbjefe.setSelected(false);
					rdbprogramador.setSelected(false);
					rdbdise.setSelected(false);
					rdbplanificador.setSelected(true);
					txtfrecuenciaTarea.setVisible(true);
					spnCantTrab.setVisible(false);
					lblCantidadDeTrabajadores.setVisible(false);
					lblNewLabel_4.setVisible(true);
					lsLenguajesDisp.setVisible(false);
					lsLengSelec.setVisible(false);
					btnAddLang.setVisible(false);
					btnRemLang.setVisible(false);
				}
				
			});
			
			rdbplanificador.setBounds(190, 201, 106, 25);
			panel.add(rdbplanificador);
			
			lblNewLabel_4 = new JLabel("Frecuencia de tareas:");
			lblNewLabel_4.setBounds(326, 189, 149, 16);
			panel.add(lblNewLabel_4);
			
			txtfrecuenciaTarea = new JTextField();
			txtfrecuenciaTarea.setBounds(487, 186, 136, 22);
			panel.add(txtfrecuenciaTarea);
			txtfrecuenciaTarea.setColumns(10);
			
			JLabel label = new JLabel("");
			
			label.setBounds(513, 166, 56, 16);
			panel.add(label);
			rdbjefe.setSelected(false);
			rdbprogramador.setSelected(false);
			rdbdise.setSelected(true);
			rdbplanificador.setSelected(false);
			
			
			JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
			lblFechaDeNacimiento.setBounds(364, 137, 127, 16);
			panel.add(lblFechaDeNacimiento);
			
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd/MM/yyyy");
			dateChooser.setBounds(501, 136, 106, 20);
			panel.add(dateChooser);
			
			lsLenguajesDisp = new JList(model);
			lsLenguajesDisp.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			lsLenguajesDisp.setBounds(374, 166, 70, 103);
			panel.add(lsLenguajesDisp);
		
			lenguajes.add("Java");
			lenguajes.add("C/C++");
			lenguajes.add("C#");
			lenguajes.add("Python");
			for (String string : lenguajes) {
				model.addElement(string);
			}
			
			lsLengSelec = new JList(model2);
			lsLengSelec.setBounds(537, 166, 70, 103);
			panel.add(lsLengSelec);
			
			btnAddLang = new JButton("->");
			btnAddLang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = lsLenguajesDisp.getSelectedValue().toString();
					if(aux!=null) {
						model2.addElement(aux);
						model.removeElementAt(lsLenguajesDisp.getSelectedIndex());
					}
					
				}
			});
			btnAddLang.setBounds(467, 186, 50, 23);
			panel.add(btnAddLang);
			
			btnRemLang = new JButton("<-");
			btnRemLang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = lsLengSelec.getSelectedValue().toString();
					if(aux!=null) {
						model.addElement(aux);
						model2.removeElementAt(lsLengSelec.getSelectedIndex());
					}
				}
			});
			btnRemLang.setBounds(467, 220, 50, 23);
			panel.add(btnRemLang);
			
			txtfrecuenciaTarea.setVisible(false);
			spnCantTrab.setVisible(false);
			lblCantidadDeTrabajadores.setVisible(false);
			lblNewLabel_4.setVisible(false);
			lsLenguajesDisp.setVisible(false);
			lsLengSelec.setVisible(false);
			btnAddLang.setVisible(false);
			btnRemLang.setVisible(false);
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Trabajador aux = null;
						//int edad = new Integer(txtEdad.getText());
					int edad = edad(dateChooser.getDate().getDate() + "/" + (dateChooser.getDate().getMonth()+1)+"/" + (dateChooser.getDate().getYear()+1900));
						Double sueldo = new Double(txtSueldo.getText());
						String sexo = cbxSexo.getSelectedItem().toString();
						int cantTrab = Integer.valueOf(spnCantTrab.getValue().toString());
						if(rdbdise.isSelected()) {
							aux = new Diseñador(txtCedula.getText(), txtNombre.getText(),txtDireccion.getText(), sexo, edad, sueldo);
						}
						if(rdbjefe.isSelected()) {
							aux = new JefeDeProyecto(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), sexo, edad, sueldo, cantTrab);
						}
						if(rdbplanificador.isSelected()) {
							aux = new Planificador(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), sexo, edad, sueldo, new Integer(txtfrecuenciaTarea.getText()));
						}
						if(rdbprogramador.isSelected()) {
							ArrayList<String> leng = new ArrayList<>();
							for (int i = 0; i < model2.size(); i++) {
								leng.add((String)model2.get(i));
							}
					aux = new Programador(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), sexo, edad, sueldo, leng);
						}
						Empresa.getInstance().insertTrabajador(aux);
						JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
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

	private void clean() {
		txtCedula.setText("");
		txtDireccion.setText("");
		txtfrecuenciaTarea.setText("");
		txtNombre.setText("");
		txtSueldo.setText("");
		cbxSexo.setSelectedIndex(0);
		dateChooser.setDate(null);
		model.removeAllElements();
		model2.removeAllElements();
		for (String string : lenguajes) {
			model.addElement(string);
		}
	}
	
	public int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy  
	    Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    String hoy = formato.format(fechaActual);
	    String[] dat1 = fecha_nac.split("/");
	    String[] dat2 = hoy.split("/");
	    int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
	    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
	    if (mes < 0) {
	      anos = anos - 1;
	    } else if (mes == 0) {
	      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	      if (dia > 0) {
	        anos = anos - 1;
	      }
	    }
	    return anos;
	  }
}
