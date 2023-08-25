module com.example.musicsoup {
    requires javafx.controls;
    requires javafx.fxml;
    requires jsoup;
    requires pdfbox;


    opens com.example.musicsoup to javafx.fxml;
    exports com.example.musicsoup;
}