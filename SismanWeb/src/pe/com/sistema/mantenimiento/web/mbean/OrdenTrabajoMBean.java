/**
 * 
 */
package pe.com.sistema.mantenimiento.web.mbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import pe.com.sistema.mantenimiento.negocio.Catalogo;
import pe.com.sistema.mantenimiento.negocio.MaestroNave;
import pe.com.sistema.mantenimiento.negocio.OrdenTrabajo;
import pe.com.sistema.mantenimiento.negocio.PersonaMantenimiento;
import pe.com.sistema.mantenimiento.negocio.dao.MaestroCatalogoDao;
import pe.com.sistema.mantenimiento.negocio.dao.MaestroNaveDao;
import pe.com.sistema.mantenimiento.negocio.dao.OrdenTrabajoDao;
import pe.com.sistema.mantenimiento.negocio.dao.PersonaMantenimientoDao;
import pe.com.sistema.mantenimiento.negocio.dao.impl.MaestroCatalogoDaoImpl;
import pe.com.sistema.mantenimiento.negocio.dao.impl.MaestroNaveDaoImpl;
import pe.com.sistema.mantenimiento.negocio.dao.impl.OrdenTrabajoDaoImpl;
import pe.com.sistema.mantenimiento.negocio.dao.impl.PersonaMantenimientoDaoImpl;

/**
 * @author Edwin
 *
 */
@ManagedBean(name = "ordenTrabajoMBean")
@SessionScoped()
public class OrdenTrabajoMBean extends BaseMBean {

	private static final long serialVersionUID = 9110761772922471814L;

	private List<OrdenTrabajo> listaOrdenesTrabajo;

	private OrdenTrabajo ordenTrabajo;
	private OrdenTrabajo ordenTrabajoBusqueda;

	private List<SelectItem> listaAviones;
	private List<SelectItem> listaInspectores;
	private List<SelectItem> listaMecanicos;
	private List<SelectItem> listaAreas;

	private boolean registrado;
	private boolean busco;
	
	private String anioActual;

	public OrdenTrabajoMBean() {
		// TODO Auto-generated constructor stub
	}

	public void buscarOrden() {
		try {

			OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
			this.setListaOrdenesTrabajo(ordenTrabajoDao
					.buscarOrdenTrabajo(getOrdenTrabajoBusqueda()));
			
			this.setBusco(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void grabarOrden() {

		try {

			OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
			ordenTrabajoDao.registrarOrdenTrabajo(getOrdenTrabajo());

			this.setRegistrado(true);
			this.setBusco(false);
			
			this.mostrarMensajeExito("Orden de trabajo registrada satisfactoriamente");

		} catch (SQLException e) {
			this.mostrarMensajeError(e.getMessage());
			e.printStackTrace();
		}

	}

	public void nuevaOrden() {
		this.setOrdenTrabajo(null);
		this.getOrdenTrabajo().getEstado().setCodigoEntero(1);
		this.setRegistrado(false);
		this.setListaInspectores(null);
		this.setListaAviones(null);
		this.setListaMecanicos(null);
	}

	/**
	 * @return the listaOrdenesTrabajo
	 */
	public List<OrdenTrabajo> getListaOrdenesTrabajo() {
		try {
			if (!busco){
				OrdenTrabajoDao ordenTrabajoDao = new OrdenTrabajoDaoImpl();
				listaOrdenesTrabajo = ordenTrabajoDao.listarOrdenTrabajo();
			}
			
			this.setShowModal(false);
			this.setMensajeModal("");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaOrdenesTrabajo;
	}

	/**
	 * @param listaOrdenesTrabajo
	 *            the listaOrdenesTrabajo to set
	 */
	public void setListaOrdenesTrabajo(List<OrdenTrabajo> listaOrdenesTrabajo) {
		this.listaOrdenesTrabajo = listaOrdenesTrabajo;
	}

	/**
	 * @return the ordenTrabajo
	 */
	public OrdenTrabajo getOrdenTrabajo() {
		if (ordenTrabajo == null) {
			ordenTrabajo = new OrdenTrabajo();
		}
		return ordenTrabajo;
	}

	/**
	 * @param ordenTrabajo
	 *            the ordenTrabajo to set
	 */
	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	/**
	 * @return the ordenTrabajoBusqueda
	 */
	public OrdenTrabajo getOrdenTrabajoBusqueda() {
		if (ordenTrabajoBusqueda == null) {
			ordenTrabajoBusqueda = new OrdenTrabajo();
		}
		return ordenTrabajoBusqueda;
	}

	/**
	 * @param ordenTrabajoBusqueda
	 *            the ordenTrabajoBusqueda to set
	 */
	public void setOrdenTrabajoBusqueda(OrdenTrabajo ordenTrabajoBusqueda) {
		this.ordenTrabajoBusqueda = ordenTrabajoBusqueda;
	}

	/**
	 * @return the listaAviones
	 */
	public List<SelectItem> getListaAviones() {
		try {
			if (listaAviones == null) {
				listaAviones = new ArrayList<SelectItem>();
			}

			MaestroNaveDao naveDao = new MaestroNaveDaoImpl();
			List<MaestroNave> lista = naveDao.listarNaves();
			if (lista != null && !lista.isEmpty()) {
				SelectItem si = null;
				for (MaestroNave maestroNave : lista) {
					si = new SelectItem();
					si.setLabel(maestroNave.getMatricula());
					si.setValue(maestroNave.getCodigoEntero());
					listaAviones.add(si);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAviones;
	}

	/**
	 * @param listaAviones
	 *            the listaAviones to set
	 */
	public void setListaAviones(List<SelectItem> listaAviones) {
		this.listaAviones = listaAviones;
	}

	/**
	 * @return the listaInspectores
	 */
	public List<SelectItem> getListaInspectores() {
		try {
			if (listaInspectores == null) {
				listaInspectores = new ArrayList<SelectItem>();
			}

			PersonaMantenimientoDao personalDao = new PersonaMantenimientoDaoImpl();
			List<PersonaMantenimiento> lista = personalDao
					.listarPersonaxCargo(2);
			if (lista != null && !lista.isEmpty()) {
				SelectItem si = null;
				for (PersonaMantenimiento persona : lista) {
					si = new SelectItem();
					si.setLabel(persona.getNombreCompleto());
					si.setValue(persona.getCodigoEntero());
					listaInspectores.add(si);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaInspectores;
	}

	/**
	 * @param listaInspectores
	 *            the listaInspectores to set
	 */
	public void setListaInspectores(List<SelectItem> listaInspectores) {
		this.listaInspectores = listaInspectores;
	}

	/**
	 * @return the listaMecanicos
	 */
	public List<SelectItem> getListaMecanicos() {
		try {
			if (listaMecanicos == null) {
				listaMecanicos = new ArrayList<SelectItem>();
			}

			PersonaMantenimientoDao personalDao = new PersonaMantenimientoDaoImpl();
			List<PersonaMantenimiento> lista = personalDao
					.listarPersonaxCargo(1);
			if (lista != null && !lista.isEmpty()) {
				SelectItem si = null;
				for (PersonaMantenimiento persona : lista) {
					si = new SelectItem();
					si.setLabel(persona.getNombreCompleto());
					si.setValue(persona.getCodigoEntero());
					listaMecanicos.add(si);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMecanicos;
	}

	/**
	 * @param listaMecanicos
	 *            the listaMecanicos to set
	 */
	public void setListaMecanicos(List<SelectItem> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}

	/**
	 * @return the registrado
	 */
	public boolean isRegistrado() {
		return registrado;
	}

	/**
	 * @param registrado
	 *            the registrado to set
	 */
	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	/**
	 * @return the busco
	 */
	public boolean isBusco() {
		return busco;
	}

	/**
	 * @param busco the busco to set
	 */
	public void setBusco(boolean busco) {
		this.busco = busco;
	}

	/**
	 * @return the anioActual
	 */
	public String getAnioActual() {
		Calendar cal = Calendar.getInstance();
		
		anioActual = String.valueOf(cal.get(Calendar.YEAR));
		
		return anioActual;
	}

	/**
	 * @param anioActual the anioActual to set
	 */
	public void setAnioActual(String anioActual) {
		this.anioActual = anioActual;
	}

	/**
	 * @return the listaAreas
	 */
	public List<SelectItem> getListaAreas() {
		try {
			listaAreas = null;
			if (listaAreas == null) {
				listaAreas = new ArrayList<SelectItem>();
			}

			MaestroCatalogoDao maestroCatalogo = new MaestroCatalogoDaoImpl(); 
			List<Catalogo> lista = maestroCatalogo.listarCatalogo(3);
			if (lista != null && !lista.isEmpty()) {
				SelectItem si = null;
				for (Catalogo catalogo : lista) {
					si = new SelectItem();
					si.setLabel(catalogo.getNombre());
					si.setValue(catalogo.getCodigoEntero());
					listaAreas.add(si);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAreas;
	}

	/**
	 * @param listaAreas the listaAreas to set
	 */
	public void setListaAreas(List<SelectItem> listaAreas) {
		this.listaAreas = listaAreas;
	}

}
