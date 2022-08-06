package service;

import domain.Flight;
import repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;

public class FlightService {
    public static String[][] getAllFLights() {
        FlightRepository flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getAllFlights();
        String[][] data  = new String[flights.size()][5];
        for(int row = 0 ; row < flights.size() ; row++){
            data[row][0] = flights.get(row).getFlightNumber().toString();
            data[row][1] = flights.get(row).getDate().toString();
            data[row][2] = flights.get(row).getSource();
            data[row][3] = flights.get(row).getDestination();
            data[row][4] = flights.get(row).getFare().toString();
        }
        return data;
    }
    public static String[][] getAllFLightsBySrcAndDes(String source,String Destination) {
        FlightRepository flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getAllFLightsBySrcAndDes(source,Destination);
        String[][] data  = new String[flights.size()][5];
        for(int row = 0 ; row < flights.size() ; row++){
            data[row][0] = flights.get(row).getFlightNumber().toString();
            data[row][1] = flights.get(row).getDate().toString();
            data[row][2] = flights.get(row).getSource();
            data[row][3] = flights.get(row).getDestination();
            data[row][4] = flights.get(row).getFare().toString();
        }
        return data;
    }



    public static int getFlightById(String flightNumber) {
        FlightRepository flightRepository= new FlightRepository();
        return flightRepository.getFlightById(flightNumber);
    }


    public static Boolean addflight(String flight_number, LocalDate date_i, String src, String des, Double fare_e, int id) {
        FlightRepository flightRepository= new FlightRepository();
        return flightRepository.addflight(flight_number,date_i,src,des,fare_e,id);
    }

    public static Boolean editflight(String flight_number, LocalDate date_i, String src, String des, Double fare_e,int AeroplaneId, int FlightId) {
        FlightRepository flightRepository = new FlightRepository();
        return flightRepository.editflight(flight_number,date_i,src,des,fare_e,AeroplaneId,FlightId);
    }

    public static Boolean deleteflight(int id) {
        FlightRepository flightRepository =  new FlightRepository();
        return flightRepository.deleteflight(id);
    }
}
