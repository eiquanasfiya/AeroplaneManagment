package Ui;




import service.AeroplaneService;

import javax.swing.*;
import java.awt.*;

public class Lookupplanes {
    public Lookupplanes(){
        JFrame f=new JFrame();
        Container c = f.getContentPane();

        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.lightGray);
        panel1.setBounds(10,10,800,100);
        panel2.setBounds(10,150,800,700);



        JButton add = new JButton("Add");
        add.setText("Add");
        add.setBounds(20,10,150,30);

        JButton delete = new JButton("delete");
        delete.setText("delete");
        delete.setBounds(200,10,150,30);

        JButton edit = new JButton("edit");
        edit.setBounds(400,10,150,30);

        JButton back = new JButton("Back");
        back.setBounds(600,10,150,30);

        back.addActionListener(bk->{
            f.dispose();
            new AdminUi();
        });

        add.addActionListener(ap->{
            f.dispose();
            new Addplane();
        });
        delete.addActionListener(dp->{
            f.dispose();
            new DeletePlane();
        });
        edit.addActionListener(ep->{
            f.dispose();
            new Editplane();
        });

        panel1.add(add);
        panel1.add(delete);
        panel1.add(edit);
        panel1.add(back);



        String column[]={"name","capacity","airline"};
        String data[][] = AeroplaneService.getallplane();

        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0,0,800,700);
        panel2.add(sp);


        c.add(panel1);
        c.add(panel2);

        f.setLayout(null);
        f.setSize(1000,1000);
        f.setVisible(true);;


    }
}

