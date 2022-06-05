package entrega_v4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_inicio extends JFrame {

	private JPanel Panel_acceso;
	private JTextField Usuario;
	private JTextField Clave;
	private int estado = 0;

	
	public Interfaz_inicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Panel_acceso = new JPanel();
		Panel_acceso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_acceso);
		Panel_acceso.setLayout(null);
		
		JButton btnAcceso = new JButton("Acceder");
		btnAcceso.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(1);
				
			}
		});
		btnAcceso.setBounds(165, 176, 89, 23);
		Panel_acceso.add(btnAcceso);
		
		Usuario = new JTextField();
		Usuario.setBounds(165, 64, 86, 20);
		Panel_acceso.add(Usuario);
		Usuario.setColumns(10);
		
		Clave = new JTextField();
		Clave.setBounds(165, 111, 86, 20);
		Panel_acceso.add(Clave);
		Clave.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(90, 67, 65, 14);
		Panel_acceso.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clave:");
		lblNewLabel_1.setBounds(109, 114, 46, 14);
		Panel_acceso.add(lblNewLabel_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(354, 227, 70, 23);
		Panel_acceso.add(btnSalir);
	}
	public void Error()
	{
		JOptionPane.showMessageDialog(null, "Error! Usuario o Contraseña incorrectos");
	}
	public void Acierto()
	{
		JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
		dispose();
	}
	
	
	public void setEstado(int pulsado)
	{
		this.estado = pulsado;
	}
	public int getEstado()
	{
		return this.estado;
	}
	public String getUser()
	{
		return Usuario.getText();
	}
	public String getClave()
	{
		return Clave.getText();
	}
}
