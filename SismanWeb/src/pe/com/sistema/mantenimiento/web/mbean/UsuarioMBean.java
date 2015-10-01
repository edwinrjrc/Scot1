/**
 * 
 */
package pe.com.sistema.mantenimiento.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import pe.com.sistema.mantenimiento.negocio.Usuario;

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
		HttpSession session = obtenerSession(true);
		session.setAttribute(this.USUARIO_SESSION, getUsuario());
		
		return "irInicio";
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
