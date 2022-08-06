package Ui;
import service.FlightService;
import service.PassengerService;

import javax.swing.*;
import java.awt.*;

public class PassengerInquiryUi {

    public PassengerInquiryUi(){
        JFrame f=new JFrame();
        Container c = f.getContentPane();

        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.lightGray);
        panel1.setBounds(10,10,800,100);
        panel2.setBounds(10,150,800,700);


        JTextField flightId = new JTextField(10);
        flightId.setText("Flight ID");
        flightId.setBounds(20,10,150,30);


        JButton search = new JButton("Search");
        search.setBounds(400,10,150,30);

        JButton back = new JButton("Back");
        back.setBounds(600,10,150,30);

        back.addActionListener(bk->{
            f.dispose();
            new UserUi();
        });

        panel1.add(flightId);
        panel1.add(search);
        panel1.add(back);


        search.addActionListener(s->{
            String fNumber = flightId.getText();
            int id = FlightService.getFlightById(fNumber);



            String column[]={"Name","Contact","Address"};
            String data[][] = PassengerService.getPassengerByFlightNumber(id);

            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(0,0,800,700);
            panel2.add(sp);

        });

        c.add(panel1);
        c.add(panel2);

        f.setLayout(null);
        f.setSize(1000,1000);
        f.setVisible(true);




    }

}

