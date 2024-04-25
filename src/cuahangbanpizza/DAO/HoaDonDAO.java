/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.DAO;

import cuahangbanpizza.DTO.HoaDon;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class HoaDonDAO {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    //Lấy thông tin từ Database
    
    public ArrayList<HoaDon> getListHoadon(){
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            String sql = "SELECT * FROM hoadon";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setMaKhachHang(rs.getInt(2));
                hd.setMaNhanVien(rs.getInt(3));
                hd.setNgayLap(rs.getString(4));
                hd.setTongTien(rs.getDouble(5));
                dshd.add(hd);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return dshd;
    }
    
    //GetListHD theo khoang thoi gian
    public ArrayList<HoaDon> getListHoadon(String dateMin, String dateMax){
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            String sql = "select * from hoadon where ngayLap between cast(? as date) and cast(? as date)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, dateMin);
            pre.setString(2, dateMax);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setMaKhachHang(rs.getInt(2));
                hd.setMaNhanVien(rs.getInt(3));
                hd.setNgayLap(rs.getString(4));
                hd.setTongTien(rs.getDouble(5));
                dshd.add(hd);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return dshd;
    }
    
    public Boolean them(HoaDon hd) throws ParseException{
        boolean result = false;
        try {
            String sql = "INSERT INTO hoadon(maHD, ngayLap, maKH, maNV, tongTien) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, hd.getMaHoaDon());
            // Phân tích chuỗi ngày tháng thành đối tượng java.util.Date
            java.util.Date ngayLapDate = df.parse(hd.getNgayLap());
            // Chuyển đổi đối tượng java.util.Date thành java.sql.Timestamp
            Timestamp ngayLapTimestamp = new Timestamp(ngayLapDate.getTime());
            // Thiết lập giá trị cho tham số thứ ba của câu lệnh SQL bằng java.sql.Timestamp
            prep.setTimestamp(2, ngayLapTimestamp);
            prep.setInt(3, hd.getMaKhachHang());
            prep.setInt(4, hd.getMaNhanVien());
//            prep.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setDouble(5, hd.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;        
    }

    public Boolean xoa(int maHD){
        boolean result = false;
        try{
            String sql = "delete from hoadon where maHD =" + maHD;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return result;
    }
    
    public Boolean sua(int maHD, HoaDon hd){
        boolean result = false;
        try{
            String sql = "update hoadon set maHD=?, ngayLap=?, maKH=?, maNV=?, tongTien=? " + "where maHD=" + maHD;
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, hd.getMaHoaDon());
            prep.setString(2, hd.getNgayLap());
            prep.setInt(3, hd.getMaKhachHang());
            prep.setInt(4, hd.getMaNhanVien());
            prep.setDouble(5, hd.getTongTien());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return result;
    }
      
    public HoaDon getHoaDon(String maHD) {
        HoaDon hd = null;
        try {
            String sql = "SELECT * FROM hoadon where maHD=" + maHD;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setMaKhachHang(rs.getInt(2));
                hd.setMaNhanVien(rs.getInt(3));
                hd.setNgayLap(rs.getString(4));
                hd.setTongTien(rs.getDouble(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    } 
    
    public int getMaHoaDonMoiNhat() {
        try {
            String sql = "SELECT MAX(maHD) FROM hoadon";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }   
}
