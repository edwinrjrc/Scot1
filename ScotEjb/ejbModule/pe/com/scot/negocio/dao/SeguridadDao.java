/**
 * 
 */
package pe.com.scot.negocio.dao;

import java.sql.SQLException;

import pe.com.scot.bean.negocio.Usuario;
import pe.com.scot.exception.InicioSesionException;

/**
 * @author EDWREB
 *
 */
public interface SeguridadDao {

	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws SQLException
	 */
	public boolean iniciarSession(Usuario usuario) throws SQLException;

	/**
	 * 
	 * @param usuario
	 * @return
	 * @throws SQLException
	 * @throws InicioSesionException 
	 */
	Usuario iniciarSession2(Usuario usuario) throws SQLException, InicioSesionException;
}
