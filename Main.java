import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");


    String data = GetData("https://swapi.dev/api/");
    System.out
        .println(data);

  }

    private static String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }

  public static String GetData (String urlQuery)
  {
    String json = "";
   try {
      URL url = new URL(urlQuery);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setInstanceFollowRedirects(false);
      connection.setRequestMethod("GET");     
      connection.connect();
      InputStream inStream = connection.getInputStream();     
      json = streamToString(inStream); // input stream to string
    } catch (IOException ex) {
      ex.printStackTrace();
    }
	return json;
  }
   
}