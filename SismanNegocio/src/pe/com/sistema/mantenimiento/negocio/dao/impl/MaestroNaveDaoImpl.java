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

import pe.com.sistema.mantenimiento.negocio.MaestroNave;
import pe.com.sistema.mantenimiento.negocio.dao.MaestroNaveDao;
import pe.com.sistema.util.UtilConexion;

/**
 * @author Edwin
 *
 */
public class MaestroNaveDaoImpl implements MaestroNaveDao {

	/* (non-Javadoc)
	 * @see pe.com.sistema.mantenimiento.negocio.dao.MaestroNaveDao#listarNaves()
	 */
	@Override
	public List<MaestroNave> listarNaves() throws SQLException {
		List<MaestroNave> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";
		
		try{
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.maestronave";
			cs = conn.prepareCall(sql);
			rs = cs.executeQuery();
			resultado = new ArrayList<MaestroNave>();
			MaestroNave maestroNave = null;
			while(rs.next()){
				maestroNave = new MaestroNave();
				maestroNave.setCodigoEntero(rs.getInt("id"));
				maestroNave.setMatricula(rs.getString("matricula"));
				maestroNave.getFabricante().setCodigoEntero(rs.getInt("idfabricante"));
				maestroNave.setNumeroSerie(rs.getString("numeroserie"));
				maestroNave.setVersion(rs.getString("version"));
				maestroNave.setModelo(rs.getString("modelo"));
				maestroNave.setVariante(rs.getString("variante"));
				maestroNave.setConfiguracion(rs.getString("configuracion"));	
				
				resultado.add(maestroNave);
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
