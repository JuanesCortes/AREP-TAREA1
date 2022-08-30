package edu.escuelaing.arem.ConsultAPI;

import java.io.IOException;

import edu.escuelaing.arem.APIURL.UrlAlphavantage;
import edu.escuelaing.arem.CacheImplementation.Cache;
import edu.escuelaing.arem.CacheImplementation.CacheException;
import edu.escuelaing.arem.httpconnection.HttpConnection;

public class Consulta {
	
	public static String getConsulta(Cache cache, String empresa, String fecha) {
		String URL = UrlAlphavantage.generar(empresa, fecha);
		String consult = "";
		try {
			if (cache.hayCache(empresa, fecha)) {
				consult = cache.getCache(empresa, fecha);
			}else {
				consult = HttpConnection.getAPI(URL);
				cache.almacenarCache(empresa, fecha, consult);
			}
		} catch (CacheException | IOException e) {
			e.printStackTrace();
		}
		return consult;
		
	}
}
