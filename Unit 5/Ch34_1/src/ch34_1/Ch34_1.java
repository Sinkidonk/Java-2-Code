/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch34_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author apary
 */
public class Ch34_1 extends Application {
    
    private Statement stmt;
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();
    private Label lblStatus = new Label("");
    private Button btView = new Button("View");
    private Button btInsert = new Button("Insert");
    private Button btUpdate = new Button("Update");
    private Button btClear = new Button("Clear");
    
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(5);
        HBox hBox1 = new HBox(5);
        hBox1.getChildren().addAll(new Label("ID"), tfId);
        HBox hBox2 = new HBox(5);
        hBox2.getChildren().addAll(new Label("Last Name"), tfLastName,
                new Label("First Name"), tfFirstName, new Label("MI"), tfMi);
        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Address"), tfAddress);
        HBox hBox4 = new HBox(5);
        hBox4.getChildren().addAll(new Label("City"), tfCity,
                new Label("State"), tfState);
        HBox hBox5 = new HBox(5);
        hBox5.getChildren().addAll(new Label("Telephone"), tfTelephone, new Label("Email"), tfEmail);
        
        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5);
        
        HBox buttonBox = new HBox(5);
        buttonBox.getChildren().addAll(btView, btInsert, btUpdate, btClear);
        buttonBox.setAlignment(Pos.CENTER);
        
        BorderPane pane = new BorderPane();
        pane.setTop(lblStatus);
        pane.setCenter(vBox);
        pane.setBottom(buttonBox);
        
        
        Scene scene = new Scene(pane, 800, 300);
        
        primaryStage.setTitle("Datebase Ch34_1");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        initializeDB();
        
        btView.setOnAction(e -> view());
        btInsert.setOnAction(e -> insert());
        btUpdate.setOnAction(e -> update());
        btClear.setOnAction(e -> clear());
        
    }
    
    private void initializeDB() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ch34_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Connection conn = DriverManager.getConnection("jdbc:mysql://kronos.gtc.edu/parysa2_javabook","parysa2","QlakK1FeT4");
            Connection conn = DriverManager.getConnection("jdbc:mysql://kronos.gtc.edu/aaaaa_javabook","aaaaa","password");
            System.out.println("Database connected\n");
            lblStatus.setText("Database connected");
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            lblStatus.setText("Connection failed: " + ex);
        }
    }


    private void view() {
        //Build a SQL Select statement
        String query = "SELECT * FROM Staff WHERE id = "
                + "'" + tfId.getText().trim() + "'";
        
        try {
            // Execute query
            ResultSet rs = stmt.executeQuery(query);
            loadToTextField(rs);
        }
        catch(SQLException ex) {
            lblStatus.setText("Select failed: " + ex);
        }
    
    }
    
    private void loadToTextField(ResultSet rs) throws SQLException {
        if (rs.next()) {
            tfLastName.setText(rs.getString(2));
            tfFirstName.setText(rs.getString(3));
            tfMi.setText(rs.getString(4));
            tfAddress.setText(rs.getString(5));
            tfCity.setText(rs.getString(6));
            tfState.setText(rs.getString(7));
            tfTelephone.setText(rs.getString(8));
            tfEmail.setText(rs.getString(9));
            lblStatus.setText("Record Found");
        }
        else
            lblStatus.setText("Record not found");
    }
    
    private void insert() {
        // Build a SQL Insert statement
        
         String insertStmt =
                "INSERT INTO Staff(id, lastName, firstName, mi, address,"
                + " city, state, telephone, email) VALUES('" + tfId.getText().trim()
                + "' , '" + tfLastName.getText().trim()
                + "' , '" + tfFirstName.getText().trim()
                + "' , '" + tfMi.getText().trim()
                + "' , '" + tfAddress.getText().trim()
                + "' , '" + tfCity.getText().trim()
                + "' , '" + tfState.getText().trim()
                + "' , '" + tfTelephone.getText().trim()
                + "' , '" + tfEmail.getText().trim() + "');";
        try {
            stmt.executeUpdate(insertStmt);
            lblStatus.setText("Record inserted");
        }
        catch (SQLException ex) {
            lblStatus.setText("Insertion Failed: " + ex);
        }
        
    }
    
    private void update() {
        // build a SQL Update statement
        String updateStmt = 
                "UPDATE Staff SET "
                + " lastName = '" + tfLastName.getText().trim()
                + "' , firstName = '" + tfFirstName.getText().trim()
                + "' , mi = '" + tfMi.getText().trim()
                + "' , address = '" + tfAddress.getText().trim()
                + "' , city = '" + tfCity.getText().trim()
                + "' , state = '" + tfState.getText().trim()
                + "' , telephone = '" + tfTelephone.getText().trim()
                + "' , email = '" + tfEmail.getText().trim() 
                + "' WHERE id = '" + tfId.getText().trim() + "';";
        
        try {
            stmt.executeUpdate(updateStmt);
            lblStatus.setText("Record updated");
        }
        catch(SQLException ex) {
            lblStatus.setText("Update Failed: " + ex);
        }
    }
    
    private void clear() {
        tfId.setText(null);
        tfLastName.setText(null);
        tfFirstName.setText(null);
        tfMi.setText(null);
        tfAddress.setText(null);
        tfCity.setText(null);
        tfState.setText(null);
        tfTelephone.setText(null);
        tfEmail.setText(null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
