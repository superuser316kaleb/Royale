module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;


    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
}