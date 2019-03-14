
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
   
   public Parcel( int number, String time)
   {
	  setParcel( "", "", "", "", 99999, "" );
      parcelID = number;
      arrivalTime = time;
   }
   
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
   
   public String getName()
   {
	   return name;
   }
   
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

}
