import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends JFrame {

    private String username;
    private String password;

    JLabel userLabel;
    JLabel passLabel;

    JTextField userField;
    JPasswordField passField;

    JButton loginButton;
    JButton resetButton;

    LoginPage() {
        configureUserLabel();
        configureUserField();
        configurePassLabel();
        configurePassField();
        configureLoginButton();
        configureResetButton();
        configureLoginPage();
    }

    private void configureLoginPage() {
        setTitle("Login Page");
        setSize(250, 100);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void configurePassField() {
        passField = new JPasswordField();
        add(passField);
    }

    private void configurePassLabel() {
        passLabel = new JLabel("Password:");
        passLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        add(passLabel);
    }

    private void configureUserField() {
        userField = new JTextField();
        add(userField);
    }

    private void configureUserLabel() {
        userLabel = new JLabel("User:");
        userLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        add(userLabel);
    }

    private void configureResetButton() {
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
        });
        add(resetButton);
    }

    private void configureLoginButton() {
        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String line = "";
            String splitBy = ",";
            String filename = "users.csv";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(filename));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String[] employee = line.split(splitBy);
                if (employee[3].equals(new String(passField.getPassword()))
                        && employee[0].equals(userField.getText())) {
                    new ExtremeSport();
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Credentiale invalide!", "Mesaj", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        add(loginButton);
    }
}
