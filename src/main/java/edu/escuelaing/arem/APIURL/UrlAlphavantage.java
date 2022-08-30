package edu.escuelaing.arem.APIURL;

public class UrlAlphavantage implements URLGen{
	
	/**
	 * Genera el URL para esuo del API segun los parametros que llegan en el encabezado del metodo
	 * @param empresa
	 * @param fecha
	 * @return URL
	 */
	public String generar(String empresa, String fecha) {
		fecha = formatDate(fecha);
		String URL = "https://www.alphavantage.co/query?function="+fecha+"&symbol="+empresa+"&interval=5min&apikey=QU5NPZG0FQEJA57P";
		return URL;
	}
	
	/**
	 *Transforma el string fecha a uno valido para el uso del API
	 * @param fecha
	 * @return fecha
	 */
	public  String formatDate(String fecha){
        switch(fecha){
        	case "intraday":
        		fecha = "TIME_SERIES_INTRADAY";
            break;
            case "daily":
                fecha = "TIME_SERIES_DAILY";
                break;
            case "week":
                fecha = "TIME_SERIES_WEEKLY";
                break;
            case "month":
                fecha = "TIME_SERIES_MONTHLY";
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
