/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14_7;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch14_7 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(3, 3, 3, 3));
        pane.setHgap(3);
        pane.setVgap(3);
        
        for (int i = 0; i < 10; i++) {
            for (int x = 0; x < 10; x++){
                TextField text = new TextField();
                text.setPrefColumnCount(1);
                text.setText(String.valueOf((int) (2 * Math.random())));
                pane.add(text, i, x);
                GridPane.setHalignment(text, HPos.CENTER);
                GridPane.setValignment(text, VPos.CENTER);
            }
        }
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Display Random 0 or 1");
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
