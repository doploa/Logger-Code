/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javafxapplication10.DatabaseConnector.connect_database;

/**
 *
 * @author Kingsley
 */


public class JavaFXApplication10 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnector dc = new DatabaseConnector();
        dc.connect_database("googledb","sqlusergoog","sqluserpw");

        
        RecordCollect rc = new RecordCollect();
        try 
        {
         //   rc = dc.ISBNretrieve(1576839168);
          //  System.out.println("Here is an author name:"+rc.RecordAuthor);
        }   catch (Exception e)
        {
            
        };
        launch(args);
    }
    
}
