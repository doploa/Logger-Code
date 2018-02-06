/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Kingsley
 */
public class RecordCollect {
    
                String RecordTitle;
                String RecordSubTitle;
                String RecordAuthor;
                String RecordPublisher;
                String RecordPublishDate;
                String RecordCategory;
                String RecordDescription;
                String RecordLanguage;
                String RecordPrintMedia;
                Double RecordAvgRating;
                Integer RecordNumRatings;
                String RecordTextSnippet;
                String RecordISBNNumber;
                String RecordImagePointer;
                String RecordBorrower;
                String RecordBorrowDate;
                String RecordBorrowerReturnDate;
                String RecordBookTransactions;
                BufferedWriter writer;
                
        RecordCollect()
        {
                this.RecordTitle = null;
                this.RecordSubTitle = null;
                this.RecordAuthor = null;
                this.RecordPublisher = null;
                this.RecordPublishDate = null;
                this.RecordCategory = null;
                this.RecordDescription = null;
                this.RecordLanguage = null;
                this.RecordPrintMedia = null;
                this.RecordAvgRating = 5.0;
                this.RecordNumRatings = 1;
                this.RecordTextSnippet = null;
                this.RecordISBNNumber = null;
                this.RecordImagePointer = null;
                this.RecordBorrower = null;
                this.RecordBorrowDate = null;
                this.RecordBorrowerReturnDate = null;
                this.RecordBookTransactions = null;
        };
        
        RecordCollect(String _RecordAuthor, String _RecordTitle, String _RecordISBN)
        {
                this.RecordAuthor = _RecordAuthor;
                this.RecordTitle = _RecordTitle;
                this.RecordISBNNumber = _RecordISBN;
        };
    
                
                
                private StringProperty RTitle;
                public void setTitle (String value) {  
                     this.RecordTitle = value;
                };
                public String getTitle () {  
                    return this.RecordTitle;
                };
                public StringProperty setTitleProperty() {
                    if (RTitle == null) RTitle = new SimpleStringProperty(this, "firstName");
                    return RTitle; 
                };
                
                private StringProperty RAuthor;
                public void setAuthor (String value) {  
                    this.RecordAuthor = value;
                };
                 public String getAuthor () {  
                    return this.RecordAuthor;
                };
                public StringProperty setAuthorProperty() {
                    if (RAuthor == null) RAuthor = new SimpleStringProperty(this, "author");
                    return RAuthor; 
                };
                
                private StringProperty RISBN;
                public void setISBN (String value) {  
                    this.RecordISBNNumber = value;
                };
                 public String getISBN () {  
                    return this.RecordISBNNumber;
                };
                public StringProperty setISBNProperty() {
                    if (RISBN == null) RISBN = new SimpleStringProperty(this, "firstName");
                    return RISBN; 
                };
                 
                public String getYear () {  
                    return "0";
                };
                
               // public String getISBN () {  
               //     return this.RecordISBNNumber;
               // };
                
                @Override
                public String toString()
                {
                  return (this.getTitle() + "," + this.getAuthor() + "," + this.getISBN());  
                    
                };
    
}
