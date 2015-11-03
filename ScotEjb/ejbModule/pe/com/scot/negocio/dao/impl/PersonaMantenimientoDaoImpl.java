/**
 * 
 */
package pe.com.scot.negocio.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.com.scot.bean.negocio.PersonaMantenimiento;
import pe.com.scot.negocio.dao.PersonaMantenimientoDao;
import pe.com.scot.util.UtilConexion;

/**
 * @author Edwin
 *
 */
public class PersonaMantenimientoDaoImpl implements PersonaMantenimientoDao {

	/* (non-Javadoc)
	 * @see pe.com.sistema.mantenimiento.negocio.dao.PersonaMantenimientoDao#listarPersonaxArea(java.lang.Integer)
	 */
	@Override
	public List<PersonaMantenimiento> listarPersonaxArea(Integer idArea)
			throws SQLException {
		List<PersonaMantenimiento> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";
		
		try{
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.personalmantenimiento where idarea = ?";
			cs = conn.prepareCall(sql);
			cs.setInt(1, idArea);
			rs = cs.executeQuery();
			resultado = new ArrayList<PersonaMantenimiento>();
			PersonaMantenimiento persona = null;
			while(rs.next()){
				persona = new PersonaMantenimiento();
				persona.setCodigoEntero(rs.getInt("id"));
				persona.getCargo().setCodigoEntero(rs.getInt("idcargo"));
				persona.setNombreCompleto(rs.getString("nombrecompleto"));
				persona.getArea().setCodigoEntero(rs.getInt("idarea"));
				persona.setNumeroLicencia(rs.getString("numerolicencia"));
				
				resultado.add(persona);
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
	
	@Override
	public List<PersonaMantenimiento> listarPersonaxCargo(Integer idCargo)
			throws SQLException {
		List<PersonaMantenimiento> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";
		
		try{
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.personalmantenimiento where idcargo = ?";
			cs = conn.prepareCall(sql);
			cs.setInt(1, idCargo);
			rs = cs.executeQuery();
			resultado = new ArrayList<PersonaMantenimiento>();
			PersonaMantenimiento persona = null;
			while(rs.next()){
				persona = new PersonaMantenimiento();
				persona.setCodigoEntero(rs.getInt("id"));
				persona.getCargo().setCodigoEntero(rs.getInt("idcargo"));
				persona.setNombreCompleto(rs.getString("nombrecompleto"));
				persona.getArea().setCodigoEntero(rs.getInt("idarea"));
				persona.setNumeroLicencia(rs.getString("numerolicencia"));
				
				resultado.add(persona);
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
