package pe.com.scot.bean.negocio;

import java.io.InputStream;

import pe.com.scot.bean.base.BaseNegocio;
import pe.com.scot.bean.base.BaseVO;

public class ArchivoAdjunto extends BaseNegocio{

	private static final long serialVersionUID = 8626594762418227527L;
	private BaseVO tipoDocumentoArchivo;
	private String nombreArchivo;
	private String tipoContenido;
	private String extensionArchivo;
	private int tamanioArchivo;
	private InputStream streamArchivo;
	private byte[] arregloArchivo;
	private Integer idOrdenArchivo;
	
	
	/**
	 * @return the tipoDocumentoArchivo
	 */
	public BaseVO getTipoDocumentoArchivo() {
		if (tipoDocumentoArchivo == null){
			tipoDocumentoArchivo = new BaseVO();
		}
		return tipoDocumentoArchivo;
	}
	/**
	 * @param tipoDocumentoArchivo the tipoDocumentoArchivo to set
	 */
	public void setTipoDocumentoArchivo(BaseVO tipoDocumentoArchivo) {
		this.tipoDocumentoArchivo = tipoDocumentoArchivo;
	}
	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	/**
	 * @return the tipoContenido
	 */
	public String getTipoContenido() {
		return tipoContenido;
	}
	/**
	 * @param tipoContenido the tipoContenido to set
	 */
	public void setTipoContenido(String tipoContenido) {
		this.tipoContenido = tipoContenido;
	}
	/**
	 * @return the extensionArchivo
	 */
	public String getExtensionArchivo() {
		return extensionArchivo;
	}
	/**
	 * @param extensionArchivo the extensionArchivo to set
	 */
	public void setExtensionArchivo(String extensionArchivo) {
		this.extensionArchivo = extensionArchivo;
	}
	/**
	 * @return the tamanioArchivo
	 */
	public int getTamanioArchivo() {
		return tamanioArchivo;
	}
	/**
	 * @param tamanioArchivo the tamanioArchivo to set
	 */
	public void setTamanioArchivo(int tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}
	/**
	 * @return the streamArchivo
	 */
	public InputStream getStreamArchivo() {
		return streamArchivo;
	}
	/**
	 * @param streamArchivo the streamArchivo to set
	 */
	public void setStreamArchivo(InputStream streamArchivo) {
		this.streamArchivo = streamArchivo;
	}
	/**
	 * @return the arregloArchivo
	 */
	public byte[] getArregloArchivo() {
		return arregloArchivo;
	}
	/**
	 * @param arregloArchivo the arregloArchivo to set
	 */
	public void setArregloArchivo(byte[] arregloArchivo) {
		this.arregloArchivo = arregloArchivo;
	}
	/**
	 * @return the idOrdenArchivo
	 */
	public Integer getIdOrdenArchivo() {
		return idOrdenArchivo;
	}
	/**
	 * @param idOrdenArchivo the idOrdenArchivo to set
	 */
	public void setIdOrdenArchivo(Integer idOrdenArchivo) {
		this.idOrdenArchivo = idOrdenArchivo;
	}
	
	
}
