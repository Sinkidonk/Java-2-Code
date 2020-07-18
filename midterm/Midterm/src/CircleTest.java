/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class CircleTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(5);
        Circle circle = new Circle(50, 200, 200);
        
        circle.setFill(Color.BLACK);
        circle.setCenterX(100);
        circle.setRadius(50);
        
        pane.getChildren().add(circle); // Place a ball into this pane
        
        Scene scene = new Scene(pane, 50, 50);
        
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
