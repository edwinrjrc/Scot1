/**
 * 
 */
package pe.com.scot.bean.negocio;

import pe.com.scot.bean.base.BaseVO;

/**
 * @author Edwin
 *
 */
public class Catalogo extends BaseVO {

	private static final long serialVersionUID = 1275909449338167396L;
	
	private Integer idMaestro;
	private String valor;
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * @return the idMaestro
	 */
	public Integer getIdMaestro() {
		return idMaestro;
	}
	/**
	 * @param idMaestro the idMaestro to set
	 */
	public void setIdMaestro(Integer idMaestro) {
		this.idMaestro = idMaestro;
	}
	
	
}
