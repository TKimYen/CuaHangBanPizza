/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.ChiTietHoaDon;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietHDDAO {
    public ArrayList<ChiTietHoaDon> getListCTHD(){
        ArrayList<ChiTietHoaDon> dscthd = new ArrayList<>();
        try{
            String sql = "select *from chitiethoadon";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHoaDon(rs.getInt(1));
                ct.setMaSanPham(rs.getInt(2));
                ct.setSoLuong(rs.getInt(3));
                ct.setDonGia(rs.getInt(4));
                ct.setThanhTien(rs.getDouble(5));
                dscthd.add(ct);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return dscthd;
    }
    
    public ArrayList<ChiTietHoaDon> getListCTHDTheoMaHD(String maHD){
        ArrayList<ChiTietHoaDon> dsct = new ArrayList<>();
        try{
            String sql = "select * from chitiethoadon where MaHD=" +maHD;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHoaDon(rs.getInt(1));
                ct.setMaSanPham(rs.getInt(2));
                ct.setSoLuong(rs.getInt(3));
                ct.setDonGia(rs.getInt(4));
                ct.setThanhTien(rs.getDouble(5));
                dsct.add(ct);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return dsct;
    }
    
    public ArrayList<ChiTietHoaDon> getListCTHDTheoMaSP(String maSP){
        ArrayList<ChiTietHoaDon> dsct = new ArrayList<>();
        try{
            String sql = "select * from chitiethoadon where MaSP=" +maSP;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setMaHoaDon(rs.getInt(1));
                ct.setMaSanPham(rs.getInt(2));
                ct.setSoLuong(rs.getInt(3));
                ct.setDonGia(rs.getInt(4));
                ct.setThanhTien(rs.getDouble(5));
                dsct.add(ct);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        return dsct;
    }
    
    public boolean them(ChiTietHoaDon ct){
        boolean result = false;
        try{
            String sql = "insert into chitiethoadon values(?,?,?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ct.getMaHoaDon());
            prep.setInt(2, ct.getMaSanPham());
            prep.setInt(3, ct.getSoLuong());
            prep.setDouble(4, ct.getDonGia());
            prep.setDouble(5, ct.getThanhTien());
            result = prep.executeUpdate() > 0;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return result;
    }
    
    public boolean xoa(String maHD){
        boolean result = false;
        try{
            String sql = "delete * from chitiethoadon where MaHD=" + maHD;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        } 
        return result;
    }
    
    public boolean sua(String maHD, String maSP, ChiTietHoaDon ct){
        boolean result = false;
        try{
            String sql = "updata chitiethoadon set MaHD=?, MaSP=?, SoLuong=?, DonGia=?, ThanhTien=? where MaHD=? and MaSP=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ct.getMaHoaDon());
            prep.setInt(2, ct.getMaSanPham());
            prep.setInt(3, ct.getSoLuong());
            prep.setDouble(4, ct.getDonGia());
            prep.setDouble(5, ct.getThanhTien());
            prep.setString(6, maHD);
            prep.setString(7, maSP);
            result = prep.executeUpdate() > 0;
        }catch(SQLException ex){
            return false;
        }
        return result;
    }
}

