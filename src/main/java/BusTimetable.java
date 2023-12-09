import kong.unirest.Unirest;

public class BusTimetable {
    public static void main(String[] args) {
        // This URL is a request for the bus departures from stop number 17940, which
        // is the stop on Hennepin Avenue for buses traveling north.
        String metroTransitURL = "http://svc.metrotransit.org/NexTrip/17940?format=json";

        MetroTransitResponse response = Unirest.get(metroTransitURL).asObject(MetroTransitResponse.class).getBody();

        BusStatus[] busStatuses = response.departures;

        String busTableTemplate = "%-10s%-40s%-20s\n";

        // Table header
        System.out.printf(busTableTemplate, "Route", "Description", "Arrival Time");
        System.out.println("=".repeat(70));

        // Read information about each bus, display in table form

        for (BusStatus bus: busStatuses) {
            System.out.printf(busTableTemplate, bus.route_id, bus.description, bus.departure_text);
        }
    }
}

class MetroTransitResponse {
    BusStatus[] departures;
}
class BusStatus {
    public String departure_text;
    public String description;
    public String route_id;
}

