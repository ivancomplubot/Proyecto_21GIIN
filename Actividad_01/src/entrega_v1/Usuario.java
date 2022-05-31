package entrega_v1;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario 
{
	ArrayList<String> lista_usuarios = new ArrayList<String>();
	Scanner leer = new Scanner(System.in);
	
	public Usuario()
	{
		
	}
	public void agregar()
	{
		String usuario_info = "";
		
		System.out.println("Introduce Nombre: ");
		usuario_info+= leer.next()+' ';
		System.out.println("Introduce clave: ");
		usuario_info+= leer.next()+' '+this.tipo();
		lista_usuarios.add(usuario_info);
	}
	public void eliminar()
	{
		if(lista_usuarios.size() > 0)
		{
			System.out.println("Elije el usuario a eliminar");
			this.mostrar();
			System.out.println("Eliminar: ");
			int eliminar = leer.nextInt();
			lista_usuarios.remove(eliminar);
		}
		else
			System.out.println("No hay usuarios que eliminar");
		
		
	}
	public void modificar()
	{
		if(lista_usuarios.size() > 0)
		{
			String usuario_info = "";
			System.out.println("Elije el usuario a modificar");
			this.mostrar();
			System.out.println("Modificar: ");
			int modificar = leer.nextInt();
			
			System.out.println("Introduce Nombre: ");
			usuario_info+= leer.next()+' ';
			System.out.println("Introduce clave: ");
			usuario_info+= leer.next()+' '+this.tipo();
			lista_usuarios.set(modificar,usuario_info);
		}
		else
			System.out.println("No hay usuarios que modificar");
		
	}
	public void mostrar()
	{
		String num;
		for(int x=0;x<lista_usuarios.size();x++)
		{
			num = String.valueOf(x)+')';
			System.out.println(num+lista_usuarios.get(x));
		}
	}
	private String tipo()
	{
		System.out.println("Introduzca el número del tipo de usuario:");
		System.out.println("1)Administrador");
		System.out.println("2)Fiscal General");
		System.out.println("3)Fiscal");
		System.out.println("4)Cuentadante");
		System.out.println("Introduce tipo de usuario: ");
		int tipo= leer.nextInt();
		if (tipo == 1)
			return "Administrador";
		else if(tipo == 2)
			return "Fiscal General";
		else if(tipo == 3)
			return "Fiscal";
		else
			return "Cuentadante";
		
		
	}
}
