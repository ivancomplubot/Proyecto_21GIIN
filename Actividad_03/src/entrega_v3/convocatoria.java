package entrega_v3;

import java.util.Scanner;

public class convocatoria 
{
	
	private String Nombre;
	private String fecha_apertura;
	private String fecha_cierre;
	private Boolean estado;
	private String docu;
	
	private Scanner leer = new Scanner(System.in);
	
	
	public convocatoria()
	{
		
	}
	public String getNombre()
	{
		return this.Nombre;
	}
	public String getFecha_apertura()
	{
		return this.fecha_apertura;
	}
	public String getFecha_cierre()
	{
		return this.fecha_cierre;
	}
	public Boolean getEstado()
	{
		return this.estado;
	}
	public String getDocu()
	{
		return this.docu;
	}
	
	
	public void setNombre(String x)
	{
		this.Nombre = x;
	}
	public void setFecha_apertura(String x)
	{
		this.fecha_apertura = x;
	}
	public void setFecha_cierre(String x)
	{
		this.fecha_cierre = x;
	}
	public void setEstado(Boolean x)
	{
		this.estado = x;
	}
	public void setDocu(String x)
	{
		this.docu = x;
	}
	
	public void mostrar()
	{
		System.out.print(this.Nombre+' ');
		System.out.print(this.fecha_apertura+' ');
		System.out.print(this.fecha_cierre+' ');
		System.out.print(this.estado);
		System.out.println(' '+this.docu);
	}
	
	public String tipoDocu()
	{
		
		System.out.println("Introduzca el tipo de documentacion:");
		System.out.println("1)Libro Diario");
		System.out.println("2)Libro Mayor");
		System.out.println("3)Balance de sumas y saldos");
		System.out.println("4)Registro de ingresos de caja");
		System.out.println("5)Registro de movimientos de bancos");
		System.out.print("Elije una opción: ");
		int tipo= this.leer.nextInt();
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
