package edu.escuelaing.arem.ConsultAPI;

import java.io.IOException;

import edu.escuelaing.arem.APIURL.URLGen;
import edu.escuelaing.arem.CacheImplementation.Cache;
import edu.escuelaing.arem.CacheImplementation.CacheException;
import edu.escuelaing.arem.httpconnection.HttpConnection;

public class Consulta {
	
	public static String getConsulta(Cache cache, URLGen urg,String empresa, String fecha) {
		String URL = urg.generar(empresa, fecha);
		String key = urg.getKey(empresa, fecha);
		String consult = "";
		try {
			if (cache.hayCache(key)) {
				consult = cache.getCache(key);
			}else {
				consult = HttpConnection.getAPI(URL);
				cache.almacenarCache(key, consult);
			}
		} catch (CacheException | IOException e) {
			consult = "Error en la consulta";
			return consult;
		}
		return consult;
		
	}
}
