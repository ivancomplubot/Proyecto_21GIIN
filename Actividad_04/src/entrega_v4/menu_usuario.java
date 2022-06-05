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

public class menu_usuario extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Clave;
	private JTextField Nombre_m;
	private JTextField Clave_m;
	private int estado = 0, eliminar,modificar;
	private String tipo_agregar;
	private String tipo_modificar;
	private ArrayList<usuario> lista_mostrar;

	public menu_usuario(ArrayList<usuario> aux) 
	{
		lista_mostrar = new ArrayList<usuario>(aux);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice Tipo = new Choice();
		Tipo.setBounds(300, 51, 118, 20);
		contentPane.add(Tipo);
		Tipo.add("Administrador");
		Tipo.add("Fiscal General");
		Tipo.add("Fiscal");
		Tipo.add("Cuentadante");
		
		Choice Tipo_1 = new Choice();
		Tipo_1.setBounds(300, 255, 118, 20);
		contentPane.add(Tipo_1);
		Tipo_1.add("Administrador");
		Tipo_1.add("Fiscal General");
		Tipo_1.add("Fiscal");
		Tipo_1.add("Cuentadante");
		
		Choice usuario_eliminar = new Choice();
		usuario_eliminar.setBounds(109, 120, 309, 20);
		contentPane.add(usuario_eliminar);
		
		Choice usuario_modificar = new Choice();
		usuario_modificar.setBounds(109, 199, 309, 20);
		contentPane.add(usuario_modificar);
		
		for(int x=0;x<this.lista_mostrar.size();x++)
		{
			usuario_eliminar.add(this.lista_mostrar.get(x).mostrar());
			usuario_modificar.add(this.lista_mostrar.get(x).mostrar());
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(1);
				setTipo_agregar(Tipo.getSelectedItem());
				usuario_eliminar.removeAll();
				usuario_modificar.removeAll();
				
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
				setEliminar(usuario_eliminar.getSelectedIndex());
				usuario_eliminar.removeAll();
				usuario_modificar.removeAll();
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
				setTipo_modificar(Tipo_1.getSelectedItem());
				setModificar(usuario_modificar.getSelectedIndex());
				usuario_eliminar.removeAll();
				usuario_modificar.removeAll();
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
		
		Clave = new JTextField();
		Clave.setBounds(205, 51, 86, 20);
		contentPane.add(Clave);
		Clave.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 614, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(109, 26, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(205, 26, 46, 14);
		contentPane.add(lblClave);
		
		JLabel lblTipo = new JLabel("Tipo de Usuario:");
		lblTipo.setBounds(301, 26, 104, 14);
		contentPane.add(lblTipo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 164, 614, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Seleciona el usuario a eliminar:");
		lblNewLabel.setBounds(111, 97, 276, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelecionaElUsuario = new JLabel("Seleciona el usuario a modificar:");
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
		
		JLabel lblTipo_1 = new JLabel("Tipo de Usuario:");
		lblTipo_1.setBounds(301, 230, 104, 14);
		contentPane.add(lblTipo_1);
		
		JLabel lblClave_1 = new JLabel("Clave:");
		lblClave_1.setBounds(205, 230, 46, 14);
		contentPane.add(lblClave_1);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(109, 230, 59, 14);
		contentPane.add(lblNombre_1);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				usuario_modificar.removeAll();
				usuario_eliminar.removeAll();
				for(int x=0;x<lista_mostrar.size();x++)
				{
					usuario_modificar.add(lista_mostrar.get(x).mostrar());
					usuario_eliminar.add(lista_mostrar.get(x).mostrar());
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
	
	public void setDatos(ArrayList<usuario> aux)
	{
		lista_mostrar = (ArrayList<usuario>) aux.clone();
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
	public String getClave()
	{
		return Clave.getText();
	}
	
	
	public String getNombre_m()
	{
		return Nombre_m.getText();
	}
	public String getClave_m()
	{
		return Clave_m.getText();
	}
	
	public void setTipo_agregar(String x)
	{
		this.tipo_agregar = x;
	}
	public void setTipo_modificar(String x)
	{
		this.tipo_modificar = x;
	}
	public String getTipo_agregar()
	{
		return tipo_agregar;
	}
	public String getTipo_modificar()
	{
		return tipo_modificar;
	}
	public void salir()
	{
		dispose();
	}
}
