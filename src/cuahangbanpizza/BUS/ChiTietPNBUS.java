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
    
    public ArrayList<ChiTietPhieuNhap> getLIstCTPNTheoMaPN(String maPN){
        ArrayList<ChiTietPhieuNhap> dsct = new ArrayList<>();
        for(ChiTietPhieuNhap ct : listCTPN){
            if(ct.getMaPN().equals(maPN))
                dsct.add(ct);
        }
        return dsct;
    }
    
    public void them(String maSP, int soLuong, double donGia, double thanhTien){
        String maPN = pnBUS.getMaPhieuNhapMoiNhat();
        
        ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
        ct.setMaPN(maPN);
        ct.setMaSP(maSP);
        ct.setSoLuong(soLuong);
        ct.setDonGia(donGia);
        ct.setThanhTien(thanhTien);
    }
}
