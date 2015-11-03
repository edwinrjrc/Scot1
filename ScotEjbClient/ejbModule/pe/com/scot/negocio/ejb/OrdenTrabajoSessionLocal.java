package pe.com.scot.negocio.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

import pe.com.scot.bean.negocio.OrdenTrabajo;
import pe.com.scot.bean.negocio.OrdenTrabajoBusqueda;
import pe.com.scot.exception.ConsultaException;
import pe.com.scot.exception.RegistroException;

@Local
public interface OrdenTrabajoSessionLocal {

	/**
	 * 
	 * @param ordenTrabajo
	 * @return
	 * @throws SQLException
	 */
	public boolean registrarOrdenTrabajo(OrdenTrabajo ordenTrabajo) throws RegistroException;
	
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
	 * @throws ConsultaException
	 */
	public OrdenTrabajo consultarOrdenTrabajo(Integer idOrdenTrabajo) throws ConsultaException;
	
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
}
