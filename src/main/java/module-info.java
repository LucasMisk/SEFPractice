module com.example.seftestpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seftestpractice to javafx.fxml;
    exports com.example.seftestpractice;
}