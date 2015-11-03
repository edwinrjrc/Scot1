/**
 * 
 */
package pe.com.scot.exception;

/**
 * @author Edwin
 *
 */
public class RegistroException extends ScotException {

	private static final long serialVersionUID = -1552313331073015431L;

	public RegistroException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RegistroException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigo
	 * @param message
	 */
	public RegistroException(String codigo, String message) {
		super(codigo, message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RegistroException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RegistroException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RegistroException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
