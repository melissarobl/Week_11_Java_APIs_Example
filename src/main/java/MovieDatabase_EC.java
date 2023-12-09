import kong.unirest.Unirest;

public class MovieDatabase_EC {

    String openMovieDatabaseURL = "https://www.omdbapi.com/swagger.json";

    OpenMovieDatabaseResponse response = Unirest.get(openMovieDatabaseURL).asObject(OpenMovieDatabaseResponse.class).getBody();
}
