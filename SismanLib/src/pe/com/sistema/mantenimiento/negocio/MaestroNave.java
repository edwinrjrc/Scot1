/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio;

import pe.com.sistema.mantenimiento.base.BaseNegocio;
import pe.com.sistema.mantenimiento.base.BaseVO;

/**
 * @author Edwin
 *
 */
public class MaestroNave extends BaseNegocio {
	
	private static final long serialVersionUID = -4864300010865065376L;

	private String matricula;
	private BaseVO fabricante;
	private String numeroSerie;
	private String version;
	private String modelo;
	private String variante;
	private String configuracion;
	
	
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return the fabricante
	 */
	public BaseVO getFabricante() {
		if (fabricante == null){
			fabricante = new BaseVO();
		}
		return fabricante;
	}
	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(BaseVO fabricante) {
		this.fabricante = fabricante;
	}
	/**
	 * @return the numeroSerie
	 */
	public String getNumeroSerie() {
		return numeroSerie;
	}
	/**
	 * @param numeroSerie the numeroSerie to set
	 */
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the variante
	 */
	public String getVariante() {
		return variante;
	}
	/**
	 * @param variante the variante to set
	 */
	public void setVariante(String variante) {
		this.variante = variante;
	}
	/**
	 * @return the configuracion
	 */
	public String getConfiguracion() {
		return configuracion;
	}
	/**
	 * @param configuracion the configuracion to set
	 */
	public void setConfiguracion(String configuracion) {
		this.configuracion = configuracion;
	}
	
	
}
