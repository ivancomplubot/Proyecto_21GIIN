package entrega_v1;
import java.util.Scanner;

public class Contables_v1 {

	public static void main(String[] args) 
	{
		int estado = -1, accion = -1;
		
		Usuario user = new Usuario();
		Municipio mun = new Municipio();
		Convocatoria conv = new Convocatoria();
		Presentacion pres = new Presentacion();
		
		Scanner leer = new Scanner(System.in);
		while (estado != 0)
		{
			switch(estado)
			{
				case -1:  //Estado Inicial
					System.out.println("Bienvenido al programa de presentaciones digitales contables");
					System.out.println("Introduzca el número del menu al cual quieres acceder:");
					System.out.println("1)Usuarios");
					System.out.println("2)Municipios");
					System.out.println("3)Convocatorias");
					System.out.println("4)Presentaciones");
					System.out.println("5)Información");
					System.out.println("0)Salir");
					System.out.print("Menu: ");
					estado = leer.nextInt();
					
					
					break;
				case 1: //Usuarios
					
					System.out.println("Menu Usuarios");
					System.out.println("Introduzca el número del menu al cual quieres acceder:");
					System.out.println("1)Alta");
					System.out.println("2)Baja");
					System.out.println("3)Modificación");
					System.out.println("0)Salir");
					System.out.print("Menu: ");
					accion = leer.nextInt();
					if (accion == 0)
						estado=0;
					else
					{
						if(accion == 1)
							user.agregar();
						else if(accion == 2)
							user.eliminar();
						else if(accion == 3)
							user.modificar();
						estado = -1;
					}
					break; 
					
				case 2: //Municipios
					System.out.println("Menu Municipios");
					System.out.println("Introduzca el número del menu al cual quieres acceder:");
					System.out.println("1)Alta");
					System.out.println("2)Baja");
					System.out.println("3)Modificación");
					System.out.println("0)Salir");
					System.out.print("Menu: ");
					accion = leer.nextInt();
					if (accion == 0)
						estado=0;
					else
					{
						if(accion == 1)
							mun.agregar();
						else if(accion == 2)
							mun.eliminar();
						else if(accion == 3)
							mun.modificar();
						estado = -1;
					}
					break; 
					
				case 3: //Convocatorias
					System.out.println("Menu Municipios");
					System.out.println("Introduzca el número del menu al cual quieres acceder:");
					System.out.println("1)Alta");
					System.out.println("2)Baja");
					System.out.println("3)Modificación");
					System.out.println("0)Salir");
					System.out.print("Menu: ");
					accion = leer.nextInt();
					if (accion == 0)
						estado=0;
					else
					{
						if(accion == 1)
							conv.agregar();
						else if(accion == 2)
							conv.eliminar();
						else if(accion == 3)
							conv.modificar();
						estado = -1;
					}
					break;
					
				case 4: //Presentaciones
					System.out.println("Menu Municipios");
					System.out.println("Introduzca el número del menu al cual quieres acceder:");
					System.out.println("1)Alta");
					System.out.println("2)Baja");
					System.out.println("3)Modificación");
					System.out.println("0)Salir");
					System.out.print("Menu: ");
					accion = leer.nextInt();
					if (accion == 0)
						estado=0;
					else
					{
						if(accion == 1)
							pres.agregar();
						else if(accion == 2)
							pres.eliminar();
						else if(accion == 3)
							pres.modificar();
						estado = -1;
					}
					break;
					
				case 5: //Informacion
					System.out.println("Información");
					conv.mostrar();
					pres.mostrar();
					System.out.println("Pulse cualquier tecla para continuar");
					leer.next();
					estado = -1;
					break;
					
				default:
					break;
			}
		}
		leer.close();
	}

}
