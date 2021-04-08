import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reservation implements ActionListener {

    JFrame frame;
    String[] country = {"Romania", "Ungaria", "SUA", "Brasil", "China", "Australia",
            "Arabia", "Austria", "Grecia", "Canada"};
    String[] sports = {"Snowboarding", "Skateboarding", "Surfing", "Parachute", "Parapante"};
    String[] month = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};
    String[] day = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"
            , "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    String[] year = {"2021", "2022"};
    JLabel nameLabel = new JLabel("NAME");
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel countryLabel = new JLabel("COUNTRY");
    JLabel extremeSport = new JLabel("SPORT");
    JLabel dayLabel = new JLabel("DAY");
    JLabel monthLabel = new JLabel("MONTH");
    JLabel yearLabel = new JLabel("YEAR");

    JComboBox countryComboBox = new JComboBox(country);
    JComboBox sportComboBox = new JComboBox(sports);
    JComboBox dayComoBox=new JComboBox(day);
    JComboBox monthComboBox=new JComboBox(month);
    JComboBox yearComboBox=new JComboBox(year);

    JTextField nameTextField = new JTextField();


    JTextField emailTextField = new JTextField();
    JButton registerButton = new JButton("RESERVATION");
    JButton resetButton = new JButton("RESET");


    Reservation() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40, 40, 380, 600);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(20, 20, 40, 70);
        countryLabel.setBounds(20, 70, 80, 70);
        extremeSport.setBounds(20, 120, 100, 70);
        dayLabel.setBounds(20, 170, 100, 70);
        dayComoBox.setBounds(180, 193, 165, 23);
        monthLabel.setBounds(20, 220, 140, 70);
        monthComboBox.setBounds(180, 243, 165, 23);
        yearLabel.setBounds(20, 270, 100, 70);
        yearComboBox.setBounds(180, 293, 165, 23);
        emailLabel.setBounds(20, 320, 100, 70);
        nameTextField.setBounds(180, 43, 165, 23);
        countryComboBox.setBounds(180, 93, 165, 23);
        sportComboBox.setBounds(180, 143, 165, 23);

        emailTextField.setBounds(180, 343, 165, 23);
        registerButton.setBounds(30, 400, 150, 35);
        resetButton.setBounds(220, 400, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(nameLabel);
        frame.add(emailLabel);
        frame.add(extremeSport);
        frame.add(countryLabel);
        frame.add(dayComoBox);
        frame.add(yearLabel);
        frame.add(yearComboBox);
        frame.add(monthComboBox);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(countryComboBox);
        frame.add(sportComboBox);
        frame.add(dayLabel);
        frame.add(monthLabel);
        frame.add(yearLabel);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }

    public void actionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        PrintWriter csvWriter = null;
        try {

            StringBuffer oneLineStringBuffer = new StringBuffer();

            String filename = "reservations.csv";
            File file = new File(filename);
            if (!file.exists()) {
                file = new File(filename);

            }
            try {
                csvWriter = new PrintWriter(new FileWriter(file, true));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            oneLineStringBuffer.append("\n");
            oneLineStringBuffer.append(nameTextField.getText());
            oneLineStringBuffer.append(",");
            oneLineStringBuffer.append((String)countryComboBox.getSelectedItem());
            oneLineStringBuffer.append(",");
            oneLineStringBuffer.append((String)sportComboBox.getSelectedItem());
            oneLineStringBuffer.append(",");
            oneLineStringBuffer.append((String)dayComoBox.getSelectedItem());
            oneLineStringBuffer.append(",");
            oneLineStringBuffer.append((String)monthComboBox.getSelectedItem());
            oneLineStringBuffer.append(",");
            oneLineStringBuffer.append((String)yearComboBox.getSelectedItem());
            oneLineStringBuffer.append(",");
            oneLineStringBuffer.append(emailTextField.getText());


            csvWriter.print(oneLineStringBuffer);
JOptionPane.showMessageDialog(null,"Reservation succesfully");
            csvWriter.close();
            System.exit(0);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}