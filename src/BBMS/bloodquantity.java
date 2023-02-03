package BBMS;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
/**
 *
 * @author Dinesh Krishnan
 *
 */
public class bloodquantity {
    private boolean status;
    public bloodquantity(String title) {
// Creating Window using JFramez
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(800, 500);
// Adding Table View
        frame.add(getTablePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private JPanel getTablePanel() {
        JPanel tableJPanel = new JPanel();
        tableJPanel.setLayout(new BorderLayout());
// Column Header
        String[] columns = {"blood_group","blood_quantity1"};
// Getting Data for Table from Database
        Object[][] data = getbloodquantity();
// Creating JTable object passing data and header
        JTable donortable = new JTable(data, columns);
        tableJPanel.add(donortable.getTableHeader(), BorderLayout.NORTH);
        tableJPanel.add(donortable, BorderLayout.CENTER);
        return tableJPanel;
    }
    private Object[][] getbloodquantity() {
        Object[][] data = null;
        final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        final String CONNECTION_URL = "jdbc:mysql://localhost:3306/bbms";
        final String USERNAME = "root";
        final String PASSWORD = "shashank";
        final String QUERY = "SELECT blood_group, SUM(blood_quantity1) FROM bbms.patient_reg GROUP BY blood_group ;";
        try {
// Loading the Driver
            Class.forName(DRIVER_NAME);
// Getting Database Connection Object by Passing URL, Username and Password
            Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(QUERY);
            int rowCount = getRowCount(rs); // Row Count
            int columnCount = getColumnCount(rs); // Column Count
            data = new Object[rowCount][columnCount];
// Starting from First Row for Iteration
            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                int j = 0;

                data[i][j++] = rs.getString("blood_group");


                data[i][j++] = rs.getInt("SUM(blood_quantity1)");


                i++;
            }
            status = true;
// Closing the Resources;
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    // Method to get Row Count from ResultSet Object
    private int getRowCount(ResultSet rs) {
        try {
            if(rs != null) {
                rs.last();
                return rs.getRow();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    // Method to get Column Count from ResultSet Object
    private int getColumnCount(ResultSet rs) {
        try {
            if(rs != null)
                return rs.getMetaData().getColumnCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public String toString() {
        return (status) ? "Data Listed Successfully" : "Application Error Occured";
    }
    public static void main(String[] args) {
        String title = "Employee Details Table";
        bloodquantity donor_reg = new bloodquantity(title);
        bloodquantity patient_reg = new bloodquantity(title);


        System.out.println(donor_reg);
        System.out.println(patient_reg);
    }
}
