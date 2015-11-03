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
public interface MaestroCatalogoDao {

	public List<Catalogo> listarCatalogo(Integer idMaestro) throws SQLException;
	
	
}
