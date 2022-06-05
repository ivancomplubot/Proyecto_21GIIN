package entrega_v4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Choice;

public class menu_municipio extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Categoria;
	private JTextField Nombre_m;
	private JTextField Clave_m;
	private int estado = 0, eliminar,modificar;
	private ArrayList<municipio> lista_mostrar;
	private JTextField Cuentadante;
	private JTextField Cuentadante_m;

	public menu_municipio(ArrayList<municipio> aux) 
	{
		lista_mostrar = new ArrayList<municipio>(aux);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice municipio_eliminar = new Choice();
		municipio_eliminar.setBounds(109, 120, 309, 20);
		contentPane.add(municipio_eliminar);
		
		Choice municipio_modificar = new Choice();
		municipio_modificar.setBounds(109, 199, 309, 20);
		contentPane.add(municipio_modificar);
		
		for(int x=0;x<this.lista_mostrar.size();x++)
		{
			municipio_eliminar.add(this.lista_mostrar.get(x).mostrar());
			municipio_modificar.add(this.lista_mostrar.get(x).mostrar());
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(1);
				municipio_eliminar.removeAll();
				municipio_modificar.removeAll();
				
			}
		});
		btnAgregar.setBounds(498, 26, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(2);
				setEliminar(municipio_eliminar.getSelectedIndex());
				municipio_eliminar.removeAll();
				municipio_modificar.removeAll();
			}
		});
		btnEliminar.setBounds(498, 97, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(3);
				setModificar(municipio_modificar.getSelectedIndex());
				
				municipio_eliminar.removeAll();
				municipio_modificar.removeAll();
			}
		});
		btnModificar.setBounds(498, 177, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(554, 327, 70, 23);
		contentPane.add(btnSalir);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(-1);
			}
		});
		btnMenuPrincipal.setBounds(109, 327, 128, 23);
		contentPane.add(btnMenuPrincipal);
		
		Nombre = new JTextField();
		Nombre.setBounds(109, 51, 86, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		Categoria = new JTextField();
		Categoria.setBounds(205, 51, 86, 20);
		contentPane.add(Categoria);
		Categoria.setColumns(10);
		
		Cuentadante = new JTextField();
		Cuentadante.setColumns(10);
		Cuentadante.setBounds(301, 51, 86, 20);
		contentPane.add(Cuentadante);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 614, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(109, 26, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblClave = new JLabel("Categoria:");
		lblClave.setBounds(205, 26, 70, 14);
		contentPane.add(lblClave);
		
		JLabel lblTipo = new JLabel("Cuentadante:");
		lblTipo.setBounds(301, 26, 104, 14);
		contentPane.add(lblTipo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 164, 614, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Seleciona el municipio a eliminar:");
		lblNewLabel.setBounds(111, 97, 276, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelecionaElUsuario = new JLabel("Seleciona el municipio a modificar:");
		lblSelecionaElUsuario.setBounds(111, 176, 276, 14);
		contentPane.add(lblSelecionaElUsuario);
		
		Nombre_m = new JTextField();
		Nombre_m.setColumns(10);
		Nombre_m.setBounds(109, 255, 86, 20);
		contentPane.add(Nombre_m);
		
		Clave_m = new JTextField();
		Clave_m.setColumns(10);
		Clave_m.setBounds(205, 255, 86, 20);
		contentPane.add(Clave_m);
		
		Cuentadante_m = new JTextField();
		Cuentadante_m.setColumns(10);
		Cuentadante_m.setBounds(301, 255, 86, 20);
		contentPane.add(Cuentadante_m);
		
		JLabel lblTipo_1 = new JLabel("Cuentadante:");
		lblTipo_1.setBounds(301, 230, 104, 14);
		contentPane.add(lblTipo_1);
		
		JLabel lblClave_1 = new JLabel("Categoria:");
		lblClave_1.setBounds(205, 230, 70, 14);
		contentPane.add(lblClave_1);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(109, 230, 59, 14);
		contentPane.add(lblNombre_1);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				municipio_modificar.removeAll();
				municipio_eliminar.removeAll();
				for(int x=0;x<lista_mostrar.size();x++)
				{
					municipio_modificar.add(lista_mostrar.get(x).mostrar());
					municipio_eliminar.add(lista_mostrar.get(x).mostrar());
				}
			}
		});
		btnActualizar.setBounds(314, 327, 104, 23);
		contentPane.add(btnActualizar);
		
	}
	public void setEstado(int pulsado)
	{
		this.estado = pulsado;
	}
	public int getEstado()
	{
		return this.estado;
	}
	
	public void setEliminar(int pulsado)
	{
		this.eliminar = pulsado;
	}
	public int getEliminar()
	{
		return this.eliminar;
	}
	
	public void setDatos(ArrayList<municipio> aux)
	{
		lista_mostrar = new ArrayList<municipio>(aux);
	}
	
	public void setModificar(int pulsado)
	{
		this.modificar = pulsado;
	}
	public int getModificar()
	{
		return this.modificar;
	}
	
	public String getNombre()
	{
		return Nombre.getText();
	}
	public String getCategoria()
	{
		return Categoria.getText();
	}
	public String getCuentadante()
	{
		return Cuentadante.getText();
	}
	
	public String getNombre_m()
	{
		return Nombre_m.getText();
	}
	public String getCategoria_m()
	{
		return Clave_m.getText();
	}
	public String getCuentadante_m()
	{
		return Cuentadante_m.getText();
	}
	
	public void salir()
	{
		dispose();
	}
}
