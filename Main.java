


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.lang.Object;

import com.google.gson.Gson;
import com.fasterxml.jackson.core;



class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    String data = GetData("https://swapi.dev/api/");
    Map<String, String> root_Map  = new HashMap<String, String>();

    // Type type = new TypeToken<Map<String, String>>() {
    // }.getType();
  Object  root = new Gson().fromJson(data, Object.class);

    ObjectMapper map = new ObjectMapper();



    // for (Map.Entry<String, String> item : root.entrySet()) {
    //   System.out.println(item.getKey() + ":" + item.getValue());

    // }
    System.out.println(data);
    System.out.println();
    System.out.println(root);

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

      System.out.println(connection.getResponseMessage());
      System.out.println(connection.getResponseCode());

      json = streamToString(inStream); // input stream to string
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return json;
  }

}