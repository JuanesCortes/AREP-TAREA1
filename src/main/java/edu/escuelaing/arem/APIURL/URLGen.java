package edu.escuelaing.arem.APIURL;

public interface URLGen {
	
	/**
	 * Genera el URL para esuo del API segun los parametros que llegan en el encabezado del metodo
	 * @param empresa
	 * @param fecha
	 * @return URL
	 */
	public String generar(String empresa , String fecha);
	/**
	 * Genera el identificador con el que se guardara la consulta
	 */
	public String getKey(String empresa , String fecha);
}
