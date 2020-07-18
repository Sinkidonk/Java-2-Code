/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch15_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch15_4 extends Application {
    
    private final Label Num1Label = new Label("Number1: ");
    private final Label Num2Label = new Label("Number2: ");
    private final Label resultLabel = new Label("Result");
    private final TextField num1Tf = new TextField();
    private final TextField num2Tf = new TextField();
    private final TextField resultTf = new TextField();
    private final Button add = new Button("Add");
    private final Button subtract = new Button("Subtract");
    private final Button multiply = new Button("Mulitply");
    private final Button divide = new Button("Divide");
    
    @Override
    public void start(Stage primaryStage) {
        
        HBox hBox1 = new HBox(2);
        HBox hBox2 = new HBox(2);
        VBox vBox = new VBox(10);
        
        hBox1.getChildren().add(Num1Label);
        hBox1.getChildren().add(num1Tf);
        hBox1.getChildren().add(Num2Label);
        hBox1.getChildren().add(num2Tf);
        hBox1.getChildren().add(resultLabel);
        hBox1.getChildren().add(resultTf);
        
        hBox2.getChildren().add(add);
        hBox2.getChildren().add(subtract);
        hBox2.getChildren().add(multiply);
        hBox2.getChildren().add(divide);
        
        vBox.getChildren().addAll(hBox1, hBox2);
        
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        resultTf.setEditable(false);
        vBox.setPadding(new Insets(5,5,0,0));
        
        add.setOnAction(e -> add());
        subtract.setOnAction(e -> subtract());
        multiply.setOnAction(e -> multiply());
        divide.setOnAction(e -> divide());
        
        
        Scene scene;
        scene = new Scene(vBox, 700, 250);
        
        primaryStage.setTitle("Create a simple calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    	// Add number1 to number2 
	private void add() {
		resultTf.setText(String.valueOf(Double.parseDouble
                    (num1Tf.getText()) + Double.parseDouble(num2Tf.getText())));
	}

	// Subtract number1 from number2 
	private void subtract() {
		resultTf.setText(String.valueOf(Double.parseDouble
                    (num1Tf.getText()) - Double.parseDouble(num2Tf.getText())));
	}

	// Mulitply number1 and number2
	private void multiply() {
		resultTf.setText(String.valueOf(Double.parseDouble
                    (num1Tf.getText()) * Double.parseDouble(num2Tf.getText())));
	}

	// Divide number 1 from number2
	private void divide() {
		resultTf.setText(String.valueOf(Double.parseDouble
                    (num1Tf.getText()) / Double.parseDouble(num2Tf.getText())));
	}
}
    

