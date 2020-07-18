/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermbutton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class MidTermButton extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Get Image and add to HBox
        HBox imagePane = new HBox(20);
        imagePane.getChildren().add(new ImageView(new Image("ThreeStooges.jpg")));
        imagePane.setPadding(new Insets(5, 5, 5, 5));
        
        HBox hBox = new HBox(10);
    
    Button btAgree = new Button("Agree");
    Button btDisagree = new Button("Disagree");
    hBox.getChildren().addAll(btAgree, btDisagree);
        BorderPane pane = new BorderPane();
        pane.setTop(imagePane);
        pane.setBottom(hBox);
    btAgree.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent hello) {
            System.out.println("Hello Agree!");
        }
    });
    
    btDisagree.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent bye) {
            System.out.println("Bye bye!");
          
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
    
}
