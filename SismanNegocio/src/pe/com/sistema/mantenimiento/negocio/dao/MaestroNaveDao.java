/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao;

import java.sql.SQLException;
import java.util.List;

import pe.com.sistema.mantenimiento.negocio.MaestroNave;

/**
 * @author Edwin
 *
 */
public interface MaestroNaveDao {

	public List<MaestroNave> listarNaves() throws SQLException;
}
