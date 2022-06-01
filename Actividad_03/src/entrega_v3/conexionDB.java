package entrega_v3;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class conexionDB 
{
	public conexionDB()
	{
		
	}
	public Connection conectar()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://dbproyecto.citgszt3ot5s.eu-west-3.rds.amazonaws.com:3306/proyecto","gb_ivan","21#DB#gb");
			System.out.println("Conexion ok");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error al cargar controlador");
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
		return con;
	}
}
