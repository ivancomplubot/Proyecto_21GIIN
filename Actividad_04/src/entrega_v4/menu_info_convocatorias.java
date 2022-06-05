package entrega_v4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;

public class menu_info_convocatorias extends JFrame {

	private JPanel contentPane;
	private int estado = 0;
	private String s_m = "";

	/**
	 * Create the frame.
	 */
	public menu_info_convocatorias(ArrayList<convocatoria> ic) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnSalir.setBounds(547, 327, 77, 23);
		contentPane.add(btnSalir);
		
		JButton btnMenu_principal = new JButton("Menu principal");
		btnMenu_principal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setEstado(-1);
			}
		});
		btnMenu_principal.setBounds(262, 327, 120, 23);
		contentPane.add(btnMenu_principal);
		
		JTextPane Convocatorias = new JTextPane();
		Convocatorias.setBounds(53, 48, 500, 268);
		contentPane.add(Convocatorias);
		
		JLabel lblConvocatoria = new JLabel("Convocatorias:");
		lblConvocatoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConvocatoria.setBounds(53, 26, 102, 14);
		contentPane.add(lblConvocatoria);
		
		for(int x=0;x<ic.size();x++)
		{
			s_m = s_m+ic.get(x).mostrar()+"\n";
		}
		Convocatorias.setText(s_m);
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
	
	//Funcion Salir
	public void salir()
	{
		dispose();
	}
}
