package BBMS;

/*import java.awt.EventQueue;
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

public class patientRegister extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField patientname;
    private JPanel contentPane;
    private JTextField patientid;

    private JTextField patientage;
    private JTextField bloodgroup;
    private JTextField anydisease;
    private JTextField no;
    private JTextField bloodquantity;
    private JButton btnNewButton;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Donationform frame = new Donationform();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public patientRegister() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("blood donation form");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewUserRegister.setBounds(362, 32, 325, 30);
        contentPane.add(lblNewUserRegister);

        JLabel lblpatientid = new JLabel("patient_id");
        lblpatientid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpatientid.setBounds(58, 72, 99, 23);
        contentPane.add(lblpatientid);

        JLabel lblpatient_name = new JLabel("patient_name");
        lblpatient_name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpatient_name.setBounds(58, 151, 300, 29);
        contentPane.add(lblpatient_name);

        JLabel lblpatient_age = new JLabel("patient_age");
        lblpatient_age.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpatient_age.setBounds(550, 72, 300, 36);
        contentPane.add(lblpatient_age);

        JLabel lblbloodgroup = new JLabel("blood_group");
        lblbloodgroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblbloodgroup.setBounds(58, 243, 300, 36);
        contentPane.add(lblbloodgroup);

        JLabel lblanydisease = new JLabel("any_disease");
        lblanydisease.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblanydisease.setBounds(58, 320, 300, 36);
        contentPane.add(lblanydisease);

        JLabel lblphone_no = new JLabel("phone_no");
        lblphone_no.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblphone_no.setBounds(550, 151, 300, 36);
        contentPane.add(lblphone_no);

        JLabel lblbloodquantity = new JLabel("blood_quantity");
        lblbloodquantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblbloodquantity.setBounds(550, 243, 200, 36);
        contentPane.add(lblbloodquantity);

        donorid = new JTextField();
        donorid.setFont(new Font("Tahoma", Font.PLAIN, 32));
        donorid.setBounds(214, 72, 228, 50);
        contentPane.add(donorid);
        donorid.setColumns(10);

        donorname = new JTextField();
        donorname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        donorname.setBounds(707, 72, 228, 50);
        contentPane.add(donorname);
        donorname.setColumns(10);

        donorage = new JTextField();

        donorage.setFont(new Font("Tahoma", Font.PLAIN, 32));
        donorage.setBounds(214, 151, 228, 50);
        contentPane.add(donorage);
        donorage.setColumns(10);

        bloodgroup = new JTextField();
        bloodgroup.setFont(new Font("Tahoma", Font.PLAIN, 32));
        bloodgroup.setBounds(214, 243, 228, 50);
        contentPane.add(bloodgroup);
        bloodgroup.setColumns(10);


        anydisease = new JTextField();
        anydisease.setFont(new Font("Tahoma", Font.PLAIN, 32));
        anydisease.setBounds(707, 235, 228, 50);
        contentPane.add(anydisease);
        anydisease.setColumns(10);

        no = new JTextField();
        no.setFont(new Font("Tahoma", Font.PLAIN, 32));
        no.setBounds(707, 151, 228, 50);
        contentPane.add(no);
        no.setColumns(10);



        bloodquantity = new JTextField();
        bloodquantity.setFont(new Font("Tahoma", Font.PLAIN, 32));
        bloodquantity.setBounds(214, 320, 228, 50);
        contentPane.add(bloodquantity);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String  donor_id= donorid.getText();
                String donor_name = donorname.getText();
                String donor_age = donorage.getText();
                String blood_group = bloodgroup.getText();
                String any_disease = anydisease.getText();
                String phone_no = no.getText();
                int len = phone_no.length();
                String blood_quantity = bloodquantity.getText();

                String msg = "" + donor_id;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "shashank");

                    String query = "INSERT INTO donor_reg values('" + donor_id + "','" + donor_age + "','" + donor_name + "','" +
                            phone_no + "','" + blood_group + "','" + blood_quantity + "','"+any_disease+"')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(499, 456, 259, 74);
        contentPane.add(btnNewButton);
        JButton btnNewButton1 = new JButton("Back");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton1.setBounds(245, 456, 259, 74);
        btnNewButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                start ah = new start();
                ah.setTitle("start");
                ah.setVisible(true);
            }
        });
        contentPane.add(btnNewButton1);
    }
}
*/