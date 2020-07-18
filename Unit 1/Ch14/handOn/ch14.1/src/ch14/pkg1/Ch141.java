/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14.pkg1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch141 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.gridLinesVisibleProperty();

        
        Image imageCool = new Image("image/cool.jpg");
        Image imageCrying = new Image("image/crying.png");
        Image imageFear = new Image("image/fear.png");
        Image imageNerd = new Image("image/nerd.jpg");
        
        ImageView cool = new ImageView(imageCool);
        ImageView crying = new ImageView(imageCrying);
        ImageView fear = new ImageView(imageFear);
        ImageView nerd = new ImageView(imageNerd);
        //pane.getChildren().add(new ImageView(image));
        pane.add(cool, 0, 0);
        pane.add(crying, 1, 0);
        pane.add(fear, 0, 1);
        pane.add(nerd, 1, 1);
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Display Images");
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
