package Ui;
import service.AeroplaneService;
import service.FlightService;

import javax.swing.*;
import java.util.ArrayList;

public class DeletePlane {
    public DeletePlane(){
        JFrame frame = new JFrame();

        JTextField airline = new JTextField("Airline");
        JButton delete = new JButton();
        delete.setText("delete plane");
        JButton back = new JButton("back");



        airline.setBounds(100,180,200,50);
        delete.setBounds(100,280,200,50);
        back.setBounds(100,380,200,50);


        delete.addActionListener(add_plane->{
            String airline_name = airline.getText();
            int id = AeroplaneService.getAeroplaneById(airline_name);
            Boolean flag = AeroplaneService.deleteplane(id);
            if(flag){
                JOptionPane.showMessageDialog(frame,"Aeroplane Deleted");
            }else {
                JOptionPane.showMessageDialog(frame,"Aeroplane Not Deleted");
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
        frame.add(airline);
        frame.add(delete);
        frame.add(back);
    }
}
