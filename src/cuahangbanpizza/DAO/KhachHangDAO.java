/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.KhachHang;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

// xuất danh sách khách hàng  
// Tìm kiếm thông tin 1 khách hàng 
// Xoas khách hàng 
// Thêm khách hàng
// Update khách hàng 

public class KhachHangDAO {
    
    //Lấy ra danh sách các khách hàng có trường TinhTrang = 1 (đang hoạt động )
    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> dskh = new ArrayList<>();
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
             String sql = "SELECT * FROM Danh_Sach_Khach_Hang WHERE TinhTrang=1";
             MyConnect myConnect = new MyConnect();
             con = myConnect.getConnection();
             prep = con.prepareStatement(sql);
             rs = prep.executeQuery();
             while (rs.next()) {
                 KhachHang kh = new KhachHang();
                 kh.setMakh(rs.getString(1));
                 kh.setHo(rs.getString(2));
                 kh.setTen(rs.getString(3));
                 kh.setGioitinh(rs.getString(4));
                 kh.setNgaysinh(rs.getString(5));
                 kh.setSdt(rs.getString(6));
                 kh.setDiachi(rs.getString(7));
                 dskh.add(kh);
             }
         } catch (SQLException ex) {
             ex.printStackTrace(); // In ra stack trace của lỗi
         } finally {
        // Đóng ResultSet, PreparedStatement và Connection
             try {
                 if (rs != null) {
                     rs.close();
                 }
                 if (prep != null) {
                     prep.close();
                 }
                 if (con != null) {
                     con.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace(); // In ra stack trace của lỗi
             }
         }
         return dskh;
     }
    
     public KhachHang getKhachHang(int maKH) {
         KhachHang kh = null;
         Connection con = null;
         PreparedStatement prep = null;
         ResultSet rs = null;
         try {
             String sql = "SELECT * FROM khachhang WHERE MaKH=? AND TinhTrang=1";
             MyConnect myConnect = new MyConnect();
             con = myConnect.getConnection();
             prep = con.prepareStatement(sql);
             prep.setInt(1, maKH); // Thiết lập tham số trước khi thực thi truy vấn
             rs = prep.executeQuery(); // Thực thi truy vấn
             while (rs.next()) {
                 kh = new KhachHang();
                 kh.setMakh(rs.getString(1));
                 kh.setHo(rs.getString(2));
                 kh.setTen(rs.getString(3));
                 kh.setGioitinh(rs.getString(4));
                 kh.setNgaysinh(rs.getString(5));
                 kh.setSdt(rs.getString(6));
                 kh.setDiachi(rs.getString(7));                
             }
         } catch (SQLException ex) {
             ex.printStackTrace(); // In ra stack trace của lỗi để kiểm tra và sửa
         } finally {
        // Đóng tất cả các tài nguyên
             try {
                 if (rs != null) {
                     rs.close();
                 }
                 if (prep != null) {
                     prep.close();
                 }
                 if (con != null) {
                     con.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace(); // In ra stack trace của lỗi
             }
         }
         return kh;
     }

    //Thêm 1 khách hàng vào trong bảng Danh_Sach_Khach_Hang trong cơ sở dữ liệu
    // Thêm thành công trả về true , ngược lại false
    public boolean addKhachHang(KhachHang kh) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?,?,?,?,1)";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, kh.getMakh());
            prep.setString(2, kh.getHo());
            prep.setString(3, kh.getTen());
            prep.setString(4, kh.getGioitinh());
            prep.setString(5, kh.getNgaysinh());
            prep.setString(6, kh.getSdt());
            prep.setString(7, kh.getDiachi());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra stack trace của lỗi
        } finally {
        // Đóng PreparedStatement và Connection
            try {
                if (prep != null) {
                    prep.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // In ra stack trace của lỗi
            }
        }
        return result;
    }

    public boolean deleteKhachHang(int maKH) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "UPDATE Danh_Sach_Khach_Hang SET TinhTrang=0 WHERE MaKH=?";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setInt(1, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra stack trace của lỗi
            result = false;
        } finally {
        // Đóng PreparedStatement và Connection
            try {
                if (prep != null) {
                     prep.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // In ra stack trace của lỗi
            }
         }
         return result;
    }

    public boolean updateKhachHang(int maKH, KhachHang kh) {
         Connection con = null;
         PreparedStatement prep = null;
         boolean result = false;
         try {
             String sql = "UPDATE Danh_Sach_Khach_Hang SET Ho=?, Ten=?, GioiTinh=?, NgaySinh=?, SoDienthoai=?, DiaChi=? WHERE MaKH=?";
             MyConnect myConnect = new MyConnect();
             con = myConnect.getConnection();
             prep = con.prepareStatement(sql);
             prep.setString(1, kh.getHo());
             prep.setString(2, kh.getTen());
             prep.setString(3, kh.getGioitinh());
             prep.setString(4, kh.getNgaysinh());
             prep.setString(5, kh.getSdt());
             prep.setString(6, kh.getDiachi());
             prep.setInt(7, maKH);
             result = prep.executeUpdate() > 0;
         } catch (SQLException ex) {
             ex.printStackTrace(); // In ra stack trace của lỗi
         } finally {
        // Đóng PreparedStatement và Connection
             try {
                 if (prep != null) {
                     prep.close();
                 }
                 if (con != null) {
                     con.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace(); // In ra stack trace của lỗi
             }
         }
         return result;
     }
    
//    public boolean nhapExcel(KhachHang kh) {
//        try {
//            String sql = "DELETE * FROM Danh_Sach_Khach_Hang; " +
//                    "INSERT INTO Danh_Sach_Khach_Hang(Ho, Ten, GioiTinh, NgaySinh, SoDienThoai,DiaChi) " +
//                    "VALUES(?, ?, ?, ?, ?, ?)";
//            PreparedStatement prep = MyConnect.con.prepareStatement(sql);
//            prep.setString(1, kh.getHo());
//            prep.setString(2, kh.getTen());
//            prep.setString(3, kh.getGioitinh());
//            prep.setString(4, kh.getNgaysinh());
//            prep.setString(5, kh.getSdt());
//            prep.setString(6, kh.getDiachi());
//            return true;
//        } catch (SQLException ex) {
//        }
//        return false;
//    }

    
}
