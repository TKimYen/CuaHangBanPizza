package QuanLyPizza.DAO;

import MyCustom.MyDialog; 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
public class MyConnect {

    public static Connection conn = null;
    private String severName="localhost";
    private String dbName="quanlypizza";
    private String userName="root";
    private String password="1234";
    
    public MyConnect() throws ClassNotFoundException {
        String strConnect = "jdbc:mysql://" + severName + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(strConnect, userName, password);
        }  catch (SQLException ex) {
            new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
            System.exit(0);
        }

    }
}
