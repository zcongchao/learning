<!-- Tutorial 32: bookInformation.jsp -->
<!-- Displays book information.       -->

<%-- import java.sql.* for database classes --%>
<%@ page import = "java.sql.*" %>

<!-- begin HTML document -->
<html>

   <!-- specify head element -->
   <head>
   
      <!-- specify page title -->
      <title>Book Information</title>
   </head>

   <!-- begin body of document -->
   <body>
   
      <!-- create a heading for the book's title -->
      <h1></h1>

      <%-- begin JSP scriptlet to connect to a database --%>
      <%
         // setup database connection
         try 
         {
            // specify database location
            System.setProperty( "db2j.system.home", 
               "C:\\Examples\\Tutorial29\\Databases" ); 

            // load Cloudscape driver
            Class.forName( "com.ibm.db2j.jdbc.DB2jDriver" );

            // obtain connection to database
            Connection connection = DriverManager.getConnection(
               "jdbc:db2j:bookstore" );

            // obtain list of titles from database
            if ( connection != null ) 
            {
               // create statement
               Statement statement = connection.createStatement();

               // execute query to get book information
               ResultSet results = statement.executeQuery( 
                  "SELECT cover, title, authors, price, isbn, " +
                  "edition, copyrightYear, description " +
                  "FROM products WHERE title = '" + 
                  request.getParameter( "bookTitle" ) + "'" );

      %>  <%-- end scriptlet to insert literal XHTML --%>

               <!-- display book cover image -->
               <img src = "" alt = "">

               <!-- display authors -->
               <p>Author(s): </p>

               <!-- display price -->
               <p>Price: </p>

               <!-- display ISBN -->
               <p>ISBN: </p>

               <!-- display edition number -->
               <p>Edition: </p>

               <!-- display copyright year -->
               <p>Copyright Year: </p>

               <!-- display authors -->
               <p>Description: </p>                 

               <!-- create link to Book List -->
               <p><a href = "books.jsp">Book List</a></p>

      <%  // continue scriptlet

               connection.close();  // close database connection

            }  // end if

         }  // end try

         // catch SQLException
         catch( SQLException exception ) 
         {
            out.println( "Exception: " + exception + " occurred." );
         }

      %>  <%-- end scriptlet --%>

   </body>
</html>

 <!--
 **************************************************************************
 * (C) Copyright 1992-2004 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************
-->

      
