/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao;

import java.sql.SQLException;
import java.util.List;

import pe.com.sistema.mantenimiento.negocio.PersonaMantenimiento;

/**
 * @author Edwin
 *
 */
public interface PersonaMantenimientoDao {
	
	public List<PersonaMantenimiento> listarPersonaxArea(Integer idArea) throws SQLException;

	List<PersonaMantenimiento> listarPersonaxCargo(Integer idCargo)
			throws SQLException;
	
}
