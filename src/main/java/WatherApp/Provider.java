package WatherApp;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

public class Provider {
    public static void main(String[] args) throws IOException {
        Repository repository = new Repository();

        System.out.println("Ktemp "+ repository.getKTemp());
        System.out.println("obj " + repository.getObj());
        System.out.println("URl "+ repository.getUrl());
        System.out.println("country " +repository.getCountry());
        System.out.println("Ctemp " +repository.getCTemp());
        System.out.println("cisnienie "+ repository.getPressure());
    }
}
