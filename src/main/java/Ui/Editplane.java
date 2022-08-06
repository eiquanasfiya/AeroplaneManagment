package Ui;




import service.AeroplaneService;
import service.FlightService;

import javax.swing.*;

public class Editplane {
    public Editplane(){
        JFrame frame = new JFrame();

        JTextField name = new JTextField("Plane Name");
        JTextField capacity = new JTextField("Plane Capacity");
        JTextField airline = new JTextField("Plane Airline");
        JButton edit = new JButton();
        edit.setText("edit");
        JButton back = new JButton();
        back.setText("Back");

        name.setBounds(100,80,200,50);
        capacity.setBounds(100,160,200,50);
        airline.setBounds(100,240,200,50);
        edit.setBounds(100,320,200,50);
        back.setBounds(100,400,200,50);

        edit.addActionListener(dp->{
            String plane_name = name.getText();
            int plane_capacity = Integer.parseInt(capacity.getText());
            String plane_airline = airline.getText();
            int id = AeroplaneService.getAeroplaneById(plane_airline);
            Boolean flag = AeroplaneService.editaeroplane(plane_name,plane_capacity,plane_airline,id);
            if(flag){
                JOptionPane.showMessageDialog(frame,"Aeroplane Edited");
            }else {
                JOptionPane.showMessageDialog(frame,"Aeroplane Not Edited");
            }
        });
        back.addActionListener(bk->{
            frame.dispose();
            new Lookupplanes();
        });

        frame.add(name);
        frame.add(capacity);
        frame.add(airline);
        frame.add(edit);
        frame.add(back);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
