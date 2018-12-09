package model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {
    private Connection connect = null;

    public Connect() {
    }
    public Connection getConnect(){
        try {
            String url = "jdbc:mysql://localhost:3306/do_an_2";
            String user = "root";
            String pass = "";
            connect = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "không thể kết nối đến cơ sở dữ liệu: " + ex);
        }
        return this.connect;
    }
    
}