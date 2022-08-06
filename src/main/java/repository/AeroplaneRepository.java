package repository;

import domain.Aeroplane;
import domain.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AeroplaneRepository extends BaseConnection{
    public int getAeroplaneById(String airline) {
        int id = 0;
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from aeroplane where airline = '"+airline+"'");
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

    public List<Aeroplane> getallplane() {
        List<Aeroplane> aeroplanes = new ArrayList<>();

        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplane");
            while(rs.next()){
                String name = rs.getString("aeroplane_name");
                Integer capacity=Integer.valueOf(rs.getString("capacity"));
                String airline=rs.getString("airline");


                aeroplanes.add(new Aeroplane(name,capacity,airline));
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
        return aeroplanes;
    }

    public Boolean addplane(String pl_name, Integer pl_capacity, String pl_airline) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO aeroplane "+
                    "(aeroplane_name, capacity, airline)"+
                    "VALUES ('"+pl_name+"','"+pl_capacity+"','"+pl_airline+"')");
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

    public Boolean editaeroplane(String plane_name, int plane_capacity, String plane_airline,int id) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("update aeroplane set aeroplane_name = '"+plane_name+"',capacity = '"+plane_capacity+"',airline=  '"+plane_airline+"' where id = '"+id+"'");
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

    public Boolean deleteplane(int id) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("delete from aeroplane where id = '"+id+"'");
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
