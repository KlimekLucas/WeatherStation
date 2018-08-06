package WatherApp;

import org.json.JSONObject;
import sample.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Repository {


   private URL url;
   private JSONObject obj;
   private String CityName;
   private Double tempC;
   private Double tempK;
   private String country;
   private String pressure;



    public Repository() throws IOException {
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+CityName+"&APPID=35369546d7d07fd5a1d2e987269cac56");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.url = url;

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();


        JSONObject obj = new JSONObject(str);
        this.obj = obj;

       ;
    }



    public Repository(String cityName) throws IOException {
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&APPID=35369546d7d07fd5a1d2e987269cac56");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.url = url;

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();


        JSONObject obj = new JSONObject(str);
        this.obj = obj;

        CityName = cityName;
    }





    public URL getUrl() {
        return url;
    }

    public JSONObject getObj() {
        return obj;
    }

    public String getCityName() {
        return CityName;
    }

    public Double getCTemp() {
        Double Ktemp = (Double) obj.getJSONObject("main").get("temp");
        Double Ctemp = Ktemp - 273.15;
        this.tempC = Ctemp;
        return Double.valueOf(Math.round(tempC));
    }

    public Double getKTemp() {
        Double Ktemp = (Double) obj.getJSONObject("main").get("temp");
       this.tempK = Ktemp;
       return tempK;

    }

    public String getCountry() {
        String Country = String.valueOf(obj.getJSONObject("sys").get("country"));
         this.country = Country;
         return country;

    }

    public String getPressure() {
        String pressure = String.valueOf (obj.getJSONObject("main").get("pressure"));
        this.pressure = pressure;
        return pressure;
    }
}
