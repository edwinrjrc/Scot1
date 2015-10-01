/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao;

import java.sql.SQLException;
import java.util.List;

import pe.com.sistema.mantenimiento.negocio.OrdenTrabajo;

/**
 * @author Edwin
 *
 */
public interface OrdenTrabajoDao {

	/**
	 * 
	 * @param ordenTrabajo
	 * @return
	 * @throws SQLException
	 */
	public boolean registrarOrdenTrabajo(OrdenTrabajo ordenTrabajo) throws SQLException;
	
	/**
	 * 
	 * @param ordenTrabajo
	 * @return
	 * @throws SQLException
	 */
	public boolean actualizarOrdenTrabajo(OrdenTrabajo ordenTrabajo) throws SQLException;
	
	/**
	 * 
	 * @param idOrdenTrabajo
	 * @return
	 * @throws SQLException
	 */
	public OrdenTrabajo consultarOrdenTrabajo(Integer idOrdenTrabajo) throws SQLException;
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<OrdenTrabajo> listarOrdenTrabajo() throws SQLException;
	
	/**
	 * 
	 * @param ordenTrabajo
	 * @return
	 * @throws SQLException
	 */
	public List<OrdenTrabajo> buscarOrdenTrabajo(OrdenTrabajo ordenTrabajo) throws SQLException;
	
}
