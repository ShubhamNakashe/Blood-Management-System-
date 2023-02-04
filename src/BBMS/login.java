package BBMS;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class login extends JFrame implements ActionListener {

    public static final long serialVersionUID = 1L;
    public JTextField textField;
    public JPasswordField passwordField;
    public JButton btnNewButton,btnNewButton1;
    public JLabel label;
    public JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public login () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 90, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Donor");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 118, 281, 55);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 250, 281, 55);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.RED);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 118, 193, 41);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.RED);
        lblPassword.setBackground(Color.RED);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 250, 193, 41);
        contentPane.add(lblPassword);


        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 356, 162, 73);
        btnNewButton.addActionListener(this);
        contentPane.add(btnNewButton);
        btnNewButton1 = new JButton("Back");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(245, 356, 162, 73);
        btnNewButton1.addActionListener(this);


        contentPane.add(btnNewButton1);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton)
            {
                try {
                    if ((textField.getText().equals("donor1")  && passwordField.getText().equals("11111")) || (textField.getText().equals("donor2")  && passwordField.getText().equals("22222")) || (textField.getText().equals("donor3")  && passwordField.getText().equals("donor")) || (textField.getText().equals("donor4")  && passwordField.getText().equals("44444")) ) {
                        setVisible(false);
                        new donorpg().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Enter Valid Username or Password");
                    }
                } catch (Exception ae) {
                    System.out.println(e);
                }

            }
         else if (e.getSource() == btnNewButton1) {
            setVisible(false);
            new start().setVisible(true);
        }
    }
}