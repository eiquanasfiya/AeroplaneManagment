package repository;

import domain.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlightRepository extends BaseConnection {
    public  List<Flight> getAllFlights(){
        List<Flight> flight = new ArrayList<>();

        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from flight");
            while(rs.next()){
                String flightNumber = rs.getString("flight_number");
                LocalDate date=LocalDate.parse(rs.getString("flight_date"));
                String source=rs.getString("flight_source");
                String destination= rs.getString("flight_destination");
                Double fare= Double.valueOf(rs.getString("fare"));

                flight.add(new Flight(flightNumber,date,source,destination,fare));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flight;
    }

    public List<Flight> getAllFLightsBySrcAndDes(String Source, String Destination) {
        List<Flight> flight = new ArrayList<>();
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from flight where flight_source = '"+Source+"' and flight_destination= '"+Destination+"'");
            while(rs.next()){
                String flightNumber = rs.getString("flight_number");
                LocalDate date=LocalDate.parse(rs.getString("flight_date"));
                String source=rs.getString("flight_source");
                String destination= rs.getString("flight_destination");
                Double fare= Double.valueOf(rs.getString("fare"));

                flight.add(new Flight(flightNumber,date,source,destination,fare));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flight;
    }

    public int getFlightById(String flightNumber){
        int id = 0;
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from flight where flight_number = '"+flightNumber+"'");
            while(rs.next()){
                id = Integer.valueOf(rs.getString("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return id;
    }

    public Boolean addflight(String flight_number, LocalDate date_i, String src, String des, Double fare_e, int id) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO flight "+
                    "(flight_number, flight_date, flight_source, flight_destination, fare, aeroplane_id)"+
                    "VALUES ('"+flight_number+"','"+date_i+"','"+src+"','"+des+"','"+fare_e+"','"+id+"')");
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    public Boolean editflight(String flight_number, LocalDate date_i, String src, String des, Double fare_e, int AeroplaneId,int FlightID) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("update flight set flight_number = '"+flight_number+"',flight_date = '"+date_i+"',flight_source=  '"+src+"',flight_destination = '"+des+"',fare='"+fare_e+"',aeroplane_id='"+AeroplaneId+"' where id = '"+FlightID+"'");
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    public Boolean deleteflight(int id) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("delete from flight where id = '"+id+"'");
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }
}
