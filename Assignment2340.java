/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package youngdahl.caleb.assignment2340;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Caleb
 */
public class Assignment2340 {
    private static HttpURLConnection connection;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        String line;
        StringBuffer squirtleAbilities = new StringBuffer();
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/7");
            connection = (HttpURLConnection) url.openConnection();
            
            //request setup
            connection.setRequestMethod("GET");
            
            int status = connection.getResponseCode();
            System.out.println(status);
            
            //get response
            
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null) {
                squirtleAbilities.append(line);
            }
            reader.close();
            System.out.println(squirtleAbilities.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Assignment2340.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.disconnect();
        }
          
    }
}
