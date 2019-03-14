<!-- Tutorial 32: books.jsp -->
<!-- Displays a form.       -->

<%-- import java.sql.* for database classes --%>
<%@ page import = "java.sql.*" %>

<!-- begin HTML document -->
<html>

   <!-- specify HTML head element -->
   <head>
   
      <!-- specify page title -->
      <title>Book List</title>
   </head>

   <!-- begin body of document -->
   <body>
      <h1>Available Books</h1>

      <!-- create form -->
      <form>

         <p>Select a book from the list and click the button to view 
            the selected book's information</p>

         <!-- create list that contains book titles -->
         <select name = "bookTitle">

            <%-- begin JSP scriptlet to connect to database --%>
            <%
               // setup database connection
               try 
               {
                  // specify database location
                  System.setProperty( "db2j.system.home", 
                     "C:\\Examples\\Tutorial29\\Databases" ); 

                  // load Cloudscape driver
                  Class.forName( "com.ibm.db2j.jdbc.DB2jDriver" );

                  // connect to database
                  Connection connection = 
                     DriverManager.getConnection( 
                        "jdbc:db2j:bookstore" );

                  // obtain list of titles
                  if ( connection != null ) 
                  {
                     Statement statement = 
                        connection.createStatement();

                     ResultSet results = statement.executeQuery(
                        "SELECT title FROM products" );

                     // close database connection
                     connection.close();  

                  }  // end if

               }  // end try

               // catch SQLException
               catch( SQLException exception ) 
               {
                  out.println( 
                     "Exception: " + exception + " occurred." );
               }

            %>  <%-- end scriptlet --%>

         </select>

         <!-- create View Information button -->
         <p><input type = "submit" value = "View Information"></p>
      </form>

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
