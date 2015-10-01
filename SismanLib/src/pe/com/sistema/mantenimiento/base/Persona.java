package pe.com.sistema.mantenimiento.base;

import java.util.Date;

/**
 * @author Edwin
 * @version 1.0
 * @created 14-dic-2013 01:14:34 p.m.
 */
public abstract class Persona extends BaseNegocio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4643534946632179203L;
	private String apellidoMaterno;
	private BaseVO estadoCivil;
	private BaseVO genero;
	private String nombres;
	private String razonSocial;
	private Date fechaNacimiento;
	
	
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * @return the estadoCivil
	 */
	public BaseVO getEstadoCivil() {
		return estadoCivil;
	}
	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(BaseVO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	/**
	 * @return the genero
	 */
	public BaseVO getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(BaseVO genero) {
		this.genero = genero;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




}