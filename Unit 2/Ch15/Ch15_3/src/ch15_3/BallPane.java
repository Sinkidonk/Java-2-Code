/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch15_3;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author apary
 */
class BallPane extends Pane {
    	private final Circle circle = new Circle(30, 30, 30);

	// Construct a default ball pane
	public BallPane() {
            circle.setFill(Color.GREEN);
            circle.setStroke(Color.DEEPPINK);
            circle.setStrokeWidth(10);
            getChildren().add(circle); // Place a ball into this pane
        }
        
        public void up() {
            circle.setCenterY(circle.getCenterY() > circle.getRadius() ? 
                    circle.getCenterY() - 20 : circle.getCenterY());
            circle.setCenterX(circle.getCenterX());
	}

        public void down() {
            circle.setCenterX(circle.getCenterX());
            circle.setCenterY(circle.getCenterY() < getHeight() - circle.getRadius() ? 
                    circle.getCenterY() + 20 : circle.getCenterY());
        }
        
        public void right() {
            circle.setCenterX(circle.getCenterX() < getWidth() - circle.getRadius() ? 
                    circle.getCenterX() + 20 : circle.getCenterX());
            circle.setCenterY(circle.getCenterY());
	}
        
        public void left() { 
            circle.setCenterX(circle.getCenterX() > circle.getRadius() ? 
                    circle.getCenterX() - 20 : circle.getCenterX());
            circle.setCenterY(circle.getCenterY());
	}
        



    
}
