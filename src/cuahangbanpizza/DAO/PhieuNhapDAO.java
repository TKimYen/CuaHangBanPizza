/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.HoaDon;
import cuahangbanpizza.DTO.PhieuNhap;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhieuNhapDAO {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public ArrayList<PhieuNhap> getListPhieuNhap(){
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        try {
            String sql = "SELECT * FROM phieunhap";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(rs.getString(1));
                pn.setMaNV(rs.getString(2));
                pn.setMaNCC(rs.getString(3));
                pn.setNgayLap(rs.getString(4));
                pn.setTongTien(rs.getDouble(5));
                dspn.add(pn);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dspn;
    }
    
    
    //GetListHD theo khoang thoi gian
    public ArrayList<PhieuNhap> getListPhieuNhap(String dateMin, String dateMax){
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        try{
            String sql = "SELECT * FROM phieunhap WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, dateMin);
            pre.setString(2, dateMax);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(rs.getString(1));
                pn.setMaNV(rs.getString(2));
                pn.setMaNCC(rs.getString(3));
                pn.setNgayLap(rs.getString(4));
                pn.setTongTien(rs.getDouble(5));
                dspn.add(pn);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return dspn;
    }
    
    public Boolean them(PhieuNhap pn) throws ParseException{
        boolean result = false;
        try {
            String sql = "INSERT INTO phieunhap(MaPN, MaNV, MaNCC, NgayLap, TongTien) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setString(1, pn.getMaPN());
            prep.setString(2, pn.getMaNV());
            // Phân tích chuỗi ngày tháng thành đối tượng java.util.Date
            java.util.Date ngayLapDate = df.parse(pn.getNgayLap());
            // Chuyển đổi đối tượng java.util.Date thành java.sql.Timestamp
            Timestamp ngayLapTimestamp = new Timestamp(ngayLapDate.getTime());
            // Thiết lập giá trị cho tham số thứ ba của câu lệnh SQL bằng java.sql.Timestamp
            prep.setTimestamp(3, ngayLapTimestamp);
            prep.setString(4, pn.getMaNCC());
            prep.setDouble(5, pn.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;        
    }

    public Boolean xoa(String maPN){
        boolean result = false;
        try{
            String sql = "delete from phieunhap where MaPN =" + maPN;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        }catch(SQLException ex){
            return false;
        }
        return result;
    }
    
    public Boolean sua(String maPN, PhieuNhap pn) throws ParseException{
        boolean result = false;
        try{
            String sql = "update phieunhap set MaPN=?, MaNV=?, MaNCC=?, NgayLap=?, TongTien=? " + "where MaPN=" + maPN;
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setString(1, pn.getMaPN());
            prep.setString(2, pn.getMaNV());
            prep.setString(3, pn.getMaNCC());
            // Phân tích chuỗi ngày tháng thành đối tượng java.util.Date
            java.util.Date ngayLapDate = df.parse(pn.getNgayLap());
            // Chuyển đổi đối tượng java.util.Date thành java.sql.Timestamp
            Timestamp ngayLapTimestamp = new Timestamp(ngayLapDate.getTime());
            // Thiết lập giá trị cho tham số thứ ba của câu lệnh SQL bằng java.sql.Timestamp
            prep.setTimestamp(3, ngayLapTimestamp);
            prep.setDouble(5, pn.getTongTien());
        }catch(SQLException ex){
            return false;
        }
        return result;
    }
      
    public PhieuNhap getPhieuNhap(String maPN) {
        PhieuNhap pn = null;
        try {
            String sql = "SELECT * FROM phieunhap where maPN=" + maPN;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                pn = new PhieuNhap();
                pn.setMaPN(rs.getString(1));
                pn.setMaNV(rs.getString(2));
                pn.setMaNCC(rs.getString(3));
                pn.setNgayLap(rs.getString(4));
                pn.setTongTien(rs.getDouble(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pn;
    } 
    
    public String getMaPhieuNhapMoiNhat() {
        try {
            String sql = "SELECT MAX(maPN) FROM phieunhap";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}
