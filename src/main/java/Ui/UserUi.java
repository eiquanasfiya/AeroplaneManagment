package Ui;



import javax.swing.*;

public class UserUi {

    public UserUi(){
        JFrame frame = new JFrame("User Panel");
        JButton btnLookupFlight = new JButton();
        btnLookupFlight.setBounds(100,100,250,30);
        btnLookupFlight.setFocusable(false);
        btnLookupFlight.setText("Lookup Flights");

        btnLookupFlight.addActionListener(btn->{
            frame.dispose();
            new LookUpUi();
        });

        JButton btnBookPassenger = new JButton();
        btnBookPassenger.setBounds(100,200,250,30);
        btnBookPassenger.setFocusable(true);
        btnBookPassenger.setText("Book Passenger");

        btnBookPassenger.addActionListener(bbp->{
            frame.dispose();
            new BookPessengerUI();
        });
        JButton btnPassengerInquiry = new JButton();
        btnPassengerInquiry.setBounds(100,300,250,30);
        btnPassengerInquiry.setFocusable(false);
        btnPassengerInquiry.setText("Passenger Inquiry");

        btnPassengerInquiry.addActionListener(b->{
            frame.dispose();
            new PassengerInquiryUi();
        });

        frame.add(btnLookupFlight);
        frame.add(btnBookPassenger);
        frame.add(btnPassengerInquiry);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

