module com.example.pellasnastrominasi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pellasnastrominasi to javafx.fxml;
    exports com.example.pellasnastrominasi;
}