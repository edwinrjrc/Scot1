/**
 * 
 */
package pe.com.sistema.mantenimiento.negocio.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang3.StringUtils;

import pe.com.sistema.exception.InicioSesionException;
import pe.com.sistema.mantenimiento.negocio.dao.SeguridadDao;
import pe.com.sistema.util.UtilConexion;
import pe.com.sistema.util.UtilJdbc;

/**
 * @author EDWREB
 *
 */
public class SeguridadDaoImpl implements SeguridadDao {

	/*
	 * (non-Javadoc)
	 * @see pe.com.sistema.mantenimiento.negocio.dao.SeguridadDao#iniciarSession(pe.com.sistema.mantenimiento.negocio.Usuario)
	 */
	@Override
	public boolean iniciarSession(Usuario usuario) throws SQLException {
		Connection conn = null;
		CallableStatement cs = null;
		String sql = "";
		try{
			sql = "{ ? = call seguridad.fn_iniciarsesion(?,?)}";
			conn = UtilConexion.obtenerConexion();
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.BOOLEAN);
			cs.setString(2, usuario.getUsuario());
			cs.setString(3, usuario.getCredencial());
			cs.execute();
			
			return cs.getBoolean(1);
		}
		catch (SQLException e){
			throw new SQLException(e);
		}
		finally{
			if (cs != null){
				cs.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see pe.com.sistema.mantenimiento.negocio.dao.SeguridadDao#iniciarSession2(pe.com.sistema.mantenimiento.negocio.Usuario)
	 */
	@Override
	public Usuario iniciarSession2(Usuario usuario) throws SQLException, InicioSesionException {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";
		try{
			sql = "Select * from seguridad.usuario where usuario = ? and credencial = ?";
			conn = UtilConexion.obtenerConexion();
			cs = conn.prepareCall(sql);
			cs.setString(1, usuario.getUsuario());
			cs.setString(2, usuario.getCredencial());
			rs = cs.executeQuery();
			
			if (rs.next()){
				usuario.setCodigoEntero(UtilJdbc.obtenerNumero(rs, "id"));
				usuario.getRol().setCodigoEntero(UtilJdbc.obtenerNumero(rs, "id_rol"));
				String nombres = UtilJdbc.obtenerCadena(rs, "nombres");
				String paterno = UtilJdbc.obtenerCadena(rs, "apepaterno");
				String materno = UtilJdbc.obtenerCadena(rs, "apematerno");
				usuario.setNombres(StringUtils.normalizeSpace(nombres+" "+paterno+" "+materno));
			}
			else{
				throw new InicioSesionException("Usuario o contraseña no corresponden");
			}
			return usuario;
		}
		catch (SQLException e){
			throw new SQLException(e);
		}
		finally{
			if (cs != null){
				cs.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	}

}
