/**
 * 
 */
package pe.com.scot.bean.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author EDWREB
 *
 */
public class OrdenTrabajoBusqueda extends OrdenTrabajo {

	private static final long serialVersionUID = -456325612268974439L;
	
	private Date fechaDesde;
	private Date fechaHasta;

	public OrdenTrabajoBusqueda() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		
		return fechaHasta;
	}

	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

}
