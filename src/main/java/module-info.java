module com.rcarbonel.hypotenusecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rcarbonel.hypotenusecalculator to javafx.fxml;
    exports com.rcarbonel.hypotenusecalculator;
}