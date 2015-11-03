/**
 * 
 */
package pe.com.scot.bean.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.com.scot.bean.base.BaseNegocio;
import pe.com.scot.bean.base.BaseVO;

/**
 * @author Edwin
 *
 */
public class OrdenTrabajo extends BaseNegocio {

	private static final long serialVersionUID = 3039785877526356436L;
	
	
	private String numeroOrden;
	private String referenciaIngenieria;
	private MaestroNave avion;
	private Date fechaEmision;
	private Date fechaProgramada;
	private String instruccionCumplimiento;
	private String referenciaPeruvian;
	private String numeroItv;
	private Date fechaTermino;
	private PersonaMantenimiento inspector;
	private PersonaMantenimiento mecanico;
	private Date fechaInspector;
	private BaseVO area;
	
	private List<ArchivoAdjunto> archivosAdjuntos;
	
	
	/**
	 * @return the numeroOrden
	 */
	public String getNumeroOrden() {
		return numeroOrden;
	}
	/**
	 * @param numeroOrden the numeroOrden to set
	 */
	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	/**
	 * @return the referenciaIngenieria
	 */
	public String getReferenciaIngenieria() {
		return referenciaIngenieria;
	}
	/**
	 * @param referenciaIngenieria the referenciaIngenieria to set
	 */
	public void setReferenciaIngenieria(String referenciaIngenieria) {
		this.referenciaIngenieria = referenciaIngenieria;
	}
	/**
	 * @return the fechaEmision
	 */
	public Date getFechaEmision() {
		return fechaEmision;
	}
	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	/**
	 * @return the fechaProgramada
	 */
	public Date getFechaProgramada() {
		return fechaProgramada;
	}
	/**
	 * @param fechaProgramada the fechaProgramada to set
	 */
	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	/**
	 * @return the instruccionCumplimiento
	 */
	public String getInstruccionCumplimiento() {
		return instruccionCumplimiento;
	}
	/**
	 * @param instruccionCumplimiento the instruccionCumplimiento to set
	 */
	public void setInstruccionCumplimiento(String instruccionCumplimiento) {
		this.instruccionCumplimiento = instruccionCumplimiento;
	}
	/**
	 * @return the referenciaPeruvian
	 */
	public String getReferenciaPeruvian() {
		return referenciaPeruvian;
	}
	/**
	 * @param referenciaPeruvian the referenciaPeruvian to set
	 */
	public void setReferenciaPeruvian(String referenciaPeruvian) {
		this.referenciaPeruvian = referenciaPeruvian;
	}
	/**
	 * @return the numeroItv
	 */
	public String getNumeroItv() {
		return numeroItv;
	}
	/**
	 * @param numeroItv the numeroItv to set
	 */
	public void setNumeroItv(String numeroItv) {
		this.numeroItv = numeroItv;
	}
	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}
	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	/**
	 * @return the fechaInspector
	 */
	public Date getFechaInspector() {
		return fechaInspector;
	}
	/**
	 * @param fechaInspector the fechaInspector to set
	 */
	public void setFechaInspector(Date fechaInspector) {
		this.fechaInspector = fechaInspector;
	}
	/**
	 * @return the avion
	 */
	public MaestroNave getAvion() {
		if (avion == null){
			avion = new MaestroNave();
		}
		return avion;
	}
	/**
	 * @param avion the avion to set
	 */
	public void setAvion(MaestroNave avion) {
		this.avion = avion;
	}
	/**
	 * @return the inspector
	 */
	public PersonaMantenimiento getInspector() {
		if (inspector == null){
			inspector = new PersonaMantenimiento();
		}
		return inspector;
	}
	/**
	 * @param inspector the inspector to set
	 */
	public void setInspector(PersonaMantenimiento inspector) {
		this.inspector = inspector;
	}
	/**
	 * @return the mecanico
	 */
	public PersonaMantenimiento getMecanico() {
		if (mecanico == null){
			mecanico = new PersonaMantenimiento();
		}
		return mecanico;
	}
	/**
	 * @param mecanico the mecanico to set
	 */
	public void setMecanico(PersonaMantenimiento mecanico) {
		this.mecanico = mecanico;
	}
	/**
	 * @return the area
	 */
	public BaseVO getArea() {
		if (area == null){
			area = new BaseVO();
		}
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(BaseVO area) {
		this.area = area;
	}
	/**
	 * @return the archivosAdjuntos
	 */
	public List<ArchivoAdjunto> getArchivosAdjuntos() {
		if (archivosAdjuntos == null){
			archivosAdjuntos = new ArrayList<ArchivoAdjunto>();
		}
		return archivosAdjuntos;
	}
	/**
	 * @param archivosAdjuntos the archivosAdjuntos to set
	 */
	public void setArchivosAdjuntos(List<ArchivoAdjunto> archivosAdjuntos) {
		this.archivosAdjuntos = archivosAdjuntos;
	}
	
}
