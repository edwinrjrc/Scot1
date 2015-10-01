/**
 * 
 */
package pe.com.sistema.exception;

/**
 * @author EDWREB
 *
 */
public abstract class ScotException extends Exception {

	private String codigo;
	private String mensaje;
	/**
	 * 
	 */
	private static final long serialVersionUID = -225101475993504710L;

	/**
	 * 
	 */
	public ScotException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ScotException(String message) {
		super(message);
		this.setMensaje(message);
	}
	
	/**
	 * 
	 * @param codigo
	 * @param message
	 */
	public ScotException(String codigo, String message) {
		super(message);
		this.setCodigo(codigo);
		this.setMensaje(message);
	}

	/**
	 * @param cause
	 */
	public ScotException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ScotException(String message, Throwable cause) {
		super(message, cause);
		this.setMensaje(message);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ScotException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.setMensaje(message);
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
