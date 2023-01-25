package Func;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class Api {

    private String APICall(String apiLocation, String method, String[] args){
        String urlx = "http://127.0.0.1:5000/"+apiLocation;

        for (int i = 0; i < args.length; i++){
            urlx+=args[i];
        }

        try{
            URL url = new URL(urlx);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
//            conn.connect();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            boolean ignore = true;
            if (!(ignore)){
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                //print in String
                System.out.println(response.toString());
                //Read JSON response and print
                JSONObject myResponse = new JSONObject(response.toString());
                System.out.println("statusCode- "+myResponse.getString("status"));
                return myResponse.getString("status");

            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return "false";
    }

    /**
     * Make an API request to create an account. It will check if the username doesnt already have an account.
     * If not the api will store the account creation in to the accounts database.
     *
     * @return will return true if the account creation was successful
     */
    public void AccountCreation(String username, String password){
        try{
            String urlx = "http://127.0.0.1:5000/createAccount?username="+username+"&password="+password;
            URL url = new URL(urlx);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
//            conn.connect();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            boolean ignore = true;
            if (!(ignore)){
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                //print in String
                System.out.println(response.toString());
                //Read JSON response and print
                JSONObject myResponse = new JSONObject(response.toString());
//                System.out.println("statusCode- "+myResponse.getString("warning"));

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String AccountLogin(String username, String password){
        return APICall("login","GET",new String[]{"?username="+username,"&password="+password});
    }

}
