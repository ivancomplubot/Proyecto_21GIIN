package entrega_v2;

import java.util.Scanner;

public class menu 
{
	private Scanner leer = new Scanner(System.in);
	
	public menu()
	{
		
	}
	public int admin(int estado)
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
				return leer.nextInt();
			case 1:
				System.out.println("Menu Usuarios");
				this.opciones();
				return leer.nextInt();
				
			case 2: //Municipios
				System.out.println("Menu Municipios");
				this.opciones();
				return leer.nextInt();
				
			case 3: //Convocatorias
				System.out.println("Menu Convocatorias");
				this.opciones();
				return leer.nextInt();
			
			case 4: //Presentaciones
				System.out.println("Menu Presentaciones");
				this.opciones();
				return leer.nextInt();
			
			
			
			default:
				return 0;
		}
	}
	public int fg(int estado)
	{
		switch(estado)
		{
			case -1:  //Estado Inicial
				System.out.println("Bienvenido al programa de presentaciones digitales contables");
				System.out.println("Introduzca el número del menu al cual quieres acceder:");
				System.out.println("1)Municipios");
				System.out.println("2)Convocatorias");
				System.out.println("3)Presentaciones");
				System.out.println("4)Información");
				System.out.println("0)Salir");
				System.out.print("Menu: ");
				return leer.nextInt();
				
				
			case 2: //Convocatorias
				System.out.println("Menu Convocatorias");
				this.opciones();
				return leer.nextInt();
			
			
			default:
				return 0;
		}
	}
	public int f(int estado)
	{
		switch(estado)
		{
			case -1:  //Estado Inicial
				System.out.println("Bienvenido al programa de presentaciones digitales contables");
				System.out.println("Introduzca el número del menu al cual quieres acceder:");
				System.out.println("1)Municipios");
				System.out.println("2)Convocatorias");
				System.out.println("3)Presentaciones");
				System.out.println("4)Información");
				System.out.println("0)Salir");
				System.out.print("Menu: ");
				return leer.nextInt();
				
				
			
			default:
				return 0;
		}
	}
	public int u(int estado)
	{
		switch(estado)
		{
			case -1:  //Estado Inicial
				System.out.println("Bienvenido al programa de presentaciones digitales contables");
				System.out.println("Introduzca el número del menu al cual quieres acceder:");
				System.out.println("1)Municipios");
				System.out.println("2)Convocatorias");
				System.out.println("3)Presentaciones");
				System.out.println("4)Información");
				System.out.println("0)Salir");
				System.out.print("Menu: ");
				return leer.nextInt();
				
			case 3: //Presentaciones
				System.out.println("Menu Presentaciones");
				this.opciones();
				return leer.nextInt();
			
			default:
				return 0;
		}
	}
	private void opciones()
	{
		System.out.println("Introduzca el número del menu al cual quieres acceder:");
		System.out.println("1)Alta");
		System.out.println("2)Baja");
		System.out.println("3)Modificación");
		System.out.println("0)Salir");
		System.out.print("Menu: ");
	}
}
