/**
 * 
 */
package pe.com.scot.negocio.dao;

import java.sql.SQLException;
import java.util.List;

import pe.com.scot.bean.negocio.PersonaMantenimiento;

/**
 * @author Edwin
 *
 */
public interface PersonaMantenimientoDao {
	
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
