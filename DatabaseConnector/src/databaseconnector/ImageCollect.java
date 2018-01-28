/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnector;

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
public class ImageCollect {
    
        ImageCollect()
        {
          
                this.RecordISBNNumber = null;
                this.RecordComments = null;
        };

                String RecordComments;
                String RecordISBNNumber;
                BufferedWriter RecordImageLink;

    
}
