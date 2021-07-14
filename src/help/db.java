package help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class db {

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;

    private static void setConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:Help.db");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }

    public static boolean isExistBefore(String name, String password) {
        try {
            setConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from user where id = \"" + password + "\" and name = \"" + name + "\"");
            con.close();
            if (rs.next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "isExistBefore " + ex.getMessage());
        }
        return false;
    }

    public static boolean addUser(String name, String password) {
        try {
            setConnection();
            st = con.createStatement();
            st.execute("insert into user values(\"" + password + "\",\"" + name + "\")");
            con.close();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "addUser" + ex.getMessage());
            try {
                con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public static String[] getDuaSource(int id) {
        String[] str = new String[2];
        try {
            setConnection();
            st = con.createStatement();
            rs = st.executeQuery("select text,source from dua where id = " + id);
            if (rs.next()) {
                str[0] = rs.getString("text");
                str[1] = rs.getString("source");
                con.close();
                System.out.println("It's not null");
                return str;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "getDuaSource    :" + ex.getMessage());
        }
        return null;
    }
}
