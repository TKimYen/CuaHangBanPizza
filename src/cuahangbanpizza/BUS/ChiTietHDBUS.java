/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuahangbanpizza.BUS;

import cuahangbanpizza.DAO.ChiTietHDDAO;
import cuahangbanpizza.DTO.ChiTietHoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChiTietHDBUS {
    private ArrayList<ChiTietHoaDon> listCTHD;
    private ChiTietHDDAO hdDAO;
    private HoaDonBUS hdBUS;
    
    public ChiTietHDBUS(){
        listCTHD = new ArrayList<>();
        hdDAO = new ChiTietHDDAO();
        listCTHD = hdDAO.getListCTHD();
        hdBUS = new HoaDonBUS();
    }

    public ArrayList<ChiTietHoaDon> getListCTHD() {
        return listCTHD;
    }
    
    public ArrayList<ChiTietHoaDon> getListCTHoaDonTheoMaHD(String maHD) {
        int ma = Integer.parseInt(maHD);
        ArrayList<ChiTietHoaDon> dsct = new ArrayList<>();
        for (ChiTietHoaDon cthd : listCTHD) {
            if (cthd.getMaHoaDon() == ma)
                dsct.add(cthd);
        }
        return dsct;
    }
    
    public void them(int maSP, int soLuong, int donGia, double thanhTien){
        int ma = hdBUS.getMaHoaDonMoiNhat();        
        ChiTietHoaDon ct = new ChiTietHoaDon();
        ct.setMaHoaDon(ma);
        ct.setMaSanPham(maSP);
        ct.setSoLuong(soLuong);
        ct.setDonGia(donGia);
        ct.setThanhTien(thanhTien);
    }
}
