/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttondemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class ButtonDemo extends Application {
    protected Text text = new Text(50, 50, "The other day I saw a bear");
    
    protected BorderPane getPane(){
        
        HBox paneForButton = new HBox(20);
        Button btLeft = new Button("Left", new ImageView("image/left-arrow.png"));
        Button btRight = new Button("Right", new ImageView("image/right-arrow.png"));
        paneForButton.getChildren().addAll(btLeft, btRight);
        paneForButton.setAlignment(Pos.CENTER);
        
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButton);
        
        
        VBox paneForCheckBoxes = new VBox(20);
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        paneForCheckBoxes.setStyle("-fx-border-color: blue");
        paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
        pane.setRight(paneForCheckBoxes);
        
        
        
        
        
        
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
        
        //btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        //btRight.setOnAction(e -> text.setX(text.getX() + 10));
        
        btLeft.setOnAction(e -> text.setY(text.getY() - 10));
        btRight.setOnAction(e -> text.setY(text.getY() + 10));
        
                
        
        return pane;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        
        
        
        Scene scene = new Scene(getPane(), 450, 200);
        
        primaryStage.setTitle("Button Demo");
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
