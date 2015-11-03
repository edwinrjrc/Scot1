package pe.com.scot.negocio.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import pe.com.scot.bean.negocio.Catalogo;

@Remote
public interface MaestroCatalogoSessionRemote {

	public List<Catalogo> listarCatalogo(Integer idMaestro) throws SQLException;
}
