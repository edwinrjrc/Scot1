package pe.com.scot.negocio.ejb;

import java.sql.SQLException;

import javax.ejb.Remote;

import pe.com.scot.bean.negocio.Usuario;
import pe.com.scot.exception.InicioSesionException;

@Remote
public interface SeguridadSessionRemote {

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
