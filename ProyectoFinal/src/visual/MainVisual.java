package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import logical.Cliente;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Component;


public class MainVisual extends JFrame {
	private JPanel contentPane;
	

	private Cliente cliente;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainVisual frame = new MainVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	
	public MainVisual() {
		setTitle("NOMBRE DE EMPRESA ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 402);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
	}
}
