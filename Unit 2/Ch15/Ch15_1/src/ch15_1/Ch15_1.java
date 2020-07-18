/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch15_1;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch15_1 extends Application {
    // get a ramdom list with the numbers
    private void getRandomCards(HBox pane) {
        // to clear out the old cards
        pane.getChildren().clear();
        
        ArrayList<Integer> randomCards = new ArrayList<>();
        for (int i = 0; i < 53; i++) 
        {
            randomCards.add(i);
        }
        // To shuffle the array list
        java.util.Collections.shuffle(randomCards);
        
        for (int i = 0; i < 4; i++) {
            pane.getChildren().add(new ImageView(new Image("image/card/" 
                    + randomCards.get(i) + ".png")));
        }
    }
   
    
    @Override
    public void start(Stage primaryStage) {
        //ArrayList<Integer> randomCards = getRandomCards();
        VBox vBox = new VBox();
	vBox.setAlignment(Pos.CENTER);
	vBox.setPadding(new Insets(5, 5, 5, 5));

	HBox hBox = new HBox(5);
	hBox.setAlignment(Pos.CENTER);
	hBox.setPadding(new Insets(5, 5, 5, 5));
	getRandomCards(hBox);
        // make the button
        Button btRefresh = new Button("Refresh");
        
        btRefresh.setOnAction(e -> getRandomCards(hBox));
        vBox.getChildren().addAll(hBox, btRefresh);
        //System.out.println(Collections.shuffle(Arrays.asList(a)));
        
        
        /*  //debug code for the array
        for(int i = 1; i < 53; i++)
        {
            System.out.println(cards.get(i));
        }
        */
        
        Scene scene = new Scene(vBox);
        
        primaryStage.setTitle("Display Three Cards");
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
