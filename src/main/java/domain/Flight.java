package domain;
import java.time.LocalDate;
import java.util.List;

public class    Flight {
    private String flightNumber;
    private LocalDate date;
    private String source;
    private String destination;
    private Double fare;
    private List<Passenger> passengerList;

    public Flight() {
    }
    public Flight(String flightNumber, LocalDate date, String source, String destination, Double fare) {
        this.flightNumber = flightNumber;
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.fare = fare;

    }

    public Flight(String flightNumber, LocalDate date, String source, String destination, Double fare, List<Passenger> passengerList) {
        this.flightNumber = flightNumber;
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.passengerList = passengerList;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", date=" + date +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", passengerList=" + passengerList +
                '}';
    }
}

