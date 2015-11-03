/**
 * 
 */
package pe.com.scot.web.mbean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import pe.com.scot.bean.negocio.Usuario;
import pe.com.scot.exception.InicioSesionException;
import pe.com.scot.negocio.dao.SeguridadDao;
import pe.com.scot.negocio.dao.impl.SeguridadDaoImpl;

/**
 * @author Edwin
 *
 */
@ManagedBean(name = "usuarioMBean")
@SessionScoped()
public class UsuarioMBean extends BaseMBean{

	private static final long serialVersionUID = -8343984197774523245L;
	
	private Usuario usuario;
	
	public UsuarioMBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String inicioSesion(){
		try {
			
			HttpSession session = obtenerSession(true);
			SeguridadDao seguridadDao = new SeguridadDaoImpl();
			
			session.setAttribute(USUARIO_SESSION, seguridadDao.iniciarSession2(getUsuario()));
			
			return "irInicio";
		} catch (InicioSesionException e) {
			obtenerRequest().setAttribute("msjeError", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	public String salirSesion(){
		obtenerSession(false).invalidate();
		
		return "IrLogin";
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		if (usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
