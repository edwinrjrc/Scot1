package pe.com.scot.negocio.ejb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import pe.com.scot.bean.negocio.ArchivoAdjunto;
import pe.com.scot.bean.negocio.OrdenTrabajo;
import pe.com.scot.bean.negocio.OrdenTrabajoBusqueda;
import pe.com.scot.exception.ConsultaException;
import pe.com.scot.exception.RegistroException;
import pe.com.scot.negocio.dao.OrdenTrabajoDao;
import pe.com.scot.negocio.dao.impl.OrdenTrabajoDaoImpl;

/**
 * Session Bean implementation class OrdenTrabajoSession
 */
@Stateless
public class OrdenTrabajoSession implements OrdenTrabajoSessionRemote, OrdenTrabajoSessionLocal {

    /**
     * Default constructor. 
     */
    public OrdenTrabajoSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean registrarOrdenTrabajo(OrdenTrabajo ordenTrabajo)
			throws RegistroException {
		try {
			OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
			
			Integer idOrden = ordenTrabajoDao.registrarOrdenTrabajo(ordenTrabajo);
			if (idOrden == null || idOrden.intValue()==0){
				throw new RegistroException("No se pudo registrar archivo adjunto");
			}
			for (ArchivoAdjunto archivoAdjunto : ordenTrabajo.getArchivosAdjuntos()){
				archivoAdjunto.setIdOrdenArchivo(idOrden);
				if (!ordenTrabajoDao.registrarAdjuntoOrdenTrabajo(archivoAdjunto)){
					throw new RegistroException("No se pudo registrar archivo adjunto");
				}
			}
		} catch (SQLException e) {
			throw new RegistroException(e.getMessage(), e);
		}
				
		return true;
	}

	@Override
	public boolean actualizarOrdenTrabajo(OrdenTrabajo ordenTrabajo)
			throws SQLException {
		OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
		
		return ordenTrabajoDao.actualizarOrdenTrabajo(ordenTrabajo);
	}

	@Override
	public OrdenTrabajo consultarOrdenTrabajo(Integer idOrdenTrabajo) throws ConsultaException {
		try {
			OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
			OrdenTrabajo ordenTrabajo = ordenTrabajoDao.consultarOrdenTrabajo(idOrdenTrabajo);
			ordenTrabajo.setArchivosAdjuntos(ordenTrabajoDao.consultarArchivosOrden(idOrdenTrabajo));
			
			return ordenTrabajo;
		} catch (IOException e) {
			throw new ConsultaException(e);
		} catch (SQLException e) {
			throw new ConsultaException(e);
		}
	}

	@Override
	public List<OrdenTrabajo> listarOrdenTrabajo() throws SQLException {
		OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
		
		return ordenTrabajoDao.listarOrdenTrabajo();
	}

	@Override
	public List<OrdenTrabajo> buscarOrdenTrabajo(
			OrdenTrabajoBusqueda ordenTrabajo2) throws SQLException {
		OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
		
		return ordenTrabajoDao.buscarOrdenTrabajo(ordenTrabajo2);
	}

}
