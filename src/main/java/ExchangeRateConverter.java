import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.doubleInput;

public class ExchangeRateConverter {

    public static void main(String[] args) {
        String url = "https://1150-exchange-rates.azurewebsites.net/latest";
        Map<String, Object> queryParameters = Map.of("base", "USD", "symbols", "EUR");

        RateResponse response = Unirest.get(url)
                .queryString(queryParameters)
                .asObject(RateResponse.class)
                .getBody();

        Rates rates = response.rates;
        String dateRequested = response.date;
        double rate = response.rates.EUR;
        double AUDrate = rates.AUD;
        double BRLrate = rates.BRL;
        double EURrate = rates.EUR;
        double ISKrate = rates.ISK;
        double amountOfDollars = doubleInput("How many US Dollars to convert to Euros?");
        double euroEquivalent = amountOfDollars * rate;
        System.out.println("On " + dateRequested + " the exchange rate from USD to EUR is " + rate);
        System.out.println("$" + amountOfDollars + " is equivalent to " + euroEquivalent + " Euros.");
        System.out.println("On " + dateRequested + " the exchange rate from UK Pounds to Australian Dollars is " + AUDrate);
        System.out.println("On " + dateRequested + " the exchange rate from UK Pounds to Brazilian Reals is " + BRLrate);
        System.out.println("On " + dateRequested + " the exchange rate from UK Pounds to Euros is " + EURrate);
        System.out.println("On " + dateRequested + " the exchange rate from UK Pounds to Icelandic Króna is " + ISKrate);

    }
}
class RateResponse {
    public String base;
    public String date;
    public Rates rates;
}

class Rates {
    public double EUR;
    public double AUD;
    public double BRL;
    public double ISK;
}
