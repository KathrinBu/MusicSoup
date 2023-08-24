package com.example.musicsoup;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    @FXML
    Button button;
    @FXML
    TextArea textArea;
    @FXML
    TextField textField;
    Modul modul=new Modul();
    String songName;

    @FXML
    public void initialize(){
       songName=textField.getText();
        button.setOnAction(a-> {
            try {
                modul.poluchenieDannyh("http://mp3party.net/search?q=");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            textArea.setText(modul.result);
        });
    }
}