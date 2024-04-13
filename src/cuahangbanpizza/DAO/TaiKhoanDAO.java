/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.TaiKhoan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaiKhoanDAO {

    public boolean themTaiKhoan(String maNV, String tenDangNhap, String quyen) {
        try {
            String sql = "INSERT INTO taikhoan(MaNV, TenDangNhap, MatKhau, Quyen) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, maNV);
            pre.setString(2, tenDangNhap);
            pre.setString(3, tenDangNhap);
            pre.setString(4, quyen);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = '" + tenDangNhap + "'";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTenDangNhapTheoMa(String maNV) {
        try {
            String sql = "SELECT TenDangNhap FROM TaiKhoan WHERE MaNV=" + maNV;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean datLaiMatKhau(String maNV, String tenDangNhap) {
        try {
            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tenDangNhap);
            pre.setString(2, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean datLaiQuyen(String maNV, String quyen) {
        try {
            String sql = "UPDATE TaiKhoan SET Quyen=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, quyen);
            pre.setString(2, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public String getQuyenTheoMa(String maNV) {
        try {
            String sql = "SELECT Quyen FROM TaiKhoan WHERE MaNV=" + maNV;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean doiMatKhau(String maNV, String matKhauCu, String matKhauMoi) {
        try {
            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=? AND MatKhau=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, matKhauMoi);
            pre.setString(2, maNV);
            pre.setString(3, matKhauCu);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean khoaTaiKhoan(String maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThai=0 WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean moKhoaTaiKhoan(String maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThai=1 WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

//    public boolean doiMatKhau(String matKhauCu, String matKhauMoi) {
//        try {
//            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=? AND MatKhau=?";
//            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
//            pre.setString(1, matKhauMoi);
//            pre.setString(2, DangNhapBUS.taiKhoanLogin.getMaNhanVien());
//            pre.setString(3, matKhauCu);
//            return pre.executeUpdate() > 0;
//        } catch (Exception e) {
//        }
//        return false;
//    }

    public int getTrangThai(String ma) {
        try {
            String sql = "SELECT TrangThai FROM TaiKhoan WHERE MaNV=" + ma;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
