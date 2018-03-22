package sample;

import WatherApp.Repository;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {




    @FXML
    private Label LabelCityValue;

    @FXML
    private Label LabelKelvinTemperatureValue;

    @FXML
    private Label LabelTemperatureValue;

    @FXML
    private Label LabelPressureValue;

    @FXML
    private Label LabelCountryValue;

    @FXML
    private TextField TextFieldCity;

    @FXML
    private Button ButtonRun;

    @FXML
    private Button ButtonClose;


    public void initialize() throws IOException {


ButtonClose.setOnAction(event -> System.exit(0));

ButtonRun.setOnAction(event ->{
    Repository repository = null;
    try {
        repository = new Repository();
    } catch (IOException e) {
        e.printStackTrace();
    }

    LabelKelvinTemperatureValue.setText(String.valueOf(repository.getKTemp()));
        LabelTemperatureValue.setText(String.valueOf(repository.getCTemp()));
        LabelCityValue.setText(String.valueOf(repository.getCityName()));
        LabelKelvinTemperatureValue.setText(String.valueOf(repository.getKTemp()));
        LabelPressureValue.setText(String.valueOf(repository.getPressure()));
        LabelCountryValue.setText(String.valueOf(repository.getCountry()));


} );
    }


}