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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Integer;
import java.lang.Double;
/**
 *
 * @author Kingsley
 */
public class JavaApplication3 {

    /**
     * @param UserName
     * @param Password
     *
     */
    
        private static Connection connection = null;
        private static Statement statement = null;
        private static PreparedStatement preparedStatement = null;
        private static ResultSet resultSet = null;
        private static RecordCollect r;
        private static RecordCollect CollectedDate = new RecordCollect();
        private static Boolean FlagNextLine = false;
   
   public static void connect_database(String DatabaseName, String UserName, String Password)
   {
      try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e)
        {
            System.out
                    .println("Where is your MySQL JDBC Driver? Please include it in the library section");
            e.printStackTrace();
            return;
        };
        
        System.out
                .println("MySQL JDBC Driver Registered!");
        //Connection connection = null;
        
        try {
                connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/"+DatabaseName+"?"+"user="+UserName+"&password="+Password);
            }
        catch (SQLException e)
            {
                System.out
                        .println("Connection fialed! Check output console");
                e.printStackTrace();
                return;
            };
        
        System.out
                .println("Succesful database connection!");
   };
   
   public static void close_database()
   {
       
   };
   
   public static void store(RecordCollect _bookRecord, String DatabaseName, String TableName)
   {
       try {
       // PreparedStatements can use variables and are more efficient
            preparedStatement = connection
                    .prepareStatement("insert into  "+DatabaseName+"."+TableName+" values (?, ?, ?, ? ,?, ?,?, ?, ?, ? ,?, ?,?, ?, ?, ? ,?, ?,default )");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            //preparedStatement.setString(1, _bookRecord.RecordTitle);
            //preparedStatement.setString(2, _bookRecord.RecordSubTitle);
            //preparedStatement.setString(3, _bookRecord.RecordAuthor);
            
            preparedStatement.setString(1, _bookRecord.RecordTitle);
            preparedStatement.setString(2, _bookRecord.RecordSubTitle);
            preparedStatement.setString(3, _bookRecord.RecordAuthor);
            System.out.println(">>>>>>>>>>>>>>"+_bookRecord.RecordAuthor);
            //preparedStatement.setString(1, "Example Title 1"); 
            //preparedStatement.setString(2, "Example SubTitle 1");
            //preparedStatement.setString(3, "Example Author 1");
            preparedStatement.setString(4,  _bookRecord.RecordPublisher);
            preparedStatement.setString(5, _bookRecord.RecordPublishDate);
            preparedStatement.setString(6,  "Category");
            preparedStatement.setString(7, "Description"); 
            preparedStatement.setString(8, _bookRecord.RecordLanguage); 
            preparedStatement.setString(9, "PrintMedia"); 
            preparedStatement.setDouble(10, _bookRecord.RecordAvgRating); 
            preparedStatement.setInt(11, _bookRecord.RecordNumRatings);
            
             double doubleValue = 1.0001d;
            //preparedStatement.setDouble(10, doubleValue); 
                int intValue = 5;
            //preparedStatement.setInt(11,intValue);
            
            preparedStatement.setString(12, "TextSnippets"); 
            preparedStatement.setString(13, "ISBNnumber"); 
            preparedStatement.setString(14, "Blob"); 
            preparedStatement.setString(15, "Borrower"); 
            preparedStatement.setString(16, "2009-09-14 10:33:11"); 
            preparedStatement.setString(17, "2017-02-01 10:00:11"); 
            preparedStatement.setString(18, "1"); 
            preparedStatement.executeUpdate();
            
             System.out.println("Updated ");
       }
       catch (SQLException e)
       {};
       
   };
   
   public static void retrieve(RecordCollect R)
   {
   
       try {
        
            statement = connection
                    .createStatement();
            resultSet = statement
                    .executeQuery("select * from feedback.comments");
            
            while (resultSet.next()) 
            {
                r.RecordTitle = resultSet
                        .getString("RecordTitle"); 
                r.RecordSubTitle = resultSet
                        .getString("RecordSubTitle"); 
                r.RecordAuthor = resultSet
                        .getString("RecordAuthor"); 
                r.RecordPublisher = resultSet
                        .getString("RecordPublisher"); 
                r.RecordPublishDate = resultSet
                        .getString("RecordPublishDate"); 
                r.RecordCategory = resultSet
                        .getString("RecordCategory"); 
                r.RecordDescription = resultSet
                        .getString("RecordDescription"); 
                r.RecordLanguage = resultSet
                        .getString("RecordLanguage"); 
                r.RecordPrintMedia = resultSet
                        .getString("RecordPrintMedia"); 
                r.RecordAvgRating = resultSet
                        .getDouble("RecordAvgRating"); 
                r.RecordNumRatings = resultSet
                        .getInt("RecordNumRatings");
                r.RecordTextSnippet = resultSet
                        .getString("RecordTextSnippet"); 
                r.RecordISBNNumber = resultSet
                        .getString("RecordISBNNumber"); 
                r.RecordImagePointer = resultSet
                        .getString("RecordImagePointer"); 
                r.RecordBorrower = resultSet
                        .getString("RecordBorrower"); 
                r.RecordBorrowDate = resultSet
                        .getString("RecordBorrowDate"); 
                r.RecordBorrowerReturnDate = resultSet
                        .getString("RecordBorrowerReturnDate"); 
                r.RecordBookTransactions = resultSet
                        .getString("RecordBookTransactions"); 
            };
       }
       catch (SQLException e)
       {
       
       
       };
   };
   
   public static void google_book_api_reader(String FILENAME, String COMMAND) 
   {
      

 
		BufferedReader br = null;
		FileReader fr = null;
                String line = "";
                line.matches("^\\[.\\]$");
                

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
                System.out.println(line);
   }

   public static void main(String[] args) throws Exception {
       
      
      
       //Pattern currently being checked for
      Pattern titleMatcher = Pattern.compile("\"title\": \"(\\s*.+\\s*)\"");
      Pattern subTitleMatcher = Pattern.compile("\"subtitle\": \"(\\s*.+\\s*)\"");
      Pattern authorMatcher = Pattern.compile("\"authors\":");
     // Pattern authorMatcherTwo = Pattern.compile("(\"Eugene\")");
      //Pattern authorMatcherTwo = Pattern.compile("\"([A-Za-z0-9.]+)\"");
      Pattern authorMatcherTwo = Pattern.compile("([a-zA-z-]+([ '-][a-zA-Z. ]+[ '-]?[a-zA-Z. ]+))");
      Pattern publishedDateMatcher = Pattern.compile("\"publishedDate\": \"(\\s*.+\\s*)\"");
      Pattern descriptionMatcher = Pattern.compile("\"description\": \"(\\s*.+\\s*)\"");
      Pattern categoriesMatcher = Pattern.compile("\"categories\": \"(\\s*.+\\s*)\"");
      Pattern languageMatcher = Pattern.compile("\"language\": \"(\\s*.+\\s*)\"");
      Pattern pageCountMatcher = Pattern.compile("\"pageCount\":(\\s*.+\\s*),");
      Pattern printTypeMatcher = Pattern.compile("\"printType\": \"(\\s*.+\\s*)\"");
      Pattern avgRatingsMatcher = Pattern.compile("\"averageRating\":?\\s{0,2}(\\d{0,10}.?\\d{0,2})");
      Pattern numRatingsMatcher = Pattern.compile("\"ratingsCount\":?\\s{0,2}(\\d{0,10})");
      Pattern textSnippet = Pattern.compile("\"textSnippet\": \"(\\s*.+\\s*)\"");
      Pattern isbnMatcher= Pattern.compile("=isbn:(\\s*.+\\s*)&hl");
      Pattern imageMatcher = Pattern.compile("thumbnail\": \"(\\s*.+\\s*)\"");

      
      URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:9781576839164");
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
      String line;
      
      int x = 0;
      while ((line = reader.readLine()) != null) {
          
         Matcher matchedTitle = titleMatcher.matcher(line);
         System.out.println(line);
         while ( matchedTitle.find() ) 
         {
             System.out.println("==================>"+matchedTitle.group(1));
             CollectedDate.RecordTitle = matchedTitle.group(1);
         }
         
         
         
         Matcher matchedSubtitle = subTitleMatcher.matcher(line);
         while ( matchedSubtitle.find() ) 
         {
             System.out.println("==================>"+matchedSubtitle.group(1));
             CollectedDate.RecordSubTitle = matchedSubtitle.group(1);
         }
        
         Matcher matchedPublishedDate = publishedDateMatcher.matcher(line);
         while ( matchedPublishedDate.find() ) System.out.println("======================================>" + matchedPublishedDate.group(1));
         
         Matcher matchedAuthor = authorMatcher.matcher(line);
         
         if (FlagNextLine)
                  {
                     //     System.out.println("============123======================>>>>>>>>>>>>>>>>>>>"+line);
                     //CollectedDate.RecordAuthor = line;
                     
                      Matcher matchedAuthortwo = authorMatcherTwo.matcher(line);
                        while ( matchedAuthortwo.find() ) 
                        {
                            System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
                            System.out.println("=====/////////////////=============>"+matchedAuthortwo.group(0));
                            CollectedDate.RecordAuthor = matchedAuthortwo.group(0);
                        }
                   
                     
                     FlagNextLine = false;
                   };
                   
         
         if (matchedAuthor.find()) {FlagNextLine = true;}
         
         
         
         Matcher matchedDescription = descriptionMatcher.matcher(line);
         while ( matchedDescription.find() ) 
         {
            System.out.println("======================================>" + matchedDescription.group(1));
            CollectedDate.RecordDescription = matchedDescription.group(1);
         }
          
         Matcher matchedCategorise = categoriesMatcher.matcher(line);
         while ( matchedCategorise.find() ) 
         {
            System.out.println("======================================>" + matchedCategorise.group(1));
            CollectedDate.RecordCategory = matchedCategorise.group(1);
         }
         
         Matcher matchedLanguage= languageMatcher.matcher(line);
         while ( matchedLanguage.find() ) 
         {
             System.out.println("======================================>" + matchedLanguage.group(1));
            CollectedDate.RecordLanguage = matchedLanguage.group(1);
         }
         
         Matcher matchedPageCounter = pageCountMatcher.matcher(line);
         while ( matchedPageCounter.find() ) 
         {
             System.out.println("=======--------===============================>" + matchedPageCounter.group(1));
         }

                  
         Matcher matchedPrintType = printTypeMatcher.matcher(line);
         while ( matchedPrintType.find() ) 
         {
             System.out.println("======================================>" + matchedPrintType.group(1));
             CollectedDate.RecordPrintMedia = matchedPrintType.group(1);
         }
         
                 
         Matcher matchedAvgRatings = avgRatingsMatcher.matcher(line);
         while ( matchedAvgRatings.find() ) 
         {
             System.out.println("======================================>" + matchedAvgRatings.group(1));
             CollectedDate.RecordAvgRating = Double.parseDouble(matchedAvgRatings.group(1));
             System.out.println("Double--------------------------------------------------------------------------------------------->>>>>"+matchedAvgRatings.group(1));
            //CollectedDate.RecordAvgRating = Double.parseDouble("4.5");
         }

         
         Matcher matchedNumRatings = numRatingsMatcher.matcher(line);
         while ( matchedNumRatings.find() ) 
         {
             System.out.println("======================================>" + matchedNumRatings.group(1));
            CollectedDate.RecordNumRatings = Integer.parseInt(matchedNumRatings.group(1));
            System.out.println("Integer--------------------------------------------------------------------------------------------->>>>>"+matchedNumRatings.group(1));
            
            // CollectedDate.RecordNumRatings = Integer.parseInt("4.5");
         }
         
         
         Matcher matchedTextSnippet = textSnippet.matcher(line); 
         while ( matchedTextSnippet.find() ) 
         {
             System.out.println("======================================>" + matchedTextSnippet.group(1));
             CollectedDate.RecordTextSnippet = matchedTextSnippet.group(1);
         
         }        
 
         Matcher matchedIsbn = isbnMatcher.matcher(line); 
         while ( matchedIsbn.find() ) 
         {
             System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>" + matchedIsbn.group(1));
             CollectedDate.RecordISBNNumber = matchedIsbn.group(1);
         }        
         
                  
         Matcher matchedImage = imageMatcher.matcher(line); 
         while ( matchedImage.find() ) 
         {
             System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>" + matchedImage.group(1));
         }
         

        
      
         book_rec br = new book_rec();
         
                 
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
        
         
         //System.out.println(line);
         writer.write(line);
         writer.newLine();
         x++;
      }
      //System.out.println(x);
      reader.close();
      writer.close();
      
      google_book_api_reader("data.html","id");
      connect_database("googledb","sqlusergoog","sqluserpw");
      store(CollectedDate,"googledb","adb");
      
      System.out.println("hello end");
   }
    
}
