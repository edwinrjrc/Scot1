/**
 * 
 */
package pe.com.scot.web.mbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import pe.com.scot.bean.negocio.Catalogo;
import pe.com.scot.negocio.ejb.MaestroCatalogoSessionRemote;

/**
 * @author Edwin
 *
 */
@ManagedBean(name = "catalogoMBean")
@SessionScoped()
public class CatalogoMBean {

	private List<SelectItem> catalogoTipoDocumentoAdjunto;
	
	@EJB
	MaestroCatalogoSessionRemote maestroCatalogoSessionRemote;

	/**
	 * @return the catalogoTipoDocumentoAdjunto
	 */
	public List<SelectItem> getCatalogoTipoDocumentoAdjunto() {
		try {
			catalogoTipoDocumentoAdjunto = null;
			List<Catalogo> lista = maestroCatalogoSessionRemote.listarCatalogo(4);
			if (lista != null){
				catalogoTipoDocumentoAdjunto = new ArrayList<SelectItem>();
				SelectItem si = null;
				for (Catalogo catalogo : lista) {
					si = new SelectItem();
					si.setLabel(catalogo.getNombre());
					si.setValue(catalogo.getCodigoEntero());
					catalogoTipoDocumentoAdjunto.add(si);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return catalogoTipoDocumentoAdjunto;
	}

	/**
	 * @param catalogoTipoDocumentoAdjunto the catalogoTipoDocumentoAdjunto to set
	 */
	public void setCatalogoTipoDocumentoAdjunto(
			List<SelectItem> catalogoTipoDocumentoAdjunto) {
		this.catalogoTipoDocumentoAdjunto = catalogoTipoDocumentoAdjunto;
	}
}
