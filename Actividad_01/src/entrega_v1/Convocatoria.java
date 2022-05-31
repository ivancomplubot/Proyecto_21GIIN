package entrega_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Convocatoria 
{
	ArrayList<String> lista_convocatorias = new ArrayList<String>();
	Scanner leer = new Scanner(System.in);
	public Convocatoria()
	{
		
	}
	
	public void agregar()
	{
		String convocatoria_info = "";
		
		System.out.println("Introduce Nombre: ");
		convocatoria_info+= leer.next()+' ';
		System.out.println("Introduce Descripcion: ");
		convocatoria_info+= leer.next()+' ';
		System.out.println("Fecha de apertura: ");
		convocatoria_info+= leer.next()+' ';
		System.out.println("Fecha de cierre: ");
		convocatoria_info+= leer.next()+' ';
		System.out.println("Estado: ");
		convocatoria_info+= leer.next()+' '+this.tipo();
		
		lista_convocatorias.add(convocatoria_info);
	}
	public void eliminar()
	{
		if(lista_convocatorias.size() > 0)
		{
			System.out.println("Elije la covocatoria a eliminar");
			this.mostrar();
			System.out.println("Eliminar: ");
			int eliminar = leer.nextInt();
			lista_convocatorias.remove(eliminar);
		}
		else
			System.out.println("No hay convocatorias que eliminar");
		
		
	}
	public void modificar()
	{
		if(lista_convocatorias.size() > 0)
		{
			String convocatoria_info = "";
			System.out.println("Elije la convocatoria a modificar");
			this.mostrar();
			System.out.println("Modificar: ");
			int modificar = leer.nextInt();
			
			System.out.println("Introduce Nombre: ");
			convocatoria_info+= leer.next()+' ';
			System.out.println("Introduce Descripcion: ");
			convocatoria_info+= leer.next()+' ';
			System.out.println("Fecha de apertura: ");
			convocatoria_info+= leer.next()+' ';
			System.out.println("Fecha de cierre: ");
			convocatoria_info+= leer.next()+' ';
			System.out.println("Estado: ");
			convocatoria_info+= leer.next()+' '+this.tipo();
			lista_convocatorias.set(modificar,convocatoria_info);
		}
		else
			System.out.println("No hay convocatorias que modificar");
		
	}
	public void mostrar()
	{
		String num;
		for(int x=0;x<lista_convocatorias.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.println(num+lista_convocatorias.get(x));
		}
	}
	private String tipo()
	{
		System.out.println("Introduzca el tipo de documentacion:");
		System.out.println("1)Libro Diario");
		System.out.println("2)Libro Mayor");
		System.out.println("3)Balance de sumas y saldos");
		System.out.println("4)Registro de ingresos de caja");
		System.out.println("5)Registro de movimientos de bancos");
		System.out.println("Elije una opción: ");
		int tipo= leer.nextInt();
		if (tipo == 1)
			return "Libro Diario";
		else if(tipo == 2)
			return "Libro Mayor";
		else if(tipo == 3)
			return "Balance de sumas y saldos";
		else if(tipo == 4)
			return "Registro de ingresos de caja";
		else
			return "Registro de movimientos de bancos";
		
		
	}
}
