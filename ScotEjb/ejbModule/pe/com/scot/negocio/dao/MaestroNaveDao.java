/**
 * 
 */
package pe.com.scot.negocio.dao;

import java.sql.SQLException;
import java.util.List;

import pe.com.scot.bean.negocio.MaestroNave;

/**
 * @author Edwin
 *
 */
public interface MaestroNaveDao {

	public List<MaestroNave> listarNaves() throws SQLException;
}
