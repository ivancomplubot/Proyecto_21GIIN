package entrega_v2;


public class municipio 
{
	private String Nombre;
	private String categoria;
	private String cuentadante;
	
	public municipio()
	{
		
	}
	public String getNombre()
	{
		return this.Nombre;
	}
	public String getCategoria()
	{
		return this.categoria;
	}
	public String getCuentadante()
	{
		return this.cuentadante;
	}
	public void setNombre(String x)
	{
		this.Nombre = x;
	}
	public void setCategoria(String x)
	{
		this.categoria = x;
	}
	public void setCuentadante(String x)
	{
		this.cuentadante = x;
	}
	
	public void mostrar()
	{
		System.out.print(this.Nombre+' ');
		System.out.print(this.categoria+' ');
		System.out.println(this.cuentadante);
	}
}
