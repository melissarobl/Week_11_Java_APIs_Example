// Yelp API response classes to map JSON to Java objects. Highest level of fields
public class YelpResponse {
    // field for businesses
    //what type? - it will be an array

    public Business[] businesses; //array of businesses (based on Yelp code designation)

}

class Business {
    //represent one business object
    public String name;
    public double rating;
    public Location location;
}

class Location {
    public String city;
    public String address1;
}


