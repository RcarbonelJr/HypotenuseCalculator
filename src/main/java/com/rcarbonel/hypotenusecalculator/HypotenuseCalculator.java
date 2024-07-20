/* Author: Randall Carbonel
 * Date: 7/19/24
 * Class: ASD216 - Java Programming
 * Assignment: Create a GUI for an application that lets the user calculate the hypotenuse of a right triangle.
 * Specifications:
 *      - Use the Pythagorean Theorem to calculate the length of the third side. The Pythagorean Theorem
 *        states that the square of the hypotenuse of a right-triangle is equal to the sum of the squares of the
 *        opposite sides: c2 = a2 + b2
 *      - Validate the user input so that the user must enter a double value for side A and B of the triangle.
 */

package com.rcarbonel.hypotenusecalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HypotenuseCalculator extends Application {

    private TextField aField;
    private TextField bField;
    private TextField cField;

    @Override
    public void start(Stage stage) {

        // Set title
        stage.setTitle("Right Triangle Calculator");

        // Create grid scene and add grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);

        // Set scene and display stage
        Scene scene = new Scene(grid);

        // Make grid objects
        grid.add(new Label("Side A:"), 0, 0);
        aField = new TextField();
        grid.add(aField, 1, 0);

        grid.add(new Label("Side B:"), 0, 1);
        bField = new TextField();
        grid.add(bField, 1, 1);

        grid.add(new Label("Side C:"), 0, 2);
        cField = new TextField();
        cField.setEditable(false);
        grid.add(cField, 1, 2);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(
                event -> calculateButtonClicked());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(
                event -> exitButtonClicked());

        // Make button box and add buttons then add button box to grid
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 4, 2, 1);

        stage.setScene(scene);
        stage.show();

    }

    private void calculateButtonClicked() {

        Validation v = new Validation();
        String errorMsg = "";
        errorMsg += v.isDouble(aField.getText(), "Side A");
        errorMsg += v.isDouble(bField.getText(), "Side B");

        if (errorMsg.isEmpty()) {

            double sideA = Double.parseDouble(aField.getText());
            double sideB = Double.parseDouble(bField.getText());

            // Calculate side C
            double sideC = Math.sqrt((Math.pow(sideA, 2)) + (Math.pow(sideB, 2)));

            // Set side C
            cField.setText(String.valueOf(sideC));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Data");
            alert.setContentText(errorMsg);
            alert.showAndWait();
        }
    }

    public void exitButtonClicked() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}