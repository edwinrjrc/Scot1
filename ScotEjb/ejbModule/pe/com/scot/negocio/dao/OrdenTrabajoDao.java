/**
 * 
 */
package pe.com.scot.negocio.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import pe.com.scot.bean.negocio.ArchivoAdjunto;
import pe.com.scot.bean.negocio.OrdenTrabajo;
import pe.com.scot.bean.negocio.OrdenTrabajoBusqueda;


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
	public Integer registrarOrdenTrabajo(OrdenTrabajo ordenTrabajo) throws SQLException;
	
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
	 * @param ordenTrabajo2
	 * @return
	 * @throws SQLException
	 */
	List<OrdenTrabajo> buscarOrdenTrabajo(OrdenTrabajoBusqueda ordenTrabajo2)
			throws SQLException;

	/**
	 * 
	 * @param archivoAdjunto
	 * @return
	 * @throws SQLException
	 */
	boolean registrarAdjuntoOrdenTrabajo(ArchivoAdjunto archivoAdjunto)
			throws SQLException;
	
	
	/**
	 * 
	 * @param irOrden
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	List<ArchivoAdjunto> consultarArchivosOrden(Integer irOrden) throws SQLException, IOException;
	
}
