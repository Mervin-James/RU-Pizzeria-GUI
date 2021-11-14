module com.project4.rupizzeriagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;


    opens com.project.rupizzeriagui to javafx.fxml;
    exports com.project.rupizzeriagui;
}