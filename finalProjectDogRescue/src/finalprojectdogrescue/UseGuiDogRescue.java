/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Alex Parys
4/14/2018
*/
package finalprojectdogrescue;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class UseGuiDogRescue extends Application {
    
    Button addDogBtn = new Button("Add Dog Menu");
    Button displayDogBtn = new Button("Display Dogs List");
    Button displayAvgCostsBtn = new Button("Display Avg Costs List");
    Button exitBtn = new Button("Exit");
    Button returnMenuBtn = new Button("Return to Menu");
    
    TextField addDogNametf = new TextField();
    TextField addFoodCostTf = new TextField();
    TextField addVetCostTf = new TextField();
    
    Stage window;
    Scene mainMenuScene, addDogScene, displayDogScene, displayAvgCostScene;
    
    DogRescue aDog = new DogRescue();
    
    int iDogCount = 0;
    String name;
    int foodCost;
    int vetCost;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        // Main menu Gui
        VBox mainMenu = new VBox(10);
        HBox mainMenulbl = new HBox(5);
        mainMenulbl.getChildren().add(new Label("Dog Rescue Menu"));
        
        HBox mainMenuAddDog = new HBox(5);
        mainMenuAddDog.getChildren().add(addDogBtn);
        
        HBox mainMenuDisplayDog = new HBox(5);
        mainMenuDisplayDog.getChildren().add(displayDogBtn);
        
        HBox mainMenuDisplyAvgCosts = new HBox(5);
        mainMenuDisplyAvgCosts.getChildren().add(displayAvgCostsBtn);
        
        HBox mainMenuExit = new HBox(5);
        mainMenuExit.getChildren().add(exitBtn);
        
        mainMenu.getChildren().addAll(mainMenulbl,
                mainMenuAddDog, mainMenuDisplayDog,
                mainMenuDisplyAvgCosts, mainMenuExit);
        
        //Main menu Sceane
        mainMenuScene = new Scene(mainMenu, 200, 200);
        
        window.setScene(mainMenuScene);
        window.setTitle("Dog Rescue Main Menu");
        window.show();
        
        displayAvgCostsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent displayAvgCost) {
                
                BorderPane displayAvgCostPane = new BorderPane();
                
                TextArea displayAvgCostTa = new TextArea();
                displayAvgCostTa.setPrefRowCount(2);
                displayAvgCostTa.setText(printAvgCost());
                displayAvgCostPane.setCenter(displayAvgCostTa);
                
                displayAvgCostPane.setBottom(returnMenuBtn);
                
                
                displayAvgCostScene = new Scene(displayAvgCostPane, 400, 300);
                window.setScene(displayAvgCostScene);
                window.setTitle("Display the cost of the dogs");
                window.show();
            }

            private String printAvgCost() {
                double totVetCost = 0;
                double totFoodCost = 0;
                
                StringBuilder output = new StringBuilder();
                
                output.append("Average Cost\n");
                
                output.append("There are " + iDogCount + " dogs.\n");
                
                for(int i = 0; i < iDogCount; i++) {
                    totVetCost = totVetCost + aDog.getVetCost(i);
                    totFoodCost = totFoodCost + aDog.getFoodCost(i);
                }
                
                output.append("Avg Food Cost: $" + totFoodCost / iDogCount + "\n");
                output.append("Avg Vet Cost: $" + totVetCost / iDogCount + "\n");
                
                return output.toString();
                
            }
        });
        
        
        // Code for the add Dog Button
        addDogBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent addDog) {
                // add dog gui
                VBox addDogMenu = new VBox(10);
                HBox addDogMenulbl = new HBox(5);
                addDogMenulbl.getChildren().add(new Label("Add Dog Info here"));
                
                HBox addDogName = new HBox(5);
                
                addDogName.getChildren().addAll(new Label("Add Dog Name"),
                        addDogNametf);
                
                HBox addFoodCost = new HBox(5);

                addFoodCost.getChildren().addAll(new Label("Add food cost"),
                        addFoodCostTf);
                
                HBox addVetCost = new HBox(5);

                addVetCost.getChildren().addAll(new Label("Add vet cost"),
                        addVetCostTf);
                
                Button addDogBtn = new Button("Add Dog");
                addDogMenu.getChildren().addAll(addDogMenulbl, 
                        addDogName,addFoodCost,addVetCost,addDogBtn,returnMenuBtn);
                
                addDogBtn.setOnAction(e -> addADog());
                
                addDogScene = new Scene(addDogMenu, 400, 300);
                window.setScene(addDogScene);
                window.setTitle("Add Dog");
                window.show();
                
                
                
            }
            private void addADog() {

                
                name = addDogNametf.getText();
                try {
                    foodCost = Integer.parseInt(addFoodCostTf.getText());
                    
                    vetCost = Integer.parseInt(addVetCostTf.getText());
                    
                    System.out.println("Name:" + name + " Food:" + foodCost + " Vet" + vetCost);
                    aDog.setDogName(iDogCount, name);
                    aDog.setFoodCost(iDogCount, vetCost);
                    aDog.setVetCost(iDogCount, vetCost);
                    iDogCount = iDogCount + 1;
                    for (int i = 0;i<iDogCount; i++) {
                        System.out.println("Dog Name: " + i + ". " + aDog.getDogName(i) );
                    }
                } catch(NumberFormatException e) {
                    System.out.println(e);
                }
                
                
                

                

                
            }
        });
        
        displayDogBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent displayDog) {
                BorderPane displayDogPane = new BorderPane();
                
                TextArea displayListTa = new TextArea();
                displayListTa.setPrefRowCount(2);
                displayListTa.setText(printOutDogList());
                displayDogPane.setCenter(displayListTa);
                
                displayDogPane.setBottom(returnMenuBtn);
                
                
                displayDogScene = new Scene(displayDogPane, 400, 300);
                window.setScene(displayDogScene);
                window.setTitle("Display all the dogs");
                window.show();
                
                
            }

            private String printOutDogList() {
                
                StringBuilder output = new StringBuilder();
                
                output.append("There are " + iDogCount + " dogs.\n");
                for (int i = 0; i < iDogCount; i++)
                {
                    output.append("Dog Name: " + i + ". " + aDog.getDogName(i) + "\n" );
                }
                return output.toString();
            }
            });
        
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent closeApp) {
                exitProgram();
                
            }

            private String printOutDogList() {
                
                StringBuilder output = new StringBuilder();
                
                output.append("There are " + iDogCount + " dogs.\n");
                for (int i = 0; i < iDogCount; i++)
                {
                    output.append("Dog Name: " + i + ". " + aDog.getDogName(i) + "\n" );
                }
                return output.toString();
            }
            });
        /*
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });
        */
        
        returnMenuBtn.setOnAction(e -> returnToMainMenu());
        
        
    }
    
    public void returnToMainMenu() {
        window.setScene(mainMenuScene);
        window.setTitle("Dog Rescue Main Menu");
    }
    
    private void exitProgram() {
        Platform.exit();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }



    
}
