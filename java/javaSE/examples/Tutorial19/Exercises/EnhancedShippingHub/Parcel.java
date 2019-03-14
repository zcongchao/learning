// Exercise 19.16: Parcel.java
// This program defines the Parcel object.
public class Parcel
{
   // member data
   private String name;
   private String address;
   private String city;
   private String state;
   private String arrivalTime;
   private int zip;
   private int parcelID;
   
   // constructor
   public Parcel( int number, String time )
   {
      setParcel( "", "", "", "", 99999, "" );
      parcelID = number;
      arrivalTime = time;
   }
   
   // set the parcel properties
   private void setParcel( String nameValue, String addressValue,
      String cityValue, String stateValue, int zipValue,
      String timeValue )
   {
      name = nameValue;
      address = addressValue;
      city = cityValue;
      state = stateValue;
      zip = zipValue;
      arrivalTime = timeValue;
   }

   // get the name
   public String getName()
   {
      return name;
   }

   // set the name
   public void setName( String nameValue )
   {
      name = nameValue;
   }   

   // get the address
   public String getAddress()
   {
      return address;
   }

   // set the address
   public void setAddress( String addressValue )
   {
      address = addressValue;
   }
   
   // get the city
   public String getCity()
   {
      return city;
   }

   // set the city
   public void setCity( String cityValue )
   {
      city = cityValue;
   }
   
   // get the state
   public String getState()
   {
      return state;
   }

   // set the state
   public void setState( String stateValue )
   {
      state = stateValue;
   }
   
   // get the zip code
   public int getZip()
   {
      return zip;
   }

   // set the zip code
   public void setZip( int zipValue )
   {
      zip = zipValue;
   }
   
   // get the parcel number
   public int getParcelID()
   {
      return parcelID;
   }
   
   // get the arrival time
   public String getArrivalTime()
   {
      return arrivalTime;
   }
   
} // end class Parcel

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