package edu.escuelaing.arem;

import edu.escuelaing.arem.httpconnection.HttpConnectionExample;

import static spark.Spark.*;

public class MDV{

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/webapp");

        get("/intraday",(req,res)  -> {
            res.type("application/json");
            return HttpConnectionExample.getAPI();
        });

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            System.out.println(System.getenv("PORT"));
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}