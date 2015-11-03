/**
 * 
 */
package pe.com.scot.exception;

/**
 * @author Edwin
 *
 */
public class ConsultaException extends ScotException {

	private static final long serialVersionUID = -1370980424776534747L;

	public ConsultaException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ConsultaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigo
	 * @param message
	 */
	public ConsultaException(String codigo, String message) {
		super(codigo, message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ConsultaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConsultaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConsultaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
