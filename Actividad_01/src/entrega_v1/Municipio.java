package entrega_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Municipio 
{
	
	ArrayList<String> lista_municipios = new ArrayList<String>();
	Scanner leer = new Scanner(System.in);
	public Municipio()
	{
		
	}
	
	public void agregar()
	{
		String municipio_info = "";
		
		System.out.println("Introduce Nombre: ");
		municipio_info+= leer.next()+' ';
		System.out.println("Introduce categoria: ");
		municipio_info+= leer.next()+' ';
		System.out.println("Introduce usuario Cuentadante: ");
		municipio_info+= leer.next();
		lista_municipios.add(municipio_info);
	}
	public void eliminar()
	{
		if(lista_municipios.size() > 0)
		{
			System.out.println("Elije el municipio a eliminar");
			this.mostrar();
			System.out.println("Eliminar: ");
			int eliminar = leer.nextInt();
			lista_municipios.remove(eliminar);
		}
		else
			System.out.println("No hay municipios que eliminar");
		
		
	}
	public void modificar()
	{
		if(lista_municipios.size() > 0)
		{
			String municipio_info = "";
			System.out.println("Elije el municipio a modificar");
			this.mostrar();
			System.out.println("Modificar: ");
			int modificar = leer.nextInt();
			
			System.out.println("Introduce Nombre: ");
			municipio_info+= leer.next()+' ';
			System.out.println("Introduce categoria: ");
			municipio_info+= leer.next()+' ';
			System.out.println("Introduce usuario Cuentadante: ");
			municipio_info+= leer.next();
			lista_municipios.set(modificar,municipio_info);
		}
		else
			System.out.println("No hay usuarios que modificar");
		
	}
	public void mostrar()
	{
		String num;
		for(int x=0;x<lista_municipios.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.println(num+lista_municipios.get(x));
		}
	}

}
