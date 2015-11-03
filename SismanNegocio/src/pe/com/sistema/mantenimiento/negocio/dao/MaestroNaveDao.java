/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Edwin
 *
 */
public interface MaestroNaveDao {

	public List<MaestroNave> listarNaves() throws SQLException;
}
