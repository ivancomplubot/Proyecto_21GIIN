package entrega_v4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class menu_principal_s extends JFrame {

	private JPanel Panel_acceso;
	private int estado=-1;
	
	public menu_principal_s() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		Panel_acceso = new JPanel();
		Panel_acceso.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_acceso);
		Panel_acceso.setLayout(null);
		
		JButton btnMunicipios = new JButton("Municipios");
		btnMunicipios.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(1);
			}
		});
		
		btnMunicipios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMunicipios.setBounds(60, 156, 113, 23);
		Panel_acceso.add(btnMunicipios);
		
		JButton btnConvocatorias = new JButton("Convocatorias");
		btnConvocatorias.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(2);
			}
		});
		btnConvocatorias.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConvocatorias.setBounds(192, 156, 113, 23);
		Panel_acceso.add(btnConvocatorias);
		
		JButton btnPresentaciones = new JButton("Presentaciones");
		btnPresentaciones.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(3);
			}
		});
		btnPresentaciones.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPresentaciones.setBounds(328, 156, 113, 23);
		Panel_acceso.add(btnPresentaciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(547, 327, 70, 23);
		Panel_acceso.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("Menu principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(224, 48, 180, 48);
		Panel_acceso.add(lblNewLabel);
		
		JButton btnInformacion = new JButton("Informaci\u00F3n");
		btnInformacion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(4);
			}
		});
		btnInformacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInformacion.setBounds(461, 156, 113, 23);
		Panel_acceso.add(btnInformacion);
	}
	public int getEstado()
	{
		return this.estado;
	}
	public void setEstado(int s)
	{
		this.estado = s;
	}
	public void salir()
	{
		dispose();
	}
}
