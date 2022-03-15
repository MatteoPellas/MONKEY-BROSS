module com.example.pellasnastrominasi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pellasnastrominasi to javafx.fxml;
    exports com.example.pellasnastrominasi;
}