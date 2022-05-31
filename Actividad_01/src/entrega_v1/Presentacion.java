package entrega_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Presentacion 
{
	ArrayList<String> lista_presentacion = new ArrayList<String>();
	Scanner leer = new Scanner(System.in);
	public Presentacion()
	{
		
	}
	
	public void agregar()
	{
		String presentacion_info = "";
		
		System.out.println("Fecha de presentacion: ");
		presentacion_info+= leer.next()+' ';
		System.out.println("Estado: ");
		presentacion_info+= leer.next()+' '+this.tipo();
		
		lista_presentacion.add(presentacion_info);
	}
	public void eliminar()
	{
		if(lista_presentacion.size() > 0)
		{
			System.out.println("Elije la presentacion a eliminar");
			this.mostrar();
			System.out.println("Eliminar: ");
			int eliminar = leer.nextInt();
			lista_presentacion.remove(eliminar);
		}
		else
			System.out.println("No hay presentaciones que eliminar");
		
		
	}
	public void modificar()
	{
		if(lista_presentacion.size() > 0)
		{
			String presentacion_info = "";
			System.out.println("Elije la presentacion a modificar");
			this.mostrar();
			System.out.println("Modificar: ");
			int modificar = leer.nextInt();
			
			System.out.println("Fecha de presentacion: ");
			presentacion_info+= leer.next()+' ';
			System.out.println("Estado: ");
			presentacion_info+= leer.next()+' '+this.tipo();
			presentacion_info+= leer.next()+' '+this.tipo();
			lista_presentacion.set(modificar,presentacion_info);
		}
		else
			System.out.println("No hay presentaciones que modificar");
		
	}
	public void mostrar()
	{
		String num;
		for(int x=0;x<lista_presentacion.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.println(num+lista_presentacion.get(x));
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
