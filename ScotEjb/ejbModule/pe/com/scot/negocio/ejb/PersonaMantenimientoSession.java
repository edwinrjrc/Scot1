package pe.com.scot.negocio.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import pe.com.scot.bean.negocio.PersonaMantenimiento;
import pe.com.scot.negocio.dao.PersonaMantenimientoDao;
import pe.com.scot.negocio.dao.impl.PersonaMantenimientoDaoImpl;

/**
 * Session Bean implementation class PersonaMantenimientoSession
 */
@Stateless
public class PersonaMantenimientoSession implements PersonaMantenimientoSessionRemote, PersonaMantenimientoSessionLocal {

    /**
     * Default constructor. 
     */
    public PersonaMantenimientoSession() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<PersonaMantenimiento> listarPersonaxArea(Integer idArea)
			throws SQLException {
		PersonaMantenimientoDao personalMantenimientoDao = new PersonaMantenimientoDaoImpl();
		
		return personalMantenimientoDao.listarPersonaxArea(idArea);
	}

	@Override
	public List<PersonaMantenimiento> listarPersonaxCargo(Integer idCargo)
			throws SQLException {
		PersonaMantenimientoDao personalMantenimientoDao = new PersonaMantenimientoDaoImpl();
		
		return personalMantenimientoDao.listarPersonaxCargo(idCargo);
	}

}
