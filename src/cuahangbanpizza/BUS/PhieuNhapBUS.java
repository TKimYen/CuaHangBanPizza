/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.BUS;

import MyCustom.MyDialog;
import cuahangbanpizza.DAO.PhieuNhapDAO;
import cuahangbanpizza.DTO.PhieuNhap;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhieuNhapBUS {
    private ArrayList<PhieuNhap> listPN;
    private PhieuNhapDAO pnDAO;
    
    public PhieuNhapBUS(){
        listPN = new ArrayList<>();
        pnDAO = new PhieuNhapDAO();
        listPN = pnDAO.getListPhieuNhap();
    }
    
    public void them(int maNV, int maNCC, String ngayLap, Double tongTien){
        PhieuNhap pn = new PhieuNhap();
        pn.setMaNV(maNV);
        pn.setMaNCC(maNCC);
        pn.setNgayLap(ngayLap);
        pn.setTongTien(tongTien);
        try {
            pnDAO.them(pn);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //KiemTra
    public boolean xoa(int maPN){
        boolean result = false;
        if(pnDAO.xoa(maPN)){
            for(PhieuNhap pn : listPN){
                if(pn.getMaPN() == maPN){
                    listPN.remove(pn);
                    return true;
                }
            }
        }
        return result;
    }

    //KiemTra
    public boolean sua(int maPN, PhieuNhap pn) throws ParseException{
        boolean result = false;
        if(pnDAO.sua(maPN, pn)){
            for(PhieuNhap phieunhap : listPN){
                if(phieunhap.getMaPN() == maPN){
                    phieunhap.setMaPN(pn.getMaPN());
                    phieunhap.setMaNV(pn.getMaNV());
                    phieunhap.setMaNCC(pn.getMaNCC());
                    phieunhap.setNgayLap(pn.getNgayLap());
                    phieunhap.setTongTien(pn.getTongTien());
                    return true;
                }
            }
        }
        return result;
    }
    
    public int getMaPhieuNhapMoiNhat(){
        return pnDAO.getMaPhieuNhapMoiNhat();
    }
    
    public ArrayList<PhieuNhap> getListHDTheoGia(String min, String max){
        try{
            double minPrice = Double.parseDouble(min);
            double maxPrice = Double.parseDouble(max);
            ArrayList<PhieuNhap> dspn = new ArrayList<>();
            for (PhieuNhap pn : listPN){ 
                if(pn.getTongTien() >= minPrice && pn.getTongTien() < maxPrice)
                    dspn.add(pn);
            }
            return dspn;
        }catch(Exception e){
            
        }
        return null;
    }
    
    public ArrayList<PhieuNhap> getListPhieuNhapTheoNgay(String dateMin, String dateMax) {
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date minDate = sdf.parse(min);
//            Date maxDate = sdf.parse(max);
//
//            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
//            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());

            ArrayList<PhieuNhap> dspn = pnDAO.getListPhieuNhap(dateMin, dateMax);
            return dspn;
        } catch (Exception e) {
            new MyDialog("Hãy nhập khoảng ngày hợp lệ!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }
}
