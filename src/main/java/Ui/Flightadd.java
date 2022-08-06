package Ui;





import service.AeroplaneService;
import service.FlightService;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Flightadd {
    public Flightadd(){
        JFrame frame = new JFrame();

        JTextField flightnum = new JTextField("flightnum");
        JTextField date = new JTextField("date");
        JTextField source = new JTextField("source");
        JTextField destination = new JTextField("destination");
        JTextField fare = new JTextField("fare");
        JTextField airline = new JTextField("airline");
        JButton add = new JButton();
        add.setText("Add");
        JButton back = new JButton();
        back.setText("Back");


        flightnum.setBounds(100,80,200,50);
        date.setBounds(100,160,200,50);
        source.setBounds(100,240,200,50);
        destination.setBounds(100,320,200,50);
        fare.setBounds(100,400,200,50);
        airline.setBounds(100,480,200,50);
        back.setBounds(100,640,200,50);
        add.setBounds(100,720,200,50);

        frame.add(flightnum);
        frame.add(date);
        frame.add(source);
        frame.add(destination);
        frame.add(fare);
        frame.add(airline);
        frame.add(add);
        frame.add(back);

        add.addActionListener(ad->{
            String flight_number = flightnum.getText();
            LocalDate date_i = LocalDate.parse(date.getText());
            String src = source.getText();
            String des = destination.getText();
            Double fare_e = Double.valueOf(fare.getText());
            String airline_e = airline.getText();
            int id =AeroplaneService.getAeroplaneById(airline_e);
            System.out.println(id);
            Boolean flag = FlightService.addflight(flight_number,date_i,src,des,fare_e,id);

            if(flag){
                JOptionPane.showMessageDialog(frame,"Flight Added");
            }else {
                JOptionPane.showMessageDialog(frame,"Flight Not Added");
            }


        });

        back.addActionListener(bk->{
            frame.dispose();
            new Lookupflights();
        });





        frame.setSize(1000, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
