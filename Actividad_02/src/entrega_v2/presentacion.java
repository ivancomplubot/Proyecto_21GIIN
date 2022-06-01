package entrega_v2;

import java.util.Scanner;

public class presentacion 
{
	
	private String convocatoria;
	private String fecha_presentacion;
	private Boolean estado;
	private String docu;
	
	private Scanner leer = new Scanner(System.in);
	
	public presentacion()
	{
		
	}
	
	public String getConvocatoria()
	{
		return this.convocatoria;
	}
	public String getFecha_presentacion()
	{
		return this.fecha_presentacion;
	}
	public Boolean getEstado()
	{
		return this.estado;
	}
	public String getDocu()
	{
		return this.docu;
	}
	
	public void setConvocatoria(String x)
	{
		this.convocatoria = x;
	}
	public void setFecha_presentacion(String x)
	{
		this.fecha_presentacion = x;
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
		System.out.print(this.convocatoria+' ');
		System.out.print(this.fecha_presentacion+' ');
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
