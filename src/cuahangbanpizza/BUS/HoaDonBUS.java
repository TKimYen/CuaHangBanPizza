/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.HoaDonDAO;
import cuahangbanpizza.DTO.HoaDon;
import MyCustom.MyDialog;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonBUS {
    private ArrayList<HoaDon> listHD;
    private HoaDonDAO hdDAO;
    
    public HoaDonBUS(){
        listHD = new ArrayList<>();
        hdDAO = new HoaDonDAO();
        listHD = hdDAO.getListHoadon();
    }
    
    public void them(String maKH, String maNV, String ngayLap, Double tongTien){
        HoaDon hd = new HoaDon();
        hd.setMaNhanVien(maNV);
        hd.setMaKhachHang(maKH);
        hd.setNgayLap(ngayLap);
        hd.setTongTien(tongTien);
        try {
            hdDAO.them(hd);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //KiemTra
    public boolean xoa(String maHD){
        boolean result = false;
        if(hdDAO.xoa(maHD)){
            for(HoaDon hd : listHD){
                if(hd.getMaHoaDon().equals(maHD)){
                    listHD.remove(hd);
                    return true;
                }
            }
        }
        return result;
    }

    //KiemTra
    public boolean sua(String maHD, HoaDon hd){
        boolean result = false;
        if(hdDAO.sua(maHD, hd)){
            for(HoaDon hoadon : listHD){
                if(hoadon.getMaHoaDon().equals(maHD)){
                    hoadon.setMaHoaDon(hd.getMaHoaDon());
                    hoadon.setMaKhachHang(hd.getMaKhachHang());
                    hoadon.setMaNhanVien(hd.getMaNhanVien());
                    hoadon.setNgayLap(hd.getNgayLap());
                    hoadon.setTongTien(hd.getTongTien());
                    return true;
                }
            }
        }
        return result;
    }
    
    public String getMaHoaDonMoiNhat(){
        return hdDAO.getMaHoaDonMoiNhat();
    }
    
    public ArrayList<HoaDon> getListHDTheoGia(String min, String max){
        try{
            double minPrice = Double.parseDouble(min);
            double maxPrice = Double.parseDouble(max);
            ArrayList<HoaDon> dshd = new ArrayList<>();
            for (HoaDon hd : listHD){
                if(hd.getTongTien() >= minPrice && hd.getTongTien() < maxPrice)
                    dshd.add(hd);
            }
            return dshd;
        }catch(Exception e){
            
        }
        return null;
    }
    
    public ArrayList<HoaDon> getListHoaDonTheoNgay(String dateMin, String dateMax) {
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date minDate = sdf.parse(min);
//            Date maxDate = sdf.parse(max);
//
//            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
//            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());

            ArrayList<HoaDon> dshd = hdDAO.getListHoadon(dateMin, dateMax);
            return dshd;
        } catch (Exception e) {
            new MyDialog("Hãy nhập khoảng ngày hợp lệ!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }
}
