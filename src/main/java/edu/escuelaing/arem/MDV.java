package edu.escuelaing.arem;


import edu.escuelaing.arem.APIURL.URLGen;
import edu.escuelaing.arem.APIURL.UrlAlphavantage;
import edu.escuelaing.arem.APIURL.UrlPoly;
import edu.escuelaing.arem.CacheImplementation.Cache;
import edu.escuelaing.arem.ConsultAPI.Consulta;


import static spark.Spark.*;

public class MDV{
	private static Cache cache = new Cache();
	private static URLGen alphUrl = new UrlAlphavantage();
	private static URLGen polyUrl = new UrlPoly();
	/**
	 * Metodo Main
	 * @param args
	 */
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/webapp");

        get("/app",(req,res)  -> {
        	res.type("application/json");
        	
            return Consulta.getConsulta(cache, alphUrl,req.queryParams("name"), req.queryParams("date"));
        });
        
        get("/appPoly",(req,res)  -> {
        	res.type("application/json");
        	
            return Consulta.getConsulta(cache, polyUrl,req.queryParams("name"), req.queryParams("date"));
        });
    }
    /**
     * Metodo que define un puerto por defecto en caso de que no se haya asignado uno
     * @return
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            System.out.println(System.getenv("PORT"));
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}