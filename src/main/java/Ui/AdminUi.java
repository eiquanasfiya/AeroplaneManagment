package Ui;


import javax.swing.*;

public class AdminUi {

    public AdminUi(){
        JFrame frame = new JFrame("Admin Panel");
        JButton btnFlight = new JButton();
        btnFlight.setBounds(100,100,150,30);
        btnFlight.setFocusable(false);
        btnFlight.setText("Flight");

        JButton btnPlane = new JButton();
        btnPlane.setBounds(100,200,150,30);
        btnPlane.setFocusable(true);
        btnPlane.setText("Plane");

        JButton btnLogout = new JButton();
        btnLogout.setBounds(100,300,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");

        frame.add(btnFlight);
        frame.add(btnPlane);
        frame.add(btnLogout);

        btnFlight.addActionListener(laf->{
            frame.dispose();
            new Lookupflights();
        });

        btnPlane.addActionListener(plb->{
            frame.dispose();
            new Lookupplanes();
        });

        btnLogout.addActionListener(lg->{
            frame.dispose();
            new LoginUi();
        });

        //   frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}

