import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPage extends JFrame {


        public static void main (String[] args){
            JFrame frame = new JFrame("Start Page");
            frame.setVisible(true);
            frame.setSize(500,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            JButton loginButton = new JButton("Login");
            panel.add(loginButton);
            loginButton.addActionListener(e->{
                new LoginPage();

            });

            JButton registerButton = new JButton("Register");
            panel.add(registerButton);
            registerButton.addActionListener (
                    e->{
                        new RegistrationForm();
                    }
            );
        }

    }
