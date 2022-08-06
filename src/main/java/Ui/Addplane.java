package Ui;



import domain.Aeroplane;
import service.AeroplaneService;

import javax.swing.*;
import java.util.ArrayList;

public class Addplane {
    public Addplane(){
        JFrame frame = new JFrame();

        JTextField plane_name = new JTextField("Plane Name");
        JTextField plane_capacity = new JTextField("Plane capacity");
        JTextField plane_airline = new JTextField("Plane Airline");
        JButton add = new JButton();
        add.setText("add plane");
        JButton back = new JButton("back");



        plane_name.setBounds(100,180,200,50);
        plane_capacity.setBounds(100,280,200,50);
        plane_airline.setBounds(100,380,200,50);
        add.setBounds(100,480,200,50);
        back.setBounds(100,580,200,50);

        add.addActionListener(add_plane->{
            String pl_name = plane_name.getText();
            Integer pl_capacity = Integer.parseInt(plane_capacity.getText());
            String pl_airline = plane_airline.getText();
            Boolean flag = AeroplaneService.addplane(pl_name,pl_capacity,pl_airline);
            if(flag){
                JOptionPane.showMessageDialog(frame,"Aeroplane Added");
            }else {
                JOptionPane.showMessageDialog(frame,"Aeroplane Not Added");
            }
        });

        back.addActionListener(bk->{
            frame.dispose();
            new Lookupplanes();
        });


        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(plane_name);
        frame.add(plane_capacity);
        frame.add(plane_airline);
        frame.add(add);
        frame.add(back);
    }
}

