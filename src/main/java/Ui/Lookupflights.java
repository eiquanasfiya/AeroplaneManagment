package Ui;




import service.FlightService;

import javax.swing.*;
import java.awt.*;

public class Lookupflights {
    JTable jt;
    JScrollPane sp;

    public Lookupflights(){
        JFrame f=new JFrame();
        Container c = f.getContentPane();

        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();


        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);


        panel1.setBackground(Color.lightGray);
        panel1.setBounds(10,10,800,100);
        panel2.setBounds(10,130,800,700);
        panel3.setBackground(Color.gray);
        panel3.setBounds(10,850,800,100);



        JTextField source = new JTextField(10);
        source.setText("source");
        source.setBounds(20,10,150,30);

        JTextField destination = new JTextField(10);
        destination.setText("destination");
        destination.setBounds(200,10,150,30);

        JButton search = new JButton("Search");
        search.setBounds(400,10,150,30);

        JButton back = new JButton("Back");
        back.setBounds(600,10,150,30);


        back.addActionListener(bk->{
            f.dispose();
            new AdminUi();
        });

        panel1.add(source);
        panel1.add(destination);
        panel1.add(search);
        panel1.add(back);

        String column[]={"FlightNumber","Date","Source","Destination","Fare"};
        String data[][] = FlightService.getAllFLights();

        jt=new JTable(data,column);
        sp=new JScrollPane(jt);
        sp.setBounds(0,0,800,700);
        panel2.add(sp);


        search.addActionListener(s->{
            String column1[]={"FlightNumber","Date","Source","Destination","Fare"};
            String data1[][] = FlightService.getAllFLightsBySrcAndDes(source.getText(),destination.getText());

//            JTable jt1=new JTable(data1,column1);
//            JScrollPane sp1=new JScrollPane(jt);
//            sp.setBounds(0,0,800,700);
//            panel2.add(sp);
            jt = new JTable(data1,column1);
            sp = new JScrollPane(jt);
            sp.setBounds(0,0,800,700);
            panel2.add(sp);
        });

        JButton add = new JButton("add");
        add.setBounds(20,30,150,30);

        JButton Edit = new JButton("edit");
        Edit.setBounds(200,30,150,30);

        JButton delete = new JButton("delete");
        delete.setBounds(400,30,150,30);

        add.addActionListener(af->{
            f.dispose();
            new Flightadd();
        });

        delete.addActionListener(df->{
            f.dispose();
            new FlightDel();
        });

        Edit.addActionListener(ef->{
            f.dispose();
            new Editflight();
        });

        panel3.add(add);
        panel3.add(Edit);
        panel3.add(delete);

        c.add(panel1);
        c.add(panel2);
        c.add(panel3);


        f.setLayout(null);
        f.setSize(1200,1200);
        f.setVisible(true);;





    }
}


