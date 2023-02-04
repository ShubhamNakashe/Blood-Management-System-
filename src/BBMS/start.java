package BBMS;
import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class start extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    start frame = new start();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public start(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 90, 1400, 597);
            setResizable(false);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
        JButton btnNewButton = new JButton("login as donor");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.setBounds(300, 92, 362, 73);
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                login ah = new login();
                ah.setTitle("donor");
                ah.setVisible(true);
            }
        });
        contentPane.add(btnNewButton);
        JButton btnNewButton1 = new JButton("login as patient");
        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton1.setBounds(300, 182, 362, 73);
        btnNewButton1.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                login1 ah = new login1();
                ah.setTitle("patient");
                ah.setVisible(true);
            }
        });
        contentPane.add(btnNewButton1);
        JButton btnNewButton2 = new JButton("login as admin");
        btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton2.setBounds(300, 282, 362, 73);
        btnNewButton2.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                login2 ah = new login2();
                ah.setTitle("admin");
                ah.setVisible(true);
            }
        });
        contentPane.add(btnNewButton2);
        JButton btnNewButton3 = new JButton("new donor registration");
        btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton3.setBounds(300, 382, 362, 73);
        btnNewButton3.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                Donationform ah = new Donationform();
                ah.setTitle("donationform");
                ah.setVisible(true);
            }
        });
        contentPane.add(btnNewButton3);
        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/B.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel l = new JLabel(j3);
        l.setBounds(5,1,800,600);
        add(l);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


     }
}







