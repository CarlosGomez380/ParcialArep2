package edu.escuelaing.arep.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cliente {

    public static void main(String[] args) {

        try {
            //Lamado al servicio del dyno Calculator
            System.out.println("Dyno Calculator");
            probarServicio("https://damp-springs-33229.herokuapp.com/results?number=90&operacion=cos");
            System.out.println("--------------------");
            //Llamado al servicio del dyno fachada
            System.out.println("Dyno Fachada");
            probarServicio("https://blooming-crag-13305.herokuapp.com/results?number=90&operacion=cos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String probarServicio(String url) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        System.out.println(response.toString());
        in.close();
        return response.toString();
    }

}
