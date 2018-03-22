package WatherApp;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import java.io.IOException;

import java.net.URL;
import java.util.Scanner;

public class Weather {
    public static void main(String[] args) throws IOException {
        URL url;
        String cityName;
        Double Ctemp;
        Provider provider = new Provider();

        Scanner cityReader = new Scanner(System.in);
        cityName = cityReader.nextLine();



        {

         url = new URL("http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");



            // read from the URL
            Scanner scan = new Scanner(url.openStream());
            String str = new String();
            while (scan.hasNext())
                str += scan.nextLine();
            scan.close();

            // build a JSON object
            JSONObject obj = new JSONObject(str);
            System.out.println(str);

            //get obects
            Double Ktemp = (Double) obj.getJSONObject("main").get("temp");
         //   Double cisnienie = (Double) obj.getJSONObject("main").get("pressure");
            String windSpeed = String.valueOf(obj.getJSONObject("wind").get("speed"));
            String Country = String.valueOf(obj.getJSONObject("sys").get("country"));


            Ctemp = Ktemp - 273.15;


          // System.out.println("cisnienie " + cisnienie+ " hpa");
            System.out.println("kraj " + Country);
            System.out.println(" pogoda w " + cityName);
            System.out.println("szybkość wiatru " + windSpeed + "mps");
            System.out.println("temperatura w Celcjuszach wynosi " + Ctemp);
            System.out.println("temperatura w Kelwinach wynosi " + Ktemp);





        }
    }
}

