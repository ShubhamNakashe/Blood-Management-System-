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

public class donorinfo {
    private boolean status;
    public donorinfo(String title) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(800, 500);

        frame.add(getTablePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private JPanel getTablePanel() {
        JPanel tableJPanel = new JPanel();
        tableJPanel.setLayout(new BorderLayout());
        String[] columns = {"donor_id", "donor_name", "donor_age", "blood_group", "any_disease", "phone_no"};
        Object[][] data = getdonorinfo();
        JTable donortable = new JTable(data, columns);
        tableJPanel.add(donortable.getTableHeader(), BorderLayout.NORTH);
        tableJPanel.add(donortable, BorderLayout.CENTER);
        return tableJPanel;
    }
    private Object[][] getdonorinfo() {
        Object[][] data = null;
        final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        final String CONNECTION_URL = "jdbc:mysql://localhost:3306/bbms";
        final String USERNAME = "root";
        final String PASSWORD = "shashank";
        final String QUERY = "SELECT donor_id, donor_name, donor_age, blood_group, any_disease, phone_no FROM bbms.donor_reg;";
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(QUERY);
            int rowCount = getRowCount(rs); // Row Count
            int columnCount = getColumnCount(rs); // Column Count
            data = new Object[rowCount][columnCount];


            rs.beforeFirst();
            int i = 0;
            while (rs.next()) {
                int j = 0;

                data[i][j++] = rs.getInt("donor_id");

                data[i][j++] = rs.getString("donor_name");

                data[i][j++] = rs.getInt("donor_age");

                data[i][j++] = rs.getString("blood_group");

                data[i][j++] = rs.getString("any_disease");

                data[i][j++] = rs.getString("phone_no");


                i++;
            }
            status = true;

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

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
        String title = "donor Details Table";
        donorinfo donor_reg = new donorinfo(title);
        System.out.println(donor_reg);
    }
}