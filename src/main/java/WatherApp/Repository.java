package WatherApp;

import org.json.JSONObject;
import sample.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Repository {

   private String NETKEY ;
   private URL url;
   private JSONObject obj;
   private String CityName;
   private Double tempC;
   private Double tempK;
   private String country;
   private Integer pressure;



    public Repository() throws IOException {
        try {
            url = new URL("http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.url = url;

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        // build a JSON object
        JSONObject obj = new JSONObject(str);
        this.obj = obj;

       ;
    }



    public Repository(String cityName,String NETKEY) throws IOException {
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&APPID="+NETKEY);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.url = url;

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        // build a JSON object
        JSONObject obj = new JSONObject(str);
        this.obj = obj;

        CityName = cityName;
    }

    ///////////////////////////////////// gettery//////////////////////



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

    public Integer getPressure() {
        Integer pressure = (Integer) obj.getJSONObject("main").get("pressure");
        this.pressure = pressure;
        return pressure;
    }
}
