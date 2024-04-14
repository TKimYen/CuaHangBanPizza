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
    
    private Connection conn;

    public SanPhamDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<SanPham> getSanPham() {
        ArrayList<SanPham> sanPhamList = new ArrayList<>();
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM SanPham";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            prep = con.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("Masp"));
                sp.setTenSP(rs.getString("Tensp"));
                sp.setMaLoaiSP(rs.getString("MaLoaisp"));
                sp.setHinhAnh(rs.getString("HinhAnh"));
                sp.setSoLuong(rs.getInt("Sl"));
                sp.setGia(rs.getDouble("Gia"));
                sanPhamList.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanPhamList;
    }

    public void addSanPham(SanPham sp) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SanPham (Masp, Tensp, MaLoaisp, HinhAnh, Sl, Gia) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, sp.getMaSP());
            pstmt.setString(2, sp.getTenSP());
            pstmt.setString(3, sp.getMaLoaiSP());
            pstmt.setString(4, sp.getHinhAnh());
            pstmt.setInt(5, sp.getSoLuong());
            pstmt.setDouble(6, sp.getGia());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSanPham(SanPham sp) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE SanPham SET Masp =?, Tensp = ?, MaLoaisp = ?, HinhAnh = ?, Sl = ?, Gia = ? WHERE Masp = ?");
            pstmt.setString(1, sp.getMaSP());
            pstmt.setString(2, sp.getTenSP());
            pstmt.setString(3, sp.getMaLoaiSP());
            pstmt.setString(4, sp.getHinhAnh());
            pstmt.setInt(5, sp.getSoLuong());
            pstmt.setDouble(6, sp.getGia());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSanPham(String MaSP) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM SanPham WHERE Masp = ?");
            pstmt.setString(1, MaSP);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SanPham findSanPham(String masp) {
        SanPham sp = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM SanPham WHERE Masp = ?");
            pstmt.setString(1, masp);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sp = new SanPham();
                sp.setMaSP(rs.getString("Masp"));
                sp.setTenSP(rs.getString("Tensp"));
                sp.setMaLoaiSP(rs.getString("MaLoaisp"));
                sp.setHinhAnh(rs.getString("HinhAnh"));
                sp.setSoLuong(rs.getInt("Sl"));
                sp.setGia(rs.getDouble("Gia"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sp;
    }
}
