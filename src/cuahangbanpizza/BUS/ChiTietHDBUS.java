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
    
    public ArrayList<ChiTietHoaDon> getLIstCTHDTheoMaHD(String maHD){
        ArrayList<ChiTietHoaDon> dsct = new ArrayList<>();
        for(ChiTietHoaDon ct : listCTHD){
            if(ct.getMaHoaDon().equals(maHD))
                dsct.add(ct);
        }
        return dsct;
    }
    
    public void them(String maSP, int soLuong, double donGia, double thanhTien){
        String maHD = hdBUS.getMaHoaDonMoiNhat();
        
        ChiTietHoaDon ct = new ChiTietHoaDon();
        ct.setMaHoaDon(maHD);
        ct.setMaSanPham(maSP);
        ct.setSoLuong(soLuong);
        ct.setDonGia(donGia);
        ct.setThanhTien(thanhTien);
    }
}
