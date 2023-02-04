package BBMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class info implements ActionListener {

    JFrame frame1;


    JButton fetchButton;


    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;


    info() {

        frame1 = new JFrame();
        frame1.setTitle("Search Database");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();

        frame1.setLayout(bagLayout);
        frame1.setBounds(300, 90, 1014, 597);

        bagConstraints.insets = new Insets(15, 40, 0, 0);


        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);


        fetchButton.addActionListener(this);


        frame1.setVisible(true);
        frame1.validate();


    }

    public static void main(String[] args) {
        new info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fetchButton) {


            frameSecond();

        }


    }


    public void frameSecond() {


        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());

        frame2.setBounds(300, 90, 1014, 597);


        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("password");


        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "shashank");//Crating connection with database
            statement = connection.createStatement();
            String query = "select * from bbms.donordata";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {


                String userName = resultSet.getString("userName");

                String password = resultSet.getString("password");

                defaultTableModel.addRow(new Object[]{userName, password});
                defaultTableModel.addRow(new Object[]{userName, password});

                frame2.setVisible(true);

                break;


            }
            frame2.setVisible(true);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}