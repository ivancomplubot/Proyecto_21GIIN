package entrega_v3;

import java.util.Scanner;

public class usuario 
{
	private String Nombre;
	private String Clave;
	private String tipo_usuario;
	private Scanner leer = new Scanner(System.in);
	public usuario()
	{
		
	}
	public String getNombre()
	{
		return this.Nombre;
	}
	public String getClave()
	{
		return this.Clave;
	}
	public String getTipo()
	{
		return this.tipo_usuario;
	}
	public void setNombre(String x)
	{
		this.Nombre = x;
	}
	public void setClave(String x)
	{
		this.Clave = x;
	}
	public void setTipo(String x)
	{
		this.tipo_usuario = x;
	}
	
	public void mostrar()
	{
		System.out.print(this.Nombre+' ');
		System.out.print(this.Clave+' ');
		System.out.println(this.tipo_usuario);
	}
	
	public String tipo()
	{
		System.out.println("Introduzca el número del tipo de usuario:");
		System.out.println("1)Administrador");
		System.out.println("2)Fiscal General");
		System.out.println("3)Fiscal");
		System.out.println("4)Cuentadante");
		System.out.print("Introduce tipo de usuario: ");
		int tipo= this.leer.nextInt();
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
