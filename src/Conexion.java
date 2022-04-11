import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//import Modelo.Conexion;
//import Modelo.Estudiante;
//import Modelo.Conexion.getCerrar;

public class Conexion {
	public static Connection miConexion;
	private Statement Query = null;
	private ResultSet Restultado = null;
	
	public static Connection getConection() {
		try {
			Runtime.getRuntime().addShutdownHook(new getCerrar());
			if (miConexion == null) {
				Class.forName("com.mysql.jdbc.Driver");
				   miConexion = DriverManager.getConnection("jdbc:mysql://localhost/programacion1", "root", "*010405");
			}
			 return miConexion;
		}
		catch(ClassNotFoundException | SQLException e){
			throw new RuntimeException("No se Pudo Establecer la Conexion a MySQL",e);
		}
	}
	static class getCerrar extends Thread{
		  @Override
		  public void run() {
			  try {
				  Connection conn = Conexion.getConection();
				  conn.close();
			  }
			  catch(SQLException ex){
				  throw new RuntimeException(ex);
			  }
		  }
	  }
	
	public int SetInformacion(String Sentencia) {
		int nResultado = 0;
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
			
			Query = miConexion.createStatement();
			nResultado = Query.executeUpdate(Sentencia);
			
			
			
			return nResultado;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return nResultado;
		}
		
	}
	public int EjecutarSentencia(String Sentencia) {
		int nResultado = 0;
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
			
			Query = miConexion.createStatement();
			nResultado = Query.executeUpdate(Sentencia);
			
			
			
			return nResultado;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return nResultado;
		}
		
	}
	public Estudiante InformacionEstudiante(int nId) {
		Estudiante oEstudiante = new Estudiante();
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
			String cQuery = "Select * from estudiantes where IdEstudiante = " + nId;
			Query = miConexion.createStatement();
			Restultado = Query.executeQuery(cQuery);
			
			while (Restultado.next()) {
				oEstudiante.setIdEstudiante(Restultado.getInt(1));
				oEstudiante.setNombre(Restultado.getString(2));
				oEstudiante.setApellido(Restultado.getString(3));
				oEstudiante.setTelefono(Restultado.getString(4));
				oEstudiante.setEmail(Restultado.getString(5));
				oEstudiante.setUserName(Restultado.getString(6));
				oEstudiante.setPassword(Restultado.getString(7));
				
			}
			
			
			
			return oEstudiante;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return oEstudiante;
		}
		
		
		
		
		
	}
	public boolean Consultar(String cQuery) {
		//int nResultado = 0;
		boolean Datos = false;
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
			
			Query = miConexion.createStatement();
			Restultado = Query.executeQuery(cQuery);
			if (Restultado.next()) {
				Datos = true;
			}
			return Datos;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return Datos;
		}
		
	}
	public String ConsultarUsuario(String cQuery) {
		//int nResultado = 0;
		String Dato = "";
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
			
			Query = miConexion.createStatement();
			Restultado = Query.executeQuery(cQuery);
			if (Restultado.next()) {
				Dato = Restultado.getString(1);
			}
			return Dato;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return Dato;
		}
		
	}
	public DefaultTableModel ConsultarTodo() {
		DefaultTableModel dtDatos = new DefaultTableModel();
		String [] cDatos = new String[6];
		
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
			
			
			dtDatos.addColumn("CODIGO");
			dtDatos.addColumn("NOMBRE");
			dtDatos.addColumn("APELLIDO");
			dtDatos.addColumn("TELEFONO");
			dtDatos.addColumn("EMAIL");
			dtDatos.addColumn("USUARIO");
			
			Query = miConexion.createStatement();
			Restultado = Query.executeQuery("Select * from estudiantes");
			while (Restultado.next()) {
				
				cDatos[0] = Restultado.getString(1);
				cDatos[1] = Restultado.getString(2);
				cDatos[2] = Restultado.getString(3);
				cDatos[3] = Restultado.getString(4);
				cDatos[4] = Restultado.getString(5);
				cDatos[5] = Restultado.getString(6);
				
				dtDatos.addRow(cDatos);
				
			}
			
			
			
			
			
			return dtDatos;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return dtDatos;
		}
		
	}
	public String[] ConsultarTodo2() {
		//ResultSet dtDatos = null;
		String [] cDatos = new String[6];
	
		try {
			if (miConexion == null) {
				JOptionPane.showMessageDialog(null,"Sin Conexion a la Base de Datos");
			}
		
			Query = miConexion.createStatement();
			Restultado = Query.executeQuery("Select * from estudiantes");
			while (Restultado.next()) {
				//System.out.println(Restultado.getString(1));
				cDatos[0] = Restultado.getString(1);
				cDatos[1] = Restultado.getString(2);
				cDatos[2] = Restultado.getString(3);
				cDatos[3] = Restultado.getString(4);
				cDatos[4] = Restultado.getString(5);
				cDatos[5] = Restultado.getString(6);
				
				//System.out.println(cDatos);
				
			}
			
			
			
			
			
			return cDatos;

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR INSERTANDO DATOS");
			e.printStackTrace();
			
			return cDatos;
		}
		
	}
	
}
