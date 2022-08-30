package edu.escuelaing.arem.APIURL;

public interface URLGen {
	
	/**
	 * Genera el URL para esuo del API segun los parametros que llegan en el encabezado del metodo
	 * @param empresa
	 * @param fecha
	 * @return URL
	 */
	public String generar(String empresa , String fecha);
	
	public String getKey(String empresa , String fecha);
}
