package BBMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class donordata implements ActionListener {

    JFrame frame1;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton fetchButton;
    JButton resetButton;

    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;
    int flag=0;


    donordata() {

        frame1 = new JFrame();
        frame1.setTitle("Search Database");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame1.setLayout(bagLayout);
        frame1.setBounds(300, 90, 1014, 597);

        bagConstraints.insets = new Insets(15, 40, 0, 0);
        nameLabel = new JLabel("Enter Donor_Name");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame1.add(nameLabel, bagConstraints);

        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame1.add(nameTextField, bagConstraints);

        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);

        resetButton = new JButton("Reset Data");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        frame1.add(resetButton, bagConstraints);

        fetchButton.addActionListener(this);
        resetButton.addActionListener(this);


        frame1.setVisible(true);
        frame1.validate();

    }

    public static void main(String[] args) {
        new donordata();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fetchButton) {

            String userName = nameTextField.getText().toString();
            frameSecond(userName);
        }
        if (e.getSource() == resetButton) {
            nameTextField.setText("");
        }

    }


    public void frameSecond(String donor_name) {

        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());

        frame2.setBounds(300, 90, 1014, 597);
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 200));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("donor_id");
        defaultTableModel.addColumn("donor_name");
        defaultTableModel.addColumn("donor_age");
        defaultTableModel.addColumn("blood_group");
        defaultTableModel.addColumn("any_disease");
        defaultTableModel.addColumn("phone_no");






        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "shashank");
            statement = connection.createStatement();
            String query = "select * from donor_reg where donor_name = '" + donor_name + "'";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {


                String donor_id = resultSet.getString("donor_id");

                String Name = resultSet.getString("donor_name");
                String donor_age = resultSet.getString("donor_age");
                String blood_group = resultSet.getString("blood_group");
                String any_disease = resultSet.getString("any_disease");
                String phone_no = resultSet.getString("phone_no");


                if (donor_name.equalsIgnoreCase(Name)) {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{donor_id, donor_name, donor_age, blood_group, any_disease, phone_no});//Adding row in Table
                    frame2.setVisible(true);
                    frame2.validate();
                    break;
                }

            }

            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such Username Found");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void setVisible(boolean b) {
    }

    public void setTitle(String donor) {
    }
}