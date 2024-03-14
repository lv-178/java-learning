package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        String model = "Boeing 737-800";

        long numberOfAircraftsOfThisModel = findCountAircraftWithModelAirbus(airport, model);
        System.out.println("Количество самолётов данной модели: " + numberOfAircraftsOfThisModel);

        Map<String, Integer> parkedAircrafts = findMapCountParkedAircraftByTerminalName(airport);
        System.out.println("Количество самолётов на каждом терминале: " + parkedAircrafts);

        List<Flight> nextFlights = findFlightsLeavingInTheNextHours(airport, 3);
        System.out.println("Количество вылетов в ближайшее время: " + nextFlights);

        String terminal = "D";
        System.out.println("Ближайший прилёт в терминал " + terminal + ": " +
                findFirstFlightArriveToTerminal(airport, terminal));

    }

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getAllAircrafts().stream()
                .filter(aircraft -> aircraft.toString().contains(model)).count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        Map<String, Integer> terminals = new TreeMap<>();
        airport.getTerminals().forEach(terminal -> terminals.put(terminal.getName(),
                terminal.getParkedAircrafts().size()));
        return terminals;
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        List<Flight> flights = new ArrayList<>();
        airport.getTerminals().forEach(terminal -> terminal.getFlights()
                        .forEach(flight -> {if ((flight.getDate()
                                .isBefore(Instant.now()
                                .plusSeconds(3600L * hours))) &
                                        (flight.getDate().isAfter(Instant.now())) &
                                (flight.getType() == Flight.Type.DEPARTURE)) {
                            flights.add(flight);
                        };}));
        return flights;
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        Stream<Flight> stream = Stream.empty();
        if (airport.getTerminals().stream().anyMatch(terminal -> terminal.getName().equals(terminalName))) {
            stream = airport.getTerminals()
                    .get(airport.getTerminals().indexOf((Terminal) (airport.getTerminals().stream()
                            .filter(terminal -> terminal.getName().equals(terminalName))
                            .findFirst().get())))
                    .getFlights().stream().filter(flight -> (flight.getDate().isAfter(Instant.now())) &
                            (flight.getType() == Flight.Type.ARRIVAL))
                    .sorted(Comparator.comparing(Flight::getDate));
        }
        return stream.findFirst();
    }
}