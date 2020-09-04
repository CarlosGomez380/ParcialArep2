package edu.escuelaing.arep.lab1;

import org.json.JSONObject;
import spark.Request;
import spark.Response;


import java.io.IOException;


import static edu.escuelaing.arep.lab1.Cliente.probarServicio;
import static spark.Spark.*;

/**
 * Minimal web app example for Heroku using SparkWeb
 *
 * @author daniel
 */
public class ServiceFacade{

    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Media y Desviacion estandar</h2>"
                + "<form action=\"/results\">"
                + "  Numero a ingresar:<br>"
                + "  <input type=\"text\" name=\"number\">"
                + "  <br><br>"
                + "  Operacion a ingresar:<br>"
                + "  <input type=\"text\" name=\"operacion\">"
                + "  <input type=\"submit\" value=\"Calcular\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static JSONObject resultsPage(Request req, Response res) throws IOException {

        String operator= req.queryParams("operacion");
        String radian= req.queryParams("number");

        String url = "https://damp-springs-33229.herokuapp.com/results?number="+radian+
                "&operacion="+operator;

        //Llamado al servicio
        String respuesta=probarServicio(url);

        String ans=respuesta;
        int inicio=ans.lastIndexOf("[");
        int end= ans.lastIndexOf("]");
        System.out.println(ans.substring(inicio+1,end));
        Double number=Double.parseDouble(ans.substring(inicio+1,end));

        JSONObject json= new JSONObject();
        json.append("Operator",operator);
        json.append("Result",number);
        return json;
    }


    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}