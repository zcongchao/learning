// Exercise 18.16: Name.java
// Represents name data and contains get and set methods.

public class Name
{
   // Strings for storing first and last name
   private String first = "";
   private String last = "";
   
   // Name constructor, first and last supplied
   public Name( String firstValue, String lastValue )
   {
      setFirst( firstValue );
      setLast( lastValue );

   } // end constructor
   
   // return first value
   public String getFirst()
   {
      return first;

   } // end method getFirst
   
   // set first value
   public void setFirst( String value )
   {
      value = first;

   } // end method setFirst
   
   // return last value
   public String getLast()
   {
      return last;

   } // end method getLast

   // set last value
   public void setLast( String value )
   {
      last = value;

   } // end method setLast

} // end class Name

/**************************************************************************
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
 **************************************************************************/