/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.com.sistema.mantenimiento.negocio.dao.MaestroCatalogoDao;
import pe.com.sistema.util.UtilConexion;

/**
 * @author Edwin
 *
 */
public class MaestroCatalogoDaoImpl implements MaestroCatalogoDao {

	/* (non-Javadoc)
	 * @see pe.com.sistema.mantenimiento.negocio.dao.MaestroCatalogoDao#listarCatalogo(java.lang.Integer)
	 */
	@Override
	public List<Catalogo> listarCatalogo(Integer idMaestro) throws SQLException {
		List<Catalogo> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";
		
		try{
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.maestrocatalogo where idmaestro = ?";
			cs = conn.prepareCall(sql);
			cs.setInt(1, idMaestro);
			rs = cs.executeQuery();
			resultado = new ArrayList<Catalogo>();
			Catalogo catalogo = null;
			while(rs.next()){
				catalogo = new Catalogo();
				catalogo.setCodigoEntero(rs.getInt("id"));
				catalogo.setIdMaestro(rs.getInt("idmaestro"));
				catalogo.setNombre(rs.getString("nombre"));
				catalogo.setValor(rs.getString("valor"));
				
				resultado.add(catalogo);
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			if (rs != null){
				rs.close();
			}
			if (cs != null){
				cs.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		
		return resultado;
	}

}
