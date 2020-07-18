/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch15_2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch15_2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
    // Make the rectangle
    Rectangle rectangle = new Rectangle();
    rectangle.setWidth(69);
    rectangle.setHeight(40);
    rectangle.setFill(Color.GREEN);
    rectangle.setStroke(Color.BLUE);
    
    Button btRotate = new Button("Rotate");
    
    btRotate.setOnAction((ActionEvent e) -> {
        rectangle.setRotate(rectangle.getRotate() + 15);
    });
    
    BorderPane pane = new BorderPane();
    pane.setCenter(rectangle);
    pane.setBottom(btRotate);
    BorderPane.setAlignment(rectangle, Pos.CENTER);
    BorderPane.setAlignment(btRotate, Pos.CENTER);
    pane.setPadding(new Insets(5, 5, 5, 5));
            
        StackPane root = new StackPane();
 
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Rotate a rectangle");
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
