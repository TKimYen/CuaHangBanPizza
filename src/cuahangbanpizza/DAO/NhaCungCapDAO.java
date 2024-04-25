package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

// Xuất danh sách nhà cung cấp 
//Tìm kiếm 1 nhà cung cấp 
// Thêm nhà cung cấp 
// Xóa 
// Update1
public class NhaCungCapDAO {

    public ArrayList<NhaCungCap> getListNhaCungCap() {
         ArrayList<NhaCungCap> dsncc = new ArrayList<>();
         Connection con = null;
         PreparedStatement prep = null;
         ResultSet rs = null;
         try {
             String sql = "SELECT * FROM nhacungcap";
             MyConnect myConnect = new MyConnect();
             con = myConnect.getConnection();
             prep = con.prepareStatement(sql);
             rs = prep.executeQuery();
             while (rs.next()) {
                 NhaCungCap ncc = new NhaCungCap();
                 ncc.setMancc(rs.getInt(1));
                 ncc.setTenncc(rs.getString(2));
                 ncc.setSdt(rs.getString(3));
                 ncc.setDiachi(rs.getString(4));
                 dsncc.add(ncc);
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
         return dsncc;
     }
    
    public NhaCungCap getNhaCungCap(int maNCC) {
         NhaCungCap ncc = null;
         Connection con = null;
         PreparedStatement prep = null;
         ResultSet rs = null;
         try {
             String sql = "SELECT * FROM nhacungcap WHERE MaNCC=?";
             MyConnect myConnect = new MyConnect();
             con = myConnect.getConnection();
             prep = con.prepareStatement(sql);
             prep.setInt(1, maNCC);
             rs = prep.executeQuery();
             while (rs.next()) {
                 ncc = new NhaCungCap();
                 ncc.setMancc(rs.getInt(1));
                 ncc.setTenncc(rs.getString(2));
                 ncc.setSdt(rs.getString(3));
                 ncc.setDiachi(rs.getString(4));
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
         return ncc;
     }

    public boolean addNhaCungCap(NhaCungCap ncc) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "INSERT INTO nhacungcap VALUES(?,?,?,?)";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setInt(1, ncc.getMancc());
            prep.setString(2, ncc.getTenncc());
            prep.setString(3, ncc.getSdt());
            prep.setString(4, ncc.getDiachi());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra stack trace của lỗi để kiểm tra và sửa
        } finally {
        // Đóng tất cả các tài nguyên
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
    
    
    public boolean deleteNhaCungCap(int maNCC) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "UPDATE Danh_Sach_Nha_Cung_Cap SET TinhTrang=0 WHERE MaNCC=?";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setInt(1, maNCC);
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
    
    

    public boolean updateNhaCungCap(int maNCC, NhaCungCap ncc) {
         Connection con = null;
         PreparedStatement prep = null;
         boolean result = false;
         try {
             String sql = "UPDATE Danh_Sach_Khach_Hang SET Ho=?, Ten=?, GioiTinh=?, NgaySinh=?, SoDienthoai=?, DiaChi=? WHERE MaKH=?";
             MyConnect myConnect = new MyConnect();
             con = myConnect.getConnection();
             prep = con.prepareStatement(sql);
             prep.setInt(1, ncc.getMancc());
             prep.setString(2, ncc.getTenncc());
             prep.setString(3, ncc.getSdt());
             prep.setString(4, ncc.getDiachi());
             prep.setString(5, ncc.getSdt());
             prep.setString(6, ncc.getDiachi());
             prep.setInt(7, maNCC);
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
    
    

    
}
