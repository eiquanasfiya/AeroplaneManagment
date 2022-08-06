package Ui;
import service.FlightService;
import service.PassengerService;

import javax.swing.*;
import java.awt.*;

public class BookPessengerUI {


    public BookPessengerUI(){
        JFrame frame = new JFrame("AIRPORT SYSTEM");
        Container container=frame.getContentPane();

        JPanel topPanel=new JPanel();
        JPanel bottomPanel=new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0,0,1000,100);
        bottomPanel.setBounds(0,100,1000,800);
        bottomPanel.setBackground(Color.lightGray);

//
        JLabel title=new JLabel("BOOKING-PANEL");
        JLabel passengerN=new JLabel("Passenger Name");
        JTextField passengerName=new JTextField(10);
        JLabel passengerCon=new JLabel("Passenger Contact");
        JTextField passengerContact=new JTextField(10);
        JLabel passengerAddress=new JLabel("Passenger Address");
        JTextField passengerAddresstf=new JTextField(10);

        JLabel flightId=new JLabel("Flight ID");
        JTextField flightIdTf=new JTextField(10);

        JButton book = new JButton("Book");


        JButton backButton = new JButton("<");

        title.setBounds(10,30,400,60);

        passengerN.setBounds(250,50,150,35);
        passengerName.setBounds(400,50,150,35);
        passengerCon.setBounds(250,100,150,35);
        passengerContact.setBounds(400,100,150,35);

        passengerAddress.setBounds(250,150,150,35);
        passengerAddresstf.setBounds(400,150,150,35);

        flightId.setBounds(250,200,150,35);
        flightIdTf.setBounds(400,200,150,35);

        book.setBounds(400,250,150,35);


        backButton.setBounds(900,5,50,50);
        title.setFont(new Font("Serif",Font.BOLD,35));
//
//        searchLookupFlights.addActionListener(btn->{
//            String src= passengerName.getText();
//            String dest=PassengerContact.getText();
//            String column[]={"FlightNumber","Date","Source","Destination","Fare"};
//            String data[][] = FlightService.getAllFLightsForJTable(column.length,src,dest);
//            JTable jt=new JTable(data,column);
//            JScrollPane sp=new JScrollPane(jt);
//            sp.setBounds(0,0,800,500);
//            bottomPanel.add(sp);
//        });
//
        backButton.addActionListener(btn->{
            frame.dispose();
            new UserUi();
        });


        topPanel.add(title);
        bottomPanel.add(passengerName);
        bottomPanel.add(passengerN);
        bottomPanel.add(passengerContact);
        bottomPanel.add(passengerCon);
        bottomPanel.add(passengerAddress);
        bottomPanel.add(passengerAddresstf);
        bottomPanel.add(flightId);
        bottomPanel.add(flightIdTf);
        bottomPanel.add(book);
        topPanel.add(backButton);

//
        container.add(topPanel);
        container.add(bottomPanel);

//
        book.addActionListener(bk->{
            System.out.println(passengerName.getText());
            System.out.println(passengerContact.getText());
            System.out.println(passengerAddresstf.getText());
            System.out.println(flightIdTf.getText());
            int id = FlightService.getFlightById(flightIdTf.getText());

            Boolean flightBooking = PassengerService.booking(passengerName.getText(),passengerContact.getText(),
                    passengerAddresstf.getText(),id);

            if(flightBooking){
                JOptionPane.showMessageDialog(frame,"Booking confirmed");
            }else {
                JOptionPane.showMessageDialog(frame,"Booking failed");
            }

        });
        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
