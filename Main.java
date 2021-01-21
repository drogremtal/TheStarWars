import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;




class Main {
  public class roots{
        String name;
            String link;
            }

  public static void main(String[] args) {

    System.out.println("Hello world!");
    ObjectMapper mapper = new ObjectMapper();

        String data = GetData("https://swapi.dev/api/");
        System.out.println(data);
        System.out.println();
        try
        {
            Map<String,Object> Item = mapper.readValue(data,Map.class);
            for(Map.Entry<String,Object> q:Item.entrySet())
            {
                System.out.println(q.getKey()+"     :"+q.getValue());
            }
        }
        catch(IOException ex){

            System.out.println(ex);
        }

 
    }

  private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }

  public static String GetData(String urlQuery) {
    String json = "";
    try {
      URL url = new URL(urlQuery);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setInstanceFollowRedirects(false);
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Accept", "application/json");
      connection.connect();
      InputStream inStream = connection.getInputStream();
      System.out.println(inStream.toString());
      

      System.out.println(connection.getResponseMessage());
      System.out.println(connection.getResponseCode());

      json = streamToString(inStream); // input stream to string
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return json;
  }



}