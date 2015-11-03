/**
 * 
 */
package pe.com.scot.negocio.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import pe.com.scot.bean.negocio.ArchivoAdjunto;
import pe.com.scot.bean.negocio.OrdenTrabajo;
import pe.com.scot.bean.negocio.OrdenTrabajoBusqueda;
import pe.com.scot.negocio.dao.OrdenTrabajoDao;
import pe.com.scot.util.UtilConexion;
import pe.com.scot.util.UtilJdbc;

/**
 * @author Edwin
 *
 */
public class OrdenTrabajoDaoImpl implements OrdenTrabajoDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.sistema.mantenimiento.negocio.dao.OrdenTrabajoDao#
	 * registrarOrdenTrabajo(pe.com.sistema.mantenimiento.negocio.OrdenTrabajo)
	 */
	@Override
	public Integer registrarOrdenTrabajo(OrdenTrabajo ordenTrabajo)
			throws SQLException {
		Connection conn = null;
		CallableStatement cs = null;
		String sql = "";

		try {
			sql = "{ ? = call principal.fn_registrarordentrabajo(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			conn = UtilConexion.obtenerConexion();
			cs = conn.prepareCall(sql);

			int i = 1;
			cs.registerOutParameter(i++, Types.INTEGER);
			cs.setString(i++, ordenTrabajo.getNumeroOrden());
			cs.setString(i++, ordenTrabajo.getReferenciaIngenieria());
			cs.setInt(i++, ordenTrabajo.getAvion().getCodigoEntero().intValue());
			if (ordenTrabajo.getFechaEmision() != null) {
				cs.setDate(i++, UtilJdbc.convertirUtilDateSQLDate(ordenTrabajo
						.getFechaEmision()));
			} else {
				cs.setNull(i++, Types.DATE);
			}
			if (ordenTrabajo.getFechaProgramada() != null) {
				cs.setDate(i++, UtilJdbc.convertirUtilDateSQLDate(ordenTrabajo
						.getFechaProgramada()));
			} else {
				cs.setNull(i++, Types.DATE);
			}
			if (StringUtils.isNotBlank(ordenTrabajo
					.getInstruccionCumplimiento())) {
				cs.setString(i++, ordenTrabajo.getInstruccionCumplimiento());
			} else {
				cs.setNull(i++, Types.VARCHAR);
			}
			if (ordenTrabajo.getInspector().getCodigoEntero() != null
					&& ordenTrabajo.getInspector().getCodigoEntero().intValue() != 0) {
				cs.setInt(i++, ordenTrabajo.getInspector().getCodigoEntero()
						.intValue());
			} else {
				cs.setNull(i++, Types.INTEGER);
			}
			if (StringUtils.isNotBlank(ordenTrabajo.getReferenciaPeruvian())) {
				cs.setString(i++, ordenTrabajo.getReferenciaPeruvian());
			} else {
				cs.setNull(i++, Types.VARCHAR);
			}
			if (StringUtils.isNotBlank(ordenTrabajo.getNumeroItv())) {
				cs.setString(i++, ordenTrabajo.getNumeroItv());
			} else {
				cs.setNull(i++, Types.VARCHAR);
			}
			if (ordenTrabajo.getFechaTermino() != null) {
				cs.setDate(i++, UtilJdbc.convertirUtilDateSQLDate(ordenTrabajo
						.getFechaTermino()));
			} else {
				cs.setNull(i++, Types.DATE);
			}
			if (ordenTrabajo.getMecanico().getCodigoEntero() != null
					&& ordenTrabajo.getMecanico().getCodigoEntero().intValue() != 0) {
				cs.setInt(i++, ordenTrabajo.getMecanico().getCodigoEntero()
						.intValue());
			} else {
				cs.setNull(i++, Types.INTEGER);
			}
			if (ordenTrabajo.getFechaInspector() != null) {
				cs.setDate(i++, UtilJdbc.convertirUtilDateSQLDate(ordenTrabajo
						.getFechaInspector()));
			} else {
				cs.setNull(i++, Types.DATE);
			}
			cs.setInt(i++, ordenTrabajo.getEstado().getCodigoEntero()
					.intValue());
			if (ordenTrabajo.getArea().getCodigoEntero() != null
					&& ordenTrabajo.getArea().getCodigoEntero().intValue() != 0) {
				cs.setInt(i++, ordenTrabajo.getArea().getCodigoEntero()
						.intValue());
			} else {
				cs.setNull(i++, Types.INTEGER);
			}
			cs.execute();

			return cs.getInt(1);
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.sistema.mantenimiento.negocio.dao.OrdenTrabajoDao#
	 * actualizarOrdenTrabajo(pe.com.sistema.mantenimiento.negocio.OrdenTrabajo)
	 */
	@Override
	public boolean actualizarOrdenTrabajo(OrdenTrabajo ordenTrabajo)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.com.sistema.mantenimiento.negocio.dao.OrdenTrabajoDao#
	 * consultarOrdenTrabajo(java.lang.Integer)
	 */
	@Override
	public OrdenTrabajo consultarOrdenTrabajo(Integer idOrdenTrabajo)
			throws SQLException {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.vw_ordenestrabajo WHERE id = ?";
			cs = conn.prepareCall(sql);
			cs.setInt(1, idOrdenTrabajo.intValue());
			rs = cs.executeQuery();
			OrdenTrabajo ordenTrabajo = null;
			if (rs.next()) {
				ordenTrabajo = new OrdenTrabajo();
				ordenTrabajo.setNumeroOrden(rs.getString("numeroorden"));
				ordenTrabajo.setReferenciaIngenieria(rs
						.getString("referenciaingenieria"));
				ordenTrabajo.getAvion().setCodigoEntero(rs.getInt("idnave"));
				ordenTrabajo.getAvion().setMatricula(rs.getString("matricula"));
				ordenTrabajo.getAvion().setNumeroSerie(
						rs.getString("numeroserie"));
				ordenTrabajo.getAvion().setVersion(rs.getString("version"));
				ordenTrabajo.getAvion().setModelo(rs.getString("modelo"));
				ordenTrabajo.getAvion().setVariante(rs.getString("variante"));
				ordenTrabajo.getAvion().setConfiguracion(
						rs.getString("configuracion"));
				ordenTrabajo.setFechaEmision(rs.getDate("fechaemision"));
				ordenTrabajo.setFechaProgramada(rs.getDate("fechaprogramada"));
				ordenTrabajo.setInstruccionCumplimiento(rs
						.getString("instrcumplimiento"));
				ordenTrabajo.getInspector().setCodigoEntero(rs.getInt("idinspectorreporta"));
				ordenTrabajo.getInspector().setNombre(rs.getString("nombreinspector"));
				ordenTrabajo.setReferenciaPeruvian(rs
						.getString("referenciaperuvian"));
				ordenTrabajo.setNumeroItv(rs.getString("numeroitv"));
				ordenTrabajo.setFechaTermino(rs.getDate("fechatermino"));
				ordenTrabajo.getMecanico().setCodigoEntero(
						rs.getInt("idmecanico"));
				ordenTrabajo.getMecanico().getArea()
						.setNombre(rs.getString("nombrearea"));
				ordenTrabajo.setFechaInspector(rs.getDate("fechainspector"));
				ordenTrabajo.getEstado().setCodigoEntero(rs.getInt("idestado"));
				ordenTrabajo.getEstado()
						.setNombre(rs.getString("nombreestado"));
				ordenTrabajo.getArea().setCodigoEntero(rs.getInt("idarearesponsable"));
				ordenTrabajo.getArea().setNombre(rs.getString("nomarearesponsable"));
			}
			
			return ordenTrabajo;
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.sistema.mantenimiento.negocio.dao.OrdenTrabajoDao#listarOrdenTrabajo
	 * ()
	 */
	@Override
	public List<OrdenTrabajo> listarOrdenTrabajo() throws SQLException {
		List<OrdenTrabajo> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.vw_ordenestrabajo";
			cs = conn.prepareCall(sql);
			rs = cs.executeQuery();
			resultado = new ArrayList<OrdenTrabajo>();
			OrdenTrabajo ordenTrabajo = null;
			while (rs.next()) {
				ordenTrabajo = new OrdenTrabajo();
				ordenTrabajo.setCodigoEntero(rs.getInt("id"));
				ordenTrabajo.setNumeroOrden(rs.getString("numeroorden"));
				ordenTrabajo.setReferenciaIngenieria(rs
						.getString("referenciaingenieria"));
				ordenTrabajo.getAvion().setCodigoEntero(rs.getInt("idnave"));
				ordenTrabajo.getAvion().setMatricula(rs.getString("matricula"));
				ordenTrabajo.getAvion().setNumeroSerie(
						rs.getString("numeroserie"));
				ordenTrabajo.getAvion().setVersion(rs.getString("version"));
				ordenTrabajo.getAvion().setModelo(rs.getString("modelo"));
				ordenTrabajo.getAvion().setVariante(rs.getString("variante"));
				ordenTrabajo.getAvion().setConfiguracion(
						rs.getString("configuracion"));
				ordenTrabajo.setFechaEmision(rs.getDate("fechaemision"));
				ordenTrabajo.setFechaProgramada(rs.getDate("fechaprogramada"));
				ordenTrabajo.setInstruccionCumplimiento(rs
						.getString("instrcumplimiento"));
				ordenTrabajo.setReferenciaPeruvian(rs
						.getString("referenciaperuvian"));
				ordenTrabajo.setNumeroItv(rs.getString("numeroitv"));
				ordenTrabajo.setFechaTermino(rs.getDate("fechatermino"));
				ordenTrabajo.getMecanico().setCodigoEntero(
						rs.getInt("idmecanico"));
				ordenTrabajo.getMecanico().getArea()
						.setNombre(rs.getString("nombrearea"));
				ordenTrabajo.setFechaInspector(rs.getDate("fechainspector"));
				ordenTrabajo.getEstado().setCodigoEntero(rs.getInt("idestado"));
				ordenTrabajo.getEstado()
						.setNombre(rs.getString("nombreestado"));

				resultado.add(ordenTrabajo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return resultado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.sistema.mantenimiento.negocio.dao.OrdenTrabajoDao#buscarOrdenTrabajo
	 * (pe.com.sistema.mantenimiento.negocio.OrdenTrabajo)
	 */
	@Override
	public List<OrdenTrabajo> buscarOrdenTrabajo(
			OrdenTrabajoBusqueda ordenTrabajo2) throws SQLException {
		List<OrdenTrabajo> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.vw_ordenestrabajo "
					+ "WHERE fechaprogramada BETWEEN ? AND ? "
					+ "AND numeroorden = COALESCE(?, numeroorden)";
			cs = conn.prepareCall(sql);
			Date fecha1 = UtilJdbc.convertirUtilDateSQLDate(ordenTrabajo2
					.getFechaDesde());
			cs.setDate(1, fecha1);
			cs.setDate(2, UtilJdbc.convertirUtilDateSQLDate(ordenTrabajo2
					.getFechaHasta()));
			if (StringUtils.isNotBlank(ordenTrabajo2.getNumeroOrden())) {
				cs.setString(3, ordenTrabajo2.getNumeroOrden());
			} else {
				cs.setNull(3, Types.VARCHAR);
			}

			rs = cs.executeQuery();
			resultado = new ArrayList<OrdenTrabajo>();
			OrdenTrabajo ordenTrabajo = null;
			while (rs.next()) {
				ordenTrabajo = new OrdenTrabajo();
				ordenTrabajo.setCodigoEntero(rs.getInt("id"));
				ordenTrabajo.setNumeroOrden(rs.getString("numeroorden"));
				ordenTrabajo.setReferenciaIngenieria(rs
						.getString("referenciaingenieria"));
				ordenTrabajo.getAvion().setCodigoEntero(rs.getInt("idnave"));
				ordenTrabajo.getAvion().setMatricula(rs.getString("matricula"));
				ordenTrabajo.getAvion().setNumeroSerie(
						rs.getString("numeroserie"));
				ordenTrabajo.getAvion().setVersion(rs.getString("version"));
				ordenTrabajo.getAvion().setModelo(rs.getString("modelo"));
				ordenTrabajo.getAvion().setVariante(rs.getString("variante"));
				ordenTrabajo.getAvion().setConfiguracion(
						rs.getString("configuracion"));
				ordenTrabajo.setFechaEmision(rs.getDate("fechaemision"));
				ordenTrabajo.setFechaProgramada(rs.getDate("fechaprogramada"));
				ordenTrabajo.setInstruccionCumplimiento(rs
						.getString("instrcumplimiento"));
				ordenTrabajo.setReferenciaPeruvian(rs
						.getString("referenciaperuvian"));
				ordenTrabajo.setNumeroItv(rs.getString("numeroitv"));
				ordenTrabajo.setFechaTermino(rs.getDate("fechatermino"));
				ordenTrabajo.getMecanico().setCodigoEntero(
						rs.getInt("idmecanico"));
				ordenTrabajo.getMecanico().getArea()
						.setNombre(rs.getString("nombrearea"));
				ordenTrabajo.setFechaInspector(rs.getDate("fechainspector"));
				ordenTrabajo.getEstado().setCodigoEntero(rs.getInt("idestado"));
				ordenTrabajo.getEstado()
						.setNombre(rs.getString("nombreestado"));

				resultado.add(ordenTrabajo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return resultado;
	}

	@Override
	public boolean registrarAdjuntoOrdenTrabajo(ArchivoAdjunto archivoAdjunto)
			throws SQLException {
		Connection conn = null;
		CallableStatement cs = null;
		String sql = "";

		try {
			sql = "{ ? = call principal.fn_registraradjuntoordentrabajo(?,?,?,?,?,?,?)}";
			conn = UtilConexion.obtenerConexion();
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.BOOLEAN);
			cs.setInt(2, archivoAdjunto.getIdOrdenArchivo());
			cs.setInt(3, archivoAdjunto.getTipoDocumentoArchivo()
					.getCodigoEntero().intValue());
			cs.setString(4, archivoAdjunto.getNombreArchivo());
			cs.setString(5, archivoAdjunto.getExtensionArchivo());
			cs.setInt(6, archivoAdjunto.getTamanioArchivo());
			cs.setString(7, archivoAdjunto.getTipoContenido());
			cs.setBinaryStream(
					8,
					new ByteArrayInputStream(archivoAdjunto.getArregloArchivo()),
					archivoAdjunto.getTamanioArchivo());
			cs.execute();

			if (!cs.getBoolean(1)) {
				System.out.println("No se registro el archivo ::"
						+ archivoAdjunto.getNombreArchivo());
			} else {
				System.out.println("Archivo registrado ::"
						+ archivoAdjunto.getNombreArchivo());
			}
			return cs.getBoolean(1);
		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}

	@Override
	public List<ArchivoAdjunto> consultarArchivosOrden(Integer irOrden)
			throws SQLException, IOException {
		List<ArchivoAdjunto> resultado = null;
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = UtilConexion.obtenerConexion();
			sql = "SELECT * FROM principal.vw_documentosadjuntos WHERE idordentrabajo = ?";
			cs = conn.prepareCall(sql);
			cs.setInt(1, irOrden.intValue());
			rs = cs.executeQuery();
			resultado = new ArrayList<ArchivoAdjunto>();
			ArchivoAdjunto archivoAdjunto = null;
			while (rs.next()) {
				archivoAdjunto = new ArchivoAdjunto();
				archivoAdjunto.setCodigoEntero(rs.getInt("idarchivo"));
				archivoAdjunto.setIdOrdenArchivo(rs.getInt("idordentrabajo"));
				archivoAdjunto.getTipoDocumentoArchivo().setCodigoEntero(rs.getInt("idtipodocumento"));
				archivoAdjunto.getTipoDocumentoArchivo().setNombre(rs.getString("nombretipodocumento"));
				archivoAdjunto.setNombreArchivo(rs.getString("nombrearchivo"));
				archivoAdjunto.setExtensionArchivo(rs.getString("extension"));
				archivoAdjunto.setTamanioArchivo(rs.getInt("tamanio"));
				archivoAdjunto.setTipoContenido(rs.getString("tipocontenido"));
				archivoAdjunto.setStreamArchivo(rs.getBinaryStream("streamarchivo"));
				archivoAdjunto.setArregloArchivo(IOUtils.toByteArray(archivoAdjunto.getStreamArchivo()));
				
				resultado.add(archivoAdjunto);
			}

		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return resultado;
	}

}
