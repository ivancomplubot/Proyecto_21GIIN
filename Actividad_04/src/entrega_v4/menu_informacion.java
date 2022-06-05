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

public class menu_informacion extends JFrame {

	private JPanel contentPane;
	private int estado = 0;
	private String s_c = "", s_p = "";

	/**
	 * Create the frame.
	 */
	public menu_informacion(ArrayList<convocatoria> c, ArrayList<presentacion> p) 
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
		Convocatorias.setBounds(53, 48, 500, 109);
		contentPane.add(Convocatorias);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 168, 614, 2);
		contentPane.add(separator);
		
		JLabel lblConvocatoria = new JLabel("Convocatorias:");
		lblConvocatoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConvocatoria.setBounds(53, 26, 102, 14);
		contentPane.add(lblConvocatoria);
		
		JLabel lblPresentaciones = new JLabel("Presentaciones:");
		lblPresentaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPresentaciones.setBounds(53, 181, 102, 14);
		contentPane.add(lblPresentaciones);
		
		JTextPane Presentaciones = new JTextPane();
		Presentaciones.setBounds(53, 203, 500, 109);
		contentPane.add(Presentaciones);
		
		for(int x=0;x<c.size();x++)
		{
			s_c = s_c+c.get(x).mostrar()+"\n";
		}
		Convocatorias.setText(s_c);
		
		for(int x=0;x<p.size();x++)
		{
			s_p = s_p+p.get(x).mostrar()+"\n";
		}
		Presentaciones.setText(s_p);
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
