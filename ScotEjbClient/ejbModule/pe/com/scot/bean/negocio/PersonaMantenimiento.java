/**
 * 
 */
package pe.com.scot.bean.negocio;

import pe.com.scot.bean.base.BaseNegocio;
import pe.com.scot.bean.base.BaseVO;

/**
 * @author Edwin
 *
 */
public class PersonaMantenimiento extends BaseNegocio {

	private static final long serialVersionUID = 5456314562553335784L;

	private BaseVO cargo;
	private String nombreCompleto;
	private BaseVO area;
	private String numeroLicencia;
	
	
	/**
	 * @return the cargo
	 */
	public BaseVO getCargo() {
		if (cargo == null){
			cargo = new BaseVO();
		}
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(BaseVO cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	/**
	 * @return the area
	 */
	public BaseVO getArea() {
		if (area == null){
			area = new BaseVO();
		}
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(BaseVO area) {
		this.area = area;
	}
	/**
	 * @return the numeroLicencia
	 */
	public String getNumeroLicencia() {
		return numeroLicencia;
	}
	/**
	 * @param numeroLicencia the numeroLicencia to set
	 */
	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}
	
	
}
