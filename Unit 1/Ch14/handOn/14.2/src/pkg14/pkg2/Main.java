/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14.pkg2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        Image imageX = new Image("image/x.gif");
        Image imageO = new Image("image/o.gif");
        //ImageView viewImageX = new ImageView(imageX);
        //ImageView viewImageO = new ImageView(imageO);
        //ImageView imageX = new ImageView(new Image("image/x.gif"));
        //ImageView imageO = new ImageView(new Image("image/o.gif"));
        
        
        // to aid in putting the image in a random loction
        for (int i = 0; i < 3; i++) { 
            // to also aid in putting the image in a random loction
            for (int x = 0; x < 3; x++) {
                // To help make everything random
                int random = (int)(Math.random() * 3);
                switch (random) {
                    case 0:
                        //pane.getChildren().add(viewImageX); // not working
                        //pane.add(viewImageX, x, i); // not working
                        pane.add(new ImageView(imageX), x, i);
                        break;
                    case 1:
                        //pane.getChildren().add(viewImageO); // not working
                        //pane.add(viewImageO, x, i); // not working
                        pane.add(new ImageView(imageO), x, i);
                        break;
                    default:
                }
            }
        }
    
        
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Tic Tac Toe");
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
