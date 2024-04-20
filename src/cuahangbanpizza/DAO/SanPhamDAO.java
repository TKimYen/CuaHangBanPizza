/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

/**
 *
 * @author THANH THAO
 */
import cuahangbanpizza.DTO.SanPham;
import java.sql.*;
import java.util.ArrayList;

public class SanPhamDAO {

    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> dssp = new ArrayList<>();
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM SanPham WHERE TinhTrang=1";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoaiSP(rs.getString(3));
                sp.setHinhAnh(rs.getString(4));
                sp.setSoLuong(rs.getInt(5));
                sp.setGia(rs.getDouble(6));
                dssp.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
                e.printStackTrace();
            }
        }
        return dssp;
    }

    public SanPham getSanPham(String maSP) {
        SanPham sp = null;
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM SanPham WHERE MaSP=? AND TinhTrang=1";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, maSP);
            rs = prep.executeQuery();
            while (rs.next()) {
                sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoaiSP(rs.getString(3));
                sp.setHinhAnh(rs.getString(4));
                sp.setSoLuong(rs.getInt(5));
                sp.setGia(rs.getDouble(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
                e.printStackTrace();
            }
        }
        return sp;
    }

    public boolean addSanPham(SanPham sp) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "INSERT INTO SanPham (MaSP, TenSP, MaLoaiSP, HinhAnh, SoLuong, Gia) VALUES (?, ?, ?, ?, ?, ?)";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, sp.getMaSP());
            prep.setString(2, sp.getTenSP());
            prep.setString(3, sp.getMaLoaiSP());
            prep.setString(4, sp.getHinhAnh());
            prep.setInt(5, sp.getSoLuong());
            prep.setDouble(6, sp.getGia());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean updateSanPham(SanPham sp) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "UPDATE SanPham SET MaSP =?, TenSP = ?, MaLoaiSP = ?, HinhAnh = ?, SoLuong = ?, Gia = ? WHERE MaSP = ?";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, sp.getMaSP());
            prep.setString(2, sp.getTenSP());
            prep.setString(3, sp.getMaLoaiSP());
            prep.setString(4, sp.getHinhAnh());
            prep.setInt(5, sp.getSoLuong());
            prep.setDouble(6, sp.getGia());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean deleteSanPham(String maSP) {
        Connection con = null;
        PreparedStatement prep = null;
        boolean result = false;
        try {
            String sql = "UPDATE SanPham SET TinhTrang =0 WHERE MaSP=?";
            MyConnect myConnect = new MyConnect();
            con = myConnect.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, maSP);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
