import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.stringInput;

public class YelpSearch {

    public static void main(String[] args) {
        String yelpURL = "https://api.yelp.com/v3/businesses/search";
        String YELP_API_KEY = System.getenv("YELP_API_KEY");

        String typeOfRestaurant = stringInput("What type of restaurant would you like to search for?");
        Map<String, Object> yelpQuery = Map.of(
                "term", typeOfRestaurant,
                "location", "Minneapolis,MN",
                "categories", "restaurants" ,
                "price", "1"
                ); //lowest price

        YelpResponse response = Unirest
                .get(yelpURL)
                .header("Authorization", "Bearer " + YELP_API_KEY)
                .queryString(yelpQuery)
                .asObject(YelpResponse.class)
                .getBody();

        System.out.println(response);
        for (Business b : response.businesses) {
            System.out.println(b.name);
            System.out.println("Rating " + b.rating);
            System.out.println(b.location.address1 + ", " + b.location.city);
        }
    }
}
