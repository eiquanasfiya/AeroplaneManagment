package service;

import domain.Aeroplane;
import domain.Flight;
import repository.AeroplaneRepository;
import repository.FlightRepository;

import javax.swing.*;
import java.util.List;

public class AeroplaneService {
    public static int getAeroplaneById(String airline) {
        AeroplaneRepository aeroplaneRepository = new AeroplaneRepository();
        return aeroplaneRepository.getAeroplaneById(airline);
    }


    public static String[][] getallplane() {
        AeroplaneRepository aeroplaneRepository = new AeroplaneRepository();
        List<Aeroplane> aeroplanes = aeroplaneRepository.getallplane();
        String[][] data = new String[aeroplanes.size()][3];
        for(int row = 0 ; row < aeroplanes.size() ; row++){
            data[row][0] = aeroplanes.get(row).getName();
            data[row][1] = aeroplanes.get(row).getCapacity().toString();
            data[row][2] = aeroplanes.get(row).getAirline();

        }
        return data;
    }

    public static Boolean addplane(String pl_name, Integer pl_capacity, String pl_airline) {
        AeroplaneRepository aeroplaneRepository = new AeroplaneRepository();
        return aeroplaneRepository.addplane(pl_name,pl_capacity,pl_airline);
    }

    public static Boolean editaeroplane(String plane_name, int plane_capacity, String plane_airline,int id) {
        AeroplaneRepository aeroplaneRepository = new AeroplaneRepository();
        return aeroplaneRepository.editaeroplane(plane_name,plane_capacity,plane_airline,id);
    }

    public static Boolean deleteplane(int id) {
        AeroplaneRepository aeroplaneRepository = new AeroplaneRepository();
        return  aeroplaneRepository.deleteplane(id);
    }
}
