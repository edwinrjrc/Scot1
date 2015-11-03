package pe.com.scot.negocio.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import pe.com.scot.bean.negocio.PersonaMantenimiento;

@Remote
public interface PersonaMantenimientoSessionRemote {

	/**
	 * 
	 * @param idArea
	 * @return
	 * @throws SQLException
	 */
	public List<PersonaMantenimiento> listarPersonaxArea(Integer idArea) throws SQLException;

	/**
	 * 
	 * @param idCargo
	 * @return
	 * @throws SQLException
	 */
	List<PersonaMantenimiento> listarPersonaxCargo(Integer idCargo)
			throws SQLException;
}
