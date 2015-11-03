package pe.com.scot.negocio.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import pe.com.scot.bean.negocio.Catalogo;
import pe.com.scot.negocio.dao.MaestroCatalogoDao;
import pe.com.scot.negocio.dao.impl.MaestroCatalogoDaoImpl;

/**
 * Session Bean implementation class MaestroCatalogoSession
 */
@Stateless
public class MaestroCatalogoSession implements MaestroCatalogoSessionRemote, MaestroCatalogoSessionLocal {

    /**
     * Default constructor. 
     */
    public MaestroCatalogoSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Catalogo> listarCatalogo(Integer idMaestro) throws SQLException {
		MaestroCatalogoDao maestroCatalogoDao = new MaestroCatalogoDaoImpl();
		
		return maestroCatalogoDao.listarCatalogo(idMaestro);
	}
    
    

}
