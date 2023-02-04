package BBMS;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class donorRegister extends JFrame implements ActionListener {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField firstname;
    public JTextField lastname;
    public JTextField email;
    public JTextField username;
    public JTextField mob;
    public JPasswordField passwordField;
    public JButton btnNewButton, btnNewButton1;
    JLabel lblNewUserRegister, lblName, lblNewLabel, lblEmailAddress, lblUsername, lblPassword, lblMobileNumber;



   donorRegister() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);
        firstname.addActionListener(this);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);
        lastname.addActionListener(this);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);
        email.addActionListener(this);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);
        username.addActionListener(this);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);


        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);
        mob.addActionListener(this);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);
        passwordField.addActionListener(this);

        btnNewButton = new JButton("Register");

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(499, 456, 259, 74);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(this);
        btnNewButton1 = new JButton("Back");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(245, 456, 259, 74);
        btnNewButton1.addActionListener(this);
        contentPane.add(btnNewButton1);
    }

        public void actionPerformed (ActionEvent e)
        {
            if (e.getSource() == btnNewButton) {
                String fname = firstname.getText();
                String lname = lastname.getText();
                String uname = username.getText();
                String mail = email.getText();
                String pass = passwordField.getText();
                String mobile = mob.getText();
                try {
                    if (fname.equals("")) {
                        JOptionPane.showMessageDialog(null, "Name is Required");
                    } else {
                        conn c = new conn();
                        String query = "insert into register values('" + fname + "','" + lname + "','" + uname + "','" + mail + "','" + pass + "','" + mobile + "')";
                        c.s.executeUpdate(query);
                    }
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }

            else if (e.getSource()== btnNewButton1){
                setVisible(false);
                new start().setVisible(true);
            }
        }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    donorRegister frame = new donorRegister();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
