/**
 * 
 */
package pe.com.sistema.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Edwin
 *
 */
public class UtilConexion {

	
private static String JNDI = "java:/jboss/jdbc/sismanDS";
	
	/**
	 * 
	 * @return Connection
	 * @throws ConnectionException 
	 */
	public static Connection obtenerConexion(){
		
		try {
			Context ic = new InitialContext();
			DataSource dataSource = null;
			
			dataSource = (DataSource) ic.lookup(JNDI);
			
			return dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			//throw new ConnectionException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new ConnectionException(e);
		}
		return null;
	}
}
