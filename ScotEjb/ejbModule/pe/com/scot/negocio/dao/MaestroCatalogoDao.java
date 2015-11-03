/**
 * 
 */
package pe.com.scot.negocio.dao;

import java.sql.SQLException;
import java.util.List;

import pe.com.scot.bean.negocio.Catalogo;

/**
 * @author Edwin
 *
 */
public interface MaestroCatalogoDao {

	public List<Catalogo> listarCatalogo(Integer idMaestro) throws SQLException;
	
	
}
