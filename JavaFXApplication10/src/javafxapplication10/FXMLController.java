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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;



//  http://www.drdobbs.com/jvm/coding-the-javafx-tableview/240001874?pgno=2

/**
 * FXML Controller class
 *
 * @author Kingsley
 */
public class FXMLController implements Initializable {
    
    private static DatabaseConnector dc = new DatabaseConnector();
    private static RecordCollect rc = new RecordCollect();
    private static ObservableList data;
    
    private ObservableList<RecordCollect> personData = FXCollections.observableArrayList();
    
    @FXML
    private TableView tableHandle;

    @FXML
    private TextField StudentNameHandle;
    @FXML
    private TextField StudentNumberHandle;
    @FXML
    private Button AddBookBtn;
    @FXML
    private Button CompleteBorrowingBtn;
     @FXML
    private ImageView ImageViewBookField = new ImageView();
    

    @FXML
    private void handleButtonActionTwo(ActionEvent event) {
        StudentNameHandle.setText("Student Name");
        StudentNumberHandle.setText("Student ");
        System.out.println("Handle Button Two");
        
        TableColumn firstNameCol = new TableColumn("Yup");
        TableColumn lastNameCol = new TableColumn("Yes");
        TableColumn emailCol = new TableColumn("Definitely");
        
        // this should be set to false in the production version
        tableHandle.setEditable(true);
        List list = new ArrayList();
        rc.setTitle("one");
        rc.setAuthor("two");
        rc.setISBN("three");
        personData.add(new RecordCollect(rc.getTitle(), rc.getAuthor(), rc.getISBN()));
        //personData.add(new RecordCollect("four","five","six"));
        
        ObservableList data = FXCollections.observableList(list);
        
        ObservableList<String> dataX = FXCollections.observableArrayList(
                    "1","2","3");
        
        
        tableHandle.getColumns().setAll(firstNameCol, lastNameCol, emailCol);
        tableHandle.setItems(this.personData);  
        tableHandle.setVisible(true);
        tableHandle.refresh();
        
   
        
       // ImageViewBookField.setImage(new Image(rc.RecordImagePointer));
    }
    
    /**
     * Initializes the controller class.
     */
    public ObservableList<RecordCollect> getPersonData() {
        return personData;
    }

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
