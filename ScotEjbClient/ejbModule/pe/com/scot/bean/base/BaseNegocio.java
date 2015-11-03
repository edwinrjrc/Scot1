/**
 * 
 */
package pe.com.scot.bean.base;

/**
 * @author Edwin
 *
 */
public class BaseNegocio extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8432706439740928438L;
	
	private BaseVO estado;

	/**
	 * @return the estado
	 */
	public BaseVO getEstado() {
		if (estado == null){
			estado = new BaseVO();
		}
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(BaseVO estado) {
		this.estado = estado;
	}
	
	

}
