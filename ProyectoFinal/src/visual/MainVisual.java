package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logical.Cliente;
import logical.Contrato;
import logical.Empresa;
import logical.Proyecto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;






public class MainVisual extends JFrame {
	
	private int web=0;
	private int sis=0;
	private int adm=0;
	private int ide=0;
	private int edu=0;
	private int otro=0;
	private double gan=0;
	private double per=0;
	
	
	private JPanel contentPane;
	

	JPanel panel;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	
	

	

	/**
	 * Create the frame.
	 */
	
	public MainVisual() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream f;
				try {
					f = new FileOutputStream("Empresa.dat");
					ObjectOutputStream oos = new ObjectOutputStream(f);
					oos.writeObject(Empresa.getInstance());
					oos.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
				
				
			}
		});
		
		setTitle("BHDL Software Development");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 402);
		setLocationRelativeTo(null);
		
		try {
			FileInputStream f = new FileInputStream("Empresa.dat");
			 ObjectInputStream oos2 = new ObjectInputStream(f);
			 Empresa.setInstance((Empresa)oos2.readObject());
			 oos2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		DatosGrafica1();
		DatosGrafica2();
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenuItem mntmRegistrarProyecto = new JMenuItem("Registrar Proyecto");
		mntmRegistrarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegProyecto rgProyecto = new RegProyecto();
				rgProyecto.setLocationRelativeTo(null);
				rgProyecto.setModal(true);
				rgProyecto.setVisible(true);
			}
		});
		mnProyectos.add(mntmRegistrarProyecto);
		
		JMenuItem mntmListadoDeProyectos = new JMenuItem("Listado de Proyectos");
		mntmListadoDeProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProyectos lsProyectos = new ListaProyectos();
				lsProyectos.setLocationRelativeTo(null);
				lsProyectos.setModal(true);
				lsProyectos.setVisible(true);
			}
		});
		mnProyectos.add(mntmListadoDeProyectos);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegCliente rgcliente = new RegCliente(cliente);
				rgcliente.setLocationRelativeTo(null);
				rgcliente.setModal(true);
				rgcliente.setVisible(true);
			}
		});
		mnClientes.add(mntmRegistrarCliente);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarClientes lsClientes = new ListarClientes();
				lsClientes.setLocationRelativeTo(null);
				lsClientes.setModal(true);
				lsClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmListadoDeClientes);
		
		JMenu mnTrabajadores = new JMenu("Trabajadores");
		menuBar.add(mnTrabajadores);
		
		JMenuItem mntmRegistrarTrabajador = new JMenuItem("Registrar Trabajador");
		mntmRegistrarTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegTrabajador rgtrab = new RegTrabajador();
				rgtrab.setLocationRelativeTo(null);
				rgtrab.setModal(true);
				rgtrab.setVisible(true);
			}
		});
		mnTrabajadores.add(mntmRegistrarTrabajador);
		
		JMenuItem mntmListadoDeTrabajadores = new JMenuItem("Listado de Trabajadores");
		mntmListadoDeTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarTrabajador lstrabajadores = new ListarTrabajador();
				lstrabajadores.setLocationRelativeTo(null);
				lstrabajadores.setModal(true);
				lstrabajadores.setVisible(true);
			}
		});
		mnTrabajadores.add(mntmListadoDeTrabajadores);
		
		JMenu mnContratos = new JMenu("Contratos");
		menuBar.add(mnContratos);
		
		JMenuItem mntmListadoDeContratos = new JMenuItem("Listado de Contratos");
		mntmListadoDeContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaContratos lsContratos = new ListaContratos();
				lsContratos.setVisible(true);
				lsContratos.setLocationRelativeTo(null);

				
			}
		});
		mnContratos.add(mntmListadoDeContratos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		hindred();
		braian();
		lisaril();
		
		
	}
	
	
	public void DatosGrafica1() {
		String aux ="";
		for (Proyecto proyecto : Empresa.getInstance().getMisProyectos()) {
			
			aux=  proyecto.getTipo();
			
			if (aux.equalsIgnoreCase("Web"))
			{
				web++;
				
			}
			if (aux.equalsIgnoreCase("Sistema Operativo"))
			{
				sis++;
				
			}
			
			if (aux.equalsIgnoreCase("Administracion/Contabilidad"))
			{
				adm++;
				
			}
			if (aux.equalsIgnoreCase("IDE"))
			{
				ide++;
				
			}
			if (aux.equalsIgnoreCase("Educativo"))
			{
				edu++;
				
			}
			if (aux.equalsIgnoreCase("Otro/a"))
			{
				otro++;
				
			}
		}
	}
	
	  public void DatosGrafica2() {
		  double aux=0;
		  double perd=0;
		  
		  for(Contrato contrato : Empresa.getInstance().getMisContratos()) {
			  
			  aux+=contrato.getMontoPagar()*0.15;
			  if(contrato.getMiProyecto().getEstado().equalsIgnoreCase("atrasado")) {
				  int days = 0;
				  days = Empresa.getInstance().daysBetween(contrato.getFechaIni(), contrato.getFechaFin());
				  perd+= (days*contrato.getMontoPagar()*0.01);
			  }
		  }
		  gan=aux;
		  per = perd;
	  }
	  private void hindred() {
	       panel = new JPanel();
	       panel.setAlignmentY(Component.TOP_ALIGNMENT);
	       panel.setAlignmentX(Component.LEFT_ALIGNMENT);
	       getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(web, "Web","Web");
	        dataset.setValue(sis, "Sistema Operativo","Sistema Operativo");
	        dataset.setValue(adm, "Adminitracion","Adminitracion");
	        dataset.setValue(ide, "IDE","IDE");
	        dataset.setValue(edu, "Educativo","Educativo");
	        dataset.setValue(otro, "Otro/a","Otro/a");
	     
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Tipos De Software Creados","Tipos", "Cantidad", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.white);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.blue); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);

	    }
	
	  private void braian() {
	       panel = new JPanel();
	       panel.setAlignmentY(Component.TOP_ALIGNMENT);
	       panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
	       getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(gan, "Ganancia","Ganancia");
	        dataset.setValue(per, "Perdida","Perdida");
	      
	     
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Ganancia VS Perdida","Tipo", "Valor $", 
	        dataset, PlotOrientation.HORIZONTAL, true,true, false);
	        chart.setBackgroundPaint(Color.white);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.blue); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);

	    }
	  
	  private void lisaril() {
	       panel = new JPanel();
	       panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	       panel.setAlignmentX(Component.LEFT_ALIGNMENT);
	       getContentPane().add(panel);
	        // Fuente de Datos
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	        dataset.setValue(8, "Web","Web");
	        dataset.setValue(7, "Sistema Operativo","Sistema Operativo");
	        dataset.setValue(9, "Adminitracion","Adminitracion");
	        dataset.setValue(4, "IDE","IDE");
	        dataset.setValue(4, "Educativo","Educativo");
	      
	     
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("5 Mejores Trabajadores ","Nombre", "Puntos", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.setBackgroundPaint(Color.white);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.blue); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	        chartPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	        panel.add(chartPanel);

	    }
	
	
	
}

