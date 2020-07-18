/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 *
 * @author apary
 */
public class Ch16_6 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField text = new TextField();
        TextField column = new TextField();
        
        text.setText("JavaFX");
	text.setAlignment(Pos.BOTTOM_CENTER);
	column.setAlignment(Pos.BOTTOM_RIGHT);
	column.setPrefColumnCount(3);
	text.setPrefColumnCount(12);
        column.setText("12");
        // Create three radio buttions
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        rbCenter.setSelected(true);

        // Create a toggle group
        ToggleGroup group = new ToggleGroup();
	rbLeft.setToggleGroup(group);
	rbCenter.setToggleGroup(group);
	rbRight.setToggleGroup(group);
        
        
        // Create four hbox
        HBox btPane = new HBox(5); // Button Pane
	btPane.getChildren().addAll(rbLeft, rbCenter, rbRight);
	btPane.setAlignment(Pos.BOTTOM_LEFT);

        HBox csPane = new HBox(5); // Colum Size Pane
	csPane.getChildren().addAll(
                new Label("Colum Size"), column);
        
        HBox tfPane = new HBox(5); // TextField Pane
	tfPane.setAlignment(Pos.CENTER);
	tfPane.getChildren().addAll(
                new Label("Text Field"), text);
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(btPane, csPane);

	// Create a vBox and place nodes in it
        VBox pane = new VBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.getChildren().addAll(tfPane, hbox);
                
        // Create and register the handlers 
        rbLeft.setOnAction(e -> {
            if (rbLeft.isSelected()) {
                text.setAlignment(Pos.BOTTOM_LEFT);
            }
        });
        rbCenter.setOnAction(e -> {
            if (rbCenter.isSelected()) {
                text.setAlignment(Pos.BOTTOM_CENTER);
            }
        });
        
        rbRight.setOnAction(e -> {
            if (rbRight.isSelected()) {
                text.setAlignment(Pos.BOTTOM_RIGHT);
            }
        });
        
        text.setOnMouseClicked(e -> {
            text.setPrefColumnCount(Integer.parseInt(
                    column.getText()));
            
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
