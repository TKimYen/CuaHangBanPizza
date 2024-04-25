/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.ChiTietPhieuNhap;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ChiTietPNDAO {
    public ArrayList<ChiTietPhieuNhap> getListCTPN(){
        ArrayList<ChiTietPhieuNhap> dscaPN = new ArrayList<>();
        try{
            String sql = "select *from chitietphieunhap";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(rs.getInt(1));
                ct.setMaSP(rs.getInt(2));
                ct.setSoLuong(rs.getInt(3));
                ct.setDonGia(rs.getInt(4));
                ct.setThanhTien(rs.getDouble(5));
                dscaPN.add(ct);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return dscaPN;
    }
    
    public ArrayList<ChiTietPhieuNhap> getListCTPNTheoMaPN(String maPN){
        ArrayList<ChiTietPhieuNhap> dsct = new ArrayList<>();
        try{
            String sql = "select * from chitietphieunhap where MaPN=" +maPN;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(rs.getInt(1));
                ct.setMaSP(rs.getInt(2));
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
    
    public ArrayList<ChiTietPhieuNhap> getListCTPNTheoMaSP(String maSP){
        ArrayList<ChiTietPhieuNhap> dsct = new ArrayList<>();
        try{
            String sql = "select * from chitietphieunhap where MaSP=" +maSP;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                ct.setMaPN(rs.getInt(1));
                ct.setMaSP(rs.getInt(2));
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
    
    public boolean them(ChiTietPhieuNhap ct){
        boolean result = false;
        try{
            String sql = "insert into chitietphieunhap values(?,?,?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ct.getMaPN());
            prep.setInt(2, ct.getMaSP());
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
    
    public boolean xoa(String maPN){
        boolean result = false;
        try{
            String sql = "delete * from chitietphieunhap where MaPN=" + maPN;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        } 
        return result;
    }
    
    public boolean sua(String maPN, String maSP, ChiTietPhieuNhap ct){
        boolean result = false;
        try{
            String sql = "updata chitietPhieuNhap set MaPN=?, MaSP=?, SoLuong=?, DonGia=?, ThanhTien=? where MaPN=? and MaSP=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, ct.getMaPN());
            prep.setInt(2, ct.getMaSP());
            prep.setInt(3, ct.getSoLuong());
            prep.setDouble(4, ct.getDonGia());
            prep.setDouble(5, ct.getThanhTien());
            prep.setString(6, maPN);
            prep.setString(7, maSP);
            result = prep.executeUpdate() > 0;
        }catch(SQLException ex){
            return false;
        }
        return result;
    }
}
