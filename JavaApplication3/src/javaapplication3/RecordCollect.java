/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 *
 * @author Kingsley
 */
public class RecordCollect {
    
        RecordCollect()
        {
                this.RecordTitle = null;
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
    
}
