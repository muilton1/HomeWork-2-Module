package homework_2.aviasales.service;

import homework_2.aviasales.dto.Flights;
import homework_2.aviasales.dao.FlightsPoolDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsPoolDaoService {
    private List<Flights> filtered;
    private FlightsPoolDao dao = new FlightsPoolDao();
    public FlightsPoolDaoService() {
        this.filtered = new ArrayList<>();
    }
    public List<Flights> filterByAirportsAndDate(String fromAirport, String toAirport, String fromDate, String toDate) {
        List<Flights> flights = dao.getAll();
        if (fromAirport != null) {
            flights.removeIf(flight -> !flight.getDeparture_airport().equals(fromAirport));
        }
        if (toAirport != null) {
            flights.removeIf(flight -> !flight.getArrival_airport().equals(toAirport));
        }
        if (!fromDate.equals("")) {
            flights.removeIf(flight -> !flight.getScheduled_departure().substring
                    (flight.getScheduled_departure().indexOf('\'') + 1, flight.getScheduled_departure().indexOf(' ')).equals(fromDate));
        }
        if (!toDate.equals("")) {
            flights.removeIf(flight -> !flight.getScheduled_arrival().substring
                    (flight.getScheduled_arrival().indexOf('\'') + 1, flight.getScheduled_arrival().indexOf(' ')).equals(toDate));
        }
        return flights;
    }

    public String clean(String toClean) {
        if (!toClean.equals("")) {
            List<String> words = new ArrayList<>();
            Collections.addAll(words, toClean.split("'"));
            words.removeIf(s -> s.length() != 3);
            return words.get(0);
        } else {
            return null;
        }
    }

    public List<Flights> getPage(List<Flights> filtered, int pageNumber) {
        int skipCount = (pageNumber - 1) * 25;

        return filtered
                .stream()
                .skip(skipCount)
                .limit(25)
                .collect(Collectors.toList());
    }
}
