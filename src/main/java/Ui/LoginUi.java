package Ui;




import repository.BaseConnection;
import service.AuthnticationService;

import javax.swing.*;
import java.awt.*;

public class LoginUi extends BaseConnection {

    public LoginUi(){
        super();
        JFrame frame = new JFrame("Login");

        JLabel username = new JLabel("username");
        JTextField usernameTf = new JTextField(10);

        JLabel password = new JLabel("password");
        JTextField passwordTf = new JTextField(10);

        JLabel errorLabel = new JLabel();

        JButton login = new JButton();
        login.setBounds(200,300,150,30);
        login.setText("Login");

        JButton logout = new JButton();
        logout.setBounds(200,400,150,30);
        logout.setText("Logout");

        login.addActionListener(btn->{
            String uname = usernameTf.getText();
            String pass = passwordTf.getText();
            String type = AuthnticationService.login(uname,pass);
            if(type.equalsIgnoreCase("user"))
            {
                frame.dispose();
                new UserUi();
            }
            else {
                frame.dispose();
                new AdminUi();
            }

        });


        frame.add(username);
        frame.add(usernameTf);
        frame.add(password);
        frame.add(passwordTf);
        frame.add(login);
        frame.add(logout);
        frame.add(errorLabel);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
