package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.NhanVien;
import MyCustom.MyDialog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

// xuất danh sách nhân viên 
// Tìm kiếm thông tin 1 nhân viên 
// Xoa nhân viên 
// Thêm nhân viên 
// Update nhân viên 
public class NhanVienDAO {

    //Lấy danh sách các đối tượng nhân viên 
    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Danh_Sach_Nhan_Vien WHERE TinhTrang=1";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getString(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioitinh(rs.getString(4));
                nv.setNgaysinh(rs.getString(5));
                nv.setSdt(rs.getString(6));
                nv.setCV(rs.getString(7));
                nv.setLuong(rs.getDouble(8));
                dsnv.add(nv);
            }
        } catch (SQLException ex) {
             ex.printStackTrace(); // In ra stack trace của lỗi
        }finally {
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
         return dsnv;

      
    }

    public NhanVien getNhanVien(int maNV) {
        NhanVien nv = null;
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Danh_Sach_Nhan_Vien WHERE MaNV=? AND TinhTrang=1";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setInt(1, maNV); // Thiết lập tham số trước khi thực thi truy vấn
            rs = prep.executeQuery(); // Thực thi truy vấn
            while (rs.next()) {
                nv = new NhanVien();
                nv.setManv(rs.getString(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioitinh(rs.getString(4));
                nv.setNgaysinh(rs.getString(5));
                nv.setSdt(rs.getString(6));
                nv.setCV(rs.getString(7));
                nv.setLuong(rs.getInt(8));
            }
        } catch (SQLException ex) {
             ex.printStackTrace(); // In ra stack trace của lỗi để kiểm tra và sửa
        }finally {
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
         return nv;
    }
    
    public boolean addNhanVien(NhanVien nv) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "INSERT INTO NhanVien(Ho, Ten, GioiTinh, NgaySinh, SoDienThoai, ChucVu, Luong) " +
                    "VALUES(?, ?, ?, ?)";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, nv.getHo());
            prep.setString(2, nv.getTen());
            prep.setString(3, nv.getGioitinh());
            prep.setString(4, nv.getNgaysinh());
            prep.setString(5, nv.getSdt());
            prep.setString(6, nv.getCV());
            prep.setDouble(7, nv.getLuong());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra stack trace của lỗi
        }finally {
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

    

    public boolean deleteNhanVien(int maNV) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "DELETE FROM Danh_Sach_Nhan_Vien SET TinhTrang =0 WHERE MaNV=?";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setInt(1, maNV);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra stack trace của lỗi
            result = false;
        }finally {
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

    
    public boolean updateNhanVien(int maNV, NhanVien nv) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "UPDATE Danh_Sach_Nhan_Vien SET Ho=?, Ten=?, GioiTinh=?, NgaySinh =?, SoDienThoai =?, ChucVu=? , Luong=? WHERE MaNV=?";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, nv.getHo());
            prep.setString(2, nv.getTen());
            prep.setString(3, nv.getGioitinh());
            prep.setString(4, nv.getNgaysinh());
            prep.setString(5, nv.getSdt());
            prep.setString(6, nv.getCV());
            prep.setDouble(7, nv.getLuong());
            prep.setString(8, nv.getManv());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra stack trace của lỗi
        }finally {
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
    
//    public boolean nhapExcel(NhanVien nv) {
//        try {
//            String sql = "DELETE * FROM nhanvien; " +
//                    "INSERT INTO NhanVien(Ho, Ten, GioiTinh, NgaySinh, SoDienThoai, ChuVu, Luong) " +
//                    "VALUES(?, ?, ?, ?)";
//            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
//            pre.setString(1, nv.getHo());
//            pre.setString(2, nv.getTen());
//            pre.setString(3, nv.getGioitinh());
//            pre.setString(4, nv.getNgaysinh());
//            pre.setString(5, nv.getSdt());
//            pre.setString(6, nv.getCV());
//            pre.setDouble(7, nv.getLuong());
//            return true;
//        } catch (SQLException ex) {
//        }
//        return false;
//    }

    
}
