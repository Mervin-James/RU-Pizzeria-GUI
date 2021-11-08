module com.project4.rupizzeriagui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.rupizzeriagui to javafx.fxml;
    exports com.project.rupizzeriagui;
}