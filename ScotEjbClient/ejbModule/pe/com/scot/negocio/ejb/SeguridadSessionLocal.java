package pe.com.scot.negocio.ejb;

import java.sql.SQLException;

import javax.ejb.Local;

import pe.com.scot.bean.negocio.Usuario;
import pe.com.scot.exception.InicioSesionException;

@Local
public interface SeguridadSessionLocal {
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
