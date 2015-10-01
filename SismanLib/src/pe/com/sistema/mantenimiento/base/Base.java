/**
 * 
 */
package pe.com.sistema.mantenimiento.base;

import java.io.Serializable;

/**
 * @author Edwin
 *
 */
public class Base implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6317952147597732274L;
	
	
	private String codigoCadena;
	private Integer codigoEntero;
	
	
	/**
	 * @return the codigoCadena
	 */
	public String getCodigoCadena() {
		return codigoCadena;
	}
	/**
	 * @param codigoCadena the codigoCadena to set
	 */
	public void setCodigoCadena(String codigoCadena) {
		this.codigoCadena = codigoCadena;
	}
	/**
	 * @return the codigoEntero
	 */
	public Integer getCodigoEntero() {
		return codigoEntero;
	}
	/**
	 * @param codigoEntero the codigoEntero to set
	 */
	public void setCodigoEntero(Integer codigoEntero) {
		this.codigoEntero = codigoEntero;
	}

	
}
