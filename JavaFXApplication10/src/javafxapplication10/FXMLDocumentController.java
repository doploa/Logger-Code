/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.image.Image;


/**
 *
 * @author Kingsley
 */
public class FXMLDocumentController implements Initializable {
    
    private static DatabaseConnector dc = new DatabaseConnector();
    private static RecordCollect rc = new RecordCollect();
        
    @FXML
    private Label label;
    
    @FXML
    private TextField BookField = new TextField();
    
    @FXML
    private TextField AuthorField = new TextField();
    
    @FXML
    private TextField YearField = new TextField();
    
    @FXML
    private TextField PublisherField = new TextField();
    
    @FXML
    private TextField SnippetField = new TextField();
    
    @FXML
    private TextArea SnippetAgain = new TextArea();
    
    @FXML
    private TextField CategoryField = new TextField();
    
     @FXML
    private ImageView ImageViewField = new ImageView();
     
    @FXML
    private TextField ISBNNumberField = new TextField();
    
    @FXML
    private void handleButtonActionT(ActionEvent event) {
        System.out.println("You clicked me!");
        //System.out.println(rc.RecordPublisher);
        //label.setText("Hello World!");
        String imageSource = rc.RecordImagePointer;
        BookField.setText(rc.RecordTitle);
        AuthorField.setText(rc.RecordAuthor);
        YearField.setText(rc.RecordPublishDate);
        PublisherField.setText(rc.RecordPublisher);
        SnippetField.setText(rc.RecordTextSnippet);
        SnippetField.setAlignment(Pos.CENTER);
        CategoryField.setText(rc.RecordCategory);
        ISBNNumberField.setText(rc.RecordISBNNumber);
        SnippetAgain.setText(rc.RecordTextSnippet);
        //System.out.println("this is meant to be the URL "+rc.RecordImagePointer);
        
        ImageViewField.setImage(new Image(rc.RecordImagePointer));
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        dc.connect_database("googledb","sqlusergoog","sqluserpw");
        
        try 
            {
                 rc = dc.ISBNretrieve(1250153271);
                 System.out.println("Here is an author name:"+rc.RecordAuthor);
            }   
                catch (Exception e)
            {
            
            };
            
        
    }    
    
}
