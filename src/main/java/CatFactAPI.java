import kong.unirest.Unirest;

public class CatFactAPI {


    public static void main(String[] args) {
        String url = "https://catfact.ninja/fact"; //string to make API request
        CatFact catFact = Unirest.get(url).asObject(CatFact.class).getBody();  //ask Unirest to convert JSON to Java object
        //define type of object with: CatFact.class
        String fact = catFact.getFact();
        int factLength = catFact.getLength();
        System.out.println("A cat fact is: \n" + fact);
        System.out.println("The fact is " + factLength + " characters long");
        //System.out.println(catFact.fact);  //catFact has a fact and a length, and we are asking for the fact
    }
}

class CatFact {
    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private String fact;  //same as field in JSON
    private int length; //same as field in JSON

}
