package service;

import domain.Flight;
import domain.Passenger;
import repository.FlightRepository;
import repository.PassengerRepository;

import java.util.List;

public class PassengerService {
    public static Boolean booking(String name, String contact, String address, int id) {
        PassengerRepository passengerRepository = new PassengerRepository();
        return passengerRepository.booking(name,contact,address,id);
    }


    public static String[][] getPassengerByFlightNumber(int id) {
        PassengerRepository passengerRepository = new PassengerRepository();
        List<Passenger> passengerList = passengerRepository.getPassengerByFlightNumber(id);
        String[][] data = new String[passengerList.size()][3];
        for(int row = 0 ; row < passengerList.size() ; row++){
            data[row][0] = passengerList.get(row).getName();
            data[row][1] = passengerList.get(row).getPhoneNumber().toString();
            data[row][2] = passengerList.get(row).getAddress();

        }
        return data;
    }
}
