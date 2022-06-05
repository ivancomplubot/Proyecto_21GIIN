package entrega_v4;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

public class DB_proyecto
{
	private conexionDB db = new conexionDB();
	private Connection con = null; 
	public DB_proyecto()
	{
		
	}
	public void agregar_usuario(usuario u)
	{
		PreparedStatement datos;
		String sql = "INSERT INTO usuario(nombre,clave,tipo) values(?,?,?)";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.setString(2, u.getClave());
			datos.setString(3, u.getTipo());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void eliminar_usuario(usuario u)
	{
		PreparedStatement datos;
		String sql = "delete from usuario where nombre = ?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void modificar_usuario(usuario u, String nombre)
	{	
		PreparedStatement datos;
		String sql = "UPDATE usuario SET nombre=?,clave=?,tipo=?"+"WHERE nombre=?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.setString(2, u.getClave());
			datos.setString(3, u.getTipo());
			datos.setString(4, nombre);
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void leer_usuarios(ArrayList<usuario> u)
	{
		usuario aux = new usuario();
		
		con = db.conectar();
		
		try 
		{
			Statement datos = con.createStatement();
			String sql = "SELECT * FROM usuario";
			ResultSet lectura;
			lectura = datos.executeQuery(sql);
			while(lectura.next())
			{
				aux.setNombre(lectura.getString("nombre"));
				aux.setClave(lectura.getString("clave"));
				aux.setTipo(lectura.getString("tipo"));
				u.add(aux);
				aux = new usuario();
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void agregar_municipio(municipio u)
	{
		PreparedStatement datos;
		String sql = "INSERT INTO municipio(nombre,categoria,usuario) values(?,?,?)";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.setString(2, u.getCategoria());
			datos.setString(3, u.getCuentadante());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void eliminar_municipio(municipio u)
	{
		PreparedStatement datos;
		String sql = "delete from municipio where nombre = ?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void modificar_municipio(municipio u, String nombre)
	{
		PreparedStatement datos;
		String sql = "UPDATE municipio SET nombre=?,categoria=?,usuario=?"+"WHERE nombre=?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.setString(2, u.getCategoria());
			datos.setString(3, u.getCuentadante());
			datos.setString(4, nombre);
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void leer_municipio(ArrayList<municipio> u)
	{
		municipio aux = new municipio();
		
		con = db.conectar();
		
		try 
		{
			Statement datos = con.createStatement();
			String sql = "SELECT * FROM municipio";
			ResultSet lectura;
			lectura = datos.executeQuery(sql);
			while(lectura.next())
			{
				aux.setNombre(lectura.getString("nombre"));
				aux.setCategoria(lectura.getString("categoria"));
				aux.setCuentadante(lectura.getString("usuario"));
				u.add(aux);
				aux = new municipio();
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void agregar_convocatoria(convocatoria u)
	{
		PreparedStatement datos;
		String sql = "INSERT INTO convocatoria(nombre,fecha_apertura,fecha_cierre,estado,docu) values(?,?,?,?,?)";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.setString(2, u.getFecha_apertura());
			datos.setString(3, u.getFecha_cierre());
			datos.setBoolean(4, u.getEstado());
			datos.setString(5, u.getDocu());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void eliminar_convocatoria(convocatoria u)
	{
		PreparedStatement datos;
		String sql = "delete from convocatoria where nombre = ?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void modificar_convocatoria(convocatoria u, String nombre)
	{
		PreparedStatement datos;
		String sql = "UPDATE convocatoria SET nombre=?,fecha_apertura=?,fecha_cierre=?,estado=?,docu=?"+"WHERE nombre=?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getNombre());
			datos.setString(2, u.getFecha_apertura());
			datos.setString(3, u.getFecha_cierre());
			datos.setBoolean(4, u.getEstado());
			datos.setString(5, u.getDocu());
			datos.setString(6, nombre);
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void leer_convocatorias(ArrayList<convocatoria> u)
	{
		convocatoria aux = new convocatoria();
		
		con = db.conectar();
		
		try 
		{
			Statement datos = con.createStatement();
			String sql = "SELECT * FROM convocatoria";
			ResultSet lectura;
			lectura = datos.executeQuery(sql);
			while(lectura.next())
			{
				aux.setNombre(lectura.getString("nombre"));
				aux.setFecha_apertura(lectura.getString("fecha_apertura"));
				aux.setFecha_cierre(lectura.getString("fecha_cierre"));
				aux.setEstado(lectura.getBoolean("estado"));
				aux.setDocu(lectura.getString("docu"));
				u.add(aux);
				aux = new convocatoria();
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void agregar_presentacion(presentacion u)
	{
		PreparedStatement datos;
		String sql = "INSERT INTO presentacion(convocatoria,fecha_presentacion,estado,docu) values(?,?,?,?)";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getConvocatoria());
			datos.setString(2, u.getFecha_presentacion());
			datos.setBoolean(3, u.getEstado());
			datos.setString(4, u.getDocu());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void eliminar_presentacion(presentacion u)
	{
		PreparedStatement datos;
		String sql = "delete from presentacion where convocatoria = ?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getConvocatoria());
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void modificar_presentacion(presentacion u, String nombre)
	{
		PreparedStatement datos;
		String sql = "UPDATE presentacion SET convocatoria=?,fecha_presentacion=?,estado=?,docu=?"+"WHERE convocatoria=?";
		try 
		{
			con = db.conectar();
			datos = con.prepareStatement(sql);
			datos.setString(1, u.getConvocatoria());
			datos.setString(2, u.getFecha_presentacion());
			datos.setBoolean(3, u.getEstado());
			datos.setString(4, u.getDocu());
			datos.setString(5, nombre);
			datos.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexion");
			e.printStackTrace();
        }
	}
	public void leer_presentacion(ArrayList<presentacion> u)
	{
		presentacion aux = new presentacion();
		
		con = db.conectar();
		
		try 
		{
			Statement datos = con.createStatement();
			String sql = "SELECT * FROM presentacion";
			ResultSet lectura;
			lectura = datos.executeQuery(sql);
			while(lectura.next())
			{
				aux.setConvocatoria(lectura.getString("convocatoria"));
				aux.setFecha_presentacion(lectura.getString("fecha_presentacion"));
				aux.setEstado(lectura.getBoolean("estado"));
				aux.setDocu(lectura.getString("docu"));
				u.add(aux);
				aux = new presentacion();
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
