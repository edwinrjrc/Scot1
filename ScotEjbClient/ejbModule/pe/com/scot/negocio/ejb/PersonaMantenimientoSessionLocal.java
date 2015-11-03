package pe.com.scot.negocio.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import pe.com.scot.bean.negocio.PersonaMantenimiento;

@Local
public interface PersonaMantenimientoSessionLocal {

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
