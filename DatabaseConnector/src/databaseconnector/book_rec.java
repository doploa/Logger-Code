/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnector;

import java.net.URL;
import java.io.IOException;
import java.lang.RuntimeException;
import java.net.MalformedURLException;

/**
 *
 * @author Kingsley
 */
public class book_rec {

       /**
        * Returns a book object that can then be painted on the screen. 
        * The url argument must specify an absolute {@link URL}. The name
        * argument is a specifier that is relative to the url argument. 
        * <p>
        * This method always returns immediately, whether or not the 
        * image exists. When this applet attempts to draw the image on
        * the screen, the data will be loaded. The graphics primitives 
        * that draw the image will incrementally paint on the screen. 
        *
        * @param  RecordImagePointer  an absolute URL giving the base location of the image
        * @param  name the location of the image, relative to the url argument
        * @return      nothing
        * @see         Image
       */
        
        String RecordTitle;
        String RecordSubTitle;
        String RecordAuthor;
        String RecordPublisher;
        String RecordPublishDate;
        String RecordCategory;
        String RecordDescription;
        String RecordLanguage;
        String RecordPrintMedia;
        String RecordAvgRating;
        String RecordNumRatings;
        String RecordTextSnippet;
        String RecordISBNNumber;
        String RecordImagePointer;
        String RecordBorrower;
        String RecordBorrowDate;
        String RecordBorrowerReturnDate;
        String RecordBookTransactions;
        String RecordLocalResourceLocator;
        String RecordLocation;
        String RecordLibrary;
        
        public book_rec() {};
        public book_rec(String[] record_entry) 
            {
                this.RecordTitle = record_entry[0];
                this.RecordSubTitle = record_entry[1];
                this.RecordAuthor = record_entry[2];
                this.RecordPublisher = record_entry[3];
                this.RecordPublishDate = record_entry[4];
                this.RecordCategory = record_entry[5];
                this.RecordDescription = record_entry[6];
                this.RecordLanguage = record_entry[7];
                this.RecordPrintMedia = record_entry[8];
                this.RecordAvgRating = record_entry[9];
                this.RecordNumRatings = record_entry[10];
                this.RecordTextSnippet = record_entry[11];
                this.RecordISBNNumber = record_entry[12];
                this.RecordImagePointer = record_entry[13]; 
                this.RecordBorrower = record_entry[14]; 
                this.RecordBorrowDate = record_entry[15]; 
                this.RecordBorrowerReturnDate = record_entry[16]; 
                this.RecordBookTransactions = record_entry[17]; 
            };
       
        
      
       
   
}

