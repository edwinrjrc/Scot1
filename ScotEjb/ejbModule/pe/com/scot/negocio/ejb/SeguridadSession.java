package pe.com.scot.negocio.ejb;

import java.sql.SQLException;

import javax.ejb.Stateless;

import pe.com.scot.bean.negocio.Usuario;
import pe.com.scot.exception.InicioSesionException;
import pe.com.scot.negocio.dao.SeguridadDao;
import pe.com.scot.negocio.dao.impl.SeguridadDaoImpl;

/**
 * Session Bean implementation class SeguridadSession
 */
@Stateless
public class SeguridadSession implements SeguridadSessionRemote, SeguridadSessionLocal {

    /**
     * Default constructor. 
     */
    public SeguridadSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean iniciarSession(Usuario usuario) throws SQLException {
		SeguridadDao seguridadDao = new SeguridadDaoImpl();
		
		return seguridadDao.iniciarSession(usuario);
	}

	@Override
	public Usuario iniciarSession2(Usuario usuario) throws SQLException,
			InicioSesionException {
		SeguridadDao seguridadDao = new SeguridadDaoImpl();
		
		return seguridadDao.iniciarSession2(usuario);
	}

}
