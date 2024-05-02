package QuanLyPizza.DAO;

import MyCustom.MyDialog;

import java.io.BufferedReader;
//import class BufferedReader từ package java.io
//Sử dụng để đọc dữ liệu văn bản từ một luồng đầu vào kí tự từng dòng một 
import java.io.FileInputStream;
////Sử dụng để mở một luồng đầu vò để đọc dữ liệu từ một tệp trên hệ thống tệp của máy tính 
import java.io.InputStreamReader;
//Sử dụng để kết nối giưa các luồng byte và luồng kí tự 
// Đọc byte từ một luồng đâu fvaof và giải mã chúng thành các kí tự sử dụng một charset chỉ định 
import java.sql.Connection;
//Kết nối cơ sở dữ liệu 
//CUng cấp các phương thức để thực thi các truy vấn SQL, thao tác với dữ liệu và đóng kết nối 
import java.sql.SQLException;
//Lớp ngoại lệ được ném khi xảy ra lỗi trong quá trình kết nối hoặc thao tác với dữ liệu 
import java.util.Properties;
//Là một tập hợp các cặp key-value được sử dụng để luuw trữ các thuộc tính câu hình cho kết nối cơ sở dữ liệu 
import java.sql.*;
import com.mysql.jdbc.Driver;
public class MyConnect {

    public static Connection conn = null;
    private String severName="localhost";
    private String dbName="quanlypizza";
    private String userName="root";
    private String password="1234";
    
    public MyConnect() throws ClassNotFoundException {
//        docFileText();

        String strConnect = "jdbc:mysql://" + severName + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection (replace connection details as needed)
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(strConnect, userName, password);
        }  catch (SQLException ex) {
            new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
            System.exit(0);
        }

    }
//    public Connection getConnection(){
//       Connection con = null;
//       try{
//         
//           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//           String dbUrl ="jdbc:sqlserver://localhost:1433;DatabaseName=quanlypizza";
//           String username ="sa"; String password ="1234";
//           String connectionUrl="jdbc:sqlserver://localhost:1433;"
//                   +"databaseName = Do_an_Java;"
//                   +"user = sa;"
//                   +"password =1234;"
//                   +"encrypt = true;"
//                   +"trustServerCertificate = true;";
//           con = DriverManager.getConnection(connectionUrl);
//       }
//       catch(Exception e){
//           // Xử lý ngoại lệ
//           e.printStackTrace();
//           new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
//            System.exit(0);
//       }
//        return con;
//    }
}
