package entrega_v3;

import java.util.ArrayList;
import java.util.Scanner;

public class Contables_v3 
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
	
	public static void agregar_usuario()
	{
		usuario aux = new usuario();
		
		//rellenamos el nombre
		System.out.print("Introduce Nombre: ");
		aux.setNombre(leer.next());
		//rellenamos la clave 
		System.out.print("Introduce clave: ");
		aux.setClave(leer.next());
		//rellenamos el tipo
		aux.setTipo(aux.tipo());
		usuarios.add(aux);
		db.agregar_usuario(aux);
	}
	public static void eliminar_usuario()
	{
		if(usuarios.size() > 0)
		{
			System.out.println("Elije el usuario a eliminar");
			
			mostrar_usuarios();
			System.out.print("Eliminar: ");
			int eliminar = leer.nextInt();
			db.eliminar_usuario(usuarios.get(eliminar));
			usuarios.remove(eliminar);	
		}
		else
			System.out.println("No hay usuarios que eliminar");
	}
	
	public static void modificar_usuario()
	{
		String nombre_ant = "";
		if(usuarios.size() > 0)
		{
			System.out.println("Elije el usuario a modificar");
			
			mostrar_usuarios();
			System.out.print("Modificar: ");
			int modificar = leer.nextInt();
			
			nombre_ant = usuarios.get(modificar).getNombre();
			
			//rellenamos el nombre
			System.out.print("Introduce Nombre: ");
			usuarios.get(modificar).setNombre(leer.next());
			//rellenamos la clave 
			System.out.print("Introduce clave: ");
			usuarios.get(modificar).setClave(leer.next());
			//rellenamos el tipo
			usuarios.get(modificar).setTipo(usuarios.get(modificar).tipo());
			db.modificar_usuario(usuarios.get(modificar), nombre_ant);
			
		}
		else
			System.out.println("No hay usuarios que modificar");
	}
	public static void mostrar_usuarios()
	{
		String num;
		for(int x=0;x<usuarios.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.print(num);
			usuarios.get(x).mostrar();
		}
	}
	
	
	//////////////////////////////////////////////////////
	//
	//	Funciones Municipio
	//
	//////////////////////////////////////////////////////
	
	public static void agregar_municipio()
	{
		municipio aux = new municipio();
		
		//rellenamos el nombre
		System.out.print("Introduce Nombre: ");
		aux.setNombre(leer.next());
		//rellenamos la categoria
		System.out.print("Introduce categoria: ");
		aux.setCategoria(leer.next());
		//rellenamos el cuentadante
		System.out.print("Introduce cuentadante: ");
		aux.setCuentadante(leer.next());
		municipios.add(aux);
		db.agregar_municipio(aux);
	}
	
	public static void eliminar_municipio()
	{
		if(municipios.size() > 0)
		{
			System.out.println("Elije el municipio a eliminar");
			
			mostrar_municipios();
			System.out.print("Eliminar: ");
			int eliminar = leer.nextInt();
			db.eliminar_municipio(municipios.get(eliminar));
			municipios.remove(eliminar);
		}
		else
			System.out.println("No hay municipios que eliminar");
	}
	
	public static void modificar_municipio()
	{
		String nombre_ant = "";
		if(municipios.size() > 0)
		{
			System.out.println("Elije el municipio a modificar");
			
			mostrar_municipios();
			System.out.print("Modificar: ");
			int modificar = leer.nextInt();
			
			nombre_ant = municipios.get(modificar).getNombre();
			
			//rellenamos el nombre
			System.out.print("Introduce Nombre: ");
			municipios.get(modificar).setNombre(leer.next());
			//rellenamos la categoria 
			System.out.print("Introduce categoria: ");
			municipios.get(modificar).setCategoria(leer.next());
			//rellenamos el cuentadante
			System.out.print("Introduce cuentadante: ");
			municipios.get(modificar).setCuentadante(leer.next());
			db.modificar_municipio(municipios.get(modificar), nombre_ant);
			
		}
		else
			System.out.println("No hay municipios que modificar");
	}
	
	public static void mostrar_municipios()
	{
		String num;
		for(int x=0;x<municipios.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.print(num);
			municipios.get(x).mostrar();
		}
	}
	
	//////////////////////////////////////////////////////
	//
	//	Funciones Convocatoria
	//
	//////////////////////////////////////////////////////
	public static void agregar_convocatoria()
	{
		convocatoria aux = new convocatoria();
		
		//rellenamos el nombre
		System.out.print("Introduce Nombre: ");
		aux.setNombre(leer.next());
		//rellenamos la fecha de apertura
		System.out.print("Introduce fecha de apertura: ");
		aux.setFecha_apertura(leer.next());
		//rellenamos la fecha de cierre
		System.out.print("Introduce fecha de cierre: ");
		aux.setFecha_cierre(leer.next());
		//rellenamos el estado
		System.out.print("Introduce el estado: ");
		aux.setEstado(leer.nextBoolean());
		//rellenamos el tipo
		aux.setDocu(aux.tipoDocu());
		
		convocatorias.add(aux);
		db.agregar_convocatoria(aux);
	}
	
	public static void eliminar_convocatoria()
	{
		
		if(convocatorias.size() > 0)
		{
			System.out.println("Elije la convocatoria a eliminar");
			
			mostrar_convocatorias();
			System.out.print("Eliminar: ");
			int eliminar = leer.nextInt();
			db.eliminar_convocatoria(convocatorias.get(eliminar));
			convocatorias.remove(eliminar);
		}
		else
			System.out.println("No hay convocatorias que eliminar");
	}
	
	public static void modificar_convocatoria()
	{
		String nombre_ant = "";
		
		if(convocatorias.size() > 0)
		{
			System.out.println("Elije la convocatoria a modificar");
			
			mostrar_convocatorias();
			System.out.print("Modificar: ");
			int modificar = leer.nextInt();
			
			nombre_ant = convocatorias.get(modificar).getNombre();
			
			//rellenamos el nombre
			System.out.print("Introduce Nombre: ");
			convocatorias.get(modificar).setNombre(leer.next());
			//rellenamos la fecha de apertura
			System.out.print("Introduce fecha de apertura: ");
			convocatorias.get(modificar).setFecha_apertura(leer.next());
			//rellenamos la fecha de cierre
			System.out.print("Introduce fecha de cierre: ");
			convocatorias.get(modificar).setFecha_cierre(leer.next());
			//rellenamos el estado
			System.out.print("Introduce el estado: ");
			convocatorias.get(modificar).setEstado(leer.nextBoolean());
			//rellenamos el tipo
			convocatorias.get(modificar).setDocu(convocatorias.get(modificar).tipoDocu());
			db.modificar_convocatoria(convocatorias.get(modificar), nombre_ant);
			
		}
		else
			System.out.println("No hay convocatorias que modificar");
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
	
	
	public static void agregar_presentacion()
	{
		presentacion aux = new presentacion();
		
		//rellenamos el nombre
		System.out.print("Introduce Convocatoria: ");
		aux.setConvocatoria(leer.next());
		//rellenamos la fecha de apertura
		System.out.print("Introduce fecha de presentacion: ");
		aux.setFecha_presentacion(leer.next());
		//rellenamos el estado
		System.out.print("Introduce el estado: ");
		aux.setEstado(leer.nextBoolean());
		//rellenamos el tipo
		aux.setDocu(aux.tipoDocu());
		
		presentaciones.add(aux);
		db.agregar_presentacion(aux);
	}
	
	public static void eliminar_presentacion()
	{
		
		if(presentaciones.size() > 0)
		{
			System.out.println("Elije la presentacion a eliminar");
			
			mostrar_presentaciones();
			System.out.print("Eliminar: ");
			int eliminar = leer.nextInt();
			db.eliminar_presentacion(presentaciones.get(eliminar));
			presentaciones.remove(eliminar);
		}
		else
			System.out.println("No hay presentaciones que eliminar");
	}
	
	public static void modificar_presentacion()
	{
		String nombre_ant = "";
		
		if(presentaciones.size() > 0)
		{
			System.out.println("Elije la presentacion a modificar");
			
			mostrar_presentaciones();
			System.out.print("Modificar: ");
			int modificar = leer.nextInt();
			
			nombre_ant = presentaciones.get(modificar).getConvocatoria();
			
			//rellenamos el nombre
			System.out.print("Introduce Nombre: ");
			presentaciones.get(modificar).setConvocatoria(leer.next());
			//rellenamos la fecha de presentacion
			System.out.print("Introduce fecha de presentacion: ");
			presentaciones.get(modificar).setFecha_presentacion(leer.next());
			//rellenamos el estado
			System.out.print("Introduce el estado: ");
			presentaciones.get(modificar).setEstado(leer.nextBoolean());
			//rellenamos el tipo
			presentaciones.get(modificar).setDocu(presentaciones.get(modificar).tipoDocu());
			db.modificar_presentacion(presentaciones.get(modificar), nombre_ant);
			
		}
		else
			System.out.println("No hay presentaciones que modificar");
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
		while(true)
		{
			System.out.print("Usuario:");
			usuario = leer.next();
			System.out.print("Clave:");
			clave = leer.next();
			for(int x=0;x<usuarios.size();x++)
			{
				if((usuarios.get(x).getNombre().equals(usuario)) && (usuarios.get(x).getClave().equals(clave)))
				{
					return usuarios.get(x).getTipo();
				}
			}
			System.out.println("Datos incorrectos, vuelva a intentarlo");
		}
	}
	
	public static void main(String[] args)
	{
		int estado=-1, accion=0;
		menu menus = new menu();
		String tipo;
		
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
							estado = menus.admin(estado);
							break;
							
						case 1:
							accion = menus.admin(estado);
							if (accion == 0)
								estado=0;
							else
							{
								if(accion == 1)
									agregar_usuario();
								else if(accion == 2)
									eliminar_usuario();
								else if(accion == 3)
									modificar_usuario();
								estado = -1;
							}
							break;
							
						case 2:
							accion = menus.admin(estado);
							if (accion == 0)
								estado=0;
							else
							{
								if(accion == 1)
									agregar_municipio();
								else if(accion == 2)
									eliminar_municipio();
								else if(accion == 3)
									modificar_municipio();
								estado = -1;
							}
							break;
						case 3:
							accion = menus.admin(estado);
							if (accion == 0)
								estado=0;
							else
							{
								if(accion == 1)
									agregar_convocatoria();
								else if(accion == 2)
									eliminar_convocatoria();
								else if(accion == 3)
									modificar_convocatoria();
								estado = -1;
							}
							break;
						case 4:
							accion = menus.admin(estado);
							if (accion == 0)
								estado=0;
							else
							{
								if(accion == 1)
									agregar_presentacion();
								else if(accion == 2)
									eliminar_presentacion();
								else if(accion == 3)
									modificar_presentacion();
								estado = -1;
							}
							break;
						
						case 5:
							System.out.println("Información");
							System.out.println("Convocatorias:");
							mostrar_convocatorias();
							System.out.println("Presentaciones:");
							mostrar_presentaciones();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
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
							estado = menus.fg(estado);
							break;
							
						case 1:
							System.out.println("Municipios:");
							mostrar_municipios();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
							
						case 2:
							accion = menus.fg(estado);
							if (accion == 0)
								estado=0;
							else
							{
								if(accion == 1)
									agregar_convocatoria();
								else if(accion == 2)
									eliminar_convocatoria();
								else if(accion == 3)
									modificar_convocatoria();
								estado = -1;
							}
							break;
						case 3:
							System.out.println("Presentaciones:");
							mostrar_presentaciones();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
						case 4:
							System.out.println("Información");
							System.out.println("Convocatorias:");
							mostrar_convocatorias();
							System.out.println("Presentaciones:");
							mostrar_presentaciones();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
					}
					break;
				case "Fiscal":
					switch(estado)
					{
						case -1:
							estado = menus.f(estado);
							break;
							
						case 1:
							System.out.println("Municipios:");
							mostrar_municipios();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
							
						case 2:
							System.out.println("Convocatorias:");
							mostrar_convocatorias();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
						case 3:
							System.out.println("Presentaciones:");
							mostrar_presentaciones();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
						case 4:
							System.out.println("Información");
							System.out.println("Convocatorias:");
							mostrar_convocatorias();
							System.out.println("Presentaciones:");
							mostrar_presentaciones();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
					}
					break;
				case "Cuentadante":
					switch(estado)
					{
						case -1:
							estado = menus.u(estado);
							break;
							
						case 1:
							System.out.println("Municipios:");
							mostrar_municipios();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
							
						case 2:
							System.out.println("Convocatorias:");
							mostrar_convocatorias();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
							break;
						case 3:
							accion = menus.admin(estado);
							if (accion == 0)
								estado=0;
							else
							{
								if(accion == 1)
									agregar_presentacion();
								else if(accion == 2)
									eliminar_presentacion();
								else if(accion == 3)
									modificar_presentacion();
								estado = -1;
							}
							break;
						case 4:
							System.out.println("Información");
							System.out.println("Convocatorias:");
							mostrar_convocatorias();
							System.out.println("Presentaciones:");
							mostrar_presentaciones();
							System.out.println("Introduzca cualquier dato para continuar");
							leer.next();
							estado = -1;
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
