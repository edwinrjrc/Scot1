/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao;

import java.sql.SQLException;

import pe.com.sistema.exception.InicioSesionException;
import pe.com.sistema.mantenimiento.negocio.Usuario;

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
