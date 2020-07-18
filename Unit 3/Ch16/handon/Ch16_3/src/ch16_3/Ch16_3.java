/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16_3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch16_3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox circlePane = new VBox(5);
        
        Circle c1 = getCircle();
        Circle c2 = getCircle();
        Circle c3 = getCircle();
        
        circlePane.getChildren().addAll(c1, c2, c3);
        
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.WHITE);
        rectangle.setWidth(50);
        rectangle.setHeight(200);
        rectangle.setStroke(Color.BLACK);
	rectangle.setStrokeWidth(2);
	StackPane stopSign = new StackPane(rectangle, circlePane);
        
        HBox rbPane = new HBox(5); // HBox pane for Radio button
        rbPane.setAlignment(Pos.CENTER);
        
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbPane.getChildren().addAll(rbRed, rbYellow, rbGreen);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(stopSign);
        pane.setBottom(rbPane);
        
        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                c1.setFill(Color.RED);
		c2.setFill(Color.WHITE);
		c3.setFill(Color.WHITE);
            }
        });
        
        rbYellow.setOnAction(e -> {
            if (rbYellow.isSelected()) {
                c1.setFill(Color.WHITE);
		c2.setFill(Color.YELLOW);
		c3.setFill(Color.WHITE);
            }
        });
        
        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                c1.setFill(Color.WHITE);
		c2.setFill(Color.WHITE);
		c3.setFill(Color.GREEN);
            }
        });

        
        Scene scene = new Scene(pane, 300, 250);
        
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
    
    private Circle getCircle() {
        Circle c = new Circle(20);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        return c;
    }
    
}
