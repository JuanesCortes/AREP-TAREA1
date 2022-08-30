package edu.escuelaing.arem.CacheImplementation;

public class CacheException extends Exception{
	private static final long serialVersionUID = 1L;
	public static final String EXISTE_CACHE = "Existe cache almacenado de esta empresa, imposible almacenar";
	public static final String NO_EXISTE_CACHE = "Existe cache almacenado de esta empresa, imposible consultar";
	
	public CacheException(String msg) {
		super(msg);
	}

}
