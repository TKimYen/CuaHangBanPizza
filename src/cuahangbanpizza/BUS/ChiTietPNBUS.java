/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.ChiTietPNDAO;
import cuahangbanpizza.DTO.ChiTietPhieuNhap;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietPNBUS {
    private ArrayList<ChiTietPhieuNhap> listCTPN;
    private ChiTietPNDAO pnDAO;
    private PhieuNhapBUS pnBUS;
   
    public ChiTietPNBUS(){
        listCTPN = new ArrayList<>();
        pnDAO = new ChiTietPNDAO();
        listCTPN = pnDAO.getListCTPN();
        pnBUS = new PhieuNhapBUS();
    }

    public ArrayList<ChiTietPhieuNhap> getListCTPN() {
        return listCTPN;
    }
    
    public ArrayList<ChiTietPhieuNhap> getListCTHoaDonTheoMaHD(String maHD) {
        int ma = Integer.parseInt(maHD);
        ArrayList<ChiTietPhieuNhap> dsct = new ArrayList<>();
        for (ChiTietPhieuNhap cthd : listCTPN) {
            if (cthd.getMaPN() == ma)
                dsct.add(cthd);
        }
        return dsct;
    }
    
    public void them(int maSP, int soLuong, int donGia, double thanhTien){
        int maPN = pnBUS.getMaPhieuNhapMoiNhat();
        ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
        ct.setMaPN(maPN);
        ct.setMaSP(maSP);
        ct.setSoLuong(soLuong);
        ct.setDonGia(donGia);
        ct.setThanhTien(thanhTien);
    }
}
