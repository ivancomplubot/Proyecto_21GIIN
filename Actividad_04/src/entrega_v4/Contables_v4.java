package entrega_v4;

import java.util.ArrayList;
import java.util.Scanner;

public class Contables_v4 
{
	static DB_proyecto db = new DB_proyecto();
	static ArrayList<usuario> usuarios = new ArrayList<usuario>();
	static ArrayList<municipio> municipios = new ArrayList<municipio>();
	static ArrayList<convocatoria> convocatorias = new ArrayList<convocatoria>();
	static ArrayList<presentacion> presentaciones = new ArrayList<presentacion>();
	static Scanner leer = new Scanner(System.in);
	
	//////////////////////////////////////////////////////
	//
	//	Funciones Usuario
	//
	//////////////////////////////////////////////////////
	
	public static void agregar_usuario(usuario aux)
	{
		usuarios.add(aux);
		db.agregar_usuario(aux);
	}
	public static void eliminar_usuario(int eliminar)
	{
		db.eliminar_usuario(usuarios.get(eliminar));
		usuarios.remove(eliminar);	
	}
	
	public static void modificar_usuario(usuario aux, int modificar)
	{
		db.modificar_usuario(aux, usuarios.get(modificar).getNombre());
		usuarios.set(modificar,aux);
	}
	public static void mostrar_usuarios()
	{
		String num;
		for(int x=0;x<usuarios.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.print(num);
			System.out.println(usuarios.get(x).mostrar());
		}
	}
	
	
	//////////////////////////////////////////////////////
	//
	//	Funciones Municipio
	//
	//////////////////////////////////////////////////////
	
	public static void agregar_municipio(municipio aux)
	{
		municipios.add(aux);
		db.agregar_municipio(aux);
	}
	
	public static void eliminar_municipio(int eliminar)
	{
		db.eliminar_municipio(municipios.get(eliminar));
		municipios.remove(eliminar);
	}
	
	public static void modificar_municipio(municipio aux, int modificar)
	{
		db.modificar_municipio(aux, municipios.get(modificar).getNombre());
		municipios.set(modificar,aux);
	}
	
	public static void mostrar_municipios()
	{
		String num;
		for(int x=0;x<municipios.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.print(num);
			System.out.println(municipios.get(x).mostrar());
		}
	}
	
	//////////////////////////////////////////////////////
	//
	//	Funciones Convocatoria
	//
	//////////////////////////////////////////////////////
	public static void agregar_convocatoria(convocatoria aux)
	{
		convocatorias.add(aux);
		db.agregar_convocatoria(aux);
	}
	
	public static void eliminar_convocatoria(int eliminar)
	{
		db.eliminar_convocatoria(convocatorias.get(eliminar));
		convocatorias.remove(eliminar);
	}
	
	public static void modificar_convocatoria(convocatoria aux, int modificar)
	{
		db.modificar_convocatoria(aux, convocatorias.get(modificar).getNombre());
		convocatorias.set(modificar,aux);
	}
	public static void mostrar_convocatorias()
	{
		String num;
		for(int x=0;x<convocatorias.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.print(num);
			convocatorias.get(x).mostrar();
		}
	}
	//////////////////////////////////////////////////////
	//
	//	Funciones Presentación
	//
	//////////////////////////////////////////////////////
	
	
	public static void agregar_presentacion(presentacion aux)
	{
		presentaciones.add(aux);
		db.agregar_presentacion(aux);
	}
	
	public static void eliminar_presentacion(int eliminar)
	{
		db.eliminar_presentacion(presentaciones.get(eliminar));
		presentaciones.remove(eliminar);
	}
	
	public static void modificar_presentacion(presentacion aux, int modificar)
	{
		db.modificar_presentacion(aux, presentaciones.get(modificar).getConvocatoria());
		presentaciones.set(modificar,aux);
	}
	
	public static void mostrar_presentaciones()
	{
		String num;
		for(int x=0;x<presentaciones.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.print(num);
			presentaciones.get(x).mostrar();
		}
	}
	
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
		
	
	public static void datos_iniciales()
	{
		db.leer_usuarios(usuarios);
		db.leer_municipio(municipios);
		db.leer_convocatorias(convocatorias);
		db.leer_presentacion(presentaciones);
	}
	
	//Funcion de login 
	public static String login()
	{
		String usuario, clave;
		Interfaz_inicio ia = new Interfaz_inicio();
		ia.setVisible(true);
		while(true)
		{
			wait(100);
			if(ia.getEstado() == 1)
			{
				usuario = ia.getUser();
				clave = ia.getClave();
				for(int x=0;x<usuarios.size();x++)
				{
					if((usuarios.get(x).getNombre().equals(usuario)) && (usuarios.get(x).getClave().equals(clave)))
					{
						ia.Acierto();
						return usuarios.get(x).getTipo();
					}
				}
				ia.setEstado(0);
				ia.Error();
			}
		}
	}
	
	public static void main(String[] args)
	{
		int estado=-1, accion=0;
		String tipo;
		usuario aux = new usuario();
		municipio aux_mu = new municipio();
		convocatoria aux_mc = new convocatoria();
		presentacion aux_mp = new presentacion();
		
		datos_iniciales();
		tipo = login();
		
		
		
		while (estado != 0)
		{
			switch(tipo)
			{
				case "Administrador":
					switch(estado)
					{
						case -1:
							menu_principal mp = new menu_principal();
							mp.setVisible(true);
							while(mp.getEstado() == -1)
								wait(100);
							estado = mp.getEstado();
							mp.salir();
							break;
							
						case 1:
							menu_usuario mu = new menu_usuario(usuarios);
							
							mu.setVisible(true);
							while(mu.getEstado() != -1)
							{
								wait(100);
								accion = mu.getEstado();
								if(accion == 1)
								{	
									
									aux.setNombre(mu.getNombre());
									aux.setClave(mu.getClave());
									aux.setTipo(mu.getTipo_agregar());
									agregar_usuario(aux);
									mu.setDatos(usuarios);
									mu.setEstado(0);
									aux = new usuario();
								}
								else if(accion == 2)
								{
									eliminar_usuario(mu.getEliminar());
									mu.setDatos(usuarios);
									mu.setEstado(0);
								}
								else if(accion == 3)
								{
									aux.setNombre(mu.getNombre_m());
									aux.setClave(mu.getClave_m());
									aux.setTipo(mu.getTipo_modificar());
									modificar_usuario(aux,mu.getModificar());
									mu.setDatos(usuarios);
									mu.setEstado(0);
									aux = new usuario();
								}
							}
							mu.salir();
							estado = mu.getEstado();
							break;
							
						case 2:
							menu_municipio mm = new menu_municipio(municipios);
							mm.setVisible(true);
							while(mm.getEstado() != -1)
							{
								wait(100);
								accion = mm.getEstado();
								if(accion == 1)
								{	
									
									aux_mu.setNombre(mm.getNombre());
									aux_mu.setCategoria(mm.getCategoria());
									aux_mu.setCuentadante(mm.getCuentadante());
									agregar_municipio(aux_mu);
									mm.setDatos(municipios);
									mm.setEstado(0);
									aux_mu = new municipio();
								}
								else if(accion == 2)
								{
									eliminar_municipio(mm.getEliminar());
									mm.setDatos(municipios);
									mm.setEstado(0);
								}
								else if(accion == 3)
								{
									aux_mu.setNombre(mm.getNombre_m());
									aux_mu.setCategoria(mm.getCategoria_m());
									aux_mu.setCuentadante(mm.getCuentadante_m());
									modificar_municipio(aux_mu,mm.getModificar());
									mm.setDatos(municipios);
									mm.setEstado(0);
									aux_mu = new municipio();
								}
							}
							mm.salir();
							estado = mm.getEstado();
							break;
						case 3:
							menu_convocatoria mc = new menu_convocatoria(convocatorias);
							mc.setVisible(true);
							while(mc.getEstado() != -1)
							{
								wait(100);
								accion = mc.getEstado();
								if(accion == 1)
								{	
									
									aux_mc.setNombre(mc.getNombre());
									aux_mc.setFecha_apertura(mc.getF_apertura());
									aux_mc.setFecha_cierre(mc.getF_cierre());
									aux_mc.setEstado(mc.getEstado_conv());
									aux_mc.setDocu(mc.getDocu());
									
									agregar_convocatoria(aux_mc);
									mc.setDatos(convocatorias);
									mc.setEstado(0);
									aux_mc = new convocatoria();
								}
								else if(accion == 2)
								{
									eliminar_convocatoria(mc.getEliminar());
									mc.setDatos(convocatorias);
									mc.setEstado(0);
								}
								else if(accion == 3)
								{
									aux_mc.setNombre(mc.getNombre_m());
									aux_mc.setFecha_apertura(mc.getF_apertura_m());
									aux_mc.setFecha_cierre(mc.getF_cierre_m());
									aux_mc.setEstado(mc.getEstado_conv_m());
									aux_mc.setDocu(mc.getDocu_m());
									
									modificar_convocatoria(aux_mc,mc.getModificar());
									mc.setDatos(convocatorias);
									mc.setEstado(0);
									aux_mc = new convocatoria();
								}
							}
							mc.salir();
							estado = mc.getEstado();
							break;
						case 4:
							menu_presentacion mpr = new menu_presentacion(presentaciones);
							mpr.setVisible(true);
							while(mpr.getEstado() != -1)
							{
								wait(100);
								accion = mpr.getEstado();
								if(accion == 1)
								{	
									
									aux_mp.setConvocatoria(mpr.getConvocatoria());
									aux_mp.setFecha_presentacion(mpr.getF_apertura());
									aux_mp.setEstado(mpr.getEstado_conv());
									aux_mp.setDocu(mpr.getDocu());
									
									agregar_presentacion(aux_mp);
									mpr.setDatos(presentaciones);
									mpr.setEstado(0);
									aux_mp = new presentacion();
								}
								else if(accion == 2)
								{
									eliminar_presentacion(mpr.getEliminar());
									mpr.setDatos(presentaciones);
									mpr.setEstado(0);
								}
								else if(accion == 3)
								{
									aux_mp.setConvocatoria(mpr.getConvocatoria_m());
									aux_mp.setFecha_presentacion(mpr.getF_apertura_m());
									aux_mp.setEstado(mpr.getEstado_conv_m());
									aux_mp.setDocu(mpr.getDocu_m());
									
									modificar_presentacion(aux_mp,mpr.getModificar());
									mpr.setDatos(presentaciones);
									mpr.setEstado(0);
									aux_mp = new presentacion();
								}
							}
							mpr.salir();
							estado = mpr.getEstado();
							break;
						
						case 5:
							menu_informacion mi = new menu_informacion(convocatorias,presentaciones);
							mi.setVisible(true);
							while(mi.getEstado() != -1)
							{
								wait(100);
							}
							mi.salir();
							estado = mi.getEstado();
							break;
							 
							
						default:
							estado = 0;
							break;
					}
					break;
					
				case "Fiscal General":
					switch(estado)
					{
						case -1:
							menu_principal_s mp = new menu_principal_s();
							mp.setVisible(true);
							while(mp.getEstado() == -1)
								wait(100);
							estado = mp.getEstado();
							mp.salir();
							break;
							
						case 1:
							menu_info_municipios mim = new menu_info_municipios(municipios);
							mim.setVisible(true);
							while(mim.getEstado() != -1)
							{
								wait(100);
							}
							mim.salir();
							estado = mim.getEstado();
							break;
							
						case 2:
							menu_convocatoria mc = new menu_convocatoria(convocatorias);
							mc.setVisible(true);
							while(mc.getEstado() != -1)
							{
								wait(100);
								accion = mc.getEstado();
								if(accion == 1)
								{	
									
									aux_mc.setNombre(mc.getNombre());
									aux_mc.setFecha_apertura(mc.getF_apertura());
									aux_mc.setFecha_cierre(mc.getF_cierre());
									aux_mc.setEstado(mc.getEstado_conv());
									aux_mc.setDocu(mc.getDocu());
									
									agregar_convocatoria(aux_mc);
									mc.setDatos(convocatorias);
									mc.setEstado(0);
									aux_mc = new convocatoria();
								}
								else if(accion == 2)
								{
									eliminar_convocatoria(mc.getEliminar());
									mc.setDatos(convocatorias);
									mc.setEstado(0);
								}
								else if(accion == 3)
								{
									aux_mc.setNombre(mc.getNombre_m());
									aux_mc.setFecha_apertura(mc.getF_apertura_m());
									aux_mc.setFecha_cierre(mc.getF_cierre_m());
									aux_mc.setEstado(mc.getEstado_conv_m());
									aux_mc.setDocu(mc.getDocu_m());
									
									modificar_convocatoria(aux_mc,mc.getModificar());
									mc.setDatos(convocatorias);
									mc.setEstado(0);
									aux_mc = new convocatoria();
								}
							}
							mc.salir();
							estado = mc.getEstado();
							break;
						case 3:
							menu_info_presentaciones mip = new menu_info_presentaciones(presentaciones);
							mip.setVisible(true);
							while(mip.getEstado() != -1)
							{
								wait(100);
							}
							mip.salir();
							estado = mip.getEstado();
							break;
						case 4:
							menu_informacion mi = new menu_informacion(convocatorias,presentaciones);
							mi.setVisible(true);
							while(mi.getEstado() != -1)
							{
								wait(100);
							}
							mi.salir();
							estado = mi.getEstado();
							break;
					}
					break;
				case "Fiscal":
					switch(estado)
					{
						case -1:
							menu_principal_s mp = new menu_principal_s();
							mp.setVisible(true);
							while(mp.getEstado() == -1)
								wait(100);
							estado = mp.getEstado();
							mp.salir();
							break;
							
						case 1:
							menu_info_municipios mim = new menu_info_municipios(municipios);
							mim.setVisible(true);
							while(mim.getEstado() != -1)
							{
								wait(100);
							}
							mim.salir();
							estado = mim.getEstado();
							break;
							
						case 2:
							menu_info_convocatorias mic = new menu_info_convocatorias(convocatorias);
							mic.setVisible(true);
							while(mic.getEstado() != -1)
							{
								wait(100);
							}
							mic.salir();
							estado = mic.getEstado();
							break;
						case 3:
							menu_info_presentaciones mip = new menu_info_presentaciones(presentaciones);
							mip.setVisible(true);
							while(mip.getEstado() != -1)
							{
								wait(100);
							}
							mip.salir();
							estado = mip.getEstado();
							break;
						case 4:
							menu_informacion mi = new menu_informacion(convocatorias,presentaciones);
							mi.setVisible(true);
							while(mi.getEstado() != -1)
							{
								wait(100);
							}
							mi.salir();
							estado = mi.getEstado();
							break;
					}
					break;
				case "Cuentadante":
					switch(estado)
					{
						case -1:
							menu_principal_s mp = new menu_principal_s();
							mp.setVisible(true);
							while(mp.getEstado() == -1)
								wait(100);
							estado = mp.getEstado();
							mp.salir();
							break;
							
						case 1:
							menu_info_municipios mim = new menu_info_municipios(municipios);
							mim.setVisible(true);
							while(mim.getEstado() != -1)
								wait(100);
							mim.salir();
							estado = mim.getEstado();
							break;
							
						case 2:
							menu_info_convocatorias mic = new menu_info_convocatorias(convocatorias);
							mic.setVisible(true);
							while(mic.getEstado() != -1)
							{
								wait(100);
							}
							mic.salir();
							estado = mic.getEstado();
							break;
						case 3:
							menu_presentacion mpr = new menu_presentacion(presentaciones);
							mpr.setVisible(true);
							while(mpr.getEstado() != -1)
							{
								wait(100);
								accion = mpr.getEstado();
								if(accion == 1)
								{	
									
									aux_mp.setConvocatoria(mpr.getConvocatoria());
									aux_mp.setFecha_presentacion(mpr.getF_apertura());
									aux_mp.setEstado(mpr.getEstado_conv());
									aux_mp.setDocu(mpr.getDocu());
									
									agregar_presentacion(aux_mp);
									mpr.setDatos(presentaciones);
									mpr.setEstado(0);
									aux_mp = new presentacion();
								}
								else if(accion == 2)
								{
									eliminar_presentacion(mpr.getEliminar());
									mpr.setDatos(presentaciones);
									mpr.setEstado(0);
								}
								else if(accion == 3)
								{
									aux_mp.setConvocatoria(mpr.getConvocatoria_m());
									aux_mp.setFecha_presentacion(mpr.getF_apertura_m());
									aux_mp.setEstado(mpr.getEstado_conv_m());
									aux_mp.setDocu(mpr.getDocu_m());
									
									modificar_presentacion(aux_mp,mpr.getModificar());
									mpr.setDatos(presentaciones);
									mpr.setEstado(0);
									aux_mp = new presentacion();
								}
							}
							mpr.salir();
							estado = mpr.getEstado();
							break;
						case 4:
							menu_informacion mi = new menu_informacion(convocatorias,presentaciones);
							mi.setVisible(true);
							while(mi.getEstado() != -1)
							{
								wait(100);
							}
							mi.salir();
							estado = mi.getEstado();
							break;
					}
					break;
					
				default:
					//estado = 0;
					break;
			}
			
		}

	}
	
}