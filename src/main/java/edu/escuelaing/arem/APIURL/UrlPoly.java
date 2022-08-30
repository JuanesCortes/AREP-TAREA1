package edu.escuelaing.arem.APIURL;

public class UrlPoly implements URLGen{

	/**
	 * Genera el URL para esuo del API segun los parametros que llegan en el encabezado del metodo
	 * @param empresa
	 * @param fecha
	 * @return URL
	 */
	public String generar(String empresa, String fecha) {
		fecha = formatDate(fecha);
		String URL = "https://api.polygon.io/v2/aggs/ticker/"+empresa+"/range/1/"+fecha+"/2021-07-22/2021-07-22?adjusted=true&sort=asc&limit=120&apiKey=Vs1p6udHhfpQoQEspEZCNjRful8m8wbo";
		return URL;
	}
	
	/**
	 *Transforma el string fecha a uno valido para el uso del API
	 * @param fecha
	 * @return fecha
	 */
	private String formatDate(String fecha) {
		switch(fecha){
    	case "minute":
    		fecha = "minute";
        break;
        case "hour":
            fecha = "hour";
            break;
        case "daily":
            fecha = "day";
            break;
        case "week":
            fecha = "week";
            break;
        case "month":
            fecha = "month";
            break;
    }
    return fecha;
	}

	/**
	 * Genera el identificador con el que se guardara la consulta
	 */
	public String getKey(String empresa, String fecha) {
		return empresa+formatDate(fecha);
	}

}
