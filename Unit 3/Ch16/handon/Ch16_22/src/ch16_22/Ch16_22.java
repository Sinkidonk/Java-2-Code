/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16_22;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 *
 * @author apary
 */
public class Ch16_22 extends Application {
     private static final String MEDIA_URL = 
    "http://cs.armstrong.edu/liang/common/audio/anthem/anthem3.mp3";

    @Override
    public void start(Stage primaryStage) {
        Button play = new Button("Play");
	Button loop = new Button("Loop");
	Button stop = new Button("Stop");
        
        
        HBox pane = new HBox(5);
        pane.getChildren().addAll(play, loop, stop);
        
        //Media media = new Media(MEDIA_URL);
        AudioClip audio = new AudioClip(MEDIA_URL);
        
        play.setOnAction(e -> {
            audio.play();
            
        });

        
        stop.setOnAction(e -> {
            audio.stop();
            
        });
        
        loop.setOnAction(e -> {
            audio.play();
            audio.setCycleCount(AudioClip.INDEFINITE);
            
            
        });
        


    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 150, 50);
    primaryStage.setTitle("Play, loop, and stop a sound clip"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
