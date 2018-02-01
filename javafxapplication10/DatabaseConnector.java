/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

/**
 *
 * @author Kingsley
 */
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


public class DatabaseConnector {

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
        private static Boolean FlagDescriptionNextLine = false;
        private static Boolean FlagCategoriesNextLine = false;
        private static Boolean FlagISBNNextLine = false;
        private static Boolean FlagImageNextLine = false;
   
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
           
            preparedStatement.setString(1, _bookRecord.RecordTitle);
            preparedStatement.setString(2, _bookRecord.RecordSubTitle);
            preparedStatement.setString(3, _bookRecord.RecordAuthor);
            preparedStatement.setString(4,  _bookRecord.RecordPublisher);
            preparedStatement.setString(5, _bookRecord.RecordPublishDate);
            preparedStatement.setString(6,  _bookRecord.RecordCategory);
            preparedStatement.setString(7, _bookRecord.RecordDescription); 
            preparedStatement.setString(8, _bookRecord.RecordLanguage); 
            preparedStatement.setString(9, _bookRecord.RecordPrintMedia); 
            preparedStatement.setDouble(10, _bookRecord.RecordAvgRating); 
            preparedStatement.setInt(11, _bookRecord.RecordNumRatings);
            preparedStatement.setString(12, _bookRecord.RecordTextSnippet); 
            preparedStatement.setString(13, _bookRecord.RecordISBNNumber); 
            preparedStatement.setString(14, "Blob"); 
            preparedStatement.setString(15, _bookRecord.RecordBorrower); 
            preparedStatement.setString(16, _bookRecord.RecordPublishDate); 
            preparedStatement.setString(17, _bookRecord.RecordBorrowerReturnDate); 
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
      Pattern titleMatcher = Pattern.compile("\"title\": \"([A-Za-z:,\\s{0,2}]+)\"");
      
      //Done
      Pattern subTitleMatcher = Pattern.compile("\"subtitle\": \"([A-Za-z:,\\s{0,2}]+)\"");
      //Done
      Pattern publishedMatcher = Pattern.compile("\"publisher\": \"([A-Za-z:,\\s{0,2}]+)\"");
      //Done
      Pattern authorMatcher = Pattern.compile("\"authors\":");
     // Pattern authorMatcherTwo = Pattern.compile("(\"Eugene\")");
      //Pattern authorMatcherTwo = Pattern.compile("\"([A-Za-z0-9.]+)\"");
      Pattern authorMatcherTwo = Pattern.compile("([a-zA-z-]+([ '-][a-zA-Z. ]+[ '-]?[a-zA-Z. ]+))");
      //Done
      Pattern publishedDateMatcher = Pattern.compile("\"publishedDate\":\\s{0,2}\"([0-9-]+)\"");
      
      Pattern descriptionMatcher = Pattern.compile("\"description\":\\s{0,4}\"([A-Za-z-,. ]{0,75})");
      Pattern descriptionMatcherTwo = Pattern.compile("\"description\":\\s{0,4}\"([A-Za-z-,. ]{0,25})");
      //Done
      Pattern categoriesMatcher = Pattern.compile("\"categories\":\\s{0,2}\\[");
      Pattern categoriesMatcherTwo = Pattern.compile("\"([a-zA-z]+)\"");   
      //Done
      Pattern languageMatcher = Pattern.compile("\"language\": \"([A-Za-z:,\\s{0,2}]+)\"");
      //Done
      Pattern pageCountMatcher = Pattern.compile("\"pageCount\\s{0,4}\":?\\s{0,2}(\\d{0,6}),");
      //Done
      Pattern printTypeMatcher = Pattern.compile("\"printType\":\\s{0,4}\"([A-Za-z]+)\"");
      //Done
      Pattern avgRatingsMatcher = Pattern.compile("\"averageRating\":?\\s{0,2}(\\d{0,10}.?\\d{0,2})");
      //Done
      Pattern numRatingsMatcher = Pattern.compile("\"ratingsCount\":?\\s{0,2}(\\d{0,10})");
      //Done
        Pattern textSnippet = Pattern.compile("\"textSnippet\":\\s{0,4}\"([A-Za-z-,. ]{0,75})");
      //Done
      Pattern isbnMatcher= Pattern.compile("\"type\": \"ISBN_10\",");
      Pattern isbnMatcherTwo = Pattern.compile("\"identifier\":\\s{0,4}\"(\\d{0,10})\"");
      //Done
      Pattern imageMatcher = Pattern.compile("thumbnail\": \"(\\s*.+\\s*)\"");
      Pattern imageMatcherTwo = Pattern.compile("([A-Za-z0-9_!:/.&?=\\s{0,2}]+)");
      //Done
      Pattern publisherMatcher = Pattern.compile("\"publisher\\s{0,10}\": \"([A-Za-z:,\\s{0,2}]+)\",");
      //Done
      Pattern countryMatcher = Pattern.compile("\"country\\s{0,10}\": \"([A-Z:,\\s{0,2}]+)\",");
      //Done Country Matcher assumes that all text is in capital letters
      Pattern publicDomainMatcher = Pattern.compile("\"publicDomain\\s{0,10}\":\\s{0,10}([A-Za-z]+),");
      //Done Country Matcher assumes that all text is in capital letters
      
      URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:1576839168");
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
      String line;
      
      int x = 0;
      while ((line = reader.readLine()) != null) {
          
         Matcher matchedTitle = titleMatcher.matcher(line);
         //System.out.println(line);
         while ( matchedTitle.find() ) 
         {
             System.out.println("==================>"+matchedTitle.group(1));
             CollectedDate.RecordTitle = matchedTitle.group(1);
         }
         
         Matcher matchedPublisher = publishedMatcher.matcher(line);
         while ( matchedPublisher.find() ) 
         {
             //System.out.println("==================>"+matchedPublisher.group(1));
             CollectedDate.RecordPublisher = matchedPublisher.group(1);
         }
         
         Matcher matchedSubtitle = subTitleMatcher.matcher(line);
         while ( matchedSubtitle.find() ) 
         {
             //System.out.println("==================>"+matchedSubtitle.group(1));
             CollectedDate.RecordSubTitle = matchedSubtitle.group(1);
         }
        
         Matcher matchedPublishedDate = publishedDateMatcher.matcher(line);
         while ( matchedPublishedDate.find() ) 
         {
             //System.out.println("==================>"+matchedPublishedDate.group(1));
             CollectedDate.RecordPublishDate = matchedPublishedDate.group(1);
         }  
             
         Matcher matchedAuthor = authorMatcher.matcher(line);
         
         // RegEx for Author Flag
         // Completed January 26th, 2018.
         if (FlagNextLine)
                  {
                          System.out.println("============123======================>>>>>>>>>>>>>>>>>>>"+line);
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
       
         // RegEx for Description Flag
         // Completed January 28th, 2018.
         if (FlagDescriptionNextLine)
                  {
                         System.out.println("============123======================>>>>>>>>>>>>>>>>>>>"+line);
                     //CollectedDate.RecordAuthor = line;
                     
                      Matcher matchedDescriptionTwo = descriptionMatcherTwo.matcher(line);
                        while ( matchedDescription.find() ) 
                        {
                            System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
                            System.out.println("=====////////*******/////////=============>"+matchedDescription.group(1));
                            CollectedDate.RecordDescription = matchedDescription.group(1);
                        }
                   
                     
                     FlagDescriptionNextLine = false;
                   };
                   
         
         //if (matchedDescription.find()) {FlagDescriptionNextLine  = true;}
         //System.out.println(line);
         while ( matchedDescription.find() ) 
         {
             //System.out.println("==================>"+matchedDescription.group(1));
             CollectedDate.RecordDescription = matchedDescription.group(1);
         }
         
         
         Matcher matchedCategories = categoriesMatcher.matcher(line);
         
         // RegEx for Categories Flag
         // Completed January 28th, 2018.
         if (FlagCategoriesNextLine)
                  {
                     //     System.out.println("============123======================>>>>>>>>>>>>>>>>>>>"+line);
                     //CollectedDate.RecordAuthor = line;
                     
                      Matcher matchedCategoriesTwo = categoriesMatcherTwo.matcher(line);
                        while ( matchedCategoriesTwo.find() ) 
                        {
                           // System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
                            //System.out.println("=====/////////////Categories////=============>"+matchedCategoriesTwo.group(1));
                            CollectedDate.RecordCategory = matchedCategoriesTwo.group(1);
                        }
                   
                     
                     FlagCategoriesNextLine = false;
                   };
                   
         
         
         if (matchedCategories.find()) {FlagCategoriesNextLine  = true;}
        
         Matcher matchedISBN = isbnMatcher.matcher(line);
         
         // RegEx for Categories Flag
         // Completed January 28th, 2018.
         if (FlagISBNNextLine)
                  {
                     //     System.out.println("============123======================>>>>>>>>>>>>>>>>>>>"+line);
                     //CollectedDate.RecordAuthor = line;
                     
                      Matcher matchedISBNTwo = isbnMatcherTwo.matcher(line);
                        while ( matchedISBNTwo.find() ) 
                        {
                           // System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
                           // System.out.println("=====/////////////////=============>"+matchedISBNTwo.group(1));
                            CollectedDate.RecordISBNNumber = matchedISBNTwo.group(1);
                        }
                   
                     
                     FlagISBNNextLine = false;
                   }
         
         if (matchedISBN.find()) {FlagISBNNextLine  = true;}
         
         Matcher matchedImage = imageMatcher.matcher(line);
         
         
         // RegEx for Image Matcher Flag
         // Completed January 28th, 2018.
         if (FlagImageNextLine)
                  {
                     //System.out.println("============123======================>>>>>>>>>>>>>>>>>>>"+line);
                     //CollectedDate.RecordAuthor = line;
                     
                      Matcher matchedImageTwo = imageMatcherTwo.matcher(line);
                        while ( matchedImageTwo.find() ) 
                        {
                            //System.out.println("}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
                            //System.out.println("=====/////////////////=============>"+matchedImageTwo.group(1));
                            CollectedDate.RecordImagePointer = matchedImageTwo.group(1);
                        }
                   
                     
                     FlagImageNextLine = false;
                   };
                   
         
         if (matchedImage.find()) {FlagImageNextLine  = true;}
         
         
       //  Matcher matchedDescription = descriptionMatcher.matcher(line);
       //  while ( matchedDescription.find() ) 
       //  {
       //     System.out.println("======================================>" + matchedDescription.group(1));
       //     CollectedDate.RecordDescription = matchedDescription.group(1);
       //  }
          
         
        
         Matcher matchedLanguage= languageMatcher.matcher(line);
         while ( matchedLanguage.find() ) 
         {
            //System.out.println("====================????==================>" + matchedLanguage.group(1));
            CollectedDate.RecordLanguage = matchedLanguage.group(1);
         }
         
         Matcher matchedPageCounter = pageCountMatcher.matcher(line);
         while ( matchedPageCounter.find() ) 
         {
            //System.out.println("=======--------===============================>" + matchedPageCounter.group(1));
         }

                  
         Matcher matchedPrintType = printTypeMatcher.matcher(line);
         while ( matchedPrintType.find() ) 
         {
             //System.out.println("====================>>>>==================>" + matchedPrintType.group(1));
             CollectedDate.RecordPrintMedia = matchedPrintType.group(1);
         }
         
                 
         Matcher matchedAvgRatings = avgRatingsMatcher.matcher(line);
         while ( matchedAvgRatings.find() ) 
         {
            //System.out.println("=======================\\\\\\\\\\\\\\===============>" + matchedAvgRatings.group(1));
             CollectedDate.RecordAvgRating = Double.parseDouble(matchedAvgRatings.group(1));
            //System.out.println("Double--------------------------------------------------------------------------------------------->>>>>"+matchedAvgRatings.group(1));
            //CollectedDate.RecordAvgRating = Double.parseDouble("4.5");
         }

         
         Matcher matchedNumRatings = numRatingsMatcher.matcher(line);
         while ( matchedNumRatings.find() ) 
         {
            //System.out.println("======================================>" + matchedNumRatings.group(1));
            CollectedDate.RecordNumRatings = Integer.parseInt(matchedNumRatings.group(1));
            //System.out.println("Integer--------------------------------------------------------------------------------------------->>>>>"+matchedNumRatings.group(1));
            
            // CollectedDate.RecordNumRatings = Integer.parseInt("4.5");
         }
         
         
         Matcher matchedTextSnippet = textSnippet.matcher(line); 
         while ( matchedTextSnippet.find() ) 
         {
             //System.out.println("=======================\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\===============>" + matchedTextSnippet.group(1));
             CollectedDate.RecordTextSnippet = matchedTextSnippet.group(1);
         
         }        
 
        // Matcher matchedIsbn = isbnMatcher.matcher(line); 
        // while ( matchedIsbn.find() ) 
        // {
         //    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>" + matchedIsbn.group(1));
          //   CollectedDate.RecordISBNNumber = matchedIsbn.group(1);
         //}        
         
                  
         //Matcher matchedImage = imageMatcher.matcher(line); 
         //while ( matchedImage.find() ) 
        // {
         //    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>" + matchedImage.group(1));
        // }
         

        
      
        // book_rec br = new book_rec();
         
                 
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
      
      //System.out.println("hello end");
   }
    
}
