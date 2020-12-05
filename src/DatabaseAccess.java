import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseAccess {

    public static Connection c = null;

    public DatabaseAccess() {

    }

    public static boolean ConnectionDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3380315", "sql3380315", "iy1IhaINnY");
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null,"Connection failed" + x);
            JOptionPane.showMessageDialog(null, x.getMessage() + "2" + x.getCause());
            return false;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error loading the driver" + ex);
            JOptionPane.showMessageDialog(null, ex.getMessage() + "2" + ex.getCause());
            return false;

        }
        return true;
    }


    public static boolean RunMysqlUpdate(String Mysql) {
        try {
            Statement sentencia = c.createStatement();
            sentencia.executeUpdate(Mysql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error" + ex);
            return false;
        }
    }

    public static ResultSet RunMysqlSelect(String Mysql) {
        try {
            Statement sentencia = c.createStatement();
            return sentencia.executeQuery(Mysql);
        } catch (SQLException e) {
            System.out.println("Error" + e);
            return null;
        }
    }

    public static void CloseConnection() {
        try {
            c.close();
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Error");
        }
    }

}
