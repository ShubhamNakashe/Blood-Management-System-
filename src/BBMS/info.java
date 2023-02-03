package BBMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class info implements ActionListener {

    JFrame frame1;//creating object of first JFrame


    JButton fetchButton;//creating object of JButton


    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement clas


    info() {

        frame1 = new JFrame();
        frame1.setTitle("Search Database");//setting the title of first JFrame
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation
        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints

        frame1.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
        frame1.setBounds(300, 90, 1014, 597);

        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components

        //Setting the property of JLabel and adding it to the first JFrame


        //Setting the property of JTextfield and adding it to the first JFrame


        //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);

        //Setting the property of JButton(Reset Data) and adding it to the second JFrame


        //adding ActionListener to both buttons
        fetchButton.addActionListener(this);


        frame1.setVisible(true);//Setting the visibility of First JFrame
        frame1.validate();//Performing relayout of the First JFrame


    }

    public static void main(String[] args) {
        new info();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fetchButton) {


            frameSecond();//passing the text value to frameSecond method

        }


    }


    public void frameSecond() {

        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());

        frame2.setBounds(300, 90, 1014, 597);

        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("password");





        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "shashank");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from bbms.donordata";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
            while (resultSet.next()) {

                //Retrieving details from the database and storing it in the String variables
                String userName = resultSet.getString("userName");

                String password = resultSet.getString("password");

                defaultTableModel.addRow(new Object[]{userName,password});//Adding row in Table
                defaultTableModel.addRow(new Object[]{userName,password});//Adding row in Table

                frame2.setVisible(true);//Setting the visibility of second Frame

                break;


            }
            frame2.setVisible(true);







        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}