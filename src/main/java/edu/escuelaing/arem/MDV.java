package edu.escuelaing.arem;


import edu.escuelaing.arem.CacheImplementation.Cache;
import edu.escuelaing.arem.ConsultAPI.Consulta;


import static spark.Spark.*;

public class MDV{
	private static Cache cache = new Cache();
	/**
	 * Metodo Main
	 * @param args
	 */
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/webapp");

        get("/app",(req,res)  -> {
        	res.type("application/json");
        	
            return Consulta.getConsulta(cache, req.queryParams("name"), req.queryParams("date"));
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