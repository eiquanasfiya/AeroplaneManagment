package Ui;
import service.AeroplaneService;
import service.FlightService;

import javax.swing.*;

public class FlightDel {
    public FlightDel(){
        JFrame frame = new JFrame();
        JTextField flight_num = new JTextField("FlightNumber");
        flight_num.setText("Flight Number");
        flight_num.setBounds(10,30,200,50);


        JButton delete_flight = new JButton("Delete Flight");
        delete_flight.setBounds(10,200,200,50);
        JButton back = new JButton("Back");
        back.setBounds(10,300,200,50);

        back.addActionListener(bk->{
            frame.dispose();
            new Lookupflights();
        });

        delete_flight.addActionListener(df->{
            String flight_number = flight_num.getText();
            int id = FlightService.getFlightById(flight_number);
            Boolean flag = FlightService.deleteflight(id);
            if(flag){
                JOptionPane.showMessageDialog(frame,"Flight Deleted");
            }else {
                JOptionPane.showMessageDialog(frame,"Flight Not Deleted");
            }
        });

        frame.add(flight_num);
        frame.add(delete_flight);
        frame.add(back);


        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

