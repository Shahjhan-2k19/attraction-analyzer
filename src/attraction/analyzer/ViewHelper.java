/* #4 controller helper to get data
 * this class is used to get all the required informaion
 * creating variables for required field
 * return and set all the data into data catagory variables 
 */

package attraction.analyzer;


//Class for object to store data from the result set
import java.util.*;
public class ViewHelper {
    public String Name,Url,Telephone,Region,Local,Country,Tags,latitude,longitude;
    public ViewHelper(String Name, String Url, String Telephone,String latitude, String longitude, String Region, String Local, String Country, String Tags) {
        this.Name = Name;
        this.Url = Url;
        this.Telephone = Telephone;
        this.Region = Region;
        this.Local = Local;
        this.Country = Country;
        this.Tags = Tags;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    //getters
    public String getName() {
        return Name;
    }

    public String getUrl() {
        return Url;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getRegion() {
        return Region;
    }

    public String getLocal() {
        return Local;
    }

    public String getCountry() {
        return Country;
    }

    public String getTags() {
        return Tags;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
  
}
