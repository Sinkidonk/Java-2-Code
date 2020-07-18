/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 *
 * @author apary
 */
public class Ch16_1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox rbpane = new HBox(20); // pane for Radio Button
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        rbpane.getChildren().addAll(
                rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
	rbBlack.setToggleGroup(group);
	rbOrange.setToggleGroup(group);
	rbGreen.setToggleGroup(group);
        
        
        Pane textPane = new Pane(); // pane for Text
        textPane.setStyle("-fx-border-color: Blue");
        Text text = new Text(50,50, "Welcome back to my domain");
        textPane.getChildren().add(text);
        
        HBox btPane = new HBox(20); // pane for Buttons
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");
        btPane.getChildren().addAll(btLeft, btRight);
        
        
        BorderPane pane = new BorderPane();
        
        pane.setBottom(btPane);
        pane.setCenter(textPane);
        pane.setTop(rbpane);
        
        // Button Code
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
	btRight.setOnAction(e -> text.setX(text.getX() + 10));
        
        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });
        
        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });
        
        rbBlack.setOnAction(e -> {
            if (rbBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });

        rbOrange.setOnAction(e -> {
            if (rbOrange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });
        
        Scene scene = new Scene(pane, 400, 100);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
