package edu.escuelaing.arem.CacheImplementation;

import java.util.HashMap;

public class Cache {
	private HashMap<String,String> cache = new HashMap<String,String>();
	
	/**
	 * Consulta en el HashMap cache el cache almacenado usando como llave el acronimo de la empresa y la fecha
	 * @param empresa
	 * @param fecha
	 * @return cache
	 * @throws CacheException Si el cache no existe
	 */
	public String getCache(String empresa, String fecha) throws CacheException {
		if (!hayCache(empresa,fecha)) {throw new CacheException(CacheException.NO_EXISTE_CACHE);}
		return cache.get(empresa+fecha);
	}
	
	/**
	 * Almacena en el HashMap cache el cache que llega por parametro usando como llave el acronimo de la empresa y la fecha
	 * @param empresa
	 * @param fecha
	 * @param jsonText
	 * @throws CacheException
	 */
	public void almacenarCache(String empresa, String fecha, String jsonText) throws CacheException {
		if (hayCache(empresa,fecha)) {throw new CacheException(CacheException.EXISTE_CACHE);}
		String key = empresa+fecha;
		cache.put(key, jsonText);
		
	}
	
	/**
	 * Consulta en el HashMap cache si existe el cache almacenado usando como llave el acronimo de la empresa y la fecha
	 * @param empresa
	 * @param fecha
	 * @return existe 
	 */
	public boolean hayCache(String empresa, String fecha) {
		boolean existe = false;
		if(cache.containsKey(empresa+fecha)) {
			existe = true;
		}
		return existe;
	}
}
