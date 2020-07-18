/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch15_3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 *
 * @author apary
 */
public class Ch15_3 extends Application {
    private final BallPane ballPane = new BallPane();
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button left = new Button("Left");
        Button right = new Button("Right");
        Button up = new Button("Up");
        Button down = new Button("Down");
        hBox.getChildren().addAll(left, right, up, down);
        
        left.setOnAction(e -> ballPane.left());
        right.setOnAction(e -> ballPane.right());
        up.setOnAction(e -> ballPane.up());
        down.setOnAction(e -> ballPane.down());
                
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(2, 5, 10, 15));
        pane.setCenter(ballPane);
        pane.setBottom(hBox);
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Move the ball");
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
