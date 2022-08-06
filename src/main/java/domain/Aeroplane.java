package domain;
import java.util.List;

public class Aeroplane {
    private String name;
    private Integer capacity;
    private String airline;
    private List<Flight> flights;

    public Aeroplane() {
    }
    public Aeroplane(String name, Integer capacity, String airline) {
        this.name = name;
        this.capacity = capacity;
        this.airline = airline;

    }
    public Aeroplane(String name, Integer capacity, String airline, List<Flight> flights) {
        this.name = name;
        this.capacity = capacity;
        this.airline = airline;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Aeroplane{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", airline='" + airline + '\'' +
                ", flights=" + flights +
                '}';
    }
}
