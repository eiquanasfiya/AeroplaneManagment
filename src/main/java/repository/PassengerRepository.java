package repository;

import domain.Passenger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository extends BaseConnection {
    public Boolean booking(String name, String contact, String address, int id) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO passenger "+
                    "(name,contact,address,flight_id)"+
                    "VALUES ('"+name+"','"+contact+"','"+address+"','"+id+"')");
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

    public List<Passenger> getPassengerByFlightNumber(int id) {
        List<Passenger> passengers = new ArrayList<>();
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from passenger where flight_id = '"+id+"' ");
            while(rs.next())
            {
                String name = rs.getString("name");
                String phoneNumber = rs.getString("contact");
                String address =  rs.getString("address");
//                Long val = Long.parseLong(phoneNumber);

                passengers.add(new Passenger(name,phoneNumber,address));
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
        return passengers;
    }
}
