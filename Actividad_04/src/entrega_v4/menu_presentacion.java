package entrega_v4;

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


public class menu_presentacion extends JFrame {

	private JPanel contentPane;
	private JTextField Convocatoria;
	private JTextField F_apertura;
	private JTextField Convocatoria_m;
	private JTextField F_apertura_m;
	
	
	private int estado = 0, eliminar, modificar;
	
	private Boolean estado_agregar;
	private Boolean estado_modificar;
	private String docu, docu_m;
	private ArrayList<presentacion> lista_mostrar;
	

	public menu_presentacion(ArrayList<presentacion> aux) 
	{
		lista_mostrar = new ArrayList<presentacion>(aux);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice Tipo_docu = new Choice();
		Tipo_docu.setBounds(346, 51, 165, 22);
		contentPane.add(Tipo_docu);
		Tipo_docu.add("Libro diario");
		Tipo_docu.add("libro mayor");
		Tipo_docu.add("Balance de sumas y saldos");
		Tipo_docu.add("Registro de ingreso de caja");
		Tipo_docu.add("Registro de movimientos");
		
		Choice Tipo_docu_m = new Choice();
		Tipo_docu_m.setBounds(346, 255, 165, 22);
		contentPane.add(Tipo_docu_m);
		Tipo_docu_m.add("Libro diario");
		Tipo_docu_m.add("libro mayor");
		Tipo_docu_m.add("Balance de sumas y saldos");
		Tipo_docu_m.add("Registro de ingreso de caja");
		Tipo_docu_m.add("Registro de movimientos");
		
		Choice Estado_conv = new Choice();
		Estado_conv.setBounds(288, 51, 52, 20);
		contentPane.add(Estado_conv);
		Estado_conv.add("True");
		Estado_conv.add("False");
		
		Choice Estado_conv_m = new Choice();
		Estado_conv_m.setBounds(288, 255, 52, 20);
		contentPane.add(Estado_conv_m);
		Estado_conv_m.add("True");
		Estado_conv_m.add("False");
		
		Choice convocatoria_eliminar = new Choice();
		convocatoria_eliminar.setBounds(109, 120, 309, 20);
		contentPane.add(convocatoria_eliminar);
		
		Choice convocatoria_modificar = new Choice();
		convocatoria_modificar.setBounds(109, 199, 309, 20);
		contentPane.add(convocatoria_modificar);
		
		for(int x=0;x<this.lista_mostrar.size();x++)
		{
			convocatoria_eliminar.add(this.lista_mostrar.get(x).mostrar());
			convocatoria_modificar.add(this.lista_mostrar.get(x).mostrar());
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(1);
				setDocu(Tipo_docu.getSelectedItem());
				if (Estado_conv.getSelectedItem() == "True")
					setEstado_conv(true);
				else
					setEstado_conv(false);
				setEliminar(convocatoria_modificar.getSelectedIndex());
				convocatoria_eliminar.removeAll();
				convocatoria_modificar.removeAll();
				
			}
		});
		btnAgregar.setBounds(535, 26, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(2);
				setEliminar(convocatoria_eliminar.getSelectedIndex());
				convocatoria_eliminar.removeAll();
				convocatoria_modificar.removeAll();
			}
		});
		btnEliminar.setBounds(535, 97, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(3);
				setDocu_m(Tipo_docu_m.getSelectedItem());
				if (Estado_conv_m.getSelectedItem() == "True")
					setEstado_conv_m(true);
				else
					setEstado_conv_m(false);
				setModificar(convocatoria_modificar.getSelectedIndex());
				convocatoria_eliminar.removeAll();
				convocatoria_modificar.removeAll();
			}
		});
		btnModificar.setBounds(535, 185, 89, 23);
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
		
		Convocatoria = new JTextField();
		Convocatoria.setBounds(70, 51, 81, 20);
		contentPane.add(Convocatoria);
		Convocatoria.setColumns(10);
		
		F_apertura = new JTextField();
		F_apertura.setBounds(161, 51, 121, 20);
		contentPane.add(F_apertura);
		F_apertura.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 614, 2);
		contentPane.add(separator);
		
		JLabel lblConvocatoria = new JLabel("Convocatoria:");
		lblConvocatoria.setBounds(70, 30, 81, 14);
		contentPane.add(lblConvocatoria);
		
		JLabel lblF_apertura = new JLabel("Fecha de presentaci\u00F3n:");
		lblF_apertura.setBounds(161, 30, 121, 14);
		contentPane.add(lblF_apertura);
		
		JLabel lblF_apertura_1 = new JLabel("Fecha de presentaci\u00F3n:");
		lblF_apertura_1.setBounds(161, 235, 121, 14);
		contentPane.add(lblF_apertura_1);
		
		JLabel lblTipo = new JLabel("Tipo de Documentaci\u00F3n:");
		lblTipo.setBounds(346, 30, 165, 14);
		contentPane.add(lblTipo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 164, 614, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Seleciona la presentaci\u00F3n a eliminar:");
		lblNewLabel.setBounds(111, 97, 276, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelecionaElUsuario = new JLabel("Seleciona la presentaci\u00F3n a modificar:");
		lblSelecionaElUsuario.setBounds(111, 176, 276, 14);
		contentPane.add(lblSelecionaElUsuario);
		
		Convocatoria_m = new JTextField();
		Convocatoria_m.setColumns(10);
		Convocatoria_m.setBounds(70, 255, 81, 20);
		contentPane.add(Convocatoria_m);
		
		F_apertura_m = new JTextField();
		F_apertura_m.setColumns(10);
		F_apertura_m.setBounds(161, 255, 121, 20);
		contentPane.add(F_apertura_m);
		
		JLabel lblTipo_1 = new JLabel("Tipo de Documentaci\u00F3n:");
		lblTipo_1.setBounds(346, 235, 165, 14);
		contentPane.add(lblTipo_1);
		
		JLabel lblConvocatoria_1 = new JLabel("Convocatoria:");
		lblConvocatoria_1.setBounds(70, 235, 81, 14);
		contentPane.add(lblConvocatoria_1);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				convocatoria_modificar.removeAll();
				convocatoria_eliminar.removeAll();
				for(int x=0;x<lista_mostrar.size();x++)
				{
					convocatoria_modificar.add(lista_mostrar.get(x).mostrar());
					convocatoria_eliminar.add(lista_mostrar.get(x).mostrar());
				}
			}
		});
		btnActualizar.setBounds(324, 327, 94, 23);
		contentPane.add(btnActualizar);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setBounds(295, 30, 45, 14);
		contentPane.add(lblEstado);
		
		JLabel lblEstado_m = new JLabel("Estado: ");
		lblEstado_m.setBounds(291, 235, 45, 14);
		contentPane.add(lblEstado_m);
	}
	
	
	//Funcion que determina el estado de los pulsadores
	public void setEstado(int pulsado)
	{
		this.estado = pulsado;
	}
	public int getEstado()
	{
		return this.estado;
	}
	
	//ID Eliminar
	public void setEliminar(int pulsado)
	{
		this.eliminar = pulsado;
	}
	public int getEliminar()
	{
		return this.eliminar;
	}
	
	//ID Modificar
	public void setModificar(int pulsado)
	{
		this.modificar = pulsado;
	}
	public int getModificar()
	{
		return this.modificar;
	}
	
	
	//Pasar datos
	public void setDatos(ArrayList<presentacion> aux)
	{
		lista_mostrar = (ArrayList<presentacion>) aux.clone();
	}
	
	//Funciones agregar
	public String getConvocatoria()
	{
		return Convocatoria.getText();
	}
	public String getF_apertura()
	{
		return F_apertura.getText();
	}
	public Boolean getEstado_conv()
	{
		return this.estado_agregar;
	}
	public void setEstado_conv(Boolean x)
	{
		this.estado_agregar = x;
	}
	
	public String getDocu()
	{
		return docu;
	}
	public void setDocu(String x)
	{
		this.docu = x;
	}
	
	//Funciones modificar
	public String getConvocatoria_m()
	{
		return Convocatoria_m.getText();
	}
	public String getF_apertura_m()
	{
		return F_apertura_m.getText();
	}
	public Boolean getEstado_conv_m()
	{
		return this.estado_modificar;
	}
	public void setEstado_conv_m(Boolean x)
	{
		this.estado_modificar = x;
	}
	
	public String getDocu_m()
	{
		return docu_m;
	}
	public void setDocu_m(String x)
	{
		this.docu_m = x;
	}
	
	//Funcion Salir
	public void salir()
	{
		dispose();
	}
}
