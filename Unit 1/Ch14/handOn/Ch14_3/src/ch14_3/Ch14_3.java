/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch14_3;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch14_3 extends Application {
    
    private ArrayList<Integer> getRandomCards() {
        ArrayList<Integer> randomCards = new ArrayList<>();
        for (int i = 0; i < 53; i++) 
        {
            randomCards.add(i);
        }
        java.util.Collections.shuffle(randomCards);
        return randomCards;
    }
   
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Integer> randomCards = getRandomCards();
        
        HBox pane = new HBox(2);
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        
        for (int i = 0; i < 3; i++) {
            pane.getChildren().add(new ImageView(new Image("image/card/" 
                    + randomCards.get(i) + ".png")));
        }

        //System.out.println(Collections.shuffle(Arrays.asList(a)));
        
        
        /*  //debug code for the array
        for(int i = 1; i < 53; i++)
        {
            System.out.println(cards.get(i));
        }
        */
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Pick four card");
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
