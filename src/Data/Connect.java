 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaara
 */
public class Connect {
    private  static Connection con;
    private static boolean Connected=false;
    
    public static Connection getConnect(){
        return con;
    }
    public static String testConnect() {
        try{
            con = Connect.getConnect();
            return "Kết nối thành công";
        }
        catch(Exception e) {
            return "Kết nối thất bại";
        }
    } 
    public static void Connection(){
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://ANKHANG:1433;databaseName=QLTV","sa","sa");
            Connected=true;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra", "Thông báo", 2);
        }
    }
    public static boolean isConnected(){
        return Connected;
    }
}
