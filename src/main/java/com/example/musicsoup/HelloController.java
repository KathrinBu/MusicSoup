package com.example.musicsoup;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class HelloController {
    @FXML
    Button button;
    @FXML
    TextArea textArea;
    @FXML
    TextField textField;
    @FXML
    TableView tableView;
    @FXML
    Button saveToPdf;
    Modul modul=new Modul();

    @FXML
    public void initialize(){
        button.setOnAction(a-> {
            modul.songName=textField.getText();
            try {
                modul.poluchenieDannyh("http://mp3party.net/search?q=");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            textArea.setText(modul.playlist.toString());
            inittable();
        });
      saveToPdf.setOnAction(a-> {
          try {
              Creator.documentCreation(modul.observableList, "1.pdf");
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      });
    }
    private void inittable(){
        tableView.getColumns().clear();
        TableColumn<Header, String> aColumn=new TableColumn<>("titleS");
        aColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableView.getColumns().add(aColumn);
        TableColumn<Header, String> bColumn=new TableColumn<>("adress");
        bColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
        tableView.getColumns().add(bColumn);
        tableView.setItems(modul.observableList);
    }
}